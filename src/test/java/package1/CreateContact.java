package package1;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

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

import commonutils.ExcelUtils;
//import commonutils.FileUtils;
import commonutils.PropertyFileUtils;
import commonutils.WebDriverUtils;

public class CreateContact {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		final WebDriver driver;
		 
		 
		 PropertyFileUtils futils=new PropertyFileUtils();
		 
		 WebDriverUtils wutils=new WebDriverUtils();
		 
		 ExcelUtils eutils=new ExcelUtils();
		 
		 //To Read data From Property File
		 String BROWSER= futils.getDataFromPropertyFile("browser");
		 String URL= futils.getDataFromPropertyFile("url");
		 String USERNAME= futils.getDataFromPropertyFile("username");
		 String PASSWORD= futils.getDataFromPropertyFile("password");
		 
		 String FirstName= eutils.getDataFromExcelFile("sheet1", 1, 3);
	     String LastName= eutils.getDataFromExcelFile("sheet1", 1, 4);
		 String TeamSelling= eutils.getDataFromExcelFile("sheet1", 2, 1);

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
         
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         
         driver.get(URL);
         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
 		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
 	   	 driver.findElement(By.id("submitButton")).click();
 	   	 
 	     driver.findElement(By.xpath("//a[text()='Contacts']")).click();
 	     driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
      
         driver.findElement(By.name("firstname")).sendKeys(FirstName);  
         driver.findElement(By.name("lastname")).sendKeys(LastName);  
        
         Set<String> ids=driver.getWindowHandles();
	        
	        for(String allid:ids) {
	        	String allurl=driver.switchTo().window(allid).getCurrentUrl();
	        }  
        
	        //To Click on group radio button
     
	   	driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		Thread.sleep(2000);
		//to handle dropdown webelement
		WebElement dropdown=driver.findElement(By.name("assigned_group_id"));
		
		//handle dropdown by visible text
		wutils.handledropdown(dropdown,TeamSelling );
        
		//click on + image in organization name
        driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		 
        //
		 WebElement hover=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 wutils.action2(driver, hover);
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
