package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MobilePhoneConfig;
import org.aeonbits.owner.ConfigFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobilePhoneDriver implements WebDriverProvider {

    public static MobilePhoneConfig config = ConfigFactory.create(MobilePhoneConfig.class);

    static String url = config.url();
    static String device = config.device();
    static String ver = config.ver();
    static String locale = config.locale();
    static String language = config.language();
    static String appPackage = config.appPackage();
    static String appActivity = config.appActivity();

    public static URL getAppiumServerUrl() {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", "Android");
       // desiredCapabilities.setCapability("deviceName", "pixel_4"); //mobile of Android Studio
        desiredCapabilities.setCapability("deviceName", device); //my mobile
        desiredCapabilities.setCapability("version", ver);
        desiredCapabilities.setCapability("locale", locale);
        desiredCapabilities.setCapability("language", language);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("app",
                getAbsolutePath("src/test/resources/app-alpha-universal-release.apk"));

        return new AndroidDriver(getAppiumServerUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");
        return file.getAbsolutePath();
    }
}
