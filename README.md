# DIU_Smart_App_Automation_Using_Appium

This is a Demo project for Android App Automation Testing using Selenium-Appium.
#### Project name: DIU Smart App Test Automation <br>


## Technology <br>
Tool: selenium,Appium <br>
Build tool: Maven <br>
Language: Java <br>
Framework: TestNG,Data Driven Framework(DDF) <br>
Report: Extent<br>
Project Structure: Page object Model(POM)<br>
Dependency Used:java-client,apache poi,extentreports,log4j,testng,selenium-java,etc<br>
IDE: Intellij<br>

## Project Architecture: <br>
![Selenium_Appium_Android_project_Arch](https://user-images.githubusercontent.com/38497405/232031031-7e64285d-6976-45f6-bc7f-0ded40efd899.png)

#### Note: In this project i have used latest version of Appium(v2) & Java-Client(v8), Also Intregrate this project with BrowserStack & Jenkins via Docker Container. <br>

## To Run the project with Different Test Runner:<br>

Use the following command from the Cmd: mvn clean test -Dfilename=testNG_File_name.xml<br>
Example: mvn clean test -Dfilename=settings_testng.xml<br>


## Allure Report view for the test:
![Screenshot 2023-04-01 at 1 01 21 AM](https://user-images.githubusercontent.com/38497405/229207232-5d3cc943-d1d9-44f9-af23-0d7ff481132f.png)
![Screenshot 2023-04-01 at 1 00 59 AM](https://user-images.githubusercontent.com/38497405/229207241-2e1ff0cd-c8fd-4ec6-b471-879880a1d5e0.png)
![Screenshot 2023-04-01 at 1 01 11 AM](https://user-images.githubusercontent.com/38497405/229207263-794d3e5c-dca6-4214-983d-46102aa81aa3.png)
![Screenshot 2023-04-01 at 1 01 35 AM](https://user-images.githubusercontent.com/38497405/229207277-52d0f380-44fa-4f47-81b5-8b5dcdbbbb5c.png)

To See the Demo Video click [here](https://youtu.be/MEx913kLWyE)<br>

----------------------------------------------------------

## BrowserStack Related Info:<br>

To run this test autoamtion project in a virtual device, i have intregrate this project with Browserstack. <br>

To See the Demo Video click [here](https://youtu.be/0ik45M0pL00)<br>

----------------------------------------------------------

## Jenkins with BrowserStack Related Info:<br>

I have intregrate this project with jenkins through the github repository and run test on Browserstack for virtual device. <br>

To See the Demo Video click [here](https://youtu.be/lWsQIi0s0zo)<br>
