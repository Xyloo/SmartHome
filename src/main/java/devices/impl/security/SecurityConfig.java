package devices.impl.security;

public class SecurityConfig
{
    private final String requiredPassword;

    public SecurityConfig(String requiredPassword)
    {
        this.requiredPassword = requiredPassword;
    }

    public boolean isAuthorized(String inputPassword)
    {
        return requiredPassword.equals(inputPassword);

    }
}
