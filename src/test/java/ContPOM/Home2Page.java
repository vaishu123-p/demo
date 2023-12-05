package ContPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home2Page {


	public WebDriver driver;

	@FindBy(xpath="(//a[text()='Contacts'])[1]")
	private WebElement Contactlink;
	
	public WebElement getContactlink() {
		return Contactlink;
		
	}
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement image;
	
	public WebElement getimage() {
		return image;
		
	}
	
	public Home2Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
