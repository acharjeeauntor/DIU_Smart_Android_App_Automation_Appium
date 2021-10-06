package org.auntor.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.auntor.testCases.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class NavigationDrawer {
    AndroidDriver driver;

    public NavigationDrawer(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


}
