package org.auntor.testCases;

import org.auntor.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.auntor.utilities.Common.closeAppSplashScreen;



/*
Test case:
1. verify if user can select campus or not
2. verify if user can select NoticeAndContest or not
3. verify if user can select Next Class notification or not
*/

public class SettingsTest extends BaseClass {

    HomePage homePage;
    NavigationDrawer navigationDrawer;
    Settings settings;

    @Test(priority = 1, description = "verify if user can select campus or not")
    public void checkCampusSelection() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        settings = new Settings(driver);
        navigationDrawer = new NavigationDrawer(driver);
        closeAppSplashScreen(driver);
        homePage.pressNavigationDrawer();
        navigationDrawer.enterSettingsPageFromNavDrawer();
        settings.selectCampus("Main");
        if (settings.getSelectedCampusName().equals("Main Campus")) {
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.info("Test Failed");
            captureScreen("checkCampusSelection");
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 2, description = "verify if user can select NoticeAndContest or not")
    public void checkNoticeAndContestToggleButton() throws IOException, InterruptedException {
      settings = new Settings(driver);
        if (settings.pressNoticeAndContestToggleButton()) {
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.info("Test Failed");
            captureScreen("checkNoticeAndContestToggleButton");
            Assert.assertTrue(false);
        }
    }
    @Test(priority = 3, description = "verify if user can select Next Class notification or not")
    public void checkNotifyNextClassSelection() throws IOException, InterruptedException {
        settings = new Settings(driver);
        settings.selectNotifyNextClass("Before 30 minutes");
        if (settings.getSelectedTime().equals("Before 30 minutes")) {
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.info("Test Failed");
            captureScreen("checkNotifyNextClassSelection");
            Assert.assertTrue(false);
        }
    }

}
