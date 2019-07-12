package com.truven.advantagesuite.pages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PackageSelectionNSaveDesc {

WebDriver driver;
	
	//Locators
	@FindBy(xpath="//*[@id='inputSearch']")
	WebElement SearchBox;
	
	@FindBy(xpath="//*[@id=\"search\"]/div/div/div[2]/button")
	WebElement SearchBtn;
	
	@FindBy(xpath="//*[text()='View details']")
	WebElement ViewDetails;
	
	@FindBy(id="viewContent")
	WebElement Description;
	
	@FindBy(id="viewdetails_close")
	WebElement closeBtn;
	
	@FindBy(css="#PackageSelectionPick")
	WebElement PackageSelector;
	
	@FindBy(id="packageButton")
	WebElement OkBtn;
	
	@FindBy(xpath="//*[@id=\"file\"]/div[1]/span")
	WebElement FileBtn;
	
	@FindBy(xpath="//*[text()='Change Package']")
	WebElement ChangePackage;
	
	
	public PackageSelectionNSaveDesc(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public void searchboxinput() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		File src=new File("C:\\ec\\workspace\\ddlex.xlsx");
	     FileInputStream finput = new FileInputStream(src);
	     @SuppressWarnings("resource")
		XSSFWorkbook wb =new XSSFWorkbook(finput);
	     XSSFSheet sheet1 = wb.getSheetAt(0);
	     String PackageName = sheet1.getRow(1).getCell(0).getStringCellValue();
	     
	     Select rcpackage = new Select(PackageSelector);
			rcpackage.selectByValue(PackageName);
			OkBtn.click();
			int x=sheet1.getLastRowNum();
			System.out.println(x);
			//Thread.sleep(45000);
		for(int i=1;i<x;i++) {
			
	     String MeasureOrSubset = sheet1.getRow(i).getCell(1).getStringCellValue();
	     String FileName = sheet1.getRow(i).getCell(2).getStringCellValue();
	     System.out.println(MeasureOrSubset);
	    wait.until(ExpectedConditions.elementToBeClickable(SearchBox));
	    
	     SearchBox.sendKeys(MeasureOrSubset);
	     SearchBtn.click();
	     
	     
	     Actions action = new Actions(driver);
			action.contextClick(driver.findElement(By.xpath("//*[text()='"+MeasureOrSubset+"']"))).perform();
			ViewDetails.click();
			Thread.sleep(3000);
			String textfile = Description.getText();
			System.out.println(textfile);
			String TestFile = "C:\\ec\\workspace\\desc\\post\\"+PackageName+"_"+FileName+".txt";
			File FC = new File(TestFile);
			FC.createNewFile();
			FileWriter FW = new FileWriter(TestFile);
			BufferedWriter BW = new BufferedWriter(FW); 
			BW.write(textfile);
			BW.close();
			closeBtn.click();
			SearchBox.clear();
		     String iPackageName = sheet1.getRow(i+1).getCell(0).getStringCellValue(); 	

			if(PackageName!=iPackageName)
			{
				PackageName = iPackageName;
				FileBtn.click();
			     ChangePackage.click();
			     Select ircpackage = new Select(PackageSelector);
					ircpackage.selectByValue(iPackageName);
					OkBtn.click();
					//Thread.sleep(45000);
			}
			
	}
		
		
		
}
}
