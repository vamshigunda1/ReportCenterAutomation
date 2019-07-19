package com.truven.advantagesuite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectRecordListing {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"file\"]/div[1]/span")
	WebElement FileBtn;
	
	@FindBy(xpath="//*[text()='New Record Listing']")
	WebElement RecordListing;
	
	@FindBy(xpath="//*[@id='inputSearch']")
	WebElement SearchBox;
	
	public SelectRecordListing(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SelRecordListing() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.elementToBeClickable(SearchBox));
		FileBtn.click();
		RecordListing.click();
		
	}
}
