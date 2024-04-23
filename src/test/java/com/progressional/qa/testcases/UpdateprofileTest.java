package com.progressional.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.progressional.qa.baseclass.BaseClass;
import com.progressional.qa.pages.HomePage;
import com.progressional.qa.pages.UpdateprofilePage;

public class UpdateprofileTest extends BaseClass {
	
	UpdateprofilePage updateprofilePage;
	public WebDriver driver;
	
	public UpdateprofileTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		driver= initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage =new HomePage(driver);
		updateprofilePage =homePage.navigateToUpadteprofilePage(); 
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@Test(priority=1)
	public void updatePersonalDetailsPageManadatoryFields()
	{
		
	}
	

}
