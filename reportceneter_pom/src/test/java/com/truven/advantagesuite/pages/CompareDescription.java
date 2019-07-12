package com.truven.advantagesuite.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CompareDescription {

	WebDriver driver;
	public CompareDescription(WebDriver driver){
		this.driver = driver;

	       

        PageFactory.initElements(driver, this);
	}
	@SuppressWarnings("unused")
	public void comparedesc() throws IOException {
		 for(int i=1;i<13;i++) {
		    	//String s="";
		    	 File src=new File("C:\\ec\\workspace\\ddlex.xlsx");
			     FileInputStream finput = new FileInputStream(src);
			     @SuppressWarnings("resource")
				XSSFWorkbook wb =new XSSFWorkbook(finput);
			     XSSFSheet sheet1 = wb.getSheetAt(0); 
			  //Array[] a = new Array[i];   
		     String s = sheet1.getRow(i).getCell(1).getStringCellValue();
     BufferedReader reader1 = new BufferedReader(new FileReader("C:\\ec\\workspace\\desc\\post\\"+s+".txt"));
      
     BufferedReader reader2 = new BufferedReader(new FileReader("C:\\ec\\workspace\\desc\\prior\\"+s+".txt"));
      
     String line1 = reader1.readLine();
      
     String line2 = reader2.readLine();
      
     boolean areEqual = true;
      
     int lineNum = 1;
      
     while (line1 != null || line2 != null)
     {
         if(line1 == null || line2 == null)
         {
             areEqual = false;
              
             break;
         }
         else if(! line1.equalsIgnoreCase(line2))
         {
             areEqual = false;
              
             break;
         }
          
         line1 = reader1.readLine();
          
         line2 = reader2.readLine();
          
         lineNum++;
     }
      
     if(areEqual)
     {
         //System.out.println(s+"have same content.");
     }
     else
     {
         //System.out.println("Two files have different content. They differ at line "+lineNum);
          System.out.println(s +"has differences");
        // System.out.println("File1 has "+line1+" and File2 has "+line2+" at line "+lineNum);
     }
      
     reader1.close();
      
     reader2.close();
 }
		
	}
}
