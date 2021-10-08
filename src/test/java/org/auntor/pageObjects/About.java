package org.auntor.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class About {
    AndroidDriver driver;


    public About(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/kdjnc")
    AndroidElement aboutPageTitleElement;


    public String getAboutPageTitle(){
        return aboutPageTitleElement.getText();
    }
}
