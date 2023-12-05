package package1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver =new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		
	    TakesScreenshot ts=(TakesScreenshot) driver; //Downcasting
		
		 //to call getScreenshotAs and store ss in the form of file
		 File tempfile=ts.getScreenshotAs(OutputType.FILE);
		 
      File destinationfile=new File("./TakeScreenShot/actitime.jpg");
		 
		 //to move ss from tempfile to destinationfile
		// tempfile.renameTo(destinationfile);
		 
		 
		 //create folder automatically & move ss from tempfile to destfile
	    FileUtils.copyFile(tempfile, destinationfile);
		

	}

}
