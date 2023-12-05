package ContPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login2Page {

	
	public WebDriver driver;

	@FindBy(name="user_name")
	private WebElement usernametf;
	
	
	@FindBy(name="user_password")
	private WebElement passwordtf;
	
	@FindBy(id="submitButton")
	private WebElement Loginbtn;
	
	public WebElement getUsernametf() {
		return usernametf;
	}

	public WebElement getPasswordtf() {
		return passwordtf;
	}

	public WebElement getLoginbtn() {
		return Loginbtn;
	}
	
	public Login2Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	}
