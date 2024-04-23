package com.progressional.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateprofilePage {
	
	WebDriver driver;
	
	//Objects
	//Personal details mandatory fields
	@FindBy(xpath="//input[@placeholder='1 (702) 123-4567']")
	WebElement telephoneField;
	@FindBy(xpath="//input[@placeholder='Address 1']")
	WebElement addressField;
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryField;
	@FindBy(xpath="//input[@placeholder='Select State']")
	WebElement stateField;
	@FindBy(xpath="//input[@placeholder='Select City']")
	WebElement cityField;
	@FindBy(xpath="//input[@placeholder='ZIP Code']")
	WebElement zipCodeField;
	@FindBy(xpath="//button[normalize-space()='Update']")
	WebElement updateBUtton;
	
	//Education mandatory fields inside the profile
	@FindBy(xpath="//input[@placeholder='School / College']")
	WebElement schoolCollegeField;
	
	@FindBy(xpath="//div[@class='form_grp error']//select[@id='exampleSelect']")
	WebElement degreeField;
	@FindBy(xpath="//div[@class='form_grp phone_numb error']//select[@id='exampleSelect']")
	WebElement studyField;
	@FindBy(xpath="//button[normalize-space()='Update']")
	WebElement updateEducationButton;
	
	//Experience mandatory fields
	@FindBy(xpath="//input[@placeholder='Job Title']")
	WebElement jobTitleField;
	@FindBy(xpath="//div[@class='add_edu_btn']//select[@id='exampleSelect']")
	WebElement employmentTypeField;
	@FindBy(xpath="//input[@placeholder='Company']")
	WebElement compnayField;
	@FindBy(xpath="//input[@placeholder='Location']")
	WebElement locationField;
	@FindBy(xpath="//input[@placeholder='Profile Headline']")
	WebElement profileHeadlineField;
	@FindBy(xpath="//select[@placeholder='Industry']")
	WebElement industryField;
	@FindBy(xpath="//li[7]//div[1]//input[1]")
	WebElement yearField;
	@FindBy(xpath="//li[8]//div[1]//input[1]")
	WebElement monthsField;
	@FindBy(xpath="//button[normalize-space()='Update']")
	WebElement updateExperienceButton;
	
	public UpdateprofilePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterTelepphoneNumber(String telephoneText)
	{
		telephoneField.sendKeys(telephoneText);
	}
	
	public void enterAddress(String addressText)
	{
		addressField.sendKeys(addressText);
	}
	public void enterCountryName(String countryText)
	{
		countryField.sendKeys(countryText);
	}
	public void enterStateName(String stateText)
	{
		stateField.sendKeys(stateText);
	}
	public void enterCityName(String cityText)
	{
		cityField.sendKeys(cityText);
	}
	public void enterZipCodeNumber(String zipCodeText)
	{
		zipCodeField.sendKeys(zipCodeText);
	}
	public LoginPage clickOnPersonalDetailsUpdateButton()
	{
		updateBUtton.click();
		return new LoginPage(driver);
	}
	
	
	
	
	
}
