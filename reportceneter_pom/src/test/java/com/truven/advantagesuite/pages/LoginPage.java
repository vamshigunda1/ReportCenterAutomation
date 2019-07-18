package com.truven.advantagesuite.pages;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	WebDriver driver;
	
	//Locators
	@FindBy(id="CAMUsername")
	WebElement txtUserName;
	
	@FindBy(id="CAMPassword")
	WebElement txtPassword;
	
	@FindBy(id="cmdOK")
	WebElement btnOK;
	
	@FindBy(id="login_username")
	WebElement txtUserNameSiam;
	
	@FindBy(id="login_password")
	WebElement txtPasswordSiam;
	
	@FindBy(id="login-submit")
	WebElement btnOKSiam;
	
	//Page Methods/Actions
	
	public LoginPage(WebDriver driver){
		this.driver = driver;

	       

        PageFactory.initElements(driver, this);
	}
	
	public void login(boolean siam) throws Exception{
		File src=new File("C:\\EclipseWorkspace\\ReportCenterAutomation\\reportceneter_pom\\ddlex.xlsx");
	     FileInputStream finput = new FileInputStream(src);
		XSSFWorkbook wb =new XSSFWorkbook(finput);
	     XSSFSheet sheet1 = wb.getSheetAt(0);
	     String username = sheet1.getRow(1).getCell(0).getStringCellValue();
	     String pwd = sheet1.getRow(2).getCell(0).getStringCellValue();
		wb.close();
		
		if(siam) {
			txtUserNameSiam.sendKeys(username);
			txtPasswordSiam.sendKeys(pwd);
			btnOKSiam.click();
		
		}
		else {
			txtUserName.sendKeys(username);
			txtPassword.sendKeys(pwd);
			btnOK.click();		
		}
	}
	

}
