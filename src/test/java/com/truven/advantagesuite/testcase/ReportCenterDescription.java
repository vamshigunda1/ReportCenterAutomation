package com.truven.advantagesuite.testcase;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.truven.advantagesuite.pages.AHRW;
import com.truven.advantagesuite.pages.LoginPage;
import com.truven.advantagesuite.pages.PackageSelectionNSaveDesc;

public class ReportCenterDescription {
	WebDriver driver;
	@BeforeTest
    public void setup () {
        driver = new ChromeDriver();	
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
        driver.manage().window().maximize();
        driver.get("https://ahrwqa-libra.truvenhealth.com/");
        		//"http://trvlapp2063/cognos/cgi-bin/cognos.cgi");
    }
  @Test
  public void SaveAndCompareDesc() throws IOException, InterruptedException {
	  LoginPage lpage = new LoginPage(driver);
	  lpage.login("qauser40", "QA0505qa");
	  AHRW reportwriter = new AHRW(driver);
	  reportwriter.openAdhocRW();
	  PackageSelectionNSaveDesc savedesc = new PackageSelectionNSaveDesc(driver);
	  savedesc.searchboxinput();
  }
  @AfterTest
  public void teardown () {
      driver.quit();
}
}
