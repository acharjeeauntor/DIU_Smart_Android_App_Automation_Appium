package org.auntor.pageObjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage {
    AndroidDriver driver;

    public HomePage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/toolbar_title")
    AndroidElement toolbarTitleElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/details_field")
    AndroidElement weatherTypeElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/card_schedule_week")
    AndroidElement currentDayElement;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'STUDENT PORTAL')]")
    AndroidElement studentPortalBtnElement;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'ADMISSION PORTAL')]")
    AndroidElement admissionPortalBtnElement;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'FACULTY MEMBERS')]")
    AndroidElement facultyMemberBtnElement;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'ACADEMIC RESULT')]")
    AndroidElement academicResultBtnElement;
    @AndroidFindBy(className = "android.widget.ImageButton")
    AndroidElement navigationDrawerBtnElement;

    public String getPageTitle(){
       return toolbarTitleElement.getText().toLowerCase();
    }

    public boolean weatherTextFiledType(){
        return weatherTypeElement.isDisplayed();
    }

    public String getCurrentDay(){
        return currentDayElement.getText().toLowerCase();
    }

    public void pressNavigationDrawer() throws InterruptedException {
        navigationDrawerBtnElement.click();
        Thread.sleep(2000);
    }

    public void clickStudentPortalBtn(){
        studentPortalBtnElement.click();

    }
    public boolean admissionPortalBtnIsEnabled(){
      return admissionPortalBtnElement.isEnabled();

    }

    public void clickFacultyMemberBtn(){
        facultyMemberBtnElement.click();

    }
    public void clickAcademicResultBtn() throws InterruptedException {

        int midOfY =facultyMemberBtnElement.getLocation().y +(facultyMemberBtnElement.getSize().height/2);
        int fromXLocation=facultyMemberBtnElement.getLocation().x;
        int toXLocation=studentPortalBtnElement.getLocation().x;

        TouchAction action =new TouchAction(driver);
        action.press(PointOption.point(fromXLocation, midOfY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(toXLocation, midOfY))
                .release()
                .perform();
        Thread.sleep(2000);
        academicResultBtnElement.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }
}
