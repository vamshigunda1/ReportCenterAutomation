package com.truven.advantagesuite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ReportCreation extends PackageSelectionNSaveDesc {
	
	
	public ReportCreation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void actionsClass() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Environment\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		WebElement sourceLocator = driver.findElement(By.xpath("//*[text()='Postpartum Contraceptive Effec 60d Adult {MS}']"));
		WebElement targetLocator = driver.findElement(By.id("columns-container"));
		action.dragAndDrop(sourceLocator, targetLocator).build().perform();
        }
}
