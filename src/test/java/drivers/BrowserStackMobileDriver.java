package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserStackConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackMobileDriver implements WebDriverProvider {

    public static BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class);

    static String url = config.url();
    static String login = config.login();
    static String key = config.key();
    static String app = config.app();
    static String device = config.device();
    static String ver = config.ver();


    public static URL getBrowserStackUrl() {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("browserstack.user", login);
        desiredCapabilities.setCapability("browserstack.key", key);
        desiredCapabilities.setCapability("app", app);
        desiredCapabilities.setCapability("device", device);
        desiredCapabilities.setCapability("os_version", ver);

        desiredCapabilities.setCapability("project", "Home work by Safronova Y.L.");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "Test for mobile app");

        return new AndroidDriver(getBrowserStackUrl(), desiredCapabilities);
    }
}
