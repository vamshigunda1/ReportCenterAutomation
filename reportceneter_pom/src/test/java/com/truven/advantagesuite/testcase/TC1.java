package com.truven.advantagesuite.testcase;

import org.testng.annotations.Test;

import com.truven.advantagesuite.pages.AHRW;
import com.truven.advantagesuite.pages.LoginPage;
import com.truven.advantagesuite.pages.PackageSelection;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
public class TC1 {
	WebDriver driver;
	@BeforeTest
    public void setup () {
        driver = new ChromeDriver();	
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
        driver.manage().window().maximize();
        driver.get("http://trvlapp2063/cognos/cgi-bin/cognos.cgi");
        		//"http://trvlapp2063/cognos/cgi-bin/cognos.cgi");
        //https://ahrwqa-libra.truvenhealth.com/
    }
  @Test
  public void SaveAndCompareDesc() throws IOException, InterruptedException, Exception {
	  LoginPage lpage = new LoginPage(driver);
	  lpage.login("qauser40", "QA0505qa",false);
	  AHRW reportwriter = new AHRW(driver);
	  reportwriter.openAdhocRW();
	  PackageSelection savedesc = new PackageSelection(driver);
	  savedesc.PackageSelector("Zero Two Two One New Commercial Demo build Package");
	  //savedesc.SearchMeasureorSubset("Postpartum Contraceptive Effec 60d Adult {MS}");
	 
	  
  }
  @AfterTest
  public void teardown () {
     //driver.quit();
}
}
