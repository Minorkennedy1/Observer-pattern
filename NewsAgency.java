import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Represents a news agency that publishes news and notifies subscribers.
 */
public class NewsAgency {
    private final Map<String, Set<Subscriber>> categorySubscribers = new ConcurrentHashMap<>();
    private final Set<Subscriber> allSubscribers = new CopyOnWriteArraySet<>();
    private static final String ALL_CATEGORIES = "ALL";

    /**
     * Subscribes a subscriber to receive all news updates.
     */
    public synchronized void subscribe(Subscriber subscriber) {
        allSubscribers.add(subscriber);
        
        String[] categories = subscriber.getInterestedCategories();
        if (categories == null || categories.length == 0) {
            addToCategory(ALL_CATEGORIES, subscriber);
        } else {
            for (String category : categories) {
                addToCategory(category.toUpperCase(), subscriber);
            }
        }
        System.out.println(subscriber.getName() + " has subscribed to the news service.");
    }

    /**
     * Unsubscribes a subscriber from all news updates.
     */
    public synchronized void unsubscribe(Subscriber subscriber) {
        allSubscribers.remove(subscriber);
        
        // Remove from all categories
        for (Set<Subscriber> subscribers : categorySubscribers.values()) {
            subscribers.remove(subscriber);
        }
        System.out.println(subscriber.getName() + " has unsubscribed from the news service.");
    }

    /**
     * Publishes a news article to all relevant subscribers.
     */
    public void publishNews(News news) {
        System.out.println("\n=== BREAKING NEWS ===\n" + news);
        
        // Notify all subscribers interested in this category
        String category = news.getCategory().toUpperCase();
        Set<Subscriber> subscribersToNotify = new HashSet<>();
        
        // Add subscribers interested in this specific category
        if (categorySubscribers.containsKey(category)) {
            subscribersToNotify.addAll(categorySubscribers.get(category));
        }
        
        // Add subscribers interested in all categories
        if (categorySubscribers.containsKey(ALL_CATEGORIES)) {
            subscribersToNotify.addAll(categorySubscribers.get(ALL_CATEGORIES));
        }
        
        // Notify all relevant subscribers
        for (Subscriber subscriber : subscribersToNotify) {
            subscriber.update(news);
        }
    }
    
    private void addToCategory(String category, Subscriber subscriber) {
        categorySubscribers
            .computeIfAbsent(category, k -> new CopyOnWriteArraySet<>())
            .add(subscriber);
    }
    
    /**
     * Returns the total number of subscribers across all categories.
     */
    public int getTotalSubscribers() {
        return allSubscribers.size();
    }
}
