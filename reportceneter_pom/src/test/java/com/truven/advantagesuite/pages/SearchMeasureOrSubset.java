package com.truven.advantagesuite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchMeasureOrSubset  {
	

		WebDriver driver;
			
			//Locators
			@FindBy(xpath="//*[@id='inputSearch']")
			WebElement SearchBox;
			
			@FindBy(xpath="//*[@id=\"search\"]/div/div/div[2]/button")
			WebElement SearchBtn;
			
			@FindBy(xpath="//*[@id=\"search\"]/div/div/div[1]/button")
			WebElement Dropdown;
			
			@FindBy(xpath="//*[@name='Measures']")
			WebElement DropdownMeasure;
			
			@FindBy(name="Subsets")
			WebElement DropdownSubset;
			
			
		
	public SearchMeasureOrSubset(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);		
	}
	public void SearchMeasure(String Measure) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.elementToBeClickable(SearchBox));
	    Dropdown.click();
	    Thread.sleep(1000);
	    DropdownMeasure.click();
	  	SearchBox.sendKeys(Measure);
		SearchBtn.click();
		WebElement searchitem = driver.findElement(By.xpath("//*[text()='" +Measure+"']"));
		Actions ac = new Actions(driver);
		ac.doubleClick(searchitem).perform();
		Thread.sleep(1000);
		SearchBox.clear();
	}
	public void SearchSubset(String Subset) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.elementToBeClickable(SearchBox));
	    Dropdown.click();
	    Thread.sleep(1000);
	    DropdownSubset.click();
	    SearchBox.clear();
		SearchBox.sendKeys(Subset);
		SearchBtn.click();
		WebElement searchitem = driver.findElement(By.xpath("//*[text()='" +Subset+"']"));
		Actions ac = new Actions(driver);
		ac.doubleClick(searchitem).perform();
		Thread.sleep(1000);
		SearchBox.clear();
	}
}
