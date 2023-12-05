package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


	public WebDriver driver;

	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement Organizationlink;
	
	public WebElement getOrganizationlink() {
		return Organizationlink;
		
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement image;
	
	public WebElement getimage() {
		return image;
		
	}
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
