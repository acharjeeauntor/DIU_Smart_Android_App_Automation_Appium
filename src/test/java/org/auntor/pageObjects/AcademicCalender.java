package org.auntor.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AcademicCalender {
    AndroidDriver driver;

    public AcademicCalender(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/dateTitle")
    AndroidElement currentDateTextElement;

    public int  getCurrentYear(){
        String monthWithYear = currentDateTextElement.getText();
        int year = Integer.parseInt(monthWithYear.replaceAll("[^0-9]", ""));
        return year;
    }
}
