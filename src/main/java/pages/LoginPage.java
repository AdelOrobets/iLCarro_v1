package pages;

import dto.UserLombok;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement inputEmail;

    @FindBy(xpath = "//div[contains(text(),'It'snot look like email')]")
    WebElement messageErrorEmail;

    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(xpath = "//div[text()=' Password is required ']")
    WebElement messageErrorPassword;

    @FindBy(xpath = "//button[text()='Y’alla!']")
    WebElement btnYalla;

    @FindBy(xpath = "//form[.//button[text()='Y’alla!']]")
    WebElement loginForm;

    public LoginPage enterEmail(String email) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        inputPassword.clear();
        inputPassword.sendKeys(password);
        return this;
    }

    public void fillCredentials(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }

    public void typeLoginForm(UserLombok user) {
        fillCredentials(user.getUsername(), user.getPassword());
        clickLoginButton();
    }

    public void clickLoginButton() {
        btnYalla.click();
    }

    public void closeAlert() {
        try {
            Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert present: " + e.getMessage());
        }
    }

    // Error checking
    public boolean isLoginFormDisplayed() {
        return isElementPresent(loginForm);
    }

    public boolean isErrorEmailMessageDisplayed() {
        return isElementPresent(messageErrorEmail);
    }

    public boolean isErrorPasswordMessageDisplayed() {
        return isElementPresent(messageErrorPassword);
    }
}

