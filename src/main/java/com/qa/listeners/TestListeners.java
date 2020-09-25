package com.qa.listeners;

import com.qa.BaseTest;
import com.qa.utils.TestUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestListeners implements ITestListener {


    public  void onTestFailure(ITestResult result){
        Map<String,String> resultParams = new HashMap<String, String>();

        if(result.getStatus() == ITestResult.FAILURE){
            result.getThrowable().printStackTrace();
        }
        else if(result.getStatus() == ITestResult.SUCCESS){

        }

        BaseTest objBaseTest = new BaseTest();
        TestUtils utils = new TestUtils();

        resultParams = result.getTestContext().getCurrentXmlTest().getAllParameters();
        String imagePath = "Screenshots" + File.separator + resultParams.get("platformName")
                + "_" + resultParams.get("platformVersion") + "_" + resultParams.get("deviceName")
                + File.separator + utils.getDateTime() + File.separator + result.getTestClass().getRealClass().getSimpleName()
                + File.separator + result.getName() + ".png";
        String completeImagePath = System.getProperty("user.dir") + File.separator + imagePath;
        File file = objBaseTest.getDriver().getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(imagePath));
            Reporter.log("This is sample Screenshot");
            Reporter.log("<a href='" + completeImagePath + "'> <image src='" + completeImagePath + "' height='100' width='100'/></a>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
