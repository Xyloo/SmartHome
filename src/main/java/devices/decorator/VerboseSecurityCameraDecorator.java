package devices.decorator;

import devices.impl.security.SecurityCamera;

//Tydzień 2, Wzorzec Decorator 4
public class VerboseSecurityCameraDecorator extends SecurityCameraDecorator {

    public VerboseSecurityCameraDecorator(SecurityCamera decorated) {
        super(decorated);
    }

    @Override
    public String getStatus() {
        return "[Verbose Security Status] "
            + super.getStatus();
    }
}
//Tydzień 2, Wzorzec Decorator 4