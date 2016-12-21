package by.epam.gmail.automation.runner;

import by.epam.gmail.automation.pages.*;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        glue = "by.epam.gmail.automation",
        features = "classpath:cucumber/gmail.feature"
)

public class RunGmailTest {
    protected static WebDriver driver;
    protected LoginPage loginPage = new LoginPage(driver);
    protected ConfirmationPage confirmationPage = new ConfirmationPage(driver);
    protected ForwardPopImapSettingsPage forwardPopImapSettingsPage = new ForwardPopImapSettingsPage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected GeneralSettingsPage generalSettingsPage = new GeneralSettingsPage(driver);
    protected ThemesPage themesPage = new ThemesPage(driver);
    protected MessagePage messagePage = new MessagePage(driver);
    protected SpamPage spamPage = new SpamPage(driver);
    protected SwitchUserPage switchUserPage = new SwitchUserPage(driver);
    protected TrashPage trashPage = new TrashPage(driver);



    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pavel_Sereda\\Desktop\\bdd\\Gmail-Automation-master\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterClass
    public void afterClass() {
        driver.close();
    }

}
