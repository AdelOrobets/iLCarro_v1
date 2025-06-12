package manager;

import dto.UserLombok;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;
import utils.HeaderMenuItem;
import utils.RandomUtils;

import java.time.Duration;

@Getter
public class ApplicationManager {

    public WebDriver driver;
    public SignUpPage signUpPage;
    public LoginPage loginPage;
    public UserLombok testUser;

    public WebDriver initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        return driver;
    }

    public void createUniqueTestUserForRegistration() {
        String firstName = RandomUtils.generateFirstNameFromList();
        String lastName = RandomUtils.generateLastNameFromList();
        String email = RandomUtils.generateEmail(8);
        String password = RandomUtils.generatePassword(10);
        testUser = new UserLombok(email, password, firstName, lastName);
        System.out.println("Generated testUser: Email: " + email + ", Password: " + password);
    }

//    public static void createUniqueTestUserForLogin() {
//        String email = RandomUtils.generateEmail(8);
//        String password = RandomUtils.generatePassword(10);
//        testUser = new UserLombok(email, password);
//        System.out.println("Generated testUser: Email: " + email + ", Password: " + password);
//    }

    public void openLoginPage() {
        loginPage = new HomePage(driver).clickHeaderMenuItem(HeaderMenuItem.LOGIN);
    }

    public void openSignUpPage() {
        signUpPage = new HomePage(driver).clickHeaderMenuItem(HeaderMenuItem.SIGN_UP);
    }

    @BeforeMethod
    public void setUpTest() {
        if (driver == null) {
            driver = initDriver();
        }
        openLoginPage();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
