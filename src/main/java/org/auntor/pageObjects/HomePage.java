package org.auntor.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage {
    AppiumDriver driver;

    public HomePage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/toolbar_title")
    WebElement toolbarTitleElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/details_field")
    WebElement weatherTypeElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/card_schedule_week")
    WebElement currentDayElement;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'STUDENT PORTAL')]")
    WebElement studentPortalBtnElement;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'ADMISSION PORTAL')]")
    WebElement admissionPortalBtnElement;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'FACULTY MEMBERS')]")
    WebElement facultyMemberBtnElement;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'ACADEMIC RESULT')]")
    WebElement academicResultBtnElement;
    @AndroidFindBy(className = "android.widget.ImageButton")
    WebElement navigationDrawerBtnElement;

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

        TouchAction action =new TouchAction((PerformsTouchActions) driver);
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
