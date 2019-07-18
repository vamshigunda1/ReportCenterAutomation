package com.truven.advantagesuite.pages;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchDimension  {
	
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='inputSearch']")
	WebElement SearchBox;
	
	@FindBy(xpath="//*[@id=\"search\"]/div/div/div[2]/button")
	WebElement SearchBtn;

	public SearchDimension(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}

	public void DimensionDragNDrop() throws  Exception{
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		File src=new File("C:\\EclipseWorkspace\\ReportCenterAutomation\\reportceneter_pom\\ddlex.xlsx");
	     FileInputStream finput = new FileInputStream(src);
		XSSFWorkbook wb =new XSSFWorkbook(finput);
	     XSSFSheet sheet1 = wb.getSheetAt(3);
			//int x=sheet1.getLastRowNum();
		for(int i=0;i<1;i++) {
				String Dimension = sheet1.getRow(i).getCell(1).getStringCellValue();
			     System.out.println(Dimension);
			    wait.until(ExpectedConditions.elementToBeClickable(SearchBox));
			    
			     SearchBox.sendKeys(Dimension);
			     SearchBtn.click();
			     
						WebElement dimsourceLocator = driver.findElement(By.xpath("//*[text()='"+ Dimension +"']"));
						Actions ac = new Actions(driver);
						ac.moveToElement(dimsourceLocator).build().perform();
						Robot robot = new Robot();
						Point dimpoint = dimsourceLocator.getLocation();
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
						SearchBox.clear();
						wb.close();
				wb.close();
				} 
		driver.findElement(By.id("runbutton")).click();

        
}

}
