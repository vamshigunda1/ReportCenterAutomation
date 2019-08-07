package com.truven.advantagesuite.sanitytestcases;

import org.testng.annotations.Test;

import com.truven.advantagesuite.utils.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.truven.advantagesuite.pages.LoginPage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class RC_Login {
  WebDriver driver;
  String baseurl="https://ahrwqa-orion.truvenhealth.com";
  ExtentReports extent;
  ExtentTest logger;
  ExtentReports report;
  public static String log=null;
  
	
  @BeforeSuite
  public void setup() {
	  report=new ExtentReports(System.getProperty("user.dir") + "/Reports/Automation_Report.html");
      }
  
  @BeforeMethod
      public void startbrowser(){
	  System.setProperty("webdriver.chrome.driver","D:\\Selenium\\Drivers\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
      driver.manage().window().maximize();
	}
  //Verify the login scenario with invalid credentials
 
  @Test
      public void TestCase1_invalidpwd() throws Exception {
	  //valid userID and invalid password
	  logger = report.startTest("TestCase1_invalidpwd");
	  driver.get(baseurl);
	  LoginPage lgn=new LoginPage(driver);
      lgn.invalidpwdlogin(true);
      log="valid userID and invalid password";
      
  }
  @Test
      public void TestCase1_invaliduID() throws Exception {
	  //valid userID and invalid password
	  logger = report.startTest("TestCase1_invaliduID");
	  driver.get(baseurl);
	  LoginPage lgn=new LoginPage(driver);
	  lgn.invaliduseridlogin(true);
	  log="valid userID and invalid password";
  }  
  @Test
      public void TestCase1_invaliduIDandpwd() throws Exception {
      //invalid userID and invalid password
	  logger = report.startTest("TestCase1_invaliduIDandpwd");
	  driver.get(baseurl);
	  LoginPage lgn=new LoginPage(driver);
	  lgn.invaliduseridandpwdlogin(true); 	
	  log="invalid userID and invalid password";
  }
  @Test
      public void TestCase2_validuIDandpwd1() throws Exception {
      //valid userID and valid password1
	  logger = report.startTest("TestCase2_validuIDandpwd1");
	  driver.get(baseurl);
	  LoginPage lgn=new LoginPage(driver);
	  lgn.validuseridandpwdlogin1(true); 
	  log="valid userID and valid password 1";
  }
  @Test
  public void TestCase2_validuIDandpwd2() throws Exception {
      //valid userID and valid password2
	  logger = report.startTest("TestCase2_validuIDandpwd2");
	  driver.get(baseurl);
	  LoginPage lgn=new LoginPage(driver);
	  lgn.validuseridandpwdlogin2(true); 
	  log="valid userID and valid password 2 ";
  }

  
  
  
  
  
  
  
  
  @AfterMethod
  public  void tearDown1(ITestResult result) throws IOException
  {
  	if(result.getStatus()==ITestResult.SUCCESS)
  	{
  		String screenshot_path=Utility.captureScreenshot(driver,result.getName());
  	    String image= logger.addScreenCapture(screenshot_path+".png");
  	    System.out.println("Screenshot" + image);
  	    logger.log(LogStatus.PASS, "Test Case" + log + "- <b>PASSED</b>",image);
  	    		}
  	else if(result.getStatus()==ITestResult.FAILURE)
  	{
  		String screenshot_path=Utility.captureScreenshot(driver,result.getName());
  		System.out.println("Screenshot" + screenshot_path);		    
  		String image= logger.addScreenCapture(screenshot_path+".png");
  		System.out.println("Screenshot" + image);
  	    logger.log(LogStatus.FAIL, "Test Case" + log +" - <font><b>FAILED</b></font>",image);
  	}
  	else if(result.getStatus() == ITestResult.SKIP)
  	{
  		logger.log(LogStatus.SKIP, "Test Case verified " +" - <b>SKIPPED</b>");
  	}
  report.endTest(logger);
  report.flush();
  }

  @AfterTest
	  public void close(){
	  driver.quit();
    }
 }
  

