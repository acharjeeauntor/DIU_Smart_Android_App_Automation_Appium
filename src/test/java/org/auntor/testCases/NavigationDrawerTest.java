package org.auntor.testCases;


/*
Test Cases:
1. Verify Navigation Drawer option is working properly or not.
2. Verify Navigation Drawer header text is showing properly or not.
3. Verify Navigation Drawer is scrolling properly or not.
4. Verify Navigation Drawer option Class Routine is working properly or not.
5. Verify Navigation Drawer option Notice Board is working properly or not.
6. Verify Navigation Drawer option Student portal is working properly or not.
7. Verify Navigation Drawer option Administration is working properly or not.
8. Verify Navigation Drawer option Faculty Members is working properly or not.
9. Verify Navigation Drawer option Academic Result is working properly or not.
10. Verify Navigation Drawer option Academic Calendar is working properly or not.
11. Verify Navigation Drawer option Faculty Members is working properly or not.
12.  Verify Navigation Drawer option Rules and Regulation is working properly or not.
9. Verify Navigation Drawer option Examination Guideline is working properly or not.
10. Verify Navigation Drawer option Prospective Students is working properly or not.
11. Verify Navigation Drawer option Credit Transfer is working properly or not.
12. Verify Navigation Drawer option Rules and Regulation is working properly or not.
13. Verify Navigation Drawer option Settings is working properly or not.
14. Verify Navigation Drawer option About is working properly or not.
 */


import org.auntor.pageObjects.AcademicResult;
import org.auntor.pageObjects.FacultyMember;
import org.auntor.pageObjects.HomePage;
import org.auntor.pageObjects.StudentPortalPage;
import org.testng.annotations.Test;

public class NavigationDrawerTest extends BaseClass {
    HomePage homePage;
    StudentPortalPage studentPortalPage;
    FacultyMember facultyMember;
    AcademicResult academicResult;

    @Test(priority = 1)
    public void checkNavigationDrawerOption(){
        homePage = new HomePage(driver);
        homePage.pressNavigationDrawer();

    }


}
