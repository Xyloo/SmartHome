# Tydzień 1
### Factory
- devices.factory.DeviceFactory: 12-26
- notifications.Notificator: 1-11
- devices.configs.ConfigFactory: 1-23
### Singleton
- util.DeviceManager: 1-46
- util.SmartLogger: 1-30
- notifications.NotificationService: 1-26
### Builder
- home.SmartHome: 1-55
- notifications.Notification: 16-45
- devices.configs.LightConfig: 35-58
- devices.configs.SecurityCameraConfig: 29-40
- devices.configs.SmartPlugConfig: 35-52
### Prototype
- devices.impl.SmartPlug: 1-39
- devices.configs.SecurityCameraConfig: 20-27
- notifications.Notification: 47-54
# Tydzień 2
### Adapter
- devices.adapter.ExternalBasicLightAdapter: 1-35
- devices.adapter.ExternalSecurityCameraAdapter: 1-66
- devices.adapter.ExternalThermostatAdapter: 1-35
### Bridge
- devices.bridge.BasicRemoteControl: 1-29
- devices.bridge.AdvancedRemoteControl: 1-50
- devices.bridge.MobileRemoteControl: 1-55
### Composite
- devices.composite.LightingGroup: 1-29
- devices.composite.SecurityGroup: 1-48
- scenarios.SmartScenario: 1-48
### Decorator
- devices.decorator.SecurityCameraDecorator: 1-64
- devices.decorator.NotificationDeviceDecorator: 1-38
- devices.decorator.SecurityCheckDecorator: 1-51
# Tydzień 3
### Facade
- home.SmartHomeFacade: 1-72
- devices.proxy.MonitoringFacade: 1-54
- devices.impl.speakers.SmartSpeakerFacade: 1-68
### Flyweight
- devices.security.sensors.SmartHomeSecuritySystem: 1-37
- devices.impl.security.lockingsystem.LockingSystem: 1-39
- devices.impl.speakers.SmartSpeakerSystem: 1-29
### Proxy
- devices.proxy.CameraProxy: 1-34
- devices.proxy.CloudStorageProxy: 1-27
- devices.impl.security.SecureDeviceProxy: s1-61
# Tydzień 4
### Command
- devices.impl.command.SetBrightnessCommand: 1-26
- scenarios.actions.GenericDeviceAction: 11-34
- devices.command.SetLightColorCommand: 7-34
- devices.command.TurnOnDeviceCommand: 6-23
### Interpreter
- devices.interpreter.expressions.TurnOnExpression: 7-24
- devices.interpreter.CommandParser: 5-23
- devices.interpreter.Context: 9-19
### Iterator 
- devices.impl.speakers.SmartSpeakerFacade: 40-50
- home.SmartHomeFacade: 63-77
- scenarios.iterator.SmartScenarioIterator: 7-34
- devices.iterator.FilteringSmartDeviceIterator: 9-50
### Mediator
- devices.mediator.SecurityMediator: 7-23
- home.SmartHomeFacade: 84-95
- devices.mediator.SmartDeviceHandler: 8-20
# Tydzień 5
### Observer
- devices.impl.Thermostat: 53-70
- devices.observer.BatteryWarningDisplay: 1-14
- devices.impl.security.sensors.MotionSensor: 59-81
### State
- devices.state.AlarmState: 1-10, devices.impl.SecurityAlarm: 51-66
- devices.impl.sprinklers.Sprinkler: 5-24
- devices.state.lockings.LockedState: 1-20
### Strategy
- devices.impl.Thermostat: 75-87
- devices.impl.speakers.SmartSpeaker: 24-36
- devices.impl.lighting.Light: 66-69
### Template
- devices.template.FirmwareUpdateTemplate: 1-31
- devices.impl.security.checks.SecurityCheck: 4-32
- devices.template.EveningLightningRoutine: 1-18
# Tydzień 6
## Memento
- devices.memento.BlindMemento:1-21
-
-
## Visitor
- devices.visitor.SmartDeviceVisitor: 1-28, devices.impl.AbstractSmartDevice: 58-60, devices.visitor.StatusReportVisitor: 1-80
-
- 