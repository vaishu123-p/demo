package commonutils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtils {

	

		
		public void maximize(WebDriver driver) {
			 driver.manage().window().maximize();
			
		}
	
		public void minimize(WebDriver driver) {
			 driver.manage().window().minimize();
			
		}

		
		public void implycitlywait(WebDriver driver) {
			
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	         
		}
		
		public void handledropdown(WebElement elementname,String Data) {
			Select s=new Select(elementname);
			s.selectByVisibleText(Data);
			
		}

		public void handledropdown(WebElement dropdown, int i) {
			
			Select s=new Select(dropdown);
			s.selectByIndex(i);
		}
		
		public void action(WebDriver driver,WebElement elementname) {
			
			Actions a=new Actions(driver);
			a.click(elementname);
			a.perform();
			
		}
		
       public void action2(WebDriver driver,WebElement elementname) {
			
			Actions a=new Actions(driver);
			a.moveToElement(elementname);
			a.perform();
			
		}
       
       public void scrolling(WebDriver driver) {
    	   JavascriptExecutor jse=(JavascriptExecutor) driver;
 	      jse.executeScript("window.scrollBy(0,900)");
       }
       
       public void Screenshot(WebDriver driver) throws IOException {
    	   TakesScreenshot ts=(TakesScreenshot) driver; //Downcasting
			 File tempfile=ts.getScreenshotAs(OutputType.FILE);
			 
	      File destinationfile=new File("./TakeScreenShot/contPOM.jpg");
	      FileUtils.copyFile(tempfile, destinationfile);
    
       }
       
       
       public void switchtoWindow(WebDriver driver,String childurl) {
       Set<String> ids=driver.getWindowHandles();
       System.out.println(ids);
       
       for(String allid:ids) {
       	String allurl=driver.switchTo().window(allid).getCurrentUrl();
       	System.out.println(allurl);
       	
       	
       	if(allurl.contains(childurl)) {
       		break;
       	}
       }
       }
}
