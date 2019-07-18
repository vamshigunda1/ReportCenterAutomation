package com.truven.advantagesuite.testcase;

import org.testng.annotations.Test;

import com.truven.advantagesuite.pages.AHRW;
import com.truven.advantagesuite.pages.LoginPage;
import com.truven.advantagesuite.pages.PackageSelection;
import com.truven.advantagesuite.pages.RunNSaveReport;
import com.truven.advantagesuite.pages.SearchMeasureOrSubset;
import com.truven.advantagesuite.pages.SelectTimePeriod;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
public class CrossTabReport {
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
  public void CrossTabRep() throws IOException, InterruptedException, Exception {
	  LoginPage lpage = new LoginPage(driver);
	  lpage.login(false);
	  AHRW reportwriter = new AHRW(driver);
	  reportwriter.openAdhocRW();
	  PackageSelection selector = new PackageSelection(driver);
	  selector.PackageSelector("Adv zero six five new demo data build Package");
	  		//"Zero Two Two One New Commercial Demo build Package");
	  SearchMeasureOrSubset rcs = new SearchMeasureOrSubset(driver);
	  rcs.SearchMeasureorSubset("Patients BMI Assessment Adult Num {QM}");
	  rcs.SearchMeasureorSubset("Patients BMI Assessment Adult Den {QM}");
	  rcs.SearchMeasureorSubset("Body Mass Index Adult Rate {QM}");
	  rcs.SearchMeasureorSubset("Body Mass Index Assessment Adult {QS}");
	  SelectTimePeriod tp = new SelectTimePeriod(driver);
	  tp.TimePeriod();
	  RunNSaveReport rs = new RunNSaveReport(driver);
	  rs.runReport();
	  rs.saveReport();
  }
  @AfterTest
  public void teardown () {
     //driver.quit();
}
}
