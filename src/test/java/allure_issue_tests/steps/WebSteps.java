package allure_issue_tests.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Open web page by the url: {url}")
    public void openWebPage(String url) {
        open(url);
    }

    @Step("Search the {repository} repository")
    public void searchRepository(String repository) {
        $(".header-search-input").setValue(repository).submit();
    }

    @Step("Navigate into the {repository} repository")
    public void navigateIntoRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Open the Issues tab in repository")
    public void openIssueTab() {
        $(withText("Issues")).click();
    }

    @Step("Verify issue name for issue #{issueNumber} is {issueName}")
    public void verifyIssueNameForIssueNumber(int issueNumber, String issueName) {
        $(("#issue_" + issueNumber)).$("#issue_" + issueNumber + "_link")
                                    .shouldHave(Condition.exactText(issueName));
    }

}