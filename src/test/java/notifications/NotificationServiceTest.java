package notifications;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {
    @BeforeEach
    void resetSingleton() throws Exception {
        Field serviceField = NotificationService.class.getDeclaredField("service");
        serviceField.setAccessible(true);
        serviceField.set(null, null);
    }

    @Test
    void getInstance_ShouldCreateSingletonWithGivenChannel() {
        NotificationService instance1 = NotificationService.getInstance(NotificationChannels.Email);
        assertNotNull(instance1);
        assertTrue(instance1.notificator instanceof EmailNotification,
                "Expected notificator to be EmailNotification");

        NotificationService instance2 = NotificationService.getInstance(NotificationChannels.Sms);
        assertSame(instance1, instance2, "getInstance should always return the same singleton instance");
        assertTrue(instance2.notificator instanceof EmailNotification,
                "Expected notificator to remain EmailNotification");
    }

    @Test
    void notify_ShouldDelegateToNotificatorSend_WithStub() {
        NotificationService service = NotificationService.getInstance(NotificationChannels.App);

        class StubNotificator implements INotification {
            List<String> messages = new ArrayList<>();
            @Override
            public void send(String message) {
                messages.add(message);
            }
        }
        StubNotificator stub = new StubNotificator();
        service.notificator = stub;

        Notification notification = new Notification.NotificationBuilder("Test notification content")
                .addTitle("ALERT")
                .setType("MOTION")
                .setPriority(2)
                .build();

        service.Notify(notification);

        String expected = "Sending notification: " + notification.toString();
        assertEquals(1, stub.messages.size(), "Expected exactly one send call");
        assertEquals(expected, stub.messages.get(0), "The sent message should match the expected format");
    }
}
