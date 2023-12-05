package package1;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import POM.HomePage;
import POM.LoginPage;
import POM.OrgPage;
import commonutils.ExcelUtils;
//import commonutils.FileUtils;
import commonutils.PropertyFileUtils;
import commonutils.WebDriverUtils;

public class createOrgPOM {
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	 final WebDriver driver;
	
	 PropertyFileUtils futils=new PropertyFileUtils();
	 
	 WebDriverUtils wutils=new WebDriverUtils();
	 
	 ExcelUtils eutils=new ExcelUtils();
	 
	 //To Read data From Property File
	 String BROWSER= futils.getDataFromPropertyFile("browser");
	 String URL= futils.getDataFromPropertyFile("url");
	 String USERNAME= futils.getDataFromPropertyFile("username");
	 String PASSWORD= futils.getDataFromPropertyFile("password");
	 
	 String OrgName= eutils.getDataFromExcelFile("sheet1", 1, 0);
	 
	 
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
     
	 driver.get(URL);
     wutils.maximize(driver);
     wutils.implycitlywait(driver);
     
    
     
     LoginPage lp1=new LoginPage(driver);
     lp1.getUsernametf().sendKeys(USERNAME);
     lp1.getPasswordtf().sendKeys(PASSWORD);
     lp1.getLoginbtn().click();
	 
     
     HomePage hp=new HomePage(driver);
     hp.getOrganizationlink().click();
     hp.getimage().click();
     
     OrgPage org=new OrgPage(driver);
     org.getorgnizationname().sendKeys(OrgName);
     org.getassignbtn().click();
     wutils.handledropdown(org.getassigntodropdown(), 2);
     org.getsavebtn().click();
     
     
		

}
}
