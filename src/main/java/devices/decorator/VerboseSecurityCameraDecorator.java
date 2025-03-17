package devices.decorator;

import devices.impl.security.SecurityCamera;

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
