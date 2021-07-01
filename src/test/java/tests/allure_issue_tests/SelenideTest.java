package tests.allure_issue_tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest extends TestBase {

    @Disabled("Do not run until fix")
    @Test
    @Tag("webUI")
    public void allureIssueNameVerification() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(BASE_URL);
        $(".header-search-input").setValue(REPOSITORY).submit();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $(withText("Issues")).click();

        $(("#issue_" + ISSUE_NUMBER)).$("#issue_" + ISSUE_NUMBER + "_link")
                                     .shouldHave(Condition.exactText(ISSUE_NAME));
    }

}