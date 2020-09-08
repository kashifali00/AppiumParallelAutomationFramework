package com.qa;

import com.qa.utils.TestUtils;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected  static AppiumDriver<MobileElement> appiumDrv;
    protected  DesiredCapabilities cap;
    protected  static Properties props;
    public SoftAssert softAssert = new SoftAssert();
    InputStream inputStream;
    URL appiumURL;
    File appURL;


    // Constructor used here to initialize the page factory class
    public BaseTest(){
    }

    public void setDriver(AppiumDriver appiumDrv){
        this.appiumDrv = appiumDrv;

    }

    public AppiumDriver getDriver(){
        return appiumDrv;
    }

    public void driverSetup(String platformName, String platformVersion, String deviceName) throws Exception{
            System.out.println("***** Executing BeforeTest method inside BaseTest Class *****");
            System.out.println("platformName "+"["+platformName+"]");
            System.out.println("platformVersion "+"["+platformVersion+"]");
            System.out.println("deviceName "+"["+deviceName+"]");
            cap = new DesiredCapabilities();
            props = new Properties();
            String propsFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propsFileName);
            props.load(inputStream);
            appURL = new File(props.getProperty("androidAppLocation"));
            cap.setCapability("platformName", platformName);
            cap.setCapability("platformVersion", platformVersion);
            cap.setCapability("deviceName",deviceName);
            cap.setCapability("automationName", props.getProperty("automationName"));
            cap.setCapability("app", appURL.getAbsolutePath());
            cap.setCapability("appPackage",props.getProperty("appPackage"));
            cap.setCapability("appActivity",props.getProperty("appActivity"));
            cap.setCapability("newCommandTimeout", TestUtils.newCommandTimeoutWait);
            cap.setCapability("appWaitDuration", TestUtils.appDurationTimeoutWait);
            cap.setCapability("fullReset","true");


            appiumURL = new URL(props.getProperty("appiumServerURL"));
            appiumDrv = new AndroidDriver<MobileElement>(appiumURL, cap);
            appiumDrv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }

    // web driver wait method

    public void waitForVisibility(MobileElement el){
            System.out.println("*****  Executing waitForVisibility method  *****");
            WebDriverWait wait = new WebDriverWait(appiumDrv, TestUtils.WAIT);
            wait.until(ExpectedConditions.visibilityOf(el)).isDisplayed();
    }

    public void waitForInvisibility(MobileElement el){
            WebDriverWait wait = new WebDriverWait(appiumDrv, TestUtils.WAIT);
            wait.until(ExpectedConditions.invisibilityOf(el));


    }

    public void waitForAlert(){
            WebDriverWait wait = new WebDriverWait(appiumDrv, TestUtils.WAIT);
            wait.until(ExpectedConditions.alertIsPresent());
    }

    // web driver actions methods
    public void Click(MobileElement el){
        System.out.println("*****  Executing Click method  *****");
            el.click();
    }

    public void Scroll(MobileElement el){
        try {
            System.out.println("Executing scroll method");
            //((FindsByAndroidUIAutomator)appiumDrv).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+el+"\"))");
            appiumDrv.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                    ".scrollIntoView(new UiSelector().textContains(\"" + el + "\"))"));
        }catch (Exception e){
        }
    }

    public void SendKeys(MobileElement el, String str){
        waitForVisibility(el);
        el.sendKeys(str);
    }

    public String getText(MobileElement el){
        waitForVisibility(el);
        return el.getAttribute("text");
    }

    public String resourceId(MobileElement el){
        waitForVisibility(el);
        return el.getAttribute("resource-id");
    }

    public String getAttribute(MobileElement el, String attribute){
        waitForVisibility(el);
        return el.getAttribute(attribute);
    }

    public void driverTearDown () throws Exception{
            System.out.println("***** Executing AfterTest method inside BaseTest Class *****");
            appiumDrv.quit();
            inputStream.close();

    }
}
