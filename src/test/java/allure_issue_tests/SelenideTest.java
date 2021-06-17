package allure_issue_tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;
    private static final String ISSUE_NAME = "Listeners NamedBy";

    @Test
    public void allureIssueNameVerification() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(BASE_URL);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $(withText("Issues")).click();

        $(("#issue_" + ISSUE_NUMBER)).$("#issue_" + ISSUE_NUMBER + "_link")
                                     .shouldHave(Condition.exactText(ISSUE_NAME));
    }

}