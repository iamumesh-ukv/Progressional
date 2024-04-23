package com.progressional.qa.testcases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.progressional.qa.baseclass.BaseClass;
import com.progressional.qa.pages.HomePage;
import com.progressional.qa.pages.LoginPage;
import com.progressional.qa.utilities.Utilities;

public class LoginTest extends BaseClass {
	LoginPage loginPage;

	public LoginTest() throws IOException {
		super();
	}
	public WebDriver driver;

	@BeforeMethod
	public void setup() 
	{
		driver= initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage =new HomePage(driver);
		loginPage =homePage.naviageToLoginPage(); 		
	}

	@AfterMethod
	public void teaDown()
	{
		driver.quit();
	}

	@Test(priority=1, dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials( String email, String password)
	{
		loginPage.login(email, password);
	}

	@DataProvider(name="validCredentialsSupplier")
	public Object [][] supplyTestData()
	{
		Object[][] data= {{"umesh@yopmail.com","Umesh@123"}};
		//Object[][] data= {{"umesh@yopmail.com","Umesh@123"},{"umesh1@yopmail.com","Umesh@123"},{"umesh2@yopmail.com","Umesh@123"}};

		return data;
	}

	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials()
	{
		loginPage.login(Utilities.generateEmailWithTimeStamp(),dataProp.getProperty("invalidPassword"));
		//Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")),"Expected Warning message is not displayed");
	}

	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndValidPassword()
	{
		loginPage.login(dataProp.getProperty("invalidEmail"),prop.getProperty("validPassword"));
		//Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")),"Expected Warning message is not displayed");		
	}

	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInvalidPassword()
	{
		loginPage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		//Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")),"Expected Warning message is not displayed");	
	}

	@Test(priority=5)
	public void verifyLoginWithoutProvidingCredentials() 
	{
		loginPage.clickOnLoginButton();
		//Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")),"Expected Warning message is not displayed");
	}
}
