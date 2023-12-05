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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class reference {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
         final WebDriver driver;
		 
		 FileInputStream fis=new FileInputStream("src\\test\\resources\\vtigerData.properties");
		 
		 Properties p=new Properties();
		 p.load(fis);
		 
		 String BROWSER = p.getProperty("browser");
		 String URL=p.getProperty("url");
		 String USERNAME=p.getProperty("username");
		 String PASSWORD=p.getProperty("password");
		 
		 

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
 	   	
 	   	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        
 	    FileInputStream fisex= new FileInputStream("src\\test\\resources\\vtigerXl.xlsx");
 	    Workbook wb=WorkbookFactory.create(fisex);
		
		Sheet sh=wb.getSheet("Sheet1");
		
		Row rw=sh.getRow(0);
		
		Cell cl=rw.getCell(1);
		
		String data=cl.getStringCellValue();
		
		driver.findElement(By.name("accountname")).sendKeys(data);
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		Thread.sleep(2000);
	  //  driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
	        
			

	}

}
