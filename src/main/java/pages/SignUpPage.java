package pages;

import dto.UserLombok;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    WebElement inputName;

    @FindBy(id = "lastName")
    WebElement inputLastName;

    @FindBy(id = "email")
    WebElement inputEmail;

    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(xpath = "//label[@for='terms-of-use']")
    WebElement checkBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;

    @FindBy(xpath = "//div[@class='error']")
    List<WebElement> messageErrorInput;

    @FindBy(xpath = "//form[.//button[text()='Y’alla!']]" )
    WebElement registrationForm;

    public SignUpPage enterFirstName(String name) {
        inputName.clear();
        inputName.sendKeys(name);
        return this;
    }

    public SignUpPage enterLastName(String lastName) {
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
        return this;
    }

    public SignUpPage enterEmail(String email) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
        return this;
    }

    public SignUpPage enterPassword(String password) {
        inputPassword.clear();
        inputPassword.sendKeys(password);
        return this;
    }

    public SignUpPage fillCredentials(UserLombok user) {
        return enterFirstName(user.getFirstName())
                .enterLastName(user.getLastName())
                .enterEmail(user.getUsername())
                .enterPassword(user.getPassword());
    }

    public SignUpPage typeSignUpForm(UserLombok user) {
        fillCredentials(user);
        clickCheckBox();
        clickBtnYalla();
        return this;
    }

    public SignUpPage clickCheckBox() {
        if (!checkBox.isSelected()) {
            int width = checkBox.getRect().getWidth();
            int height = checkBox.getRect().getHeight();
            new Actions(driver)
                    .moveToElement(checkBox, -width / 20 * 9, 0)
                    .click()
                    .perform();
        }
        return this;
    }

    public SignUpPage clickBtnYalla() {
        btnYalla.click();
        return this;
    }

    // Checks
    public boolean isRegistrationFormDisplayed() {
        return isElementPresent(registrationForm);
    }

    public boolean btnYallaIsEnabled() {
        return elementIsEnabled(btnYalla);
    }

    public boolean validateErrorMessage(String text) {
        return messageErrorInput.stream().anyMatch(e -> e.getText().contains(text));
    }
}
