package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WikipediaMobileByTest extends TestBase {

    @Owner("olgakos")
    @Feature("Mobile smoke tests")
    @DisplayName("Проверка мобильной Wikipedia (MobileBy). Поиск статьи по запросу Java")
    @Test
        void wikiSearchTest() {
            step("Skip first onboarding page", () ->
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click()
            //back()
            ); //?

            step("Type search", () -> {
                //$(AppiumBy.accessibilityId("Search Wikipedia")).click();
                $(MobileBy.AccessibilityId("Search Wikipedia")).click();
                //$(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Java");
            });

            step("Verify content found", () ->
                    $$(byClassName("android.widget.TextView"))
                            //$$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                            .shouldHave(sizeGreaterThan(0))
            );

        }
}


