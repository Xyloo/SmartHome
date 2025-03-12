package notifications;

public class Notificator {
    public static INotification Create(NotificationChannels channel){
        return switch (channel){
            case NotificationChannels.App -> new AppNotification();
            case NotificationChannels.Email -> new EmailNotification();
            case NotificationChannels.Sms -> new SmsNotification();
        };
    }
}
