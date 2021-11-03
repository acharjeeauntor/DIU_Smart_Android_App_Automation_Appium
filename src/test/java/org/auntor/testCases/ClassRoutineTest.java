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

public class ClassRoutineTest extends BaseClass {
    HomePage homePage;
    NavigationDrawerPage navigationDrawer;
    ClassRoutinePage classRoutine;
    SchedulePage schedulePage;
    AddToRoutinePage addToRoutinePage;


    @Test(priority = 1,dataProvider = "RoutineDataProvider")
    @Description("Verify that Empty course related toast message is showing properly or not")
    @Epic("Epic-4")
    @Feature("Toast Message")
    @Story("story6")
    @Severity(SeverityLevel.MINOR)
    public void checkEmptyClassRoutine(String code,String roomNumber,String hintText,String toastMsg,String emptyText) throws InterruptedException, IOException {
        homePage = new HomePage(driver);
        navigationDrawer = new NavigationDrawerPage(driver);
        classRoutine = new ClassRoutinePage(driver);
        closeAppSplashScreen(driver);
        homePage.pressNavigationDrawer();
        Thread.sleep(1000);
        navigationDrawer.enterClassRoutineFromNavDrawer();
        if (classRoutine.getEmptyRoutineHintText().equals(hintText) && classRoutine.getToastMessageText().equals(toastMsg)) {
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

    @Test(priority = 3,dataProvider = "RoutineDataProvider")
    @Description("Verify if a new Course is added from class Routine section or not")
    @Epic("Epic-4")
    @Feature("Class Routine")
    @Story("story6")
    @Severity(SeverityLevel.CRITICAL)
    public void checkAddANewCourse(String code,String roomNumber,String hintText,String toastMsg,String emptyText) throws InterruptedException, IOException {
        classRoutine = new ClassRoutinePage(driver);
        if (classRoutine.addANewCourse(code)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 4,dataProvider = "RoutineDataProvider")
    @Description("Verify if empty schedule Data Text is showing properly or not")
    @Epic("Epic-4")
    @Feature("Class Routine")
    @Story("story6")
    @Severity(SeverityLevel.NORMAL)
    public void checkEmptyScheduleText(String code,String roomNumber,String hintText,String toastMsg,String emptyText) throws InterruptedException, IOException {
        classRoutine = new ClassRoutinePage(driver);
        if (classRoutine.emptyScheduleData().equals(emptyText)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }


    @Test(priority = 5,dataProvider = "RoutineDataProvider")
    @Description("Verify if a new schedule can add today section or not")
    @Epic("Epic-4")
    @Feature("Class Routine")
    @Story("story6")
    @Severity(SeverityLevel.NORMAL)
    public void checkAddANewScheduleForToday(String code,String roomNumber,String hintText,String toastMsg,String emptyText) throws InterruptedException, IOException {
        schedulePage = new SchedulePage(driver);
        addToRoutinePage = new AddToRoutinePage(driver);
        schedulePage.addNewScheduleForToday();
        addToRoutinePage.AddAClassToday(roomNumber);
        if(addToRoutinePage.isTodayClassVisible(code)){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 6,dataProvider = "RoutineDataProvider")
    @Description("Verify if a new schedule can add Tomorrow section or not")
    @Epic("Epic-4")
    @Feature("Class Routine")
    @Story("story6")
    @Severity(SeverityLevel.NORMAL)
    public void checkAddANewScheduleForTomorrow(String code,String roomNumber,String hintText,String toastMsg,String emptyText) throws InterruptedException, IOException {
        schedulePage = new SchedulePage(driver);
        addToRoutinePage = new AddToRoutinePage(driver);
        schedulePage.addNewScheduleForTomorrow();
        addToRoutinePage.AddAClassTomorrow(roomNumber);
        if(addToRoutinePage.isTodayClassVisible(code)){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }
    }

    @DataProvider(name = "RoutineDataProvider")
    Object[][] getRoutineData() throws IOException {
        String path = System.getProperty("user.dir")
                + "/src/main/java/org/auntor/testData/DiuSmartAppData.xlsx";
        int rowNum = XLUtils.getRowCount(path, "classRoutine");
        int colCount = XLUtils.getCellCount(path, "classRoutine", 1);
        System.out.println("Row:::" + rowNum + "column:::" + colCount);
        Object[][] data = new Object[rowNum][colCount];

        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = XLUtils.getCellData(path, "classRoutine", i, j);
            }

        }
        return data;
    }

}
