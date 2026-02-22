import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TrendingSystem trendingSystem = new TrendingSystem();

        long now = System.currentTimeMillis();
        trendingSystem.processEvent(new OrderEvent("o1", "u1", "MacBook Pro", "Electronics", "US", now));
        trendingSystem.processEvent(new OrderEvent("o2", "u2", "MackBook Pro", "Electronics", "US", now));
        trendingSystem.processEvent(new OrderEvent("o3", "u3", "iphone ", "Electronics", "US", now));
        trendingSystem.processEvent(new OrderEvent("o4", "u4", "Nike Air", "Shoes", "US", now));
        trendingSystem.processEvent(new OrderEvent("o5", "u5", "Nike Air", "Shoes", "US", now));
        trendingSystem.processEvent(new OrderEvent("o6", "u6", "Nike Air", "Shoes", "US", now));
        trendingSystem.processEvent(new OrderEvent("o7", "u7", "Casio G-Shock", "Electronics", "India", now));
        trendingSystem.processEvent(new OrderEvent("o8", "u8", "Casio G-Shock", "Electronics", "India", now));
        trendingSystem.processEvent(new OrderEvent("o9", "u9", "Samsung S24", "Watches", "India", now));


        System.out.println("Top 5 Trending Products:");
        List<String> topProducts = trendingSystem.getTop5TrendingProducts();
        for (int i = 0; i < topProducts.size(); i++) {
            System.out.println((i + 1) + ". " + topProducts.get(i));
        }


        System.out.println("Top 3 Trending Categories per Region:");
        Map<String, List<String>> topCategories = trendingSystem.getTop3CategoriesPerRegion();
        for (Map.Entry<String, List<String>> entry : topCategories.entrySet()) {
            System.out.println(entry.getKey() + " -> " + String.join(", ", entry.getValue()));
        }

        System.out.println("\nSystem executed successfully.");
    }
}