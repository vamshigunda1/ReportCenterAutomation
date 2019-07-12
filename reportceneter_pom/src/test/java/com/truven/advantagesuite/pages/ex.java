package com.truven.advantagesuite.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ex {

  

    WebDriver driver;

    @FindBy(xpath="//*[text()='IBM Advantage Suite® Ad Hoc Report Writer']")
	WebElement AHRW1;

    public ex(WebDriver driver){

        this.driver = driver;

       

        PageFactory.initElements(driver, this);

    }

    public void openAdhocRW() throws InterruptedException {
		Thread.sleep(3000);
		AHRW1.click();
		Thread.sleep(3000);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		
		
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          driver.switchTo().window(windowHandle);
	}
		       }
    }
}