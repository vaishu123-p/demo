package TestNGPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TestDepndm {
	
	@Test
	public void login() {
		
		System.out.println("LogIn Page");
		Assert.assertEquals("pune", "deccan");
	}
	
	@Test(dependsOnMethods="login")
	public void home() {
		System.out.println("Home Page");
		
	}
	
	@Test(dependsOnMethods="login")
	public void logOut() {
		System.out.println("LogOut Page");
		
	}

}
