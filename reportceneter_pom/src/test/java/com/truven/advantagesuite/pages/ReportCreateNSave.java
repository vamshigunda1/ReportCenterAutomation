package com.truven.advantagesuite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportCreateNSave {
	 WebDriver driver;
	 
	 @FindBy(xpath="//*[@id='inputSearch']")
		WebElement SearchBox;
		
		@FindBy(xpath="//*[@id=\"search\"]/div/div/div[2]/button")
		WebElement SearchBtn;
		
		@FindBy(id="runbutton")
		WebElement RunBtn;
		
		@FindBy(className="viewAsTextForExcelUrl")
		WebElement ExcelBtn;
		
		@FindBy(xpath="//*[@id=\"main-toolbar-button-container\"]/div[2]")
		WebElement SaveBtn;
	public ReportCreateNSave(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	public void measureORsubsetORtimeperiod(String measure) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.elementToBeClickable(SearchBox));
		SearchBox.sendKeys(measure);
		SearchBtn.click();
		WebElement searchitem = driver.findElement(By.xpath("//*[text()='" +measure+"']"));
		Actions ac = new Actions(driver);
		ac.doubleClick(searchitem).perform();
		Thread.sleep(1000);
		SearchBox.clear();
	}
	public void TimePeriod() throws InterruptedException {
		driver.findElement(By.cssSelector("#tree-tab-timeperiods > div")).click();
		Thread.sleep(1000);
		Actions ac = new Actions(driver);
	ac.doubleClick(driver.findElement(By.id("reno-ALL.INCURRED"))).perform();
	}
	public void runReport() {
		RunBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 300);
	    wait.until(ExpectedConditions.visibilityOf(ExcelBtn));
	    		//elementToBeClickable(ExcelBtn));
	}
	public void saveReport() {
		SaveBtn.click();
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.cssSelector("#Zero\\ Two\\ Two\\ One\\ New\\ Commercial\\ Demo_build > td.itemName"));
	    String a=elementLocator.getText();
	    System.out.println(a);
		ac.doubleClick(elementLocator).perform();
		//ac.doubleClick(driver.findElement(By.cssSelector("#Zero\\ Two\\ Two\\ One\\ New\\ Commercial\\ Demo_build > td.itemName"))).perform();
		
	}
}
