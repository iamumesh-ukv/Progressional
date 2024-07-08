package com.progressional.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.progressional.qa.baseclass.BaseClass;
import com.progressional.qa.pages.CreateJourneyPage;
import com.progressional.qa.pages.HomePage;

public class CreateJourneyTest extends BaseClass{

	CreateJourneyPage createJourneyPage;

	public CreateJourneyTest()
	{
		super();
	}
	public WebDriver driver;

	@BeforeMethod
	public void setup()
	{
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage= new HomePage(driver);
		createJourneyPage = homePage.navigateToCreateJourneyPage();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@Test(priority = 1)
	public void verifyCreateJourney()
	{
		createJourneyPage.clickOnCreateJourneyButton();
	}
}
