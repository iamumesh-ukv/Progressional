package com.progressional.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage{
	WebDriver driver;

	//Objects
	@FindBy(xpath="//div[@class='sc-dmyCSP bDsWfK']")
	WebElement selectUserTypeDropdown;

	@FindBy(xpath="//li[normalize-space()='USER']")
	WebElement selectUser;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstNameField;

	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastNameField;

	@FindBy(xpath="//div[@class='modal-body']//input[@placeholder='Email Address']")
	WebElement emailAddressField;

	@FindBy(xpath="//input[@id='password']")
	WebElement passwordField;

	@FindBy(xpath="//button[@type='submit']")
	WebElement signupButton;

	@FindBy(xpath="//span[normalize-space()='Please enter first name.']")
	WebElement firstNameWarning;

	@FindBy(xpath="//span[normalize-space()='Please enter last name.']")
	WebElement lastNameWarning;

	@FindBy(xpath="//span[normalize-space()='Please enter email ID.']")
	WebElement emailWarning;
	@FindBy(xpath="//div[contains(text(),'Email already exists.')]")
	WebElement duplicateEmailAddressWarning;

	@FindBy(xpath="//span[normalize-space()='Please enter email ID.']")
	WebElement passwordWarning;
	
	@FindBy(xpath="//p[contains(text(),'Congratulations! your account has been successfull')]")
	WebElement accountSuccessPageHeading;


	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String retrieveFirstNameWarning()
	{
		String firstNameWarningText = firstNameWarning.getText();
		return firstNameWarningText;
	}
	public String retrieveLastNameWarning()
	{
		String lastNameWarningText = lastNameWarning.getText();
		return lastNameWarningText;
	}
	public String retrieveEmailWarning()
	{
		String emailWaringText = emailWarning.getText();
		return emailWaringText;
	}
	public String retrievePasswordWarning()
	{
		String passwordWarningText = passwordWarning.getText();
		return passwordWarningText;
	}
	public void enterFirstName(String firstNameText)
	{
		firstNameField.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText)
	{
		lastNameField.sendKeys(lastNameText);
	}
	public void enterEmailAddress(String emailText)
	{
		emailAddressField.sendKeys(emailText);
	}
	public void enterPassword(String passwordText)
	{
		passwordField.sendKeys(passwordText);
	}

	public RegisterPage clickOnSignupButton()
	{
		signupButton.click();
		return new RegisterPage(driver);
	}

	public RegisterPage selectUserType()
	{
		selectUserTypeDropdown.click();
		selectUser.click();
		return new RegisterPage(driver);
	}

	public String retrieveDuplicateEmailAddressWarning() {

		String duplicateEmailWarningText = duplicateEmailAddressWarning.getText();
		return duplicateEmailWarningText;
	}

	public String retrieveAccountSuccessPageHeading() {

		String accountSuccessPageHeadingText = accountSuccessPageHeading.getText();
		return accountSuccessPageHeadingText;
	}

	public RegisterPage registerWithMandatoryFields(String firstNameText, String lastNameText, String emailText, String passwordText)
	{
		selectUserTypeDropdown.click();
		selectUser.click();
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailAddressField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		signupButton.click();

		return new RegisterPage(driver);

	}
	public RegisterPage registerWithAllFields(String firstNameText, String lastNameText, String emailText,String passwordText)
	{
		selectUserTypeDropdown.click();
		selectUser.click();
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailAddressField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		signupButton.click();

		return new RegisterPage(driver);

	}
	public boolean displayStatusOfWarningMessages(String expectedFirstNameWarning,String expectedLastNameWarning, String expectedEmailWarning, String expectedPasswordWarning)
	{
		boolean firstNameWarningStatus = firstNameWarning.getText().equals(expectedFirstNameWarning);
		boolean lastNameWarningStatus = lastNameWarning.getText().equals(expectedLastNameWarning);
		boolean emailWarningStatus = emailWarning.getText().equals(expectedEmailWarning);
		boolean passwordWarningStatus= passwordWarning.getText().equals(expectedPasswordWarning);
		return firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && passwordWarningStatus;
	}
	/*
	public WebElement userField()
	{
		return userField;
	}
	public WebElement firstNameField()
	{
		return firstNameField;	
	}
	public WebElement lastNameField() 
	{
		return lastNameField;
	}
	public WebElement emailAddressField()
	{
		return emailAddressField;
	}
	public WebElement passwordField()
	{
		return passwordField;
	}

	public WebElement signupButton()
	{
		return signupButton;
	}*/
}
