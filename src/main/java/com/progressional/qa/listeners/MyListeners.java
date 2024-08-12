package com.progressional.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListeners implements ITestListener  {

	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context)
	{
		//extentReport = ExtentReport.
	}

	@Override
	public void onTestStart(ITestResult result)
	{
		//extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO,result.getName()+" started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result )
	{
		extentTest.log(Status.PASS,result.getName()+" got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult reslut)
	{

	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+" got skipped");
	}
	@Override
	public void onFinish(ITestContext context)
	{
		
	}
}
