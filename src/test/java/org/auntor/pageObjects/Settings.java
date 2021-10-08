package org.auntor.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Settings {
    AndroidDriver driver;


    public Settings(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='android:id/title' and contains(@text,'Student Info')]")
    AndroidElement settingsPageTitleElement;


    public String getSettingsPageTitle(){
        return settingsPageTitleElement.getText();
    }
}
