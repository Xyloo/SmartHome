import devices.adapter.ExternalBasicLightAdapter;
import devices.adapter.ExternalSecurityCameraAdapter;
import devices.adapter.ExternalThermostatAdapter;
import devices.bridge.AdvancedRemoteControl;
import devices.bridge.BasicRemoteControl;
import devices.bridge.MobileRemoteControl;
import devices.composite.LightingGroup;
import devices.composite.SecurityGroup;
import devices.decorator.VerboseSecurityCameraDecorator;
import devices.factory.DeviceFactory;
import devices.impl.Thermostat;
import devices.impl.lighting.BasicLight;
import devices.impl.lighting.Light;
import devices.impl.SmartDevice;
import devices.impl.SmartPlug;
import devices.configs.LightConfig;
import devices.impl.security.ExternalSecurityCamera;
import devices.impl.security.SecurityCamera;
import devices.impl.security.SecurityCameraDevice;
import home.SmartHome;
import notifications.Notification;
import notifications.NotificationChannels;
import notifications.NotificationService;
import util.DeviceManager;
import util.SmartLogger;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    private static final String SEPARATOR = "----------------------------------------";
    public static void main(String[] args) {

        //Tydzień 2, Wzorzec Composite 1
        System.out.println(SEPARATOR);
        LightingGroup livingRoomLights = new LightingGroup(1);
        livingRoomLights.addDevice(new Light());
        livingRoomLights.addDevice(new Light());
        livingRoomLights.turnOn();
        livingRoomLights.setBrightness (20);
        System.out.println(livingRoomLights.getStatus ());

        livingRoomLights.turnOff();
        livingRoomLights.setBrightness (40);
        System.out.println(livingRoomLights.getStatus ());
        System.out.println(SEPARATOR);

        SecurityGroup securityGroup = new SecurityGroup (2);
        securityGroup.addDevice (new SecurityCamera (4));
        System.out.println (securityGroup.getStatus ());

        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Composite 1


        //Tydzień 2, Wzorzec Decorator 1
        VerboseSecurityCameraDecorator decorator = new VerboseSecurityCameraDecorator(
                new SecurityCamera(1)
        );
        System.out.println(decorator.getStatus());
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Decorator 1


        //Tydzień 2, Wzorzec Adapter 1
        List<SecurityCameraDevice> smartDeviceList = new ArrayList<>();
        var securityCamera = new SecurityCamera(50);
        var externalSecurityCamera = new ExternalSecurityCamera();
        var externalSecurityCameraAdapter = new ExternalSecurityCameraAdapter(externalSecurityCamera);

        smartDeviceList.add(securityCamera);
        smartDeviceList.add(externalSecurityCameraAdapter);

        for (SecurityCameraDevice smartDevice : smartDeviceList) {
            System.out.println(((SmartDevice)smartDevice).getStatus());
            smartDevice.stopRecording();
            smartDevice.takeSnapshot();
            smartDevice.setAutoRecordingEnabled(true);
            System.out.println(((SmartDevice)smartDevice).getStatus() + "\n");
        }
        //Koniec Tydzień 2, Wzorzec Adapter 1

        //Tydzień 2, Wzorzec Adapter 2
        System.out.println(SEPARATOR);
        var externalBasicLight = new BasicLight();
        var externalBasicLightAdapter = new ExternalBasicLightAdapter(externalBasicLight);

        System.out.println(externalBasicLightAdapter.getStatus());
        externalBasicLightAdapter.turnOn();

        System.out.println(externalBasicLightAdapter.getStatus());
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Adapter 2

        //Tydzień 2, Wzorzec Adapter 3
        System.out.println(SEPARATOR);
        var thermostat = new Thermostat();
        var thermostatAdapter = new ExternalThermostatAdapter(thermostat);

        System.out.println(thermostatAdapter.getStatus());
        thermostatAdapter.turnOff();
        System.out.println(thermostatAdapter.getStatus());
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Adapter 3

        //Tydzień 2, Wzorzec Bridge 1
        BasicRemoteControl remoteControl = new BasicRemoteControl(new Light());
        System.out.println(remoteControl.getStatus());
        remoteControl.turnOn();
        System.out.println(remoteControl.getStatus());
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Bridge 1

        //Tydzień 2, Wzorzec Bridge 2
        System.out.println(SEPARATOR);
        var advancedRemoteControl = new AdvancedRemoteControl(securityCamera);
        System.out.println(advancedRemoteControl.getStatus());
        advancedRemoteControl.startRecording();
        advancedRemoteControl.setBrightness(50);
        System.out.println(advancedRemoteControl.getStatus());
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Bridge 2

        //Tydzień 2, Wzorzez Bridge 3
        System.out.println(SEPARATOR);
        var mobileRemoteControl = new MobileRemoteControl(externalSecurityCameraAdapter);
        System.out.println(mobileRemoteControl.getStatus());
        mobileRemoteControl.enableVoiceControl();
        mobileRemoteControl.setBrightness(50);
        System.out.println(mobileRemoteControl.getStatus());
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Bridge 3
    }

    private void tydzien1()
    {
        // Tydzień 1, Wzorzec Factory 1
        SmartDevice light = DeviceFactory.createDevice("light");
        SmartDevice camera = DeviceFactory.createDevice("camera");

        light.turnOn();
        camera.turnOn();

        System.out.println(light.getStatus());
        System.out.println(camera.getStatus());

        light.turnOff();
        camera.turnOff();

        System.out.println(light.getStatus());
        System.out.println(camera.getStatus());
        // Koniec, Tydzień 1, Wzorzec Factory 1

        System.out.println(SEPARATOR);

        // Tydzień 1, Wzorzec Singleton 1
        SmartLogger logger = SmartLogger.getInstance();
        SmartLogger logger2 = SmartLogger.getInstance();
        assert logger == logger2;
        logger.log("SmartHome system started.");
        // Koniec, Tydzień 1, Wzorzec Singleton 1

        System.out.println(SEPARATOR);

        // Tydzień 1, Wzorzec Builder 1
        SmartHome home = new SmartHome.Builder("Błyskotliwy dom")
                .location("Nadbystrzycka 38")
                .addDevice(DeviceFactory.createDevice("light"))
                .addDevice(DeviceFactory.createDevice("thermostat"))
                .build();
        System.out.println(home);
        // Koniec, Tydzień 1, Wzorzec Builder 1

        System.out.println(SEPARATOR);

        // Tydzień 1, Wzorzec Prototype 1
        SmartPlug plug1 = new SmartPlug("Living Room Plug");
        plug1.turnOn();
        SmartPlug plug2 = plug1.clone();
        System.out.println(plug1.getStatus());
        System.out.println(plug2.getStatus());
        // Koniec, Tydzień 1, Wzorzec Prototype 1

        System.out.println(SEPARATOR);

        // Tydzień 1, Wzorzec Singleton oraz Factory 2
        NotificationService service = NotificationService.getInstance(NotificationChannels.App);
        // Koniec, Tydzień 1, Wzorzec Singleton oraz Factory 2

        System.out.println(SEPARATOR);

        // Tydzień 1, Wzorzec Builder 2
        Notification notification = new Notification.NotificationBuilder("Uwaga! Wykryto niespodziewany ruch w salonie!")
                .setPriority(1)
                .setType("Warning")
                .addTitle("Uwaga! Wykryto ruch!")
                .build();
        service.Notify(notification);
        // Koniec, Tydzień 1, Wzorzec Builder 2

        System.out.println(SEPARATOR);

        // Tydzień 1, Wzorzec Prototype 2
        Notification secondNotification = notification.clone();
        service.Notify(secondNotification);
        // Koniec, Tydzień 1, Prototype Builder 2

        System.out.println(SEPARATOR);


        //Tydzień 1, Wzorzec Factory 3, Builder 3
        System.out.println("Default settings:");

        List<SmartDevice> smartDevices = new ArrayList<SmartDevice>() {{
            add(DeviceFactory.createDevice("light"));
            add(DeviceFactory.createDevice("camera"));
            add(DeviceFactory.createDevice("smartPlug"));
        }};

        for (SmartDevice smartDevice : smartDevices) {
            System.out.println(smartDevice.getStatus());
        }
        //Koniec Tydzień 1, Wzorzec Factory 3, Builder 3


        //Tydzień 1, Wzorzec Prototype 3
        LightConfig defaultLightConfig = DeviceManager.INSTANCE.getSetting(Light.CONFIG_KEY, LightConfig.class);
        System.out.println("Default LightConfig: " + defaultLightConfig);

        LightConfig clonedLightConfig = defaultLightConfig.clone();
        System.out.println("Cloned LightConfig: " + clonedLightConfig);
        //Koniec Tydzień 1, Wzorzec Prototype 3
    }
}
