package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:selenoid.properties"})
public interface SelenoidConfig extends Config {
    @Key("url")
    String url();

    @Key("user")
    String user();

    @Key("pass")
    String pass();

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("ver")
    String ver();

    @Key("locale")
    String locale();

    @Key("language")
    String language();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();
}
