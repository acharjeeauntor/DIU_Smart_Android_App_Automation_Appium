package org.auntor.utilities;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BaseClass{
    public static AppiumDriver driver;
    public AppiumDriverLocalService service;
    
    @BeforeClass
    public void automationEnvStart() throws IOException, InterruptedException {
       startServer();
        capabilities();
    }

    @AfterClass
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
        Config config = new Config();
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
