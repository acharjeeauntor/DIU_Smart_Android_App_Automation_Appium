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


import io.qameta.allure.*;
import org.auntor.pageObjects.*;
import org.auntor.utilities.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Year;

import static org.auntor.utilities.Common.*;

public class NavigationDrawerTest extends BaseClass {
    HomePage homePage;
    StudentPortalPage studentPortalPage;
    FacultyMemberPage facultyMember;
    AcademicResultPage academicResult;
    NavigationDrawerPage navigationDrawer;

    @Test(priority = 1, description = "Verify Navigation Drawer option is working properly and header text is visible or not")
    @Description("Verify Navigation Drawer option is working properly and header text is visible or not")
    @Epic("Epic-2")
    @Feature("Navigation Drawer")
    @Story("Story2")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavigationDrawerOptionAndText() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawerPage(driver);
        closeAppSplashScreen(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.getNavigationDrawerHeaderText().equals("DIU")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 2, description = "Verify Navigation Drawer is scrolling properly or not")
    @Description("Verify Navigation Drawer is scrolling properly or not")
    @Epic("Epic-2")
    @Feature("Navigation Drawer")
    @Story("Story2")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavigationDrawerScrolling() throws IOException, InterruptedException {
        navigationDrawer = new NavigationDrawerPage(driver);
        homePage = new HomePage(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.scrollNavigationDrawer()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 3, description = "Verify Navigation Drawer option Class Routine is working properly or not")
    @Description("Verify Navigation Drawer option Class Routine is working properly or not")
    @Epic("Epic-2")
    @Feature("Navigation Drawer")
    @Story("Story2")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavDrawerClassRoutineOption() throws IOException {
        navigationDrawer = new NavigationDrawerPage(driver);
        if (navigationDrawer.getClassRoutinePageHeader().equals("Setup Semester")) {
            driver.navigate().back();
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 4, description = "Verify Navigation Drawer option Notice Board is working properly or not")
    @Description("Verify Navigation Drawer option Notice Board is working properly or not")
    @Epic("Epic-2")
    @Feature("Navigation Drawer")
    @Story("Story2")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavDrawerNoticeBoardOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawerPage(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.getNoticeBoardPageHeader().equals("Notice Board")) {
            driver.navigate().back();
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }


    @Test(priority = 5, enabled = false,description = "Verify Navigation Drawer option Student portal is working properly or not")
    @Description("Verify Navigation Drawer option Student portal is working properly or not")
    @Epic("Epic-2")
    @Feature("Navigation Drawer")
    @Story("Story2")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavStudentPortalOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawerPage(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.getStudentPortalPageHeader().equals("Requested Resource Not Found!")) {
            driver.navigate().back();
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 6, description = "Verify Navigation Drawer option Administration is working properly or not")
    @Description("Verify Navigation Drawer option Administration is working properly or not")
    @Epic("Epic-2")
    @Feature("Navigation Drawer")
    @Story("Story3")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavAdministrationOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawerPage(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.getAdministrationSearchHintText().equals("Search Member")) {
            driver.navigate().back();
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 7, description = "Verify Navigation Drawer option Faculty Members is working properly or not")
    @Description("Verify Navigation Drawer option Faculty Members is working properly or not")
    @Epic("Epic-2")
    @Feature("Navigation Drawer")
    @Story("Story3")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavFacultyMemberOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawerPage(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.getFacultyMemberSearchHintText().equals("Search Member")) {
            driver.navigate().back();
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 8, enabled = false,description = "Verify Navigation Drawer option Academic Result is working properly or not")
    @Description("Verify Navigation Drawer option Academic Result is working properly or not")
    @Epic("Epic-2")
    @Feature("Navigation Drawer")
    @Story("Story3")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavAcademicResultOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawerPage(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.getAcademicResultPageHeaderText().equals("Academic Result")) {
            driver.navigate().back();
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 9,enabled = false, description = "Verify Navigation Drawer option Academic Calendar is working properly or not")
    @Description("Verify Navigation Drawer option Academic Calendar is working properly or not")
    @Epic("Epic-2")
    @Feature("Navigation Drawer")
    @Story("Story3")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavAcademicCalenderOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawerPage(driver);
        homePage.pressNavigationDrawer();
        int currentYear = Year.now().getValue();
        if (navigationDrawer.getAcademicCalenderYearText() == currentYear) {
            driver.navigate().back();
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 10,enabled = false,description = "Verify Navigation Drawer option Rules and Regulation is working properly or not")
    @Description("Verify Navigation Drawer option Rules and Regulation is working properly or not")
    @Epic("Epic-2")
    @Feature("Navigation Drawer")
    @Story("Story4")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavRulesAndRegulationOption() throws IOException, InterruptedException {
        scrollToView(driver,"Settings");
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawerPage(driver);
        homePage.pressNavigationDrawer();
        Thread.sleep(2000);
        if (navigationDrawer.rulesAndRegulationPageOkBtnCheck()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 11, description = " Verify Navigation Drawer option Examination Guideline is working properly or not")
    @Description("Verify Navigation Drawer option Examination Guideline is working properly or not")
    @Epic("Epic-2")
    @Feature("Navigation Drawer")
    @Story("Story4")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavExaminationGuidelineOption() throws IOException, InterruptedException {

        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawerPage(driver);
        homePage.pressNavigationDrawer();
        scrollToView(driver,"Settings");
        if (navigationDrawer.examinationGuidelinePageOkBtnCheck()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 12, description = "Verify Navigation Drawer option Prospective Students is working properly or not")
    @Description("Verify Navigation Drawer option Prospective Students is working properly or not")
    @Epic("Epic-2")
    @Feature("Navigation Drawer")
    @Story("Story4")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavProspectiveStudentsOption() throws IOException, InterruptedException {

        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawerPage(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.prospectiveStudentsPageOkBtnCheck()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 13, description = "Verify Navigation Drawer option Credit Transfer is working properly or not")
    @Description("Verify Navigation Drawer option Credit Transfer is working properly or not")
    @Epic("Epic-2")
    @Feature("Navigation Drawer")
    @Story("Story4")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavCreditTransferOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawerPage(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.creditTransferPageOkBtnCheck()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @Test(priority = 14, description = "Verify Navigation Drawer option Settings is working properly or not")
    @Description("Verify Navigation Drawer option Settings is working properly or not")
    @Epic("Epic-2")
    @Feature("Navigation Drawer")
    @Story("Story4")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavSettingsOption() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawerPage(driver);
        homePage.pressNavigationDrawer();
        if (navigationDrawer.getSettingsPageTitleText().equals("Student Info")) {
            driver.navigate().back();
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }


}
