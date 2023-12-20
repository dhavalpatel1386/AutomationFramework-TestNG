package TestCases;

import org.testng.annotations.Test;
import Base.BaseClass;

public class Test_Login extends BaseClass {

	@Test(priority = 1, enabled=true)
	public void testSuccessfulLoginandLogout() throws InterruptedException {
		page_Login.ValidLogin();
		logger.info("Login success");
		Thread.sleep(2000);
		page_Login.testLogout();
	}
	
	@Test(priority = 2,enabled=true)
	public void testInvalidLogin() throws InterruptedException {
		page_Login.InvalidPassword();
		page_Login.verifyInvalidPassword();
	}

	@Test(priority = 3,enabled=true)
	public void testRequiredFieldValidation() throws InterruptedException {
		page_Login.verifyFieldValidationMessage();
	}
	
	@Test(priority = 4,enabled=true)
	public void testForgotPassReqFieldValidation() throws InterruptedException {
		page_Login.verifyForgotPasswordReqValidation();
	}

}
