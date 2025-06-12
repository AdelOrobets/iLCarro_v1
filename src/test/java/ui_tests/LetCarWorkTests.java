package ui_tests;

import dto.CarLombok;
import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.TestDataFactory;

public class LetCarWorkTests extends ApplicationManager {

    private static final Logger logger = LoggerFactory.getLogger(LetCarWorkPage.class);

    @BeforeMethod
    public void precondition() {
        openSignUpPage();
        signUpPage.typeSignUpForm(TestDataFactory.validUser());
        signUpPage.clickBtnOkPopupMsg();
    }

    @Test
    public void testSuccessful_addNewCar() {
        logger.info("Starting test: testSuccessful_addNewCar");
        CarLombok car = TestDataFactory.validCar();
        openLetCarWorkPage();
        try {
            letCarWorkPage.addNewCarInForm(car);
            Assert.assertTrue(letCarWorkPage.popUpMessageContains("Car was added"),
                    "Expected success message 'Car was added' not found");
            logger.info("Car was added successfully");
        } catch (AssertionError | Exception e) {
            logger.error("Test failed: Could not add car", e);
            throw e;
        }
    }
}
