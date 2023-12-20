package TestCases;

import java.util.HashMap;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import Base.BaseClass;
import PageObject.Page_AdminFeatures;

public class Test_AdminFunctionality extends BaseClass{
	
	
	@Test(enabled=true,dataProvider="dataSupplier")
	public void testCreateUser(HashMap<String,String> hMap) throws InterruptedException, FindFailed
	{
		page_Login.ValidLogin();
		page_AdminFeatures=new Page_AdminFeatures(driver);
		page_AdminFeatures.fillAddUserDetail(hMap.get("UserName"),hMap.get("Password"),hMap.get("ConfirmPassword"));
	}

}
