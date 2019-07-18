package com.truven.advantagesuite.pages;

import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectTimePeriod {
 WebDriver driver;
	 
	 @FindBy(css="#tree-tab-timeperiods > div")
		WebElement TimePeriodTab;
	 
	 @FindBy(id="reno-ALL.INCURRED")
	 	WebElement AllIncurred;
		
		
	public SelectTimePeriod(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	public void TimePeriod() throws Exception {
		TimePeriodTab.click();
		Thread.sleep(1000);
		Actions ac = new Actions(driver);
	//ac.doubleClick(AllIncurred).perform();
		
		
	/*String Dimension = sheet1.getRow(i).getCell(1).getStringCellValue();
    System.out.println(Dimension);
   wait.until(ExpectedConditions.elementToBeClickable(SearchBox));
   
    SearchBox.sendKeys(Dimension);
    SearchBtn.click();*/
    
			ac.moveToElement(AllIncurred).build().perform();
			Robot robot = new Robot();
			Point dimpoint = AllIncurred.getLocation();
			int dimsourceX = dimpoint.getX() + 50;
			int dimsourceY = dimpoint.getY() + 121;
			System.out.println("cod" + dimsourceX + "," + dimsourceY);
			Thread.sleep(1000);
			robot.mouseMove(dimsourceX, dimsourceY);
			Thread.sleep(2000);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			Thread.sleep(2000);
			robot.mouseMove(430, 535);
			Thread.sleep(2000);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			Thread.sleep(2000);
			
	}
}
