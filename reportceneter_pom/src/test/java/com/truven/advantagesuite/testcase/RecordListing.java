package com.truven.advantagesuite.testcase;

import org.testng.annotations.Test;

import com.truven.advantagesuite.pages.AHRW;
import com.truven.advantagesuite.pages.LoginPage;
import com.truven.advantagesuite.pages.PackageSelection;
import com.truven.advantagesuite.pages.RunNSaveReport;
import com.truven.advantagesuite.pages.SearchMeasureOrSubset;
import com.truven.advantagesuite.pages.SelectRecordListing;
import com.truven.advantagesuite.pages.SelectTimePeriod;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
public class RecordListing {
	WebDriver driver;
	@BeforeTest
    public void setup () {
        driver = new ChromeDriver();	
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
        driver.get("http://trvlapp2063/cognos/cgi-bin/cognos.cgi");
        //https://ahrwqa-orion.truvenhealth.com/
        //"http://trvlapp2063/cognos/cgi-bin/cognos.cgi");
        //https://ahrwqa-libra.truvenhealth.com/
    }
  @Test
  public void RecordListingRep() throws IOException, InterruptedException, Exception {
	  LoginPage lpage = new LoginPage(driver);
	  lpage.login(false);
	  AHRW reportwriter = new AHRW(driver);
	  reportwriter.openAdhocRW();
	  PackageSelection selector = new PackageSelection(driver);
	  selector.PackageSelector("Adv zero six five new demo data build Package");
	  		//"Zero Two Two One New Commercial Demo build Package");
	  SelectRecordListing rl = new SelectRecordListing(driver);
	  rl.SelRecordListing();
	  SearchMeasureOrSubset rcs = new SearchMeasureOrSubset(driver);
	  rcs.SearchMeasure("Admissions");
	  rcs.SearchSubset("Admissions");
	  SelectTimePeriod tp = new SelectTimePeriod(driver);
	  tp.RecListTimePeriod();
	  RunNSaveReport rs = new RunNSaveReport(driver);
	  rs.runRecList();
	  rs.saveReport();
  }
  @AfterTest
  public void teardown () {
     //driver.quit();
}
}
