package com.progressional.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//button[normalize-space()='Sign Up']")
	WebElement signupOption;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
    //Actions
	public RegisterPage navigateToRegisterPage()
	{
		signupOption.click();
		return new  RegisterPage(driver);
	}
	public LoginPage naviageToLoginPage()
	{
		return new LoginPage(driver);
	}
	public UpdateprofilePage navigateToUpadteprofilePage()
	{
		return new UpdateprofilePage(driver);
}
}
