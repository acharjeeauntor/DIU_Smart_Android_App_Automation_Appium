package org.auntor.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NoticeBoardPage {
    AppiumDriver driver;


    public NoticeBoardPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/kdjnc")
    WebElement NoticeBoardHeaderElement;


    public String  getHeaderText(){
        return NoticeBoardHeaderElement.getText();
    }
}
