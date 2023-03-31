package org.auntor.testCases;

import io.qameta.allure.*;
import org.auntor.pageObjects.*;
import org.auntor.utilities.BaseClass;
import org.auntor.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
    NavigationDrawerPage navigationDrawer;
    SettingsPage settings;

    @Test(priority =1, description = "Verify Navigation Drawer option Settings is working properly or not")
    @Description("Verify Navigation Drawer option Settings is working properly or not")
    @Epic("Epic-2")
    @Feature("Navigation Drawer")
    @Story("Story4")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavigateToSettings() throws InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawerPage(driver);
        closeAppSplashScreen(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.getSettingsPageTitleText().equals("Student Info")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 2, description = "Verify if user can select campus or not",dataProvider = "CampusNameDataProvider")
    @Description("Verify if user can select campus or not")
    @Epic("Epic-3")
    @Feature("Navigation Drawer")
    @Story("Story5")
    @Severity(SeverityLevel.CRITICAL)
    public void checkCampusSelection(String campusName) throws IOException, InterruptedException {
        settings = new SettingsPage(driver);
        settings.selectCampus(campusName);
        if (settings.getSelectedCampusName(campusName).equals(campusName)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 3 ,description = "Verify if user can select NoticeAndContest or not")
    @Description("Verify if user can select NoticeAndContest or not")
    @Epic("Epic-3")
    @Feature("Navigation Drawer")
    @Story("Story5")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNoticeAndContestToggleButton() throws IOException, InterruptedException {
      settings = new SettingsPage(driver);
      settings.pressNoticeAndContestToggleButton();
    }
    @Test(priority = 4,dataProvider = "NotifyNextClassDataProvider",description = "Verify if user can select Next Class notification or not")
    @Description("Verify if user can select Next Class notification or not")
    @Epic("Epic-3")
    @Feature("Navigation Drawer")
    @Story("Story5")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNotifyNextClassSelection(String notifyNextClass) throws IOException, InterruptedException {
        settings = new SettingsPage(driver);
        settings.selectNotifyNextClass(notifyNextClass);
        if (settings.getSelectedTime(notifyNextClass).equals(notifyNextClass)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }
    @DataProvider(name = "CampusNameDataProvider")
    Object[][] getCampusNameData() throws IOException {
        String path = System.getProperty("user.dir")
                + "/src/main/java/org/auntor/testData/DiuSmartAppData.xlsx";
        int rowNum = XLUtils.getRowCount(path, "campusName");
        int colCount = XLUtils.getCellCount(path, "campusName", 1);
        Object[][] data = new Object[rowNum][colCount];

        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = XLUtils.getCellData(path, "campusName", i, j);
            }
        }
        return data;
    }

    @DataProvider(name = "NotifyNextClassDataProvider")
    Object[][] getNotifyNextClassData() throws IOException {
        String path = System.getProperty("user.dir")
                + "/src/main/java/org/auntor/testData/DiuSmartAppData.xlsx";
        int rowNum = XLUtils.getRowCount(path, "notifyNextClass");
        int colCount = XLUtils.getCellCount(path, "notifyNextClass", 1);
        Object[][] data = new Object[rowNum][colCount];

        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = XLUtils.getCellData(path, "notifyNextClass", i, j);
            }
        }
        return data;
    }

}
