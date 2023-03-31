package org.auntor.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {
    AppiumDriver driver;


    public SettingsPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='android:id/title' and contains(@text,'Student Info')]")
    WebElement settingsPageTitleElement;
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/title' and contains(@text,'Your Campus')]")
    WebElement campusOptionElement;
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/title' and contains(@text,'Notice')]")
    WebElement noticeToggleBtnElement;
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/title' and contains(@text,'Contest')]")
    WebElement contestToggleBtnElement;
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/title' and contains(@text,'Notify Next Class')]")
    WebElement notifyNextClassOptionElement;

    public String getSettingsPageTitle() {
        return settingsPageTitleElement.getText();
    }

    public void selectCampus(String campusName) {
        campusOptionElement.click();
        driver.findElement(By.xpath("//*[@resource-id='android:id/text1' and contains(@text,'" + campusName + "')]")).click();
    }

    public String getSelectedCampusName(String campus) {
        return driver.findElement(By.xpath("//*[@resource-id='android:id/summary' and contains(@text,'" + campus + "')]")).getText();
    }

    public void pressNoticeAndContestToggleButton() {
        noticeToggleBtnElement.click();
        contestToggleBtnElement.click();
    }

    public void selectNotifyNextClass(String time){
        notifyNextClassOptionElement.click();
//        int totalTimeOption = driver.findElements(By.id("android:id/text1")).size();
//        for (int i = 0; i < totalTimeOption; i++) {
//           AndroidElement option = (AndroidElement) driver.findElementsById("android:id/text1").get(i);
//           option.click();
//           action.tap(new TapOptions().withElement(new ElementOption().withElement(notifyNextClassOptionElement))).perform();
//        }

        driver.findElement(By.xpath("//*[@resource-id='android:id/text1' and contains(@text,'" + time + "')]")).click();
    }

    public String getSelectedTime(String time) {
        return driver.findElement(By.xpath("//*[@resource-id='android:id/summary' and contains(@text,'" + time + "')]")).getText();
    }

}
