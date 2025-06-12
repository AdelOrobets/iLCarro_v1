package pages;

import dto.CarLombok;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LetCarWorkPage extends BasePage {

    public LetCarWorkPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger logger = LoggerFactory.getLogger(LetCarWorkPage.class);

    @FindBy(id = "pickUpPlace")
    WebElement inputCity;

    @FindBy(id = "make")
    WebElement inputManufacture;

    @FindBy(id = "model")
    WebElement inputModel;

    @FindBy(id = "year")
    WebElement inputYear;

    @FindBy(id = "fuel")
    WebElement selectFuel;

    @FindBy(id = "seats")
    WebElement inputSeats;

    @FindBy(id = "class")
    WebElement inputCarClass;

    @FindBy(id = "serialNumber")
    WebElement inputRegNumber;

    @FindBy(id = "price")
    WebElement inputPrice;

    @FindBy(id = "about")
    WebElement inputAboutText;

    @FindBy(id = "//label[contains(text(), 'Add photos')]")
    WebElement AddPhotos;

    @FindBy(xpath = "//button[@type='submit' and text()='Submit']")
    WebElement submitButton;


    public void addNewCarInForm(CarLombok car) {
        logger.info("Filling car form with test data:");
        logger.info("City: {}", car.getCity());
        logger.info("Manufacture: {}", car.getManufacture());
        logger.info("Model: {}", car.getModel());
        logger.info("Year: {}", car.getYear());
        logger.info("Fuel: {}", car.getFuel());
        logger.info("Seats: {}", car.getSeats());
        logger.info("Class: {}", car.getCarClass());
        logger.info("Reg Number: {}", car.getSerialNumber());
        logger.info("Price: {}", car.getPricePerDay());
        logger.info("About: {}", car.getAbout());

        inputCity.sendKeys(car.getCity());
        inputManufacture.sendKeys(car.getManufacture());
        inputModel.sendKeys(car.getModel());
        inputYear.sendKeys(String.valueOf(car.getYear()));

        Select fuelSelect = new Select(selectFuel);
        fuelSelect.selectByVisibleText(car.getFuel());

        inputSeats.sendKeys(String.valueOf(car.getSeats()));
        inputCarClass.sendKeys(car.getCarClass());
        inputRegNumber.sendKeys(car.getSerialNumber());
        inputPrice.sendKeys(String.valueOf(car.getPricePerDay()));
        inputAboutText.sendKeys(car.getAbout());

        // AddPhotos.click();
        submitButton.click();
    }

    public boolean btnSubmitEnabled() {
        return elementIsEnabled(submitButton);
    }

}
