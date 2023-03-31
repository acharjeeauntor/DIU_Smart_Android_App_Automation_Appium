package org.auntor.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.Date;


public class AddToRoutinePage {
    AppiumDriver driver;

    public AddToRoutinePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/submitRoutine")
    WebElement submitRoutineElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/roomNumber")
    WebElement roomNumberElement;

    public void AddAClassToday(String roomNumber) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayNumberOfWeek = c.get(Calendar.DAY_OF_WEEK); //// 0-sat,1-sun,2-mon,3,4,5,6
        driver.findElement(By.xpath("//android.widget.ImageView[@index='" + dayNumberOfWeek + "']")).click();
        roomNumberElement.sendKeys(roomNumber);
        submitRoutineElement.click();
    }
    public boolean isTodayClassVisible(String course) {
        int count=0;
        int totalElements =  driver.findElements(By.className("android.widget.TextView")).size();
        for(int i=0;i<totalElements-1;i++){
            WebElement element = driver.findElements(By.className("android.widget.TextView")).get(i);
            if(element.getText().equals(course)){
               count++;
                break;
            }
        }
        if(count==1){
            return true;
        }else {
            return false;
        }
    }


    public void AddAClassTomorrow(String roomNumber) throws InterruptedException {
        Date date2 = new Date();
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);
      int todayNumber = c2.get(Calendar.DAY_OF_WEEK);
        driver.findElement(By.xpath("//android.widget.ImageView[@index='" + todayNumber + "']")).click();
        Thread.sleep(2000);
        if(todayNumber==6){
            driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
        }else{
            driver.findElement(By.xpath("//android.widget.ImageView[@index='" + (todayNumber+1) + "']")).click();
        }
        roomNumberElement.sendKeys(roomNumber);
        submitRoutineElement.click();
    }

}
