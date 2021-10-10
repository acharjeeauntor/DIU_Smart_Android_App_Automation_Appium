package org.auntor.pageObjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class Settings {
    AndroidDriver driver;


    public Settings(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='android:id/title' and contains(@text,'Student Info')]")
    AndroidElement settingsPageTitleElement;
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/title' and contains(@text,'Your Campus')]")
    AndroidElement campusOptionElement;
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/summary' and contains(@text,'Main Campus')]")
    AndroidElement campusSelectedElement;
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/title' and contains(@text,'Notice')]")
    AndroidElement noticeToggleBtnElement;
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/title' and contains(@text,'Contest')]")
    AndroidElement contestToggleBtnElement;
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/title' and contains(@text,'Notify Next Class')]")
    AndroidElement notifyNextClassOptionElement;
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/summary' and contains(@text,'Before 30 minutes')]")
    AndroidElement timeSelectedElement;


    public String getSettingsPageTitle() {
        return settingsPageTitleElement.getText();
    }

    public void selectCampus(String campusName) {
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(campusOptionElement))).perform();
        int totalCampusOption = driver.findElements(By.id("android:id/text1")).size();
        for (int i = 0; i < totalCampusOption; i++) {
            AndroidElement option = (AndroidElement) driver.findElementsById("android:id/text1").get(i);
            option.click();
            action.tap(new TapOptions().withElement(new ElementOption().withElement(campusOptionElement))).perform();
        }
        driver.findElement(By.xpath("//*[@resource-id='android:id/text1' and contains(@text,'" + campusName + " Campus')]")).click();
    }

    public String getSelectedCampusName() {
        return campusSelectedElement.getText();
    }

    public boolean pressNoticeAndContestToggleButton() {
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(noticeToggleBtnElement))).perform();
        action.tap(new TapOptions().withElement(new ElementOption().withElement(contestToggleBtnElement))).perform();
        AndroidElement e1 = (AndroidElement) driver.findElement(By.xpath("//*[@resource-id='android:id/switch_widget' and contains(@text,'Off')]"));
        if (e1.getText().equals("Off")) {
            return true;
        } else {
            return false;
        }
    }

    public void selectNotifyNextClass(String time) throws InterruptedException {
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(notifyNextClassOptionElement))).perform();
        int totalTimeOption = driver.findElements(By.id("android:id/text1")).size();
        for (int i = 0; i < totalTimeOption; i++) {
           AndroidElement option = (AndroidElement) driver.findElementsById("android:id/text1").get(i);
           option.click();
           action.tap(new TapOptions().withElement(new ElementOption().withElement(notifyNextClassOptionElement))).perform();
        }

        driver.findElement(By.xpath("//*[@resource-id='android:id/text1' and contains(@text,'" + time + "')]")).click();
    }

    public String getSelectedTime() {
        return timeSelectedElement.getText();
    }

}
