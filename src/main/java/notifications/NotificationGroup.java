package notifications;

import java.util.ArrayList;
import java.util.List;

public class NotificationGroup implements INotification{
    private List<INotification> notifications = new ArrayList<>();

    public void addNotification(INotification notification)
    {
        notifications.add(notification);
    }
    public void removeNotification(INotification notification){
        notifications.remove(notification);
    }

    @Override
    public void send(String message) {
        for (INotification notification : notifications) {
            notification.send(message);
        }
    }
}
