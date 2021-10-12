package org.auntor.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class StudentPortalPage {

    AndroidDriver driver;

    public StudentPortalPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='4']")
    AndroidElement portalPageText;

    public String portalPageTest() {
        return portalPageText.getText();
    }

}
