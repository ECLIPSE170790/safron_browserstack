package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.SelenoidConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidMobileDriver implements WebDriverProvider {

    public static SelenoidConfig config = ConfigFactory.create(SelenoidConfig.class);

    static String url = config.url();
    static String user = config.user();
    static String pass = config.pass();
    static String platformName = config.platformName();
    static String deviceName = config.deviceName();
    static String ver = config.ver();
    static String locale = config.locale();
    static String language = config.language();
    static String appPackage = config.appPackage();
    static String appActivity = config.appActivity();

    public static URL getSelenoidUrl() {
        try {
            //return new URL("https://user1:1234@65.108.161.82:8080/wd/hub");
            //return new URL("https://user1:1234@selenoid.autotests.cloud/wd/hub");
            return new URL("https://" + user + ":" + pass + "@" + url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("version", ver);
        desiredCapabilities.setCapability("locale", locale);
        desiredCapabilities.setCapability("language", language);
        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);

        desiredCapabilities.setCapability("app", apkUrl());

        return new AndroidDriver(getSelenoidUrl(), desiredCapabilities);
    }

   private URL apkUrl() {
        try {
            return new URL("https://github.com/wikimedia/apps-android-wikipedia/" +
                    "releases/tag/latest/app-alpha-universal-release.apk");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
   }
}
