import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TrendingSystem trendingSystem = new TrendingSystem();

        long now = System.currentTimeMillis();


        trendingSystem.processEvent(new OrderEvent("o1", "u1", "Margherita Pizza", "Italian", "New York", now));
        trendingSystem.processEvent(new OrderEvent("o2", "u2", "Margherita Pizza", "Italian", "New York", now));
        trendingSystem.processEvent(new OrderEvent("o3", "u3", "Pepperoni Pizza", "Italian", "New York", now));
        trendingSystem.processEvent(new OrderEvent("o4", "u4", "Cheeseburger", "American", "New York", now));
        trendingSystem.processEvent(new OrderEvent("o5", "u5", "Cheeseburger", "American", "New York", now));
        trendingSystem.processEvent(new OrderEvent("o6", "u6", "Cheeseburger", "American", "New York", now));

        trendingSystem.processEvent(new OrderEvent("o7", "u7", "Butter Chicken", "Indian", "Mumbai", now));
        trendingSystem.processEvent(new OrderEvent("o8", "u8", "Butter Chicken", "Indian", "Mumbai", now));
        trendingSystem.processEvent(new OrderEvent("o9", "u9", "Paneer Tikka", "Indian", "Mumbai", now));
        trendingSystem.processEvent(new OrderEvent("o10", "u10", "Sushi Roll", "Japanese", "Mumbai", now));

        trendingSystem.processEvent(new OrderEvent("o11", "u11", "Fish and Chips", "British", "London", now));
        trendingSystem.processEvent(new OrderEvent("o12", "u12", "Fish and Chips", "British", "London", now));
        trendingSystem.processEvent(new OrderEvent("o13", "u13", "Tacos", "Mexican", "London", now));

        System.out.println("Top 5 Trending Dishes:");
        List<String> topProducts = trendingSystem.getTop5TrendingProducts();
        for (int i = 0; i < topProducts.size(); i++) {
            System.out.println((i + 1) + ". " + topProducts.get(i));
        }

        System.out.println("\nTop 3 Trending Cuisines per City:");
        Map<String, List<String>> topCategories = trendingSystem.getTop3CategoriesPerRegion();
        for (Map.Entry<String, List<String>> entry : topCategories.entrySet()) {
            System.out.println(entry.getKey() + " -> " + String.join(", ", entry.getValue()));
        }

        System.out.println("\nFood delivery trending system executed successfully.");
    }
}