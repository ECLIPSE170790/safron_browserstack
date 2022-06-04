package tests.browserstack;

import org.junit.jupiter.api.Tag;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;
import testbases.BrowserStackTestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Tag("browserstack")
public class BrowserStackAndroidSelenideTests extends BrowserStackTestBase {

    @Test
    void searchTest() {
        $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
        $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                .shouldHave(sizeGreaterThan(0));
    }

    @Test
    void checkLanguage() {
        $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        $(MobileBy.id("android:id/summary")).isDisplayed();
    }

    @Test
    void checkTitle() {
        $(MobileBy.id("org.wikipedia.alpha:id/view_card_header_subtitle")).isDisplayed();
        $(MobileBy.AccessibilityId("In the news")).isDisplayed();
        $(MobileBy.AccessibilityId("Featured article")).isDisplayed();
    }


}
