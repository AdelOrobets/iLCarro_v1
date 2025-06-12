package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h1[text()='Find your car now!']")
    private WebElement textHomePage;

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("https://ilcarro.web.app/search");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(textHomePage));
    }

    public boolean isHomePageDisplayed() {
        return isElementPresent(textHomePage);
    }
}
