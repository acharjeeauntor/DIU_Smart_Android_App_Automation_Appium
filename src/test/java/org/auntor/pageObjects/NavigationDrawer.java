package org.auntor.pageObjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.auntor.testCases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class NavigationDrawer extends BaseClass {
    AndroidDriver driver;


    public NavigationDrawer(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/material_drawer_account_header_name")
    AndroidElement navigationDrawerHeaderElement;


    public String getNavigationDrawerHeaderText() {
        return navigationDrawerHeaderElement.getText();
    }


    public boolean scrollNavigationDrawer() {
        int count = 0;
        scrolling(.20, .20, .80, .20);
        List<AndroidElement> elements = driver.findElements(By.id("com.daffodilvarsity.diu:id/material_drawer_name"));
        for (int i = 0; i < elements.size() - 1; i++) {
            if (elements.get(i).getText().equals("ADMIN PORTAL")) {
                count++;
            }
        }
        scrolling(.20, .20, .20, .80);
        if (count == 1) {
            return true;
        } else {
            return false;
        }

    }

}
