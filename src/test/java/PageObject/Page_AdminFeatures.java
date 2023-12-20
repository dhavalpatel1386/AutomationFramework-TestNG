package PageObject;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class Page_AdminFeatures extends AbstractComponent<WebDriver>{
	public WebDriver driver;
	public Page_AdminFeatures(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[4]")
	WebElement clkAdminTab;
	
	@FindBy(xpath="//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
	WebElement txtUsername;
	
	@FindBy(xpath="(//div[contains(text(),'-- Select --')])[1]")
	WebElement txtUserRole;
	
	@FindBy(xpath="//div[@class='oxd-select-text-input'][normalize-space()='Admin']")
	WebElement selectOption;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement txtSearchEmployee;
	
	@FindBy(xpath="(//div[contains(text(),'-- Select --')])[1]")
	WebElement selectStatus;
	
	@FindBy(xpath="((//i)[13]")
	WebElement selectOption1;
	
	//----
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
	WebElement btnAdd;
	
	@FindBy(xpath="//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")
	WebElement drpUserRole;
	
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement txtEmployeeName;
	

	@FindBy(xpath="//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")
	WebElement drpStatus;
	
	@FindBy(xpath="//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	WebElement txtUserName;
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement btnSave; 
	
	
	
	
	
	public void fillAddUserDetail(String uname,String pass,String confPass) throws InterruptedException, FindFailed
	{
		Thread.sleep(4000);
		System.out.println("Method Invoke");
	//	clkAdminTab.click();
		Screen sikuliScreen = new Screen();
		Pattern imagePattern = new Pattern("C:\\Users\\azure\\eclipse-workspace\\AutomationFramework\\Image\\Test.jpg");
		 sikuliScreen.click(imagePattern);
			
		 Thread.sleep(2000); 
		 btnAdd.click();
		 drpUserRole.click(); 
		 
	//	 Select drpRole=new Select();
		 txtEmployeeName.sendKeys("Peter Mac Anderson");
		 drpStatus.click();
		 txtUserName.sendKeys(uname);
		 txtPassword.sendKeys(pass); 
		 txtConfirmPassword.sendKeys(confPass);
		 btnSave.click();
			 
	}
	

}
