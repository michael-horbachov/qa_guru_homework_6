package allure_issue_tests;

import allure_issue_tests.steps.WebSteps;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;
    private static final String ISSUE_NAME = "Listeners NamedBy";

    private final WebSteps webSteps = new WebSteps();

    @Test
    public void allureIssueNameVerification() {
        webSteps.openWebPage(BASE_URL);
        webSteps.searchRepository(REPOSITORY);
        webSteps.navigateIntoRepository(REPOSITORY);
        webSteps.openIssueTab();
        webSteps.verifyIssueNameForIssueNumber(ISSUE_NUMBER, ISSUE_NAME);
    }

}