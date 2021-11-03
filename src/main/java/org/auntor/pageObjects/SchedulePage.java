package org.auntor.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.auntor.utilities.Common;
import org.openqa.selenium.support.PageFactory;

import static org.auntor.utilities.Common.scrollingAndSwapping;

public class SchedulePage {
    AndroidDriver driver;

    public SchedulePage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/routineHome_addNew")
    AndroidElement addNewScheduleIconElement;


    public void addNewScheduleForToday(){
        addNewScheduleIconElement.click();
    }
    public void addNewScheduleForTomorrow(){
        scrollingAndSwapping(driver,.90,.10,.50,.50);
        addNewScheduleIconElement.click();
    }


}
