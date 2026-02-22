import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TrendingSystem {

    private static final long WINDOW_MS = 10 * 60 * 1000;

    private final ConcurrentLinkedQueue<OrderEvent> eventWindow = new ConcurrentLinkedQueue<>();

    private final ConcurrentHashMap<String, AtomicInteger> productCounts = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, AtomicInteger>> regionCategoryCounts = new ConcurrentHashMap<>();

    public void processEvent(OrderEvent event) {
        evictExpiredEvents();

        eventWindow.offer(event);

        productCounts.compute(event.productId, (k, v) -> {
            if (v == null) v = new AtomicInteger(0);
            v.incrementAndGet();
            return v;
        });

        regionCategoryCounts
                .computeIfAbsent(event.region, k -> new ConcurrentHashMap<>())
                .compute(event.category, (k, v) -> {
                    if (v == null) v = new AtomicInteger(0);
                    v.incrementAndGet();
                    return v;
                });
    }

    private void evictExpiredEvents() {
        long evictionThreshold = System.currentTimeMillis() - WINDOW_MS;

        while (!eventWindow.isEmpty()) {
            OrderEvent oldest = eventWindow.peek();

            if (oldest == null || oldest.timestamp >= evictionThreshold) {
                break;
            }

            OrderEvent removed = eventWindow.poll();
            if (removed != null) {

                productCounts.computeIfPresent(removed.productId, (k, v) -> {
                    if (v.decrementAndGet() == 0) return null;
                    return v;
                });

                ConcurrentHashMap<String, AtomicInteger> catMap = regionCategoryCounts.get(removed.region);
                if (catMap != null) {
                    catMap.computeIfPresent(removed.category, (k, v) -> {
                        if (v.decrementAndGet() == 0) return null;
                        return v;
                    });
                }
            }
        }
    }

    public List<String> getTop5TrendingProducts() {
        evictExpiredEvents();
        return getTopK(productCounts, 5);
    }

    public Map<String, List<String>> getTop3CategoriesPerRegion() {
        evictExpiredEvents();

        Map<String, List<String>> result = new HashMap<>();
        for (Map.Entry<String, ConcurrentHashMap<String, AtomicInteger>> entry : regionCategoryCounts.entrySet()) {
            result.put(entry.getKey(), getTopK(entry.getValue(), 3));
        }
        return result;
    }

    private List<String> getTopK(Map<String, AtomicInteger> counts, int k) {
        PriorityQueue<Map.Entry<String, AtomicInteger>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(e -> e.getValue().get())
        );

        for (Map.Entry<String, AtomicInteger> entry : counts.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> topK = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            topK.add(minHeap.poll().getKey());
        }
        Collections.reverse(topK);
        return topK;
    }
}
