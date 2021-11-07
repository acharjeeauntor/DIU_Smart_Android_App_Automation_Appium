package org.auntor.testCases;

import io.qameta.allure.*;
import org.auntor.pageObjects.*;
import org.auntor.utilities.BaseClass;
import org.auntor.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.*;

import static org.auntor.utilities.Common.closeAppSplashScreen;

public class ClassRoutineTestUsingDB extends BaseClass {
    HomePage homePage;
    NavigationDrawerPage navigationDrawer;
    ClassRoutinePage classRoutine;
    SchedulePage schedulePage;
    AddToRoutinePage addToRoutinePage;
    public String courseCode;
    public String roomNumber;
    public String hint_Text_For_Schedule;
    public String toast_Message_For_Schedule;
    public String empty_Schedule_Text;


    @Test(priority = 1)
    @Description("Verify that Empty course related toast message is showing properly or not")
    @Epic("Epic-4")
    @Feature("Toast Message")
    @Story("story6")
    @Severity(SeverityLevel.MINOR)
    public void checkEmptyClassRoutine() throws InterruptedException, IOException, SQLException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawerPage(driver);
        classRoutine = new ClassRoutinePage(driver);
        closeAppSplashScreen(driver);
        getDataFromDB();
        Thread.sleep(7000);
        homePage.pressNavigationDrawer();
        Thread.sleep(1000);
        navigationDrawer.enterClassRoutineFromNavDrawer();
        System.out.println(":::::::::"+hint_Text_For_Schedule);
        if (classRoutine.getEmptyRoutineHintText().equals(hint_Text_For_Schedule) && classRoutine.getToastMessageText().equals(toast_Message_For_Schedule)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 2)
    @Description("Verify that Start and End Semester Date can select or not")
    @Epic("Epic-4")
    @Feature("Class Routine")
    @Story("story6")
    @Severity(SeverityLevel.MINOR)
    public void checkSemesterRoutineDate() throws InterruptedException, IOException {
        classRoutine = new ClassRoutinePage(driver);
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
    @Epic("Epic-4")
    @Feature("Class Routine")
    @Story("story6")
    @Severity(SeverityLevel.CRITICAL)
    public void checkAddANewCourse() throws InterruptedException, IOException {
        classRoutine = new ClassRoutinePage(driver);
        if (classRoutine.addANewCourse(courseCode)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 4)
    @Description("Verify if empty schedule Data Text is showing properly or not")
    @Epic("Epic-4")
    @Feature("Class Routine")
    @Story("story6")
    @Severity(SeverityLevel.NORMAL)
    public void checkEmptyScheduleText() throws InterruptedException, IOException {
        classRoutine = new ClassRoutinePage(driver);
        if (classRoutine.emptyScheduleData().equals(empty_Schedule_Text)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }


    @Test(priority = 5)
    @Description("Verify if a new schedule can add today section or not")
    @Epic("Epic-4")
    @Feature("Class Routine")
    @Story("story6")
    @Severity(SeverityLevel.NORMAL)
    public void checkAddANewScheduleForToday() throws InterruptedException, IOException {
        schedulePage = new SchedulePage(driver);
        addToRoutinePage = new AddToRoutinePage(driver);
        schedulePage.addNewScheduleForToday();
        addToRoutinePage.AddAClassToday(roomNumber);
        if (addToRoutinePage.isTodayClassVisible(courseCode)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 6)
    @Description("Verify if a new schedule can add Tomorrow section or not")
    @Epic("Epic-4")
    @Feature("Class Routine")
    @Story("story6")
    @Severity(SeverityLevel.NORMAL)
    public void checkAddANewScheduleForTomorrow() throws InterruptedException, IOException {
        schedulePage = new SchedulePage(driver);
        addToRoutinePage = new AddToRoutinePage(driver);
        schedulePage.addNewScheduleForTomorrow();
        addToRoutinePage.AddAClassTomorrow(roomNumber);
        if (addToRoutinePage.isTodayClassVisible(courseCode)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }


    public void getDataFromDB() throws SQLException {
        String host = "localhost";
        String port = "3306";
        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/diusmartapp", "root", "abcd85284");
        System.out.println(":::::::::"+con);
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM classRoutine");
        System.out.println(":::::::::"+resultSet);
        while (resultSet.next()){
            courseCode = resultSet.getString("Course_Code");
            roomNumber = resultSet.getString("Room_Number");
            hint_Text_For_Schedule = resultSet.getString("Hint_Text_For_Schedule");
            toast_Message_For_Schedule = resultSet.getString("Toast_Message_For_Schedule");
            System.out.println(":::::::::"+toast_Message_For_Schedule);
            empty_Schedule_Text = resultSet.getString("Empty_Schedule_Text");
        }

    }

}
