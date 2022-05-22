package config;

import com.codeborne.selenide.Configuration;
import config.drivers.BrowserStackMobileDriver;
import config.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static config.helpers.Attach.getSessionId;

public class BrowserStackTestBase {

    public static String
            login = null,
            key = null,
            url = null;


    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        initVars();
        Configuration.browser = BrowserStackMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    private static void initVars() {
        BrowserStackConfig credentials =
                ConfigFactory.create(BrowserStackConfig.class);

        login = credentials.login();
        key = credentials.key();
        url = credentials.url();
    }

    @AfterEach
    public void afterEach() {
        String sessionID = getSessionId();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
        Attach.attachVideo(sessionID);
    }
}
