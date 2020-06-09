package zidPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage  extends BaseTest{
	
	@FindBy (xpath ="//button[@class='leadinModal-close']")
	WebElement AlertClose;
	
	@FindBy (xpath="//a[contains(text(),'E')]")
	WebElement EnglishMode;
	
	@FindBy (xpath="//a[contains(text(),'تسجيل')]")
	WebElement RegesterationLink;
	
	@FindBy (id="name")
	WebElement FullName ;
	
	@FindBy (id="mobile")
	WebElement Phone;
	
	@FindBy (id="registration_email")
	WebElement Email;
	
	@FindBy (id="registration_password")
	WebElement Password;
	
	@FindBy (xpath="//button[@class='btn next-tab-btn']")
	WebElement Next;
	
	
	@FindBy (id="store_username")
	WebElement ArabicStoreName;
	
	@FindBy (id="store_name")
	WebElement EnStoreName;
	
	
	@FindBy (id="store_category_id")
	WebElement StoreCategory;
	
	@FindBy (id="started_business_before_registration_yes")
	WebElement RadioBtnYes;
	
	@FindBy (xpath="//button[contains(text(),'سجل الآن')]")
	WebElement Registerbtn;
	
	@FindBy (xpath="//a[contains(text(),'إدارة الاشتراك')]")
	WebElement Check;
	
	
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void AlertHandle() {
		AlertClose.click();
		Actions act =new Actions (driver);
		act.moveToElement(EnglishMode).click().perform();
	}
	
	public String Registeration(String fName, String phone, String mail
			,String pass, String AStoreName ,String EStoreName ) {
		
		RegesterationLink.click();
		FullName.clear();
		FullName.sendKeys(fName);
		Phone.clear();
		Phone.sendKeys(phone);
		Email.clear();
		Email.sendKeys(mail);
		Password.clear();
		Password.sendKeys(pass);
		
		Next.click();
		ArabicStoreName.clear();
		ArabicStoreName.sendKeys(AStoreName);
		EnStoreName.clear();
		EnStoreName.sendKeys(EStoreName);
		Select sel =new Select(StoreCategory);
		sel.selectByVisibleText("كتب");
		RadioBtnYes.click();
		Registerbtn.click();
		System.out.println(driver.getTitle());
		return driver.getTitle();
	    
	}
	
	
	
	
	

}
