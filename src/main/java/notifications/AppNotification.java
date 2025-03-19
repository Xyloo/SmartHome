package notifications;

public class AppNotification implements INotification{
    public AppNotification(){

    }
    @Override
    public void send(String message) {
        System.out.println("APP: "+ message);
    }
}
