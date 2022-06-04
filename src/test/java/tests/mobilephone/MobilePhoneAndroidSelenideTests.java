package tests.mobilephone;

import org.junit.jupiter.api.Tag;
import testbases.MobileTestBase;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

@Tag("mobilephone")
public class MobilePhoneAndroidSelenideTests extends MobileTestBase {

    @Test
    void searchTest() {
        back();
        $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
        $$(MobileBy.id("org.wikipedia.alpha:id/fragment_search_results"))
                .shouldHave(sizeGreaterThan(0));
    }

    @Test
    void checkLanguage() {
        back();
        $(MobileBy.id("org.wikipedia.alpha:id/nav_more_container")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/main_drawer_settings_container")).click();
        $(MobileBy.id("android:id/summary")).isDisplayed();
    }

    @Test
    void checkTitle() {
        back();
        $(MobileBy.id("org.wikipedia.alpha:id/view_card_header_title")).isDisplayed();
        $(MobileBy.AccessibilityId("In the news")).isDisplayed();
        $(MobileBy.AccessibilityId("Featured article")).isDisplayed();
    }

    @Test
    void checkScreens() {
        $(MobileBy.AccessibilityId("ADD OR EDIT LANGUAGES")).isDisplayed();

        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        $(MobileBy.AccessibilityId("New ways to explore")).isDisplayed();


        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        $(MobileBy.AccessibilityId("Reading lists with sync")).isDisplayed();

        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        $(MobileBy.AccessibilityId("Send anonymous data")).isDisplayed();
    }
}
