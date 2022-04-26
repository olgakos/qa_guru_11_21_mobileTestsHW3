package tests;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class WikipediaAppiumTest extends TestBase {

    @Owner("olgakos")
    //@Disabled ("пропуск")
    @Feature("Mobile smoke tests")
    @DisplayName("Поиск Wikipedia-статьи по запросу Appium (AppiumBy)")
    //@Tag("selenide")
    @Tags({@Tag("api"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    @Test
    void wikiSearchSkipOnBoardingTest() {
        step("Skip onboarding page", () -> back());
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .setValue("Appium");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

}
