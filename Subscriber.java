/**
 * Represents a subscriber who can receive news updates.
 */
public interface Subscriber {
    /**
     * Called when a new news article is published.
     * @param news The news article that was published
     */
    void update(News news);
    
    /**
     * Returns the subscriber's name for identification.
     */
    String getName();
    
    /**
     * Returns the categories this subscriber is interested in.
     * If empty, the subscriber receives all news.
     */
    default String[] getInterestedCategories() {
        return new String[0];
    }
}
