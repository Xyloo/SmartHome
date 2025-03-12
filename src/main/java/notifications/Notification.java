package notifications;

public class Notification implements Cloneable {
    private final String title;
    private final String content;
    private final String type;
    private final int priority;

    private Notification(NotificationBuilder builder) {
        this.title = builder.title;
        this.content = builder.content;
        this.type = builder.type;
        this.priority = builder.priority;
    }

    public static class NotificationBuilder {
        private final String content;

        private String title = "SmartHome Alert";
        private String type = "";
        private int priority = 1;

        public NotificationBuilder(String content) {
            this.content = content;
        }

        public NotificationBuilder addTitle(String title) {
            this.title = title;
            return this;
        }

        public NotificationBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public NotificationBuilder setPriority(int priority) {
            this.priority = priority;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }

    @Override
    public Notification clone() {
        try {
            return (Notification) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Notification{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", priority=" + priority +
                '}';
    }
}
