package tests.allure_issue_tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest extends TestBase {

    @Test
    @Tag("webUI")
    public void allureIssueNameVerification() {
        step("Open web page by url: " + BASE_URL, (s) -> {
            s.parameter("url", BASE_URL);
            open(BASE_URL);
        });
        step("Search the " + REPOSITORY + " repository", (s) -> {
            s.parameter("repository", REPOSITORY);
            $(".header-search-input").setValue(REPOSITORY).submit();
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