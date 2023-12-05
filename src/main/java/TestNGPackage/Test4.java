package TestNGPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test4 {

	@Test
	public void home() {
		System.out.println("Home Page");
	}
	
	@Test
	public void home1() {
		System.out.println("Home1 Page");
	}
	
	@BeforeMethod
	public void bM(){
		System.out.println("LogIn");
	}
	
	@AfterMethod
	public void aM() {
		System.out.println("LogOut");
	}
	
	@BeforeClass
	public void bClass() {
		System.out.println("Launch the browser");
	}
	
	@AfterClass
	public void aClass() {
		System.out.println("Close the browser");
	}
	
	@BeforeSuite
	public void bSuite() {
		System.out.println("Connect To DB");
		
	}

	@AfterSuite
	public void aSuite() {
		System.out.println("DisConnect To DB");
	}
}
