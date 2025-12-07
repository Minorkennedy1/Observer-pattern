/**
 * A concrete implementation of Subscriber that receives news via mobile app notifications.
 */
public class MobileAppSubscriber implements Subscriber {
    private final String username;
    private final String deviceId;
    private final String[] interestedCategories;

    public MobileAppSubscriber(String username, String deviceId, String... categories) {
        this.username = username;
        this.deviceId = deviceId;
        this.interestedCategories = categories != null ? categories : new String[0];
    }

    @Override
    public void update(News news) {
        // In a real application, this would send a push notification
        System.out.printf("\uD83D\uDCF1 [%s] Push notification to %s (%s): %s%n",
            news.getCategory().toUpperCase(),
            username,
            deviceId,
            news.getTitle());
    }

    @Override
    public String getName() {
        return username + " (Mobile App)";
    }

    @Override
    public String[] getInterestedCategories() {
        return interestedCategories;
    }
}
