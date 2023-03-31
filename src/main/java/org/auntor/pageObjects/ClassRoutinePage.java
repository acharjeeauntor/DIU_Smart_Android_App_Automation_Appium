package org.auntor.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.auntor.utilities.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import static org.auntor.utilities.Common.scrollingAndSwapping;

public class ClassRoutinePage {
    AppiumDriver driver;
    Common common;

    public ClassRoutinePage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/tvCategory")
    WebElement classRoutineHeaderElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/noCourseAdded")
    WebElement emptyRoutineHintTextElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/submitRoutine")
    WebElement routineSubmitIconElement;
    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    WebElement addCourseToastElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/startSemester")
    WebElement startSemesterOptionElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/endSemester")
    WebElement endSemesterOptionElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/date_picker_year")
    WebElement datePickerYearElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/month_text_view' and contains(@text,'2021')]")
    WebElement selectSemesterYearElement;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='25 September 2021']")
    WebElement selectSemesterStartDateElement;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='10 November 2021']")
    WebElement selectSemesterEndDateElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/ok")
    WebElement datePickerOkBtnElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/dayDiff")
    WebElement totalSemesterDayElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/fabSetupSemester")
    WebElement addCourseFabBtnElement;
    @AndroidFindBy(id = "android:id/input")
    WebElement courseInputFieldElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/buttonDefaultPositive")
    WebElement courseAddBtnElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/routineEmptyNoData")
    WebElement emptyScheduleTextElement;


    public String  getHeaderText(){
        return classRoutineHeaderElement.getText();
    }
    public String  getEmptyRoutineHintText(){
        return emptyRoutineHintTextElement.getText();
    }
    public String getToastMessageText(){
        routineSubmitIconElement.click();
       return addCourseToastElement.getAttribute("name");
    }


    public void selectSemesterStartDate() throws InterruptedException {
        startSemesterOptionElement.click();
        datePickerYearElement.click();
        Thread.sleep(2000);
        scrollingAndSwapping(driver,.50,.50,.50,.20);
        selectSemesterYearElement.click();
        selectSemesterStartDateElement.click();
        datePickerOkBtnElement.click();
    }


    public void selectSemesterEndDate() throws InterruptedException {
        endSemesterOptionElement.click();
        datePickerYearElement.click();
        Thread.sleep(2000);
        scrollingAndSwapping(driver,.50,.50,.50,.20);
        selectSemesterYearElement.click();
        scrollingAndSwapping(driver,.50,.50,.50,.80);
        selectSemesterEndDateElement.click();
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
       return driver.findElement(By.xpath("//*[@text=\""+courseName+"\"]")).isDisplayed();
    }

    public String emptyScheduleData() throws InterruptedException {
        routineSubmitIconElement.click();
        return emptyScheduleTextElement.getText();
    }
}
