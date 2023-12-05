package package1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		d.get("http://localhost:8888/index.php?action=index&module=Home");
		d.findElement(By.name("user_name")).sendKeys("admin");
		d.findElement(By.name("user_password")).sendKeys("admin");
		d.findElement(By.id("submitButton")).click();
		
        d.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
        d.findElement(By.xpath("//img[@title='Create Organization...']")).click();
  //      d.findElement(By.name("assigntype")).click();
        d.findElement(By.name("accountname")).sendKeys("CDE");
        d.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
       // d.findElement(By.className("crmbutton small save")).click();
        
        d.findElement(By.xpath("//a[text()='Contacts']")).click();
        d.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
        d.findElement(By.name("lastname")).sendKeys("puppalu");
        d.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        d.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
        
        
        }

}
