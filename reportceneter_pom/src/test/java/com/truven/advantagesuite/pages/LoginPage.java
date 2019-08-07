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
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	String username;
	String pwd;
	File src;
	FileInputStream finput;
	
	
	
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
		loginexcelparameters1(siam, "ContentTesting", 1, 0, 2, 0);
	}
    public void invalidpwdlogin(boolean siam) throws Exception{
		loginexcelparameters2(siam, "SanityTest", 4, 0, 2, 0);
		
	}
	public void invaliduseridlogin(boolean siam) throws Exception{
		loginexcelparameters2(siam, "SanityTest", 4, 0, 5, 0);
	}
	public void invaliduseridandpwdlogin(boolean siam) throws Exception{
	    loginexcelparameters2(siam, "SanityTest", 7, 0, 8, 0);
	}
	public void validuseridandpwdlogin1(boolean siam) throws Exception{
	    loginexcelparameters2(siam, "SanityTest", 10, 0, 11, 0);
	}
	public void validuseridandpwdlogin2(boolean siam) throws Exception{
	    loginexcelparameters2(siam, "SanityTest", 12, 0, 13, 0);
	}
	
	
	
	public void loginexcelparameters1(boolean siam,String sheets,int row1,int column1,int row2,int column2) throws Exception{
		
		src=new File("D:\\Selenium\\ddlex.xlsx");
	    finput = new FileInputStream(src);
	    wb =new XSSFWorkbook(finput);
	    sheet1 = wb.getSheet(sheets);//0
	    username = sheet1.getRow(row1).getCell(column1).getStringCellValue();//1,0
	    pwd = sheet1.getRow(row2).getCell(column2).getStringCellValue();//2,0
		wb.close();
		  if(siam){
			txtUserNameSiam.sendKeys(username);
			txtPasswordSiam.sendKeys(pwd);
			btnOKSiam.click();
		  }
		  else{
			txtUserName.sendKeys(username);
			txtPassword.sendKeys(pwd);
			btnOK.click();		
		  }
	}
	
	public void loginexcelparameters2(boolean siam,String sheets,int row1,int column1,int row2,int column2) throws Exception{
    	 
    	src=new File("D:\\Selenium\\ddlex.xlsx");
	    finput = new FileInputStream(src);
	    wb =new XSSFWorkbook(finput);
	    sheet1 = wb.getSheet(sheets);
    	String username = sheet1.getRow(row1).getCell(column1).getStringCellValue();
	    System.out.println(username);
	    String pwd = sheet1.getRow(row2).getCell(column2).getStringCellValue();
	    System.out.println(pwd);
		wb.close();
		  if(siam){
			txtUserNameSiam.sendKeys(username);
			txtPasswordSiam.sendKeys(pwd);
			btnOKSiam.click();
		  }
		  else{
			txtUserName.sendKeys(username);
			txtPassword.sendKeys(pwd);
			btnOK.click();		
		  }
	}
}