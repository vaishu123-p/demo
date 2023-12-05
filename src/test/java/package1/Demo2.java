package package1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		
		//To read data from external trsources
		FileInputStream fis=new FileInputStream("src\\test\\resources\\maven.properties");
		
		//to read data from property file
		Properties p=new Properties();
		
		//to read the location of property
		p.load(fis);
		
		//to read key from property file
		String URL=p.getProperty("url");
		driver.get(URL);
		 
		// driver.findElement(By.name("user_name")).click();
		
        String USERNAME = p.getProperty("usrnm");
        String PASSWORD = p.getProperty("usrpass");
        
       
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();

	}

}
