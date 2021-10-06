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

import org.auntor.pageObjects.AcademicResult;
import org.auntor.pageObjects.FacultyMember;
import org.auntor.pageObjects.HomePage;
import org.auntor.pageObjects.StudentPortalPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BaseClass {
    HomePage homePage;
    StudentPortalPage studentPortalPage;
    FacultyMember facultyMember;
    AcademicResult academicResult;

    @Test(priority = 1, description = "Verify that Home page title is DIU")
    public void verifyPageTitle() throws IOException {
        homePage = new HomePage(driver);
        closeAppSplashScreen();
        String title = homePage.getPageTitle();
        if (title.equals("diu")) {
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("verifyPageTitle");
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 2, description = "Verify that current Weather information is Showing properly or not")
    public void verifyWeatherInfo() throws IOException {
        homePage = new HomePage(driver);
        if (homePage.weatherTextFiledType()) {
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("verifyWeatherInfo");
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 3, description = "Verify that Current Day is showing properly or not")
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
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("verifyCurrentDay");
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 4, description = "Verify that STUDENT PORTAL button is working properly or not")
    public void checkStudentPortalButton() throws IOException {
        homePage = new HomePage(driver);
        studentPortalPage = new StudentPortalPage(driver);
        homePage.clickStudentPortalBtn();
        if (studentPortalPage.portalPageHeadingTest().equals("Requested Resource Not Found!")) {
            driver.navigate().back();
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("checkStudentPortalButton");
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 5, description = "Verify that Admission Portal button is working properly or not")
    public void checkAdmissionPortalButton() throws IOException {
        homePage = new HomePage(driver);
        if (homePage.admissionPortalBtnIsEnabled()) {
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("checkAdmissionPortalButton");
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 6, description = "Verify that Faculty Member button is working properly or not")
    public void checkFacultyMemberButton() throws IOException {
        homePage = new HomePage(driver);
        facultyMember = new FacultyMember(driver);
        homePage.clickFacultyMemberBtn();
        if (facultyMember.getSearchHintText().equals("Search Member")) {
            driver.navigate().back();
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("checkFacultyMemberButton");
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 7, description = "Verify that Academic Result button is working properly or not")
    public void checkAcademicResultButton() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        academicResult = new AcademicResult(driver);
        homePage.clickAcademicResultBtn();
        if (academicResult.getHeaderText().equals("Academic Result")) {
            driver.navigate().back();
            logger.info("Test Passed");
            Assert.assertTrue(true);
        } else {
            logger.warn("Test Failed");
            captureScreen("checkAcademicResultButton");
            Assert.assertTrue(false);
        }
    }


}

