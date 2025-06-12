package ui_tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.HeaderMenuItem;

public class HomeTests extends ApplicationManager {

    HomePage homePage;

    // Positive tests
    @Test
    public void testHomePageDisplayed() {
        new HomePage(getDriver()).clickHeaderMenuItem(HeaderMenuItem.SEARCH);
        Assert.assertTrue(homePage.isHomePageDisplayed(),
                "HomePage is not displayed");
    }
}
