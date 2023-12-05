package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {
	
	@FindBy(name="accountname")
	private WebElement orgnizationname;
	
	public WebElement getorgnizationname() {
		return orgnizationname;
	}

	
	@FindBy(xpath="//input[@type='radio'][2]")
	private WebElement assignbtn;
	
	public WebElement getassignbtn() {
		return assignbtn;
	}
	
	@FindBy(name="assigned_group_id")
	private WebElement assigntodropdown;
	
	public WebElement getassigntodropdown() {
		return assigntodropdown;
	}
	
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement savebtn;
	
	public WebElement getsavebtn() {
		return savebtn;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement imgbtn;
	
	public WebElement getimgbtn() {
		return imgbtn;
	}
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutbtn;
	
	public WebElement getsignoutbtn() {
		return signoutbtn;
	}
	
	
	
	
	
	public OrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
