package com.truven.advantagesuite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Set;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AHRW {
	
WebDriver driver;
	
	//Locators
	@FindBy(xpath="//*[text()='IBM Advantage Suite® Ad Hoc Report Writer']")
	WebElement AHRW1;
	
	public AHRW(WebDriver driver){
		this.driver = driver;

	       

        PageFactory.initElements(driver, this);
	}
	
	public void openAdhocRW() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(AHRW1));
		AHRW1.click();
		
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		
		
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          driver.switchTo().window(windowHandle);
		          driver.manage().window().maximize();

	}
		       }
		   

	
	}
}
