package pages;

import manager.ApplicationManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import utils.HeaderMenuItem;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }


    @FindBy(xpath = "//div[@class='dialog-container']")
    protected WebElement popUpMessage;

    public boolean validatePopUpMessage(String text) {
        return isTextInElementPresent(popUpMessage, text);
    }

    public void waitForElementVisible(WebElement element, int timeoutSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOf(element));
    }


    public <T extends BasePage> T clickHeaderMenuItem(HeaderMenuItem headerMenuItem) {
        String locator = headerMenuItem.getLocator();
        WebElement element = driver.findElement(By.xpath(locator));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();
        if (headerMenuItem == HeaderMenuItem.LOGOUT) {
            return null;
        }
        return switch (headerMenuItem) {
            case SEARCH -> (T) new HomePage(driver);
            case LET_CAR_WORK -> (T) new LetCarWorkPage(driver);
            case TERMS -> (T) new TermsOfUsePage(driver);
            case SIGN_UP -> (T) new SignUpPage(driver);
            case LOGIN -> (T) new LoginPage(driver);
            default -> throw new IllegalArgumentException("Invalid header menu item: " + headerMenuItem);
        };
    }

    public boolean isTextInElementPresent(WebElement element, String text) {
        try {
            return element.getText().contains(text);
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean elementIsEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }
}
