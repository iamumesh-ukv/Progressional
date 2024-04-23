package com.progressional.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.progressional.qa.baseclass.BaseClass;
import com.progressional.qa.pages.HomePage;
import com.progressional.qa.pages.RegisterPage;
import com.progressional.qa.utilities.Utilities;

public class RegisterTest extends BaseClass {

	RegisterPage registerPage;

	public RegisterTest() throws IOException
	{
		super();

	}
	public WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver= initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage =new HomePage(driver);
		registerPage =homePage.navigateToRegisterPage(); 
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	@Test(priority=1)
	public void verifyRegisteringAnAccountWithMandatoryFields()
	{
		registerPage =registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),Utilities.generateEmailWithTimeStamp(),prop.getProperty("validPassword"));
		//Assert.assertEquals(registerPage.retrieveAccountSuccessPageHeading().contains(dataProp.getProperty("accountSuccessfullyCreatedHeading")),"Congratulations! your account has been successfull");
	}

	//	@Test(priority=2)
	//	public void verifyRegisteringAccountByProvidingAllFields() {
	//	}

	@Test(priority=2)
	public void verifyRegisteringAccountWithExistingEmailAddress() {

		registerPage= registerPage.registerWithAllFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),prop.getProperty("validEmail"),prop.getProperty("validPassword"));
		//Assert.assertEquals(registerPage.retrieveDuplicateEmailAddressWarning().contains(dataProp.getProperty("duplicateEmailWarning")),"Warning message regarding duplicate email address is not displayed");
	}

	@Test(priority=3)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {

		registerPage.clickOnSignupButton();
		Assert.assertEquals(registerPage.displayStatusOfWarningMessages(dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"), dataProp.getProperty("emailWarning"), dataProp.getProperty("passwordWarning")), false);
	}

}