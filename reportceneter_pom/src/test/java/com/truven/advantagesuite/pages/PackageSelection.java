package com.truven.advantagesuite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PackageSelection {

WebDriver driver;
	
	//Locators
	@FindBy(xpath="//*[@id='inputSearch']")
	WebElement SearchBox;
	
	@FindBy(xpath="//*[@id=\"search\"]/div/div/div[2]/button")
	WebElement SearchBtn;
	
	@FindBy(xpath="//*[text()='View details']")
	WebElement ViewDetails;
	
	@FindBy(id="viewContent")
	WebElement Description;
	
	@FindBy(id="viewdetails_close")
	WebElement closeBtn;
	
	@FindBy(css="#PackageSelectionPick")
	WebElement PackageSelector;
	
	@FindBy(id="packageButton")
	WebElement OkBtn;
	
	@FindBy(xpath="//*[@id=\"file\"]/div[1]/span")
	WebElement FileBtn;
	
	@FindBy(xpath="//*[text()='Change Package']")
	WebElement ChangePackage;
	
	
	public PackageSelection(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	

	public void PackageSelector(String PackageName) {
		Select rcpackage = new Select(PackageSelector);
		rcpackage.selectByValue(PackageName);
		OkBtn.click();
	}
	
}
