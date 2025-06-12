package ui_tests;

import dto.UserLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;
import utils.HeaderMenuItem;

public class LoginTests extends ApplicationManager {

    @Test
    public void testLoginFormDisplayed() {
        Assert.assertTrue(getLoginPage().isLoginFormDisplayed(), "Login form is not displayed");
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

    @Test(dependsOnMethods = "testUserCanSignUpSuccessfully")
    public void testSuccessfulLogin() {
        UserLombok user = getTestUser();
        openLoginPage();
        getLoginPage().typeLoginForm(user);

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.closeAlert();

        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page not displayed after login");
    }
}




//    @Test
//    public void testSuccessfulLogin_uppercaseEmail()
//
//
//    @Test
//    public void loginNegativeTest_unregisteredUser()
//
//
//    @Test
//    public void loginNegativeTest_wrongPassword()
//
//
//    @Test
//    public void loginNegativeTest_emptyUsername()
//
//
//    @Test
//    public void loginNegativeTest_emptyPassword()
//
//
//    @Test
//    public void loginNegativeTest_invalidUsernameFormat()
//
//
//    @Test
//    public void loginNegativeTest_invalidUsernameDomain()
//
//
//    @Test
//    public void loginNegativeTest_invalidUsername_withSpace()
//
//
//    @Test
//    public void loginNegativeTest_invalidPasswordShort()
//
//
//    @Test
//    public void loginNegativeTest_invalidPasswordLong()
//
//
//    @Test
//    public void loginNegativeTest_invalidPasswordNoDigit()
//
//
//    @Test
//    public void loginNegativeTest_invalidPasswordNoSymbol()

