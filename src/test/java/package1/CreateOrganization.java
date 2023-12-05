package package1;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import commonutils.ExcelUtils;
import commonutils.JavaUtils;
//import commonutils.FileUtils;
import commonutils.PropertyFileUtils;
import commonutils.WebDriverUtils;

public class CreateOrganization {

	@Test 
	public void organization()throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		 final WebDriver driver;
		 
		 
		 PropertyFileUtils futils=new PropertyFileUtils();
		 
		 WebDriverUtils wutils=new WebDriverUtils();
		 
		 ExcelUtils eutils=new ExcelUtils();
		 
		  JavaUtils jutils= new JavaUtils();
		  
		 //To Read data From Property File
		 String BROWSER= futils.getDataFromPropertyFile("browser");
		 String URL= futils.getDataFromPropertyFile("url");
		 String USERNAME= futils.getDataFromPropertyFile("username");
		 String PASSWORD= futils.getDataFromPropertyFile("password");
		
	     //To Read data from excel file
		   String OrgName= eutils.getDataFromExcelFile("sheet1", 1, 0);
		   String Group= eutils.getDataFromExcelFile("sheet1", 1, 1);
		   String Industry=eutils.getDataFromExcelFile("sheet1", 1, 2);
		  
		
		 

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
         wutils.implycitlywait(driver);
         
         //To launch the url
         driver.get(URL);
         
         //to login the application
         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
 		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
 	   	 driver.findElement(By.id("submitButton")).click();
 	   	
 	   	 //to click on organization
   	   	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
   	   	
   	   	//to click on orgnization +image
         driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        
 	    //To pass the orgnization Name
		driver.findElement(By.name("accountname")).sendKeys(OrgName+jutils.getRandomNumber());
		
		//To click on radio button
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		Thread.sleep(2000);
		
		//handle drop down using SearchbyVisibletext
		WebElement dropdown=driver.findElement(By.name("assigned_group_id"));
		wutils.handledropdown(dropdown, Group);
		
		//Handle Dropdown by using searchbyindex
		wutils.handledropdown(dropdown, 2);
		
		WebElement industrydropdown=driver.findElement(By.name("industry"));
		wutils.handledropdown(industrydropdown,Industry);
	  
		
		WebElement box1=driver.findElement(By.name("notify_owner"));
		wutils.action(driver, box1);
		
		
		
		WebElement box2=driver.findElement(By.name("emailoptout"));
		wutils.action(driver, box2);
	        
		//Save button
		 driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		 
		 Thread.sleep(4000);
		 //Click/mousehover on Admin Image
		 WebElement hover=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 wutils.action2(driver, hover);
		 
		 Thread.sleep(4000);
		 //to click on signOut button
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
 		}

}
