package org.auntor.utilities;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BaseClass{
    public static AndroidDriver<AndroidElement> driver;
    public static AppiumDriverLocalService service;
    
    @BeforeTest
    public void automationEnvStart() throws IOException, InterruptedException {
        startServer();
        capabilities();
    }

    @AfterTest
    public void automationEnvStop() {
        driver.quit();
        service.stop();
    }

    @BeforeSuite
    void setAllureEnvironment(){
        Config config = new Config();
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Test Device Type","ABC")
                        .put("Test Device Name",config.getDeviceName())
                        .put("Test Device Os Version", config.getDeviceOsVersion())
                        .put("Apk Name", config.getApkName())
                        .build(), System.getProperty("user.dir")
                        + "/allure-results/");
    }


    public AppiumDriverLocalService startServer() {
        //
        boolean flag = checkIfServerIsRunning(4723);
        if (!flag) {

            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;

    }


    public static AndroidDriver<AndroidElement> capabilities() throws IOException, InterruptedException {

        Config config = new Config();
        String testApkName = config.getApkName();
        String deviceType = config.getDeviceType();

        DesiredCapabilities dc = new DesiredCapabilities();

        if (deviceType.contains("emulator")) {
            startEmulator();
        }
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceType);
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
        dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        dc.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/src/main/java/org/auntor/TestApk/" + testApkName + ".apk");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static boolean checkIfServerIsRunning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);

            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static void startEmulator() throws IOException, InterruptedException {

        Runtime.getRuntime().exec(System.getProperty("user.dir") + "Configuration\\startEmulator.bat");
        Thread.sleep(6000);
    }



}
