package com.truven.advantagesuite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RunNSaveReport {
 WebDriver driver;
	 
		
		@FindBy(id="runbutton")
		WebElement RunBtn;
		
		@FindBy(className="viewAsTextForExcelUrl")
		WebElement ExcelBtn;
		
		@FindBy(xpath="//*[@id=\"main-toolbar-button-container\"]/div[2]")
		WebElement SaveBtn;
		
		@FindBy(id="htmlFormat")
		WebElement HtmlRadioBtn;
		
		@FindBy(id="excelFormat")
		WebElement ExcelRadioBtn;
		
		@FindBy(id="textFormat")
		WebElement DelimitedCSVRadioBtn;
		
		@FindBy(id="formatSelector-ok-button")
		WebElement OkBtnForRadioBtn;
	
		
	public RunNSaveReport(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public void runReport() {
		RunBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 300);
	    wait.until(ExpectedConditions.visibilityOf(ExcelBtn));
	}
	public void runRecList() {
		RunBtn.click();
		HtmlRadioBtn.click();
		OkBtnForRadioBtn.click();
	}
	
	
	public void saveReport() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOf(ExcelBtn));
		SaveBtn.click();
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/span[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]"));
	    String a=elementLocator.getText();
	    System.out.println(a);
		ac.doubleClick(elementLocator).perform();
		//ac.doubleClick(driver.findElement(By.cssSelector("#Zero\\ Two\\ Two\\ One\\ New\\ Commercial\\ Demo_build > td.itemName"))).perform();
		
	}
}
