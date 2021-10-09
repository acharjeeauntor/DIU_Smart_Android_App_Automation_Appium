package org.auntor.testCases;


/*
Test Cases:
1. Verify Navigation Drawer option is working properly and header text is visible or not
2. Verify Navigation Drawer is scrolling properly or not.
3. Verify Navigation Drawer option Class Routine is working properly or not.
4. Verify Navigation Drawer option Notice Board is working properly or not.
5. Verify Navigation Drawer option Student portal is working properly or not.
6. Verify Navigation Drawer option Administration is working properly or not.
7. Verify Navigation Drawer option Faculty Members is working properly or not.
8. Verify Navigation Drawer option Academic Result is working properly or not.
9. Verify Navigation Drawer option Academic Calendar is working properly or not.
10. Verify Navigation Drawer option Rules and Regulation is working properly or not.
11. Verify Navigation Drawer option Examination Guideline is working properly or not.
12. Verify Navigation Drawer option Prospective Students is working properly or not.
13. Verify Navigation Drawer option Credit Transfer is working properly or not.
14. Verify Navigation Drawer option Settings is working properly or not.
 */


import org.auntor.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Year;
import java.util.Date;

public class NavigationDrawerTest extends BaseClass {
    HomePage homePage;
    StudentPortalPage studentPortalPage;
    FacultyMember facultyMember;
    AcademicResult academicResult;
    NavigationDrawer navigationDrawer;

    @Test(priority = 1, description = "Verify Navigation Drawer option is working properly and header text is visible or not")
    public void checkNavigationDrawerOptionAndText() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawer(driver);
        closeAppSplashScreen();
        homePage.pressNavigationDrawer();
        if (navigationDrawer.getNavigationDrawerHeaderText().equals("DIU")) {
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("checkNavigationDrawerOptionAndText");
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 2, description = "Verify Navigation Drawer is scrolling properly or not")
    public void checkNavigationDrawerScrolling() throws IOException, InterruptedException {
        navigationDrawer = new NavigationDrawer(driver);
        homePage = new HomePage(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.scrollNavigationDrawer()) {
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("checkNavigationDrawerScrolling");
            Assert.assertTrue(false);
        }

    }

        @Test(priority = 3,description = "Verify Navigation Drawer option Class Routine is working properly or not")
    public void checkNavDrawerClassRoutineOption() throws IOException {
        navigationDrawer = new NavigationDrawer(driver);
        if(navigationDrawer.getClassRoutinePageHeader().equals("Setup Semester")){
            logger.info("Test Passed");
            driver.navigate().back();
            Assert.assertTrue(true);
        }else{
            logger.warn("Test Failed");
            captureScreen("checkNavDrawerClassRoutineOption");
            Assert.assertTrue(false);
        }

    }
    @Test(priority = 4,description = "Verify Navigation Drawer option Notice Board is working properly or not")
    public void checkNavDrawerNoticeBoardOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawer(driver);
        homePage.pressNavigationDrawer();
        if(navigationDrawer.getNoticeBoardPageHeader().equals("Notice Board")){
            logger.info("Test Passed");
            driver.navigate().back();
            Assert.assertTrue(true);
        }else{
            logger.warn("Test Failed");
            captureScreen("checkNavDrawerNoticeBoardOption");
            Assert.assertTrue(false);
        }

    }


    @Test(priority = 5,description = "Verify Navigation Drawer option Student portal is working properly or not")
    public void checkNavStudentPortalOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawer(driver);
        homePage.pressNavigationDrawer();
        if(navigationDrawer.getStudentPortalPageHeader().equals("Requested Resource Not Found!")){
            logger.info("Test Passed");
            driver.navigate().back();
            Assert.assertTrue(true);
        }else{
            logger.warn("Test Failed");
            captureScreen("checkNavStudentPortalOption");
            Assert.assertTrue(false);
        }

    }
    @Test(priority = 6,description = "Verify Navigation Drawer option Administration is working properly or not")
    public void checkNavAdministrationOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawer(driver);
        homePage.pressNavigationDrawer();
        if(navigationDrawer.getAdministrationSearchHintText().equals("Search Member")){
            logger.info("Test Passed");
            driver.navigate().back();
            Assert.assertTrue(true);
        }else{
            logger.warn("Test Failed");
            captureScreen("checkNavAdministrationOption");
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 7,description = "Verify Navigation Drawer option Faculty Members is working properly or not")
    public void checkNavFacultyMemberOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawer(driver);
        homePage.pressNavigationDrawer();
        if(navigationDrawer.getFacultyMemberSearchHintText().equals("Search Member")){
            logger.info("Test Passed");
            driver.navigate().back();
            Assert.assertTrue(true);
        }else{
            logger.warn("Test Failed");
            captureScreen("checkNavFacultyMemberOption");
            Assert.assertTrue(false);
        }

    }
    @Test(priority = 8,description = "Verify Navigation Drawer option Academic Result is working properly or not")
    public void checkNavAcademicResultOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawer(driver);
        homePage.pressNavigationDrawer();
        if(navigationDrawer.getAcademicResultPageHeaderText().equals("Academic Result")){
            logger.info("Test Passed");
            driver.navigate().back();
            Assert.assertTrue(true);
        }else{
            logger.warn("Test Failed");
            captureScreen("checkNavAcademicResultOption");
            Assert.assertTrue(false);
        }

    }
    @Test(priority = 9, description = "Verify Navigation Drawer option Academic Calendar is working properly or not")
    public void checkNavAcademicCalenderOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawer(driver);
        homePage.pressNavigationDrawer();
        int currentYear = Year.now().getValue();
        if (navigationDrawer.getAcademicCalenderYearText() == currentYear) {
            logger.info("Test Passed");
            driver.navigate().back();
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("checkNavAcademicCalenderOption");
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 10, description = "Verify Navigation Drawer option Rules and Regulation is working properly or not")
    public void checkNavRulesAndRegulationOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawer(driver);
        homePage.pressNavigationDrawer();
        Thread.sleep(2000);
        scrolling(.20, .20, .80, .20);
        if (navigationDrawer.rulesAndRegulationPageOkBtnCheck()) {
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("checkNavRulesAndRegulationOption");
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 11, description = " Verify Navigation Drawer option Examination Guideline is working properly or not")
    public void checkNavExaminationGuidelineOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawer(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.examinationGuidelinePageOkBtnCheck()) {
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("checkNavExaminationGuidelineOption");
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 12, description = "Verify Navigation Drawer option Prospective Students is working properly or not")
    public void checkNavProspectiveStudentsOption() throws IOException, InterruptedException {

        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawer(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.prospectiveStudentsPageOkBtnCheck()) {
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("checkNavProspectiveStudentsOption");
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 13, description = "Verify Navigation Drawer option Credit Transfer is working properly or not")
    public void checkNavCreditTransferOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawer(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.creditTransferPageOkBtnCheck()) {
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("checkNavCreditTransferOption");
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 14, description = "Verify Navigation Drawer option Settings is working properly or not")
    public void checkNavSettingsOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawer(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.getSettingsPageTitleText().equals("Student Info")) {
            logger.info("Test Passed");
            driver.navigate().back();
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("checkNavSettingsOption");
            Assert.assertTrue(false);
        }

    }


}
