package devices.observer;

public interface Observer<T> {
    void update(T value);
}
