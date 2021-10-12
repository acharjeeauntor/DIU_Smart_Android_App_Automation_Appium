package org.auntor.testCases;

import org.auntor.pageObjects.ClassRoutine;
import org.auntor.pageObjects.HomePage;
import org.auntor.pageObjects.NavigationDrawer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClassRoutineTest extends BaseClass {
    HomePage homePage;
    NavigationDrawer navigationDrawer;
    ClassRoutine classRoutine;


    @Test(priority = 1)
    public void checkEmptyClassRoutine() throws InterruptedException, IOException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawer(driver);
        classRoutine = new ClassRoutine(driver);
        closeAppSplashScreen();
        homePage.pressNavigationDrawer();
        Thread.sleep(1000);
        navigationDrawer.enterClassRoutineFromNavDrawer();
        if (classRoutine.getEmptyRoutineHintText().equals("Please add courses of this semester") && classRoutine.getToastMessageText().equals("Please add at least one Course")) {
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("checkEmptyClassRoutine");
            Assert.assertTrue(false);
        }
    }


}
