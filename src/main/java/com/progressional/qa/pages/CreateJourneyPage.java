package com.progressional.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateJourneyPage {
	WebDriver driver;

	//Objects


	public CreateJourneyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//@FindBy(xpath="//img[@alt='add journey']")
	//@FindBy(xpath="//a[@class='activecl']")
	
	@FindBy(xpath = "//span[normalize-space()='Create New Journey']")
	WebElement createJourneyButton;

	public CreateJourneyPage clickOnCreateJourneyButton()
	{
		createJourneyButton.click();
		return new CreateJourneyPage(driver);
	}


}
