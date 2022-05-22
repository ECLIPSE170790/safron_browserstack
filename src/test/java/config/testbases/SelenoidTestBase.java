package config.testbases;

import com.codeborne.selenide.Configuration;
import config.BrowserStackConfig;
import config.drivers.LocalMobileDriver;
import config.drivers.SelenoidMobileDriver;
import config.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class SelenoidTestBase {

    public static String
            login = null,
            key = null,
            url = null;


    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        initVars();
        Configuration.browser = SelenoidMobileDriver.class.getName();
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
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
    }
}
