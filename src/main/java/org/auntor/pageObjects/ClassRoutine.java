package org.auntor.pageObjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.support.PageFactory;

public class ClassRoutine {
    AndroidDriver driver;

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

}
