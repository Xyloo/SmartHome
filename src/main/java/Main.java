public class Main
{
    private static final String SEPARATOR = "----------------------------------------";

    public static void main(String[] args) {
        // Tydzień 6, Wzorzec Memento 1
        System.out.println("Wzorzec Memento 1");
        // Koniec Tydzień 6, Wzorzec Memento 1

        System.out.println(SEPARATOR);

        // Tydzień 6, Wzorzec Memento 2
        System.out.println("Wzorzec Memento 2");
        // Koniec Tydzień 6, Wzorzec Memento 2

        System.out.println(SEPARATOR);

        // Tydzień 6, Wzorzec Memento 3
        System.out.println("Wzorzec Memento 3");

        // Koniec Tydzień 6, Wzorzec Memento 3

        System.out.println(SEPARATOR);

        // Tydzień 6, Wzorzec Visitor 1
        System.out.println("Wzorzec Visitor 1");

        // Koniec Tydzień 6, Wzorzec Visitor 1

        System.out.println(SEPARATOR);

        // Tydzień 6, Wzorzec Visitor 2
        System.out.println("Wzorzec Visitor 2");

        // Koniec Tydzień 6, Wzorzec Visitor 2

        System.out.println(SEPARATOR);

        // Tydzień 6, Wzorzec Visitor 3
        System.out.println("Wzorzec Visitor 3");

        // Koniec Tydzień 6, Wzorzec Visitor 3

        System.out.println(SEPARATOR);

        // Tydzień 6, SOLID - Single-Responsibility 1
        System.out.println("SOLID - Single-Responsibility 1");

        // Koniec Tydzień 6, SOLID - Single-Responsibility 1

        System.out.println(SEPARATOR);

        // Tydzień 6, SOLID - Single-Responsibility 2
        System.out.println("SOLID - Single-Responsibility 2");

        // Koniec Tydzień 6, SOLID - Single-Responsibility 2

        System.out.println(SEPARATOR);

        // Tydzień 6, SOLID - Single-Responsibility 3
        System.out.println("SOLID - Single-Responsibility 3");

        // Koniec Tydzień 6, SOLID - Single-Responsibility 3

        System.out.println(SEPARATOR);

        // Tydzień 6, SOLID - Open-Close 1
        System.out.println("SOLID - Open-Close 1");

        // Koniec Tydzień 6, SOLID - Open-Close 1

        System.out.println(SEPARATOR);

        // Tydzień 6, SOLID - Open-Close 2
        System.out.println("SOLID - Open-Close 2");

        // Koniec Tydzień 6, SOLID - Open-Close 2

        System.out.println(SEPARATOR);

        // Tydzień 6, SOLID - Open-Close 3
        System.out.println("SOLID - Open-Close 3");

        // Koniec Tydzień 6, SOLID - Open-Close 3
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
    private void tydzien3(){
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

        System.out.println(SEPARATOR);

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

        // Tydzień 3, Wzorzec Proxy 1 & Facade 2
        MonitoringFacade monitoring = new MonitoringFacade();
        monitoring.startRecording();
        monitoring.stopRecording();
        // Koniec, Tydzień 3, Wzorzec Proxy 1 & Facade 2
        System.out.println(SEPARATOR);

        // Tydzień 3, Wzorzec Proxy 1, 2
        Camera camera = new CameraProxy();
        camera.startRecording();
        camera.stopRecording();
        // Koniec, Tydzień 3, Wzorzec Proxy 1, 2
        System.out.println(SEPARATOR);

        // Tydzień 3, Wzorzec Proxy 3
        SecurityConfig securityConfig = new SecurityConfig("password123");
        SecureDeviceProxy secureDeviceProxy = new SecureDeviceProxy(alarm1, securityConfig);
        secureDeviceProxy.turnOn();
        secureDeviceProxy.turnOff();
        // Koniec, Tydzień 3, Wzorzec Proxy 3
        System.out.println(SEPARATOR);

        // Tydzień 3, Wzorzec Flyweight 3
        SmartSpeakerSystem speakerSystem = new SmartSpeakerSystem();

        // Install speakers (note how shared SpeakerType is reused if identical)
        speakerSystem.installSpeaker("Living Room", "Echo Dot", "Amazon", true);
        speakerSystem.installSpeaker("Kitchen", "Echo Dot", "Amazon", true);
        speakerSystem.installSpeaker("Bedroom", "HomePod Mini", "Apple", false);

        // Play music on all speakers
        speakerSystem.playMusicOnAll("Imagine by John Lennon");

        // Adjust volume on all speakers
        speakerSystem.setAllVolumes(70);
        // Koniec, Tydzień 3, Wzorzec Flyweight 3

        System.out.println(SEPARATOR);

        // Tydzień 3, Wzorzec Facade 3
        SmartSpeakerFacade speakerFacade = new SmartSpeakerFacade();

        speakerFacade.installSpeaker("Living Room", "Echo Dot", "Amazon", true);
        speakerFacade.installSpeaker("Kitchen", "Echo Dot", "Amazon", true);

        speakerFacade.turnOnAllSpeakers();
        speakerFacade.playMusicOnAll("Imagine by John Lennon");
        speakerFacade.setVolumeForAll(70);

        speakerFacade.playMusicOnSpeaker("Living Room", "Song B");
        speakerFacade.setVolumeForSpeaker("Living Room", 30);

        speakerFacade.activatePartyMode();
        speakerFacade.turnOffAllSpeakers();
        // Koniec, Tydzień 3, Wzorzec Facade 3
    }
private void tydzien4(){
// Tydzien 4, Wzorzec Command 1
        Light lightDevice1 = (Light)DeviceFactory.createDevice ("light");
        Light lightDevice2 = (Light)DeviceFactory.createDevice ("light");
        Light lightDevice3 = (Light)DeviceFactory.createDevice ("light");

        System.out.println ("\n" + SEPARATOR + "\n");

        System.out.println("Command 1");
        System.out.println (lightDevice1.getStatus ());
        System.out.println (lightDevice2.getStatus ());
        System.out.println (lightDevice3.getStatus ());

        SmartScenario smartScenario = new SmartScenario.Builder("My Scenario")
                .addAction(new GenericDeviceAction<>(lightDevice1, Light::turnOn))
                .addAction(new GenericDeviceAction<>(lightDevice2, Light::turnOff))
                .addAction(new GenericDeviceAction<>(lightDevice3, Light::turnOn))
                .build();

        smartScenario.execute ();


        System.out.println ( "\n" + lightDevice1.getStatus ());
        System.out.println (lightDevice2.getStatus ());
        System.out.println (lightDevice3.getStatus ());

        // Koniec Tydzien 4, Wzorzec Command 1

        // Tydzien 4, Wzorzec Command 2
        System.out.println(SEPARATOR + "\n Command 2");
        LightingDevice colorLight = new ColorLight("red");
        System.out.println(colorLight.getStatus());

        System.out.println("\n");
        MacroCommand colorLightCommands = new MacroCommand();
        colorLightCommands.addCommand(new SetBrightnessCommand(colorLight, 10));
        colorLightCommands.addCommand(new TurnOnDeviceCommand(colorLight));
        colorLightCommands.addCommand(new SetLightColorCommand(colorLight, "blue"));
        colorLightCommands.execute();

        System.out.println(colorLight.getStatus());
        System.out.println("\n");

        LightingDevice lightDevice = new Light();
        lightDevice.turnOn();
        System.out.println(lightDevice.getStatus());
        System.out.println("\n");


        MacroCommand lightCommands = new MacroCommand();
        colorLightCommands.addCommand(new SetBrightnessCommand(lightDevice, 20));
        colorLightCommands.addCommand(new TurnOffDeviceCommand(lightDevice));

        colorLightCommands.execute();
        System.out.println(colorLight.getStatus());


        System.out.println("CommandsWrapper");
        MacroCommand commandsWrapper = new MacroCommand();
        commandsWrapper.addCommand(colorLightCommands);
        commandsWrapper.addCommand(lightCommands);
        commandsWrapper.execute();

        System.out.println(colorLight.getStatus());
        System.out.println(lightDevice.getStatus());


        // Koniec Tydzien 4, Wzorzec Command 2

        // Tydzien 4, Wzorzec Command 3

        System.out.println(SEPARATOR + "\n Command 3");
        LockingSystem system = new LockingSystem();
        system.installBlind("Sypialnia","Dzień-noc","Białe","Zaciemniające");
        system.installBlind("Kuchnia","Dzień-noc","Białe","Termoizolacyjne");
        system.installBlind("Salon","Dzień-noc","Białe","Zaciemniające");

        Command closeAllRollersCommand = new CloseAllBlindsCommand(system.getBlinds());

        // Wykonujemy komendę
        closeAllRollersCommand.execute();

        // Cofamy działanie (undo)
        closeAllRollersCommand.undo();
        // Koniec Tydzien 4, Wzorzec Command 3

        System.out.println(SEPARATOR);
        System.out.println("Interpreter 1");

        // Tydzien 4, Wzorzec Interpreter 1

        System.out.println(lightDevice.getStatus());
        Context context = new Context();
        lightDevice.turnOff();
        context.addDevice("LIGHT", lightDevice);
        String command = "TURN_ON LIGHT";
        Expression expression = CommandParser.parse(command);

        if(expression != null){
            expression.interpret(context);
        }
        System.out.println(lightDevice.getStatus());

        // Koniec Tydzien 4, Wzorzec Interpreter 1

        System.out.println(SEPARATOR);

        // Tydzien 4, Wzorzec Interpreter 2
        System.out.println ("Interpreter 2 \n Initial light status:" + lightDevice.getStatus ());
        Expression expression2 = CommandParser.parse("SET_BRIGHTNESS LIGHT 99");
        if(expression2 != null)
        {
            expression2.interpret (context);
        }

        System.out.println (lightDevice.getStatus ());

        // Koniec Tydzien 4, Wzorzec Interpreter 2

        System.out.println(SEPARATOR);

        // Tydzien 4, Wzorzec Interpreter 3

        System.out.println ("Interpreter 3");
        SmartSpeakerSystem speakerSystem = new SmartSpeakerSystem();

        SmartSpeaker speaker1 = speakerSystem.installSpeaker("Living Room", "Echo Dot", "Amazon", true);
        SmartSpeaker speaker2 = speakerSystem.installSpeaker("Kitchen", "Echo Dot", "Amazon", true);
        SmartSpeaker speaker3 = speakerSystem.installSpeaker("Bedroom", "HomePod Mini", "Apple", false);

        context.addDevice(speaker1.getLocation(),speaker1);
        context.addDevice(speaker2.getLocation(),speaker2);
        context.addDevice(speaker3.getLocation(),speaker3);

        Expression expression3 = CommandParser.parse("SET_VOLUME KITCHEN 50");
        if(expression3 != null)
        {
            expression3.interpret (context);
        }

        // Koniec Tydzien 4, Wzorzec Interpreter 3

        System.out.println(SEPARATOR);

        // Tydzien 4, Wzorzec Iterator 1

        System.out.println("Iterator 1");
        LightingGroup lightingGroup = new LightingGroup();
        lightingGroup.addDevice(colorLight);
        lightingGroup.addDevice(lightDevice);

        Iterator<SmartDevice> smartDeviceIterator = new FilteringSmartDeviceIterator(
                lightingGroup.iterator(),
                device -> device instanceof ColorLight
        );

        while (smartDeviceIterator.hasNext()) {
            System.out.println(smartDeviceIterator.next().getStatus());
        }

        // Koniec Tydzien 4, Wzorzec Iterator 1



        // Tydzien 4, Wzorzec Iterator 2
        System.out.println(SEPARATOR + "\n Iterator 2");
        SmartSpeakerFacade speakerFacade = new SmartSpeakerFacade();

        speakerFacade.installSpeaker("Living Room", "Xl5S", "LG", true);
        speakerFacade.installSpeaker("Kitchen", "TD22", "Sony", false);
        speakerFacade.installSpeaker("Living Room", "Acton III", "Marshall", true);

        speakerFacade.playMusicOnSpeaker("Living Room", "Nirvana - Come as You Are");
        speakerFacade.playMusicOnSpeaker("Kitchen", "Linkin Park - Numb");
        speakerFacade.playMusicOnSpeaker("Bedroom", "Metallica - Nothing else matters");

        // Koniec Tydzien 4, Wzorzec Iterator 2



        // Tydzien 4, Wzorzec Iterator 3
        System.out.println(SEPARATOR + "\n Iterator 3");
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

        List<String> scenariosToExecute = new ArrayList<>();
        scenariosToExecute.add("NightMode");
        scenariosToExecute.add("My Scenario");

        smartHomeFacade.executeScenarios(scenariosToExecute);
        // Koniec Tydzien 4, Wzorzec Iterator Iterator 3



        // Tydzien 4, Wzorzec Mediator 1
        System.out.println(SEPARATOR + "\n Mediator 1");
        MotionSensor sensor = new MotionSensor("Video motion sensor","Xiaomi","high sensitive");
        sensor.setMediator(smartHomeFacade);
        sensor.triggerAlarm("Entrance",true);
        // Koniec Tydzien 4, Wzorzec Mediator 1



        // Tydzien 4, Wzorzec Mediator 2
        System.out.println(SEPARATOR + "\n Mediator 2");
        SmartDeviceHandler handler = new SmartDeviceHandler();
        SmartDevice light = DeviceFactory.createDevice("light");
        SmartDevice camera = DeviceFactory.createDevice("camera");

        handler.addDevice(light);
        handler.addDevice(camera);

        handler.notify(light,"LIGHTS_TURN_OFF");
        // Koniec Tydzien 4, Wzorzec Mediator 2



        // Tydzien 4, Wzorzec Mediator 3
        System.out.println(SEPARATOR + "\n Mediator 3");
        SecurityMediator securityMediator = new SecurityMediator();
        SmartDevice secureWindow = new SecureWindow("Secure Window", 2);
        SmartDevice securityCamera = new SecurityCamera(3);

        securityMediator.registerDevice(secureWindow);
        securityMediator.registerDevice(light);
        securityMediator.registerDevice(securityCamera);

        SmartDevice door = new Door();
        door.setMediator(securityMediator);
        ((Door)door).simulateIncorrectPassword();

        System.out.println("\n");
        // Koniec Tydzien 4, Wzorzec Mediator Mediator

        //Tydzień 5, Wzorzec Observer 1
        System.out.println("Wzorzec Observer 1");
        var thermostat = new Thermostat();
        thermostat.registerObserver(new CoolingSystem());
        thermostat.registerObserver(new HeatingSystem());

        thermostat.setTemperature(30);
        thermostat.setTemperature(19);

        //Koniec Tydzien 5, Wzorzec Observer 1

        System.out.println(SEPARATOR);

        //Tydzień 5, Wzorzec Observer 2
        System.out.println("Wzorzec Observer 2");
        BatterySubject batterySensor = new BatterySubject();
        BatteryWarningDisplay display = new BatteryWarningDisplay();

        batterySensor.registerObserver(display);

        batterySensor.setBatteryLevel(15);  // Should trigger a low battery warning
        batterySensor.setBatteryLevel(80);  // Should indicate a stable battery level

        //Koniec Tydzien 5, Wzorzec Observer 2

        //Tydzień 5, Wzorzec Observer 3
        System.out.println(SEPARATOR);
        System.out.println("Wzorzec Observer 3");

        Light light = new Light();
        SecurityCamera camera = new SecurityCamera();
        MotionSensor sensor = new MotionSensor("Video motion sensor","Xiaomi","high sensitive");

        sensor.registerObserver(camera);
        sensor.registerObserver(light);

        sensor.triggerAlarm("Backdoor");

        System.out.println(light.getStatus());
        System.out.println(camera.getStatus());

        //Koniec Tydzien 5, Wzorzec Observer 3

        System.out.println(SEPARATOR);

        //Tydzień 5, Wzorzec State 1
        System.out.println("Wzorzec State 1");
        NotificationGroup notificationGroup = new NotificationGroup();
        notificationGroup.addNotification(Notificator.create(NotificationChannels.App));

        SecurityAlarm alarm = new SecurityAlarm(notificationGroup);
        alarm.arm();
        alarm.trigger();
        alarm.disarm();
        System.out.println(alarm.getStatus());
        //Koniec Tydzien 5, Wzorzec State 1

        System.out.println(SEPARATOR);

        //Tydzień 5, Wzorzec State 2
        System.out.println("Wzorzec State 2");
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.startWatering();
        sprinkler.turnOffSprinkler();
        //Koniec Tydzien 5, Wzorzec State 2

        System.out.println(SEPARATOR);

        //Tydzień 5, Wzorzec State 3
        System.out.println("Wzorzec State 3");
        SmartLock frontDoorLock = new SmartLock("Front Door Lock", 101);
        System.out.println(frontDoorLock.getStatus());
        frontDoorLock.unlock();
        System.out.println(frontDoorLock.getStatus());
        frontDoorLock.lock();
        System.out.println(frontDoorLock.getStatus());

        //Koniec Tydzien 5, Wzorzec State 3

        System.out.println(SEPARATOR);

        //Tydzień 5, Wzorzec Strategy 1
        System.out.println("Wzorzec Strategy 1");
        Thermostat thermostat2 = new Thermostat();
        thermostat2.setStrategy(new EcoModeStrategy());
        thermostat2.adjustTemperature();  // Sets to 18°C

        thermostat2.setStrategy(new ComfortModeStrategy());
        thermostat2.adjustTemperature();  // Sets to 22°C

        //Koniec Tydzien 5, Wzorzec Strategy 1

        System.out.println(SEPARATOR);

        //Tydzień 5, Wzorzec Strategy 2
        System.out.println("Wzorzec Strategy 2");
        SmartSpeakerSystem speakerSystem = new SmartSpeakerSystem();
        SmartSpeaker strategySpeaker = speakerSystem.installSpeaker("Living Room", "Echo Dot", "Amazon", true);

        strategySpeaker.setStrategy(new LofiModeSpeaker());
        strategySpeaker.playPlaylist();

        strategySpeaker.setStrategy(new PartyModeSpeaker());
        strategySpeaker.playPlaylist();
        //Koniec Tydzien 5, Wzorzec Strategy 2

        System.out.println(SEPARATOR);

        //Tydzień 5, Wzorzec Strategy 3
        System.out.println("Wzorzec Strategy 3");
        BrightnessStrategy ecoMode = new EnergySavingStrategy();
        BrightnessStrategy partyMode = new FullBrightnessStrategy();

        light.turnOn();
        ((Light) light).applyBrightnessStrategy(ecoMode);
        System.out.println(light.getStatus());

        ((Light) light).applyBrightnessStrategy(partyMode);
        System.out.println(light.getStatus());

        System.out.println(SEPARATOR);

        //Tydzień 5, Wzorzec Template 1
        System.out.println("Wzorzec Template 1");
        SmartSpeaker speaker = new SmartSpeaker(SpeakerFactory.getSpeakerType("Echo Dot", "Amazon", true), "Living Room");
        FirmwareUpdateTemplate speakerUpdate = new SmartSpeakerFirmwareUpdate(speaker);
        speakerUpdate.performFirmwareUpdate();

        FirmwareUpdateTemplate cameraUpdate = new SecurityCameraFirmwareUpdate(camera);
        cameraUpdate.performFirmwareUpdate();
        //Koniec Tydzien 5, Wzorzec Template 1

        System.out.println(SEPARATOR);

        //Tydzień 5, Wzorzec Template 2
        System.out.println("Wzorzec Template 2");

        System.out.println("\nNight Mode Check:");
        SecurityCheck nightCheck = new NightSecurityCheck();
        nightCheck.performSecurityCheck();

        System.out.println("\nAway Security Check:");
        SecurityCheck awayCheck = new AwaySecurityCheck();
        awayCheck.performSecurityCheck();

        //Koniec Tydzien 5, Wzorzec Template 2

        System.out.println(SEPARATOR);

        //Tydzien 5, Wzorzec Template 3
        System.out.println("Wzorzec Template 3");

        LightingDevice livingRoomLight = new Light();
        DeviceRoutine lightingRoutine = new EveningLightingRoutine(livingRoomLight);
        lightingRoutine.executeRoutine();
        System.out.println(livingRoomLight.getStatus());

        DeviceRoutine securityRoutine = new NightSecurityRoutine(camera);
        securityRoutine.executeRoutine();
        System.out.println(camera.getStatus());

        //Koniec Tydzien 5, Wzorzec Template 3
    }
 */
