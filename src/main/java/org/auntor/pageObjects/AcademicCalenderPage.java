package org.auntor.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AcademicCalenderPage {
    AppiumDriver driver;

    public AcademicCalenderPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/dateTitle")
    WebElement currentDateTextElement;

    public int  getCurrentYear(){

        String monthWithYear = currentDateTextElement.getText();
        int year = Integer.parseInt(monthWithYear.replaceAll("[^0-9]", ""));
        return year;
    }
}
