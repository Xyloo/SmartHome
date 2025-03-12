package notifications;

public class EmailNotification implements INotification{
    @Override
    public void Send(String message) {
        System.out.println("Email: " + message);
    }
}
