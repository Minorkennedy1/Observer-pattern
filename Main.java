/**
 * Demo class to demonstrate the real-time news subscription service.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create the news agency
        NewsAgency newsAgency = new NewsAgency();

        // Create some subscribers with different interests
        Subscriber john = new EmailSubscriber("John Doe", "john@example.com", "TECH", "BUSINESS");
        Subscriber jane = new EmailSubscriber("Jane Smith", "jane@example.com"); // Subscribes to all categories
        Subscriber mike = new MobileAppSubscriber("Mike", "device123", "SPORTS");
        Subscriber sarah = new MobileAppSubscriber("Sarah", "device456", "TECH", "SCIENCE");

        // Subscribe users
        newsAgency.subscribe(john);
        newsAgency.subscribe(jane);
        newsAgency.subscribe(mike);
        newsAgency.subscribe(sarah);

        System.out.println("\n=== Starting news broadcast ===");
        
        // Publish some news
        newsAgency.publishNews(new News("Java 21 Released", 
            "Oracle has announced the release of Java 21 with new features.", "TECH"));
        
        Thread.sleep(1000); // Small delay between news
        
        newsAgency.publishNews(new News("Stock Market Reaches All-Time High", 
            "The stock market has reached a new record high today.", "BUSINESS"));
        
        Thread.sleep(1000);
        
        // Unsubscribe someone
        System.out.println("\n=== Mike is unsubscribing ===");
        newsAgency.unsubscribe(mike);
        
        // More news
        newsAgency.publishNews(new News("Local Team Wins Championship", 
            "The home team has won the national championship!", "SPORTS"));
            
        Thread.sleep(1000);
        
        // New subscriber joins
        Subscriber newUser = new EmailSubscriber("Alex", "alex@example.com", "SCIENCE");
        newsAgency.subscribe(newUser);
        
        // Final news
        newsAgency.publishNews(new News("Breakthrough in Quantum Computing", 
            "Scientists have made a significant breakthrough in quantum computing.", "SCIENCE"));
            
        System.out.println("\n=== News broadcast completed ===");
        System.out.println("Total subscribers: " + newsAgency.getTotalSubscribers());
    }
}
