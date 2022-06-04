package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:emulator.properties"})
public interface EmulatorConfig extends Config {
    @Key("url")
    String url();

    @Key("device")
    String device();

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
