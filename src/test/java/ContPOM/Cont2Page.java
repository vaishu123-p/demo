package ContPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cont2Page {

	@FindBy(name="firstname")
	private WebElement FirstName;
	
	public WebElement getFirstName() {
		return FirstName;
	}
	
	
	@FindBy(name="lastname")
	private WebElement LastName;
	
	public WebElement getLastName() {
		return LastName;
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
	
	
	//for plusbutton of organizationname
	
		@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
		private WebElement imgcontbtn;
		
		public WebElement getimgcontbtn() {
			return imgcontbtn;
		}
	
        @FindBy(id="search_txt")
		private WebElement ContactSearchTf;
		
		public WebElement getContactSearchTf() {
			return ContactSearchTf;
		}
		
	    @FindBy(name="search")
			private WebElement ContactSearchBtn;
			
			public WebElement getContactSearchBtn() {
				return ContactSearchBtn;
			}
			
			
			 @FindBy(xpath="//a[text()='vwx3']")
			 private WebElement ContactText;
				
		     public WebElement getContactText() {
					return ContactText;
				}
			
			



	public Cont2Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
