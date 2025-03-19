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
    public void Send(String message) {

    }
}
