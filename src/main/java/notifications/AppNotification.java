package notifications;

public class AppNotification implements INotification{
    public AppNotification(){

    }
    @Override
    public void Send(String message) {
        System.out.println("APP: "+ message);
    }
}
