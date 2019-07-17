package com.truven.advantagesuite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchMeasureOrSubset {
	

		WebDriver driver;
			
			//Locators
			@FindBy(xpath="//*[@id='inputSearch']")
			WebElement SearchBox;
			
			@FindBy(xpath="//*[@id=\"search\"]/div/div/div[2]/button")
			WebElement SearchBtn;
		
	public SearchMeasureOrSubset(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);		
	}
	public void SearchMeasureorSubset(String MeasureOrSubset) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.elementToBeClickable(SearchBox));
		SearchBox.sendKeys(MeasureOrSubset);
		SearchBtn.click();
		WebElement searchitem = driver.findElement(By.xpath("//*[text()='" +MeasureOrSubset+"']"));
		Actions ac = new Actions(driver);
		ac.doubleClick(searchitem).perform();
		Thread.sleep(1000);
		SearchBox.clear();
	}
}
