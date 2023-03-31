package org.auntor.testCases;

/*
Test Cases:
1. Verify that Home page title is DIU
2. Verify that current Weather information is Showing properly or not
3. Verify that Current Day is showing properly or not
4. Verify that STUDENT PORTAL button is working properly or not
5. Verify that ADMISSION PORTAL button is working properly or not
6. Verify that FACULTY MEMBERS button is working properly or not
7. Verify that ACADEMIC RESULT button is working properly or not
* */

import io.qameta.allure.*;
import org.auntor.pageObjects.AcademicResultPage;
import org.auntor.pageObjects.FacultyMemberPage;
import org.auntor.pageObjects.HomePage;
import org.auntor.pageObjects.StudentPortalPage;
import org.auntor.utilities.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.auntor.utilities.Common.closeAppSplashScreen;

public class HomePageTest extends BaseClass {
    HomePage homePage;
    StudentPortalPage studentPortalPage;
    FacultyMemberPage facultyMember;
    AcademicResultPage academicResult;

    @Test(priority = 1, description = "Verify that Home page title is DIU")
    @Description("Verify that Home page title is DIU")
    @Epic("Epic-1")
    @Feature("Home Page")
    @Story("Story1")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyPageTitle() throws IOException {
        homePage = new HomePage(driver);
       closeAppSplashScreen(driver);
        String title = homePage.getPageTitle();
        if (title.equals("diu")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 2, description = "Verify that current Weather information is Showing properly or not")
    @Description("Verify that current Weather information is Showing properly or not")
    @Epic("Epic-1")
    @Feature("Home Page")
    @Story("Story1")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyWeatherInfo() throws IOException {
        homePage = new HomePage(driver);
        if (homePage.weatherTextFiledType()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 3, description = "Verify that Current Day is showing properly or not")
    @Description("Verify that Current Day is showing properly or not")
    @Epic("Epic-1")
    @Feature("Home Page")
    @Story("Story1")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyCurrentDay() throws IOException {
        String[] days = {"saturday", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday"};
        int count = 0;
        homePage = new HomePage(driver);
        String currentDay = homePage.getCurrentDay();
        for (int i = 0; i < days.length - 1; i++) {
            if (currentDay.equals(days[i])) {
                count++;
                break;
            }
        }

        if (count == 1) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 4, description = "Verify that STUDENT PORTAL button is working properly or not")
    @Description("Verify that STUDENT PORTAL button is working properly or not")
    @Epic("Epic-1")
    @Feature("Home Page")
    @Story("Story1")
    @Severity(SeverityLevel.CRITICAL)
    public void checkStudentPortalButton() throws IOException {
        homePage = new HomePage(driver);
        studentPortalPage = new StudentPortalPage(driver);
        homePage.clickStudentPortalBtn();
        if (studentPortalPage.portalPageTest().equals("Requested Resource Not Found!")) {
            driver.navigate().back();
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 5, description = "Verify that Admission Portal button is working properly or not")
    @Description("Verify that Admission Portal button is working properly or not")
    @Epic("Epic-1")
    @Feature("Home Page")
    @Story("Story1")
    @Severity(SeverityLevel.BLOCKER)
    public void checkAdmissionPortalButton() throws IOException {
        homePage = new HomePage(driver);
        if (homePage.admissionPortalBtnIsEnabled()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 6, description = "Verify that Faculty Member button is working properly or not")
    @Description("Verify that Faculty Member button is working properly or not")
    @Epic("Epic-1")
    @Feature("Home Page")
    @Story("Story2")
    @Severity(SeverityLevel.BLOCKER)
    public void checkFacultyMemberButton() throws IOException {
        homePage = new HomePage(driver);
        facultyMember = new FacultyMemberPage(driver);
        homePage.clickFacultyMemberBtn();
        if (facultyMember.getSearchHintText().equals("Search Member")) {
            driver.navigate().back();
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 7, description = "Verify that Academic Result button is working properly or not")
    @Description("Verify that Academic Result button is working properly or not")
    @Epic("Epic-1")
    @Feature("Home Page")
    @Story("Story2")
    @Severity(SeverityLevel.BLOCKER)
    public void checkAcademicResultButton() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        academicResult = new AcademicResultPage(driver);
        homePage.clickAcademicResultBtn();
        if (academicResult.getHeaderText().equals("Academic Result")) {
            driver.navigate().back();
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }


}

