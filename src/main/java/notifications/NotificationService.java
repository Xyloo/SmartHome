package notifications;

public class NotificationService {
    private static volatile NotificationService service;
    public INotification notificator;

    private NotificationService(NotificationChannels channel){
        this.notificator = Notificator.Create(channel);
    }

    public static NotificationService getInstance(NotificationChannels value){
        NotificationService notificationService = service;
        if(notificationService != null){
            return notificationService;
        }
        synchronized (NotificationService.class){
            if(service == null){
                service = new NotificationService(value);
            }
            return service;
        }
    }
    public void Notify(Notification notification){
        notificator.Send("Sending notification: " + notification.toString());
    }
}
