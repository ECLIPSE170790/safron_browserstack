package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:mobilephone.properties"})
public interface MobilePhoneConfig extends Config {

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
