package commonutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class POMLogIn {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		FileInputStream fis=new FileInputStream("src\\test\\resources\\vtigerData.properties");
		 
		 Properties p=new Properties();

         p.load(fis);
		 
		 String BROWSER = p.getProperty("browser");
		 String URL=p.getProperty("url");
		 String USERNAME=p.getProperty("username");
		 String PASSWORD=p.getProperty("password");
	}

}
