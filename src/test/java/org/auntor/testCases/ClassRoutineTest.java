package org.auntor.testCases;

import io.qameta.allure.*;
import org.auntor.pageObjects.ClassRoutine;
import org.auntor.pageObjects.HomePage;
import org.auntor.pageObjects.NavigationDrawer;
import org.auntor.utilities.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.auntor.utilities.Common.closeAppSplashScreen;

public class ClassRoutineTest extends BaseClass {
    HomePage homePage;
    NavigationDrawer navigationDrawer;
    ClassRoutine classRoutine;


    @Test(priority = 1)
    @Description("Verify that Empty course related toast message is showing properly or not")
    @Epic("Epp1")
    @Feature("Toast Message")
    @Story("St1")
    @Severity(SeverityLevel.MINOR)
    public void checkEmptyClassRoutine() throws InterruptedException, IOException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawer(driver);
        classRoutine = new ClassRoutine(driver);
        closeAppSplashScreen(driver);
        homePage.pressNavigationDrawer();
        Thread.sleep(1000);
        navigationDrawer.enterClassRoutineFromNavDrawer();
        if (classRoutine.getEmptyRoutineHintText().equals("Please add courses of this semester") && classRoutine.getToastMessageText().equals("Please add at least one Course")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 2)
    @Description("Verify that Empty course related toast message is showing properly or not")
    @Epic("Epp1")
    @Feature("Toast Message")
    @Story("St1")
    @Severity(SeverityLevel.MINOR)
    public void checkSemesterRoutineDate() throws InterruptedException, IOException {
        classRoutine = new ClassRoutine(driver);
        classRoutine.selectSemesterStartDate();
    }

}
