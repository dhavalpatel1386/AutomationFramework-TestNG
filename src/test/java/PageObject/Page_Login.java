package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class Page_Login extends AbstractComponent<WebDriver>{
	
	/*
	 * public WebDriver ldriver; public Page_Login(WebDriver rdriver) {
	 * ldriver=rdriver; PageFactory.initElements(rdriver, this); }
	 */
	public WebDriver driver;
	public Page_Login(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//input[@name='username']")
	WebElement txtUserName;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement txtPassword;
	
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnLogin;
	
	@FindBy(xpath="//*[@id=\'app\']/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")
	WebElement drpProfile;
	
	@FindBy(xpath="//*[@id=\'app\']/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")
	WebElement optLogout;
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	WebElement txtInvalidCredential;
	
	@FindBy(xpath="//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
	WebElement txtRequired;
	
	@FindBy(xpath="//h5[text()='Login']")
	WebElement txtLogin;
	
	@FindBy(xpath="//p[text()='Forgot your password? ']")
	WebElement lnkLForgotPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//span[text()='Required']")
	WebElement txtFPRequired;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement btnCancel;
	
	
	public void ValidLogin() throws InterruptedException
	{
		txtUserName.sendKeys("Admin");
		txtPassword.sendKeys("admin123");
		Thread.sleep(2000);
		btnLogin.click();	
	}
	public void InvalidPassword() throws InterruptedException
	{
		txtUserName.sendKeys("Admin");
		txtPassword.sendKeys("Admin");
		Thread.sleep(2000);
		btnLogin.click();	
	}
	public void testLogout() throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println("SecondMethod");
		drpProfile.click();
		optLogout.click();
		Thread.sleep(2000);
		String verifyText=txtLogin.getText();
		Assert.assertEquals(verifyText,"Login");
	}
	public void verifyInvalidPassword() throws InterruptedException
	{
		Thread.sleep(2000);
		String txtPass=txtInvalidCredential.getText();
		Assert.assertEquals(txtPass,"Invalid credentials");
	}
	public void verifyFieldValidationMessage() throws InterruptedException
	{
		Thread.sleep(2000);
		btnLogin.click();	
		Thread.sleep(1000);
		String valText=txtRequired.getText();
		Assert.assertEquals(valText,"Required");	
	}
	public void verifyForgotPasswordReqValidation() throws InterruptedException
	{
		lnkLForgotPassword.click();
	//	ldriver.switchTo().activeElement();
		Thread.sleep(2000);
		btnSubmit.click();
		String valText=txtFPRequired.getText();
		System.out.println("Required:"+valText);
		btnCancel.click();
	}
	
	
}
