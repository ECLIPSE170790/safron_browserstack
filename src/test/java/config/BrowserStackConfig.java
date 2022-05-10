package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:Credentials.properties"})
public interface BrowserStackConfig extends Config {
    String login();
    String key();
    String url();
}
