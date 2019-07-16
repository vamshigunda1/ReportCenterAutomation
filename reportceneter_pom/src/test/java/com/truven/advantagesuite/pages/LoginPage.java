package com.truven.advantagesuite.pages;

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
	
	public void login(String username, String pwd,boolean siam){
		
		
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
