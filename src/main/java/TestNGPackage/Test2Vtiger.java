package TestNGPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test2Vtiger {

	/*SoftAssert s=new SoftAssert();
	@Test
	
	
	public void vtiger() {
		// TODO Auto-generated method stub

		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.vtiger.com/vtigercrm/");
		String actualTitle = driver.getTitle();
		
		
		
		String expectedTitle = "vtigerpune";
		
		//Softassert
		
		s.assertEquals(actualTitle, expectedTitle);
		
		System.out.println(actualTitle);
		System.out.println("Good Mornig");
		//used to fail the testScript in SoftAssert
		s.assertAll();
		

		
		//Hardassert
		
//		Assert.assertEquals(actualTitle,expectedTitle );
//		System.out.println(actualTitle);
		
		
		
	}*/
	
	
	@Test
	public void vtigercrm() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		WebElement LogInBtn = driver.findElement(By.id("submitButton"));
		//Assert.assertTrue(LogInBtn.isEnabled());
	//	Assert.assertTrue(LogInBtn.isSelected());
		
	//Assert.assertFalse(LogInBtn.isSelected());
		Assert.assertFalse(LogInBtn.isDisplayed());
	Assert.assertFalse(LogInBtn.isEnabled());
		System.out.println("Good Noon");
	}

}
