package tests.allure_issue_tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static config.Credentials.credentials;

public class TestBase {

    public static final String BASE_URL = "https://github.com";
    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final int ISSUE_NUMBER = 68;
    public static final String ISSUE_NAME = "Listeners NamedBy";

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.startMaximized = true;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        String login = credentials.login();
        String password = credentials.password();

        Configuration.remote = String.format("https://%s:%s@%s/wd/hub/", login, password, System.getProperty("selenoidUrl"));
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

}