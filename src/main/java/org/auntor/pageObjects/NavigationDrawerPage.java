package org.auntor.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.auntor.utilities.Common;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NavigationDrawerPage extends Common {
    AppiumDriver driver;
    ClassRoutinePage classRoutine;
    NoticeBoardPage noticeBoard;
    StudentPortalPage studentPortalPage;
    AdministrationPage administration;
    FacultyMemberPage facultyMember;
    AcademicResultPage academicResult;
    AcademicCalenderPage academicCalender;
    RulesAndRegulationPage rulesAndRegulation;
    HomePage homePage;
    ExaminationGuidelinePage examinationGuideline;
    ProspectiveStudentsPage prospectiveStudents;
    CreditTransferPage creditTransfer;
    SettingsPage settings;

    public NavigationDrawerPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/material_drawer_account_header_name")
    WebElement navigationDrawerHeaderElement;
   @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Class Routine')]")
   WebElement nav_ClassRoutineElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Notice Board')]")
    WebElement nav_NoticeBoardElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Student Portal')]")
    WebElement nav_StudentPortalElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Administration')]")
    WebElement nav_AdministrationElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Faculty Members')]")
    WebElement nav_FacultyMembersElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Academic Result')]")
    WebElement nav_AcademicResultElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Academic Calendar')]")
    WebElement nav_AcademicCalendarElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Rules and Regulation')]")
    WebElement nav_RulesAndRegulationElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Examination Guideline')]")
    WebElement nav_ExaminationGuidelineElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Prospective Students')]")
    WebElement nav_ProspectiveStudentsElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Credit Transfer')]")
    WebElement nav_CreditTransferElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Settings')]")
    WebElement nav_SettingsElement;
    public String getNavigationDrawerHeaderText() {
        return navigationDrawerHeaderElement.getText();
    }


    public boolean scrollNavigationDrawer() {
        int count = 0;
        scrollToView(driver,"ADMIN PORTAL");
        List<WebElement> elements = driver.findElements(By.id("com.daffodilvarsity.diu:id/material_drawer_name"));
        for (int i = 0; i < elements.size() - 1; i++) {
            if (elements.get(i).getText().equals("ADMIN PORTAL")) {
                count++;
            }
        }
        scrollToView(driver,"Home");
        if (count == 1) {
            return true;
        } else {
            return false;
        }

    }

    public String getClassRoutinePageHeader() {
        classRoutine = new ClassRoutinePage(driver);
        nav_ClassRoutineElement.click();
        closeAppSplashScreen(driver);
        return classRoutine.getHeaderText();
    }

    public void enterClassRoutineFromNavDrawer() {
        classRoutine = new ClassRoutinePage(driver);
        nav_ClassRoutineElement.click();
        closeAppSplashScreen(driver);
    }

    public String getNoticeBoardPageHeader() {
        noticeBoard = new NoticeBoardPage(driver);
        nav_NoticeBoardElement.click();
        return noticeBoard.getHeaderText();
    }

    public String getStudentPortalPageHeader() {
        studentPortalPage = new StudentPortalPage(driver);
        nav_StudentPortalElement.click();
        return studentPortalPage.portalPageTest();
    }

    public String getAdministrationSearchHintText() {
        administration = new AdministrationPage(driver);
        nav_AdministrationElement.click();
        return administration.getSearchHintTextForAdministration();
    }

    public String getFacultyMemberSearchHintText() {
        facultyMember = new FacultyMemberPage(driver);
        nav_FacultyMembersElement.click();
        return facultyMember.getSearchHintText();
    }

    public String getAcademicResultPageHeaderText() {
        academicResult = new AcademicResultPage(driver);
        nav_AcademicResultElement.click();
        return academicResult.getHeaderText();
    }

    public int getAcademicCalenderYearText() {
        academicCalender = new AcademicCalenderPage(driver);
        nav_AcademicCalendarElement.click();
        return academicCalender.getCurrentYear();
    }

    public boolean rulesAndRegulationPageOkBtnCheck() {
        rulesAndRegulation = new RulesAndRegulationPage(driver);
        nav_RulesAndRegulationElement.click();
        rulesAndRegulation.PressOkButton();
        if(homePage.getPageTitle().equals("diu")){
            return true;
        }else{
            return false;
        }
    }
    public boolean examinationGuidelinePageOkBtnCheck() {
       examinationGuideline = new ExaminationGuidelinePage(driver);
        homePage = new HomePage(driver);
        nav_ExaminationGuidelineElement.click();
        examinationGuideline.PressOkButton();
        if(homePage.getPageTitle().equals("diu")){
            return true;
        }else{
            return false;
        }
    }
    public boolean prospectiveStudentsPageOkBtnCheck() {
        prospectiveStudents = new ProspectiveStudentsPage(driver);
        homePage = new HomePage(driver);
        nav_ProspectiveStudentsElement.click();
        prospectiveStudents.PressOkButton();
        if(homePage.getPageTitle().equals("diu")){
            return true;
        }else{
            return false;
        }
    }

    public boolean creditTransferPageOkBtnCheck() {
        creditTransfer = new CreditTransferPage(driver);
        homePage = new HomePage(driver);
        nav_CreditTransferElement.click();
        creditTransfer.PressOkButton();
        if(homePage.getPageTitle().equals("diu")){
            return true;
        }else{
            return false;
        }
    }

    public String getSettingsPageTitleText() {
        settings = new SettingsPage(driver);
        scrollToView(driver,"Settings");
        nav_SettingsElement.click();
        return settings.getSettingsPageTitle();
    }

}
