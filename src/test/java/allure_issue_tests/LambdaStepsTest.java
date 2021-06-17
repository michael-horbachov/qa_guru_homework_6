package allure_issue_tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;
    private static final String ISSUE_NAME = "Listeners NamedBy";

    @Test
    public void allureIssueNameVerification() {
        step("Open web page by url: " + BASE_URL, (s) -> {
            s.parameter("url", BASE_URL);
            open(BASE_URL);
        });
        step("Search the " + REPOSITORY + " repository", (s) -> {
            s.parameter("repository", REPOSITORY);
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Navigate into the " + REPOSITORY + " repository", (s) -> {
            s.parameter("repository", REPOSITORY);
            $(By.linkText("eroshenkoam/allure-example")).click();
        });
        step("Open the Issues tab in repository", () -> {
            $(withText("Issues")).click();
        });
        step("Verify issue name for issue #" + ISSUE_NUMBER + " is " + ISSUE_NAME, (s) -> {
            s.parameter("issue number", ISSUE_NUMBER);
            s.parameter("issue name", ISSUE_NAME);
            $(("#issue_" + ISSUE_NUMBER)).$("#issue_" + ISSUE_NUMBER + "_link")
                                         .shouldHave(Condition.exactText(ISSUE_NAME));
        });
    }

}