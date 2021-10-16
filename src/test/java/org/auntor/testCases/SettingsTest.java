package org.auntor.testCases;

import io.qameta.allure.*;
import org.auntor.pageObjects.*;
import org.auntor.utilities.BaseClass;
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

    @Test(priority = 1, description = "Verify if user can select campus or not")
    @Description("Verify if user can select campus or not")
    @Epic("Epp1")
    @Feature("Navigation Drawer")
    @Story("Story1")
    @Severity(SeverityLevel.CRITICAL)
    public void checkCampusSelection() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        settings = new Settings(driver);
        navigationDrawer = new NavigationDrawer(driver);
        closeAppSplashScreen(driver);
        homePage.pressNavigationDrawer();
        navigationDrawer.enterSettingsPageFromNavDrawer();
        settings.selectCampus("Main");
        if (settings.getSelectedCampusName().equals("Main Campus")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 2, description = "Verify if user can select NoticeAndContest or not")
    @Description("Verify if user can select NoticeAndContest or not")
    @Epic("Epp1")
    @Feature("Navigation Drawer")
    @Story("Story1")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNoticeAndContestToggleButton() throws IOException, InterruptedException {
      settings = new Settings(driver);
        if (settings.pressNoticeAndContestToggleButton()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }
    @Test(priority = 3, description = "Verify if user can select Next Class notification or not")
    @Description("Verify if user can select Next Class notification or not")
    @Epic("Epp1")
    @Feature("Navigation Drawer")
    @Story("Story1")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNotifyNextClassSelection() throws IOException, InterruptedException {
        settings = new Settings(driver);
        settings.selectNotifyNextClass("Before 30 minutes");
        if (settings.getSelectedTime().equals("Before 30 minutes")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

}
