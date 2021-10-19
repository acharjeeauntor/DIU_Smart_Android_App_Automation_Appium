package org.auntor.pageObjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.auntor.utilities.Common;
import org.openqa.selenium.support.PageFactory;

import static org.auntor.utilities.Common.scrolling;

public class ClassRoutine {
    AndroidDriver driver;
    Common common;

    public ClassRoutine(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/tvCategory")
    AndroidElement classRoutineHeaderElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/noCourseAdded")
    AndroidElement emptyRoutineHintTextElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/submitRoutine")
    AndroidElement routineSubmitIconElement;
    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    AndroidElement addCourseToastElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/startSemester")
    AndroidElement startSemesterOptionElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/endSemester")
    AndroidElement endSemesterOptionElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/date_picker_year")
    AndroidElement datePickerYearElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/month_text_view' and contains(@text,'2021')]")
    AndroidElement selectSemesterYearElement;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='25 September 2021']")
    AndroidElement selectSemesterStartDateElement;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='10 November 2021']")
    AndroidElement selectSemesterEndDateElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/ok")
    AndroidElement datePickerOkBtnElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/dayDiff")
    AndroidElement totalSemesterDayElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/fabSetupSemester")
    AndroidElement addCourseFabBtnElement;
    @AndroidFindBy(id = "android:id/input")
    AndroidElement courseInputFieldElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/buttonDefaultPositive")
    AndroidElement courseAddBtnElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/routineEmptyNoData")
    AndroidElement emptyScheduleTextElement;


    public String  getHeaderText(){
        return classRoutineHeaderElement.getText();
    }
    public String  getEmptyRoutineHintText(){
        return emptyRoutineHintTextElement.getText();
    }
    public String getToastMessageText(){
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(routineSubmitIconElement))).perform();
       return addCourseToastElement.getAttribute("name");
    }


    public void selectSemesterStartDate() throws InterruptedException {
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(startSemesterOptionElement))).perform();
        datePickerYearElement.click();
        Thread.sleep(2000);
        scrolling(driver,.50,.50,.50,.20);
        selectSemesterYearElement.click();
        action.tap(new TapOptions().withElement(new ElementOption().withElement(selectSemesterStartDateElement))).perform();
        datePickerOkBtnElement.click();
    }


    public void selectSemesterEndDate() throws InterruptedException {
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(endSemesterOptionElement))).perform();
        datePickerYearElement.click();
        Thread.sleep(2000);
        scrolling(driver,.50,.50,.50,.20);
        selectSemesterYearElement.click();
        scrolling(driver,.50,.50,.50,.80);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(selectSemesterEndDateElement))).perform();
        datePickerOkBtnElement.click();
    }


    public int getTotalSemesterDay(){
        int day = Integer.parseInt(totalSemesterDayElement.getText().replaceAll("[^0-9]", ""));
        return day;
    }

    public boolean addANewCourse(String courseName) throws InterruptedException {
        addCourseFabBtnElement.click();
        courseInputFieldElement.sendKeys(courseName);
        courseAddBtnElement.click();
       return driver.findElementByXPath("//*[@text=\""+courseName+"\"]").isDisplayed();
    }

    public String emptyScheduleData() throws InterruptedException {
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(routineSubmitIconElement))).perform();
        return emptyScheduleTextElement.getText();
    }
}
