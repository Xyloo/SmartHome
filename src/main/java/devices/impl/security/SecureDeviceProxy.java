package devices.impl.security;

import devices.impl.SmartDevice;
import devices.mediator.Mediator;

import java.util.Scanner;

// Tydzień 3, Wzorzec Proxy 3
public class SecureDeviceProxy implements SmartDevice {
    private final SmartDevice realDevice;
    private final SecurityConfig config;
    private boolean isAuthenticated = false;
    private Mediator mediator;

    public SecureDeviceProxy(SmartDevice realDevice, SecurityConfig config) {
        this.realDevice = realDevice;
        this.config = config;
    }

    // Explicit authentication step
    public void authenticate(String password) {
        if (config.isAuthorized(password)) {
            isAuthenticated = true;
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed: Invalid password.");
        }
    }

    // Check before delegating any action
    private void checkAccess() {
        if (!isAuthenticated) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the password to proceed:");
            String password = sc.nextLine();
            authenticate(password);
        }
    }

    @Override
    public void turnOn() {
        checkAccess();
        if (isAuthenticated)
            realDevice.turnOn();
    }

    @Override
    public void turnOff() {
        checkAccess();
        if (isAuthenticated)
            realDevice.turnOff();
    }

    @Override
    public String getStatus() {
        checkAccess();
        if (isAuthenticated)
            return realDevice.getStatus();
        else
            return "Access denied";
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void Handle(String event) {
        if(event.equals("SECURE_DEVICE_TURN_OFF")){
            turnOff();
        }
    }
}
// Koniec Tydzień 3, Wzorzec Proxy 3