package org.auntor.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.auntor.testCases.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class RulesAndRegulation extends BaseClass {
    AndroidDriver driver;


    public RulesAndRegulation(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='2']")
    AndroidElement okButtonElement;


    public void PressOkButton(){
        scrolling(.20, .20, .80, .20);
        okButtonElement.click();
    }
}
