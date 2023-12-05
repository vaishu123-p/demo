package TestNGPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;




public class Test1 {

	@Test(priority=3)
	
	public void facebook() {
		WebDriver wb=new ChromeDriver();
		wb.get("https://www.facebook.com/");
	}
	
	@Test(invocationCount=2,priority=1)
	public void zomato() {
		WebDriver wb=new ChromeDriver();
		wb.get("https://www.zomato.com/india");
		
	}
	
	@Test(priority=2)
	public void instagram() {
		WebDriver wb=new ChromeDriver();
		wb.get("https://www.instagram.com/");
		
	}
}
