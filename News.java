import java.time.LocalDateTime;

/**
 * Represents a news article with title, content, and publication time.
 */
public class News {
    private final String title;
    private final String content;
    private final LocalDateTime publicationTime;
    private final String category;

    public News(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.publicationTime = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getPublicationTime() {
        return publicationTime;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("""
                --- %s ---
                %s
                [%s] %s
                ",""", 
                title.toUpperCase(), 
                "-".repeat(title.length() + 8), 
                publicationTime, 
                content);
    }
}
