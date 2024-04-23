package com.progressional.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Objects
	@FindBy(xpath="//input[@placeholder='Email Address']")
	WebElement emailAddressField;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement passwordField;
	
	@FindBy(xpath ="//button[@class='popFBtn wd-100']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@class='Toastify__toast-body']")
	WebElement emailPasswordNotMatchingWarning;
	
	public void enterEmailAddress( String emailText)
	{
		emailAddressField.sendKeys(emailText);
	}
	public void enterPassword(String passwordText)
	{
		passwordField.sendKeys(passwordText);
	}
	
	public LoginPage clickOnLoginButton()
	{
		loginButton.click();
		return new LoginPage(driver);
	}
	
	public LoginPage login(String emailText, String passwordText)
	{
		emailAddressField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		loginButton.click();
		
		return new LoginPage(driver); 
	}
	public String retrieveEmailPasswordNotMatchingWarningMessageText()
	{
		String warningText = emailPasswordNotMatchingWarning.getText();
		return warningText;
	}
	
	//Action 
	public WebElement emailAddressField()
	{
		return emailAddressField;
	}
	public WebElement passwordField()
	{
		return passwordField;
	}
	public WebElement loginButton()
	{
		return loginButton;
	}	
}


