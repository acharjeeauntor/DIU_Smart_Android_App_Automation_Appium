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
        common = new Common();
        action.tap(new TapOptions().withElement(new ElementOption().withElement(startSemesterOptionElement))).perform();
        datePickerYearElement.click();
        Thread.sleep(2000);
        common.scrollToView(driver,"2020");

    }




}
