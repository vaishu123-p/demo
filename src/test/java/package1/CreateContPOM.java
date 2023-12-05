package package1;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ContPOM.Cont2Page;
import ContPOM.Home2Page;
import ContPOM.Login2Page;
import commonutils.ExcelUtils;
//import commonutils.FileUtils;
import commonutils.PropertyFileUtils;
import commonutils.WebDriverUtils;

public class CreateContPOM {
	
	@Test

	public void Contact() throws IOException, InterruptedException {
		
		 final WebDriver driver;
			
		 PropertyFileUtils futils=new PropertyFileUtils();
		 
		 WebDriverUtils wutils=new WebDriverUtils();
		 
		 ExcelUtils eutils=new ExcelUtils();
		 
		 //To Read data From Property File
		 String BROWSER= futils.getDataFromPropertyFile("browser");
		 String URL= futils.getDataFromPropertyFile("url");
		 String USERNAME= futils.getDataFromPropertyFile("username");
		 String PASSWORD= futils.getDataFromPropertyFile("password");
		 
		 
		 //To Read data from Exel file
		 String FirstName= eutils.getDataFromExcelFile("sheet1", 1, 3);
	     String LastName= eutils.getDataFromExcelFile("sheet1", 1, 4);
		 String TeamSelling= eutils.getDataFromExcelFile("sheet1", 2, 1);
		 String OrgName= eutils.getDataFromExcelFile("sheet1", 1, 0);
		 String ParentUrl=eutils.getDataFromExcelFile("sheet1", 1, 5);
		 String ChildUrl=eutils.getDataFromExcelFile("sheet1",4 , 5);
		 
		 if(BROWSER.equalsIgnoreCase("Chrome"))
	     {
	    	 driver=new ChromeDriver();

	     }
	     else if(BROWSER.equalsIgnoreCase("Edge")) {
	    	 driver=new EdgeDriver();

	     }
	     else {
	    	 driver=new FirefoxDriver();
	    	 
	    	 

	     }
	     
		 //To maximize the window
		 wutils.maximize(driver);
		 
		 //To apply implicit wait
	     wutils.implycitlywait(driver);
	     
	     //To launch url
	     driver.get(URL);
	     
	     //Login to Application
	     Login2Page lp1=new Login2Page(driver);
	     lp1.getUsernametf().sendKeys(USERNAME);
	     lp1.getPasswordtf().sendKeys(PASSWORD);
	     lp1.getLoginbtn().click();
		 
	     //Click on Contact
	     Home2Page hp=new Home2Page(driver);
	     //Click on Contact Imagae
	     hp.getContactlink().click();
	     hp.getimage().click();
	     
	     
	     Cont2Page cp=new Cont2Page(driver);
	     cp.getFirstName().sendKeys(FirstName);
	     
	     cp.getLastName().sendKeys(LastName);
	     cp.getimgcontbtn().click();
	     
	    driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
	      
	    //To TRansfer control from parent to child
	    wutils.switchtoWindow(driver,ChildUrl);
	    
	    
	     //    driver.findElement(By.id("search_txt")).sendKeys("vwx");
	        cp.getContactSearchTf().sendKeys(OrgName);
	        
	    //  driver.findElement(By.name("search")).click();
	        
	        cp.getContactSearchBtn().click();
	        
	    //   driver.findElement(By.xpath("//a[text()='vwx2']")).click();
	        
	        cp.getContactText().click();
	     
	        //To TRansfer control from  child to parent
	        wutils.switchtoWindow(driver, ParentUrl);
	    
	     /*   for(String allids:ids) {
	        	String allurl=driver.switchTo().window(allids).getCurrentUrl();
	        	System.out.println(allurl);
	        	String ParentUrl="http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
	        
	        	if(allurl.contains(ParentUrl)) {
	        		break;
	        	}
	        }*/
	        	
	      //to take screenshot of webpage
         wutils.Screenshot(driver);
         Thread.sleep(2000);
         
         //used for scrolling page
	     wutils.scrolling(driver);
			
//	      driver.findElement(By.name("imagename")).click();
//	      Thread.sleep(2000);
//	      Runtime.getRuntime().exec("C:\\Users\\admin\\Desktop\\HTML.exe");
		    
	     
	     //to click on save button
	        driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
			 
	        //Admin Image
			 WebElement hover=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 
			 //MouseHovering on admin Image
			 wutils.action2(driver, hover);
			 
			 //For SignOut Button
			 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}

