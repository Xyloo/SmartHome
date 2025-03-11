package util;

// Tydzień 1, Wzorzec Singleton 1
// Wzorzec Singleton pozwala na stworzenie tylko jednej instancji danej klasy w obrębie całego programu.
// Daje to pewność, że istnieje jedna instancja danej klasy i dostęp do niej jest możliwy z każdego miejsca w programie.
// Poniższa implementacja jest bezpieczna wątkowo.
public class SmartLogger {
    private static volatile SmartLogger instance;

    private SmartLogger() {}

    public static SmartLogger getInstance() {
        if (instance == null) {
            synchronized(SmartLogger.class) {
                if (instance == null) {
                    instance = new SmartLogger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
// Koniec, Tydzień 1, Wzorzec Singleton 1
