package org.auntor.testCases;

import io.qameta.allure.*;
import org.auntor.pageObjects.*;
import org.auntor.utilities.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.auntor.utilities.Common.closeAppSplashScreen;

public class ClassRoutineTest extends BaseClass {
    HomePage homePage;
    NavigationDrawer navigationDrawer;
    ClassRoutine classRoutine;
    SchedulePage schedulePage;
    AddToRoutinePage addToRoutinePage;


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
    @Description("Verify that Start and End Semester Date can select or not")
    @Epic("Epp1")
    @Feature("Class Routine")
    @Story("St1")
    @Severity(SeverityLevel.MINOR)
    public void checkSemesterRoutineDate() throws InterruptedException, IOException {
        classRoutine = new ClassRoutine(driver);
        classRoutine.selectSemesterStartDate();
        classRoutine.selectSemesterEndDate();
        if (classRoutine.getTotalSemesterDay() == 46) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 3)
    @Description("Verify if a new Course is added from class Routine section or not")
    @Epic("Epp1")
    @Feature("Class Routine")
    @Story("St1")
    @Severity(SeverityLevel.CRITICAL)
    public void checkAddANewCourse() throws InterruptedException, IOException {
        classRoutine = new ClassRoutine(driver);
        if (classRoutine.addANewCourse("CSE123")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 4)
    @Description("Verify if empty schedule Data Text is showing properly or not")
    @Epic("Epp1")
    @Feature("Class Routine")
    @Story("St1")
    @Severity(SeverityLevel.NORMAL)
    public void checkEmptyScheduleText() throws InterruptedException, IOException {
        classRoutine = new ClassRoutine(driver);
        if (classRoutine.emptyScheduleData().equals("No Schedule Added")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }


    @Test(priority = 5)
    @Description("Verify if a new schedule can add today section or not")
    @Epic("Epp1")
    @Feature("Class Routine")
    @Story("St1")
    @Severity(SeverityLevel.NORMAL)
    public void checkAddANewSchedule() throws InterruptedException, IOException {
        schedulePage = new SchedulePage(driver);
        addToRoutinePage = new AddToRoutinePage(driver);
        schedulePage.addNewSchedule();
        addToRoutinePage.AddAClassToday("A5");
        if(addToRoutinePage.isTodayClassVisible("CSE123")){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }
    }
}
