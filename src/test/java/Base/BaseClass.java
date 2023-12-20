package Base;

import java.util.ResourceBundle;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import PageObject.Page_AdminFeatures;
import PageObject.Page_Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public ResourceBundle rb;
	public WebDriver driver;
	public Page_Login page_Login;
	public Page_AdminFeatures page_AdminFeatures;
	public Logger logger;
	public Utilities.MyXLSReader excelReader;	
	
	@BeforeClass
	public void setUp() throws InterruptedException
	{
		logger=Logger.getLogger("TestAutomation-Web");
		PropertyConfigurator.configure("Log4j.properties");
		

		/*
		 * ChromeOptions chromeOptions = new ChromeOptions();
		 * chromeOptions.addArguments("--headless"); // Run in headless mode
		 * chromeOptions.addArguments("--disable-gpu");
		 */  // Disable GPU acceleration (needed in headless mode)
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		logger.info("Browser Maximize");
		rb=ResourceBundle.getBundle("config");
		driver.get(rb.getString("url"));

		logger.info("Url Entered");
		Thread.sleep(2000);	
    	page_Login=new Page_Login(driver);
	}
	
	@AfterClass
	public void tearDown()
	{
		if (driver!= null) {
            driver.quit();
        }
	}
	
	
	@DataProvider
	public Object[][] dataSupplier() {
		
		Object[][] obj = null;
		
		try {
			
			excelReader = new Utilities.MyXLSReader("C:\\Users\\azure\\eclipse-workspace\\AutomationFramework\\TestData\\Test1.xlsx");
			obj = Utilities.DataUtils.getTestData(excelReader, "testCreateUser", "Data");
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return obj;
		
	}
}
