package config.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import config.TestBase;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackMobileDriver extends TestBase implements WebDriverProvider {

    public static URL getBrowserStackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", login);
        desiredCapabilities.setCapability("browserstack.key", key);

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", url);

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", "Google Pixel 3");
        desiredCapabilities.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "first_test");

        return new AndroidDriver(getBrowserStackUrl(), desiredCapabilities);
    }
}