import devices.impl.SecurityAlarm;
import home.SmartHomeFacade;
import scenarios.actions.*;
import scenarios.SmartScenario;
import devices.impl.Thermostat;
import devices.impl.lighting.Light;
import devices.impl.SmartDevice;
import devices.impl.SmartPlug;
import devices.configs.LightConfig;
import devices.impl.security.ExternalSecurityCamera;
import devices.impl.security.SecurityCamera;
import devices.impl.security.SecurityCameraDevice;
import devices.impl.security.lockingsystem.LockingSystem;
import devices.impl.security.sensors.SmartHomeSecuritySystem;
import home.SmartHome;
import notifications.*;

public class Main
{
    private static final String SEPARATOR = "----------------------------------------";

    public static void main(String[] args)
    {
        //Tydzień 3, Wzorzec Flyweight 1
        SmartHomeSecuritySystem securitySystem = new SmartHomeSecuritySystem();
        securitySystem.installSensor(80, true, "Salon", "Motion", "High Sensitivity", "1", true);
        securitySystem.installSensor(75, true, "Kuchnia", "Motion", "High Sensitivity", "2", true);
        securitySystem.installSensor(90, false, "Sypialnia", "Motion", "Medium Sensitivity", "3", false);

        System.out.println("\n--- Testowanie czujników ---");
        securitySystem.testSensor("Salon");
        securitySystem.testSensor("Kuchnia");
        securitySystem.testSensor("Sypialnia");

        // Sprawdzanie statusu
        System.out.println("\n--- Status czujników ---");
        securitySystem.getSensorStatus("Salon");
        securitySystem.getSensorStatus("Sypialnia");
        securitySystem.getSensorStatus("Kuchnia");

        // Wyzwalanie alarmów
        System.out.println("\n--- Symulacja alarmów ---");
        securitySystem.triggerAlarm("Salon");
        securitySystem.triggerAlarm("Sypialnia");
        //Koniec Tydzień 3, Wzorzec Flyweight 1

        System.out.println(SEPARATOR);

        //Tydzień 3, Wzorzec Flyweight 2
        LockingSystem system = new LockingSystem();
        system.installBlind("Sypialnia","Dzień-noc","Białe","Zaciemniające");
        system.installBlind("Kuchnia","Dzień-noc","Białe","Termoizolacyjne");
        system.installBlind("Salon","Dzień-noc","Białe","Zaciemniające");

        system.openAll();
        system.listDevices();
        system.closeAll();
        //Koniec Tydzień 3, Wzorzec Flyweight 2
    }
    private void tydzien2(){

        //Tydzień 2, Wzorzec Composite 1
        System.out.println(SEPARATOR);
        LightingGroup livingRoomLights = new LightingGroup(1);
        livingRoomLights.addDevice(new Light());
        //livingRoomLights.addDevice(new BasicLight());
        livingRoomLights.turnOn();
        livingRoomLights.setBrightness (20);
        System.out.println(livingRoomLights.getStatus ());

        livingRoomLights.turnOff();
        livingRoomLights.setBrightness (40);
        System.out.println(livingRoomLights.getStatus ());
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Composite 1

        //Koniec Tydzień 2, Wzorzec Composite 2
        SecurityGroup securityGroup = new SecurityGroup (2);
        securityGroup.addDevice (new SecurityCamera (4));
        securityGroup.addDevice (new SecurityCamera (5));
        securityGroup.addDevice (livingRoomLights);
        System.out.println (securityGroup.getStatus ());
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Composite 2

        //Tydzien 2, Wzorzec Composite 3
        SmartScenario nightMode = new SmartScenario.Builder("Night Mode")
                .addAction(new TurnOffLights())
                .addAction(new SetThermostatLow())
                .addAction(new ActivateAlarm())
                .build();
        nightMode.execute();
        System.out.println(SEPARATOR);
        //Koniec, Tydzien 2, Wzorzec Composite 3


        // Tydzień 3, Wzorzec Facade 1
        NotificationGroup notificationGroup = new NotificationGroup();
        notificationGroup.addNotification(Notificator.create(NotificationChannels.App));
        SecurityAlarm alarm1 = new SecurityAlarm(notificationGroup);
        SecurityAlarm alarm2 = new SecurityAlarm(notificationGroup);
        Light light1 = new Light();
        Light light2 = new Light();
        Light light3 = new Light();
        Thermostat thermostat1 = new Thermostat();
        SmartHome smartHome1 = new SmartHome.Builder("Smart Home 1")
                .location("Nadbystrzycka 38")
                .addDevice(light1)
                .addDevice(light2)
                .addDevice(light3)
                .addDevice(thermostat1)
                .addDevice(alarm1)
                .addDevice(alarm2)
                .build();
        SmartScenario smartScenario1 = new SmartScenario.Builder("My Scenario")
                .addAction(new GenericDeviceAction<>(light1, Light::turnOn))
                .addAction(new GenericDeviceAction<>(light2, Light::turnOff))
                .addAction(new GenericDeviceAction<>(light3, Light::turnOn))
                .build();
        SmartHomeFacade smartHomeFacade = new SmartHomeFacade(smartHome1, notificationGroup, smartScenario1);
        smartHomeFacade.executeScenario(smartScenario1.getName());
        smartHomeFacade.activateNightMode();
        smartHomeFacade.deactivateNightMode();
        System.out.println(SEPARATOR);
        // Koniec, Tydzień 3, Wzorzec Facade 1
    }
}

    /*
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
        //Koniec, Tydzień 1, Wzorzec Prototype 3
        System.out.println(SEPARATOR);


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

        //Tydzień 2, Wzorzec Bridge 1
        BasicRemoteControl remoteControl = new BasicRemoteControl(new Light());
        System.out.println(remoteControl.getStatus());
        remoteControl.turnOn();
        System.out.println(remoteControl.getStatus());
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Bridge 1


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

    }

    private void tydzien2()
    {
        //Tydzień 2, Wzorzec Composite 1
        System.out.println(SEPARATOR);
        LightingGroup livingRoomLights = new LightingGroup(1);
        livingRoomLights.addDevice(new Light());
        //livingRoomLights.addDevice(new BasicLight());
        livingRoomLights.turnOn();
        livingRoomLights.setBrightness (20);
        System.out.println(livingRoomLights.getStatus ());

        livingRoomLights.turnOff();
        livingRoomLights.setBrightness (40);
        System.out.println(livingRoomLights.getStatus ());
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Composite 1

        //Koniec Tydzień 2, Wzorzec Composite 2
        SecurityGroup securityGroup = new SecurityGroup (2);
        securityGroup.addDevice (new SecurityCamera (4));
        securityGroup.addDevice (new SecurityCamera (5));
        securityGroup.addDevice (livingRoomLights);
        System.out.println (securityGroup.getStatus ());
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Composite 2




        //Tydzień 2, Wzorzec Decorator 1
        SecurityCameraDecorator decorator = new SecurityCameraDecorator(
                new SecurityCamera(1)
        );
        System.out.println(decorator.getStatus());
        decorator.startRecording();
        System.out.println(decorator.getStatus());
        VerboseSecurityCameraDecorator decorator1 = new VerboseSecurityCameraDecorator(
                decorator
        );
        System.out.println(decorator1.getStatus());
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Decorator 1

        //Tydzień 2, Wzorzec Decorator 2
        NotificationGroup notificationGroup = new NotificationGroup();
        notificationGroup.addNotification(Notificator.create(NotificationChannels.App));
        notificationGroup.addNotification(Notificator.create(NotificationChannels.Email));
        NotificationDeviceDecorator decorator2 = new NotificationDeviceDecorator(
                new SecurityCamera(2),
                notificationGroup
        );
        decorator2.turnOn();
        decorator2.turnOff();
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Decorator 2

        //Tydzien 2, Wzorzec Composite 3
        Light light1 = new Light();
        Thermostat thermostat1 = new Thermostat();
        SecurityAlarm securityAlarm1 = new SecurityAlarm(notificationGroup);
        SmartScenario nightMode = new SmartScenario.Builder("Night Mode")
                .addAction(new TurnOffLights(light1))
                .addAction(new SetThermostatLow(thermostat1))
                .addAction(new ActivateAlarm(securityAlarm1))
                .build();
        nightMode.execute();
        System.out.println(SEPARATOR);
        //Koniec, Tydzien 2, Wzorzec Composite 3

        //Tydzień 2, Wzorzec Decorator 3
        SecurityCheckDecorator securityCheckDecorator = new SecurityCheckDecorator(
                new SecurityCamera(3)
        );
        securityCheckDecorator.turnOn();
        securityCheckDecorator.turnOff();
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Decorator 3


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
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Adapter 1

        //Tydzień 2, Wzorzec Adapter 2
        var externalBasicLight = new BasicLight();
        var externalBasicLightAdapter = new ExternalBasicLightAdapter(externalBasicLight);

        System.out.println(externalBasicLightAdapter.getStatus());
        externalBasicLightAdapter.turnOn();

        System.out.println(externalBasicLightAdapter.getStatus());
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Adapter 2

        //Tydzień 2, Wzorzec Adapter 3
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
        var advancedRemoteControl = new AdvancedRemoteControl(securityCamera);
        System.out.println(advancedRemoteControl.getStatus());
        advancedRemoteControl.startRecording();
        advancedRemoteControl.setBrightness(50);
        System.out.println(advancedRemoteControl.getStatus());
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Bridge 2

        //Tydzień 2, Wzorzez Bridge 3
        var mobileRemoteControl = new MobileRemoteControl(externalSecurityCameraAdapter);
        System.out.println(mobileRemoteControl.getStatus());
        mobileRemoteControl.enableVoiceControl();
        mobileRemoteControl.setBrightness(50);
        System.out.println(mobileRemoteControl.getStatus());
        System.out.println(SEPARATOR);
        //Koniec Tydzień 2, Wzorzec Bridge 3
    }
    */
