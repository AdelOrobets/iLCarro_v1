package ui_tests;

import dto.UserLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;
import utils.HeaderMenuItem;

public class SignUpTests extends ApplicationManager {

    @Test
    public void testRegistrationFormDisplayed() {
        openSignUpPage();
        Assert.assertTrue(signUpPage.isRegistrationFormDisplayed(), "Registration form is not displayed");
    }

    @Test
    public void testUserCanSignUpSuccessfully() {
        createUniqueTestUserForRegistration();
        UserLombok user = getTestUser();

        SignUpPage signUpPage = new HomePage(getDriver()).clickHeaderMenuItem(HeaderMenuItem.SIGN_UP);
        signUpPage.typeSignUpForm(user);

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.closeAlert();

        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page not displayed after sign-up");
        homePage.clickHeaderMenuItem(HeaderMenuItem.LOGOUT);
    }
}