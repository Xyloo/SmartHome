package notifications;

public class SmsNotification implements INotification {
    @Override
    public void Send(String message) {
        System.out.println("SMS: " + message);
    }
}
