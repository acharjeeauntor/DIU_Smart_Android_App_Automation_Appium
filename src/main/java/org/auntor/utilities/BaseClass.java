package org.auntor.utilities;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;


public class BaseClass{
    static Config config = new Config();
    public static AppiumDriver driver;
    public AppiumDriverLocalService service;
    public static final String UserName=config.getBSUserName();
    public static final String Key= config.getBSKey();
    public static final String URL="https://"+UserName+":"+Key+"@hub-cloud.browserstack.com/wd/hub";

    
    @BeforeClass
    public void automationEnvStart() throws IOException, InterruptedException {
        //startServer();
        if(config.getDeviceType().equals("Emulator")){
            startServer();
            capabilities();
        } else if (config.getDeviceType().equals("BrowserStack")) {
            bsCapabilities();
        }
    }

    @AfterClass
    public void automationEnvStop() {
        if(config.getDeviceType().equals("Emulator")){
            driver.quit();
            service.stop();
        } else if (config.getDeviceType().equals("BrowserStack")) {
            driver.quit();
        }
    }

    @BeforeSuite
    void setAllureEnvironment(){
        //Config config = new Config();
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

            service = new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
                    .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                    .withIPAddress("127.0.0.1")
                    .withLogFile(new File("appium.log"))
                    .withTimeout(Duration.ofSeconds(200))
                    .usingPort(4723).build();
            service.start();
        }
        return service;

    }


    public static AppiumDriver capabilities() throws IOException, InterruptedException {
        String testApkName = config.getApkName();
        String deviceName = config.getDeviceName();

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName(deviceName)
                .setUdid("emulator-5554")
                .setAutomationName("UiAutomator2")
                .setApp(System.getProperty("user.dir") + "/src/main/java/org/auntor/TestApk/" + testApkName + ".apk")
                .setNoReset(false)
                .eventTimings();

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        return driver;
    }

    public static AppiumDriver bsCapabilities() throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName","Google Pixel 3");
        caps.setCapability("os_version","9.0");
        caps.setCapability("Project","DIU Smart App Test Automation");
        caps.setCapability("build","6.7");
        caps.setCapability("name","Run DIU Smart App Test Automation in BrowserStack");
        caps.setCapability("app",config.getBSDIUSmartAppKey());

        driver = new AppiumDriver(new URL(URL),caps);

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




}
