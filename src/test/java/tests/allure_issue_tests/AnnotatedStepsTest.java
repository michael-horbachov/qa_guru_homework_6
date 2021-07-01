package tests.allure_issue_tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.allure_issue_tests.steps.WebSteps;

public class AnnotatedStepsTest extends TestBase {

    private final WebSteps webSteps = new WebSteps();

    @Test
    @Tag("webUI")
    public void allureIssueNameVerification() {
        webSteps.openWebPage(BASE_URL);
        webSteps.searchRepository(REPOSITORY);
        webSteps.navigateIntoRepository(REPOSITORY);
        webSteps.openIssueTab();
        webSteps.verifyIssueNameForIssueNumber(ISSUE_NUMBER, ISSUE_NAME);
    }

}