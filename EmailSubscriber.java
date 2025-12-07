/**
 * A concrete implementation of Subscriber that receives news via email.
 */
public class EmailSubscriber implements Subscriber {
    private final String name;
    private final String email;
    private final String[] interestedCategories;

    public EmailSubscriber(String name, String email, String... categories) {
        this.name = name;
        this.email = email;
        this.interestedCategories = categories != null ? categories : new String[0];
    }

    @Override
    public void update(News news) {
        // In a real application, this would send an actual email
        System.out.printf("\uD83D\uDCE7 [%s] Email to %s (%s): %s%n", 
            news.getCategory().toUpperCase(), 
            email, 
            name, 
            news.getTitle());
    }

    @Override
    public String getName() {
        return name + " (Email: " + email + ")";
    }

    @Override
    public String[] getInterestedCategories() {
        return interestedCategories;
    }
}
