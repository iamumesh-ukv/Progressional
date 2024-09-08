package com.progressional.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.progressional.qa.utilities.ExtentReporter;


public class MyListeners implements ITestListener  {

	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context)
	{
		extentReport = ExtentReporter.generateExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result)
	{
		String testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO,testName+" started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result )
	{
		String testName = result.getName();
		extentTest.log(Status.PASS,testName+" got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		WebDriver driver = null;

		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		String destinationScreenshotPath = com.progressional.qa.utilities.Utilities.captureScreenshot(driver,result.getName());

		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL,result.getName()+" got failed");

	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		String testName = result.getName();
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP, testName+" got skipped");
	}
	@Override
	public void onFinish(ITestContext context)
	{

		extentReport.flush();
		String pathofExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentReport.html";
		File extentReport =  new File(pathofExtentReport);
		try
		{
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
