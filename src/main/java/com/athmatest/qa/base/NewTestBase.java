package com.athmatest.qa.base;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.athmatest.qa.pages.HomePage;
import com.athmatest.qa.pages.LoginPage;
import com.athmatest.qa.utils.CommonUtils;

public class NewTestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	LoginPage lp; 
	HomePage hp;
	
	
	public NewTestBase() throws IOException {
		try {
			prop = new Properties();
			
			FileInputStream proFile = new FileInputStream("C:\\Users\\339154\\eclipse-workspace\\NewFrameworkStart\\src\\main\\java\\com\\athmatest\\qa\\config\\config.properties");
			prop.load(proFile);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
			
	}
	@BeforeClass
	public  void intialization() 
	{		
		
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
					}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(CommonUtils.common_Wait, TimeUnit.MILLISECONDS);
	
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.manage().deleteAllCookies();
		driver.close();
		
	}
	
	@BeforeMethod
	public void loginToTheApplication() throws IOException, InterruptedException {
		//intialization();
		lp = new LoginPage();
		String loginPageTitle = lp.loginPageTitleTest();
		//assertEquals(loginPageTitle, "Welcome to Athma!","Page title not matched");
		
		String userId = prop.getProperty("userName");
		String userPass = prop.getProperty("passWord");
		//System.out.println(("Before method "+userId+" "+userPass));
		//lp = new LoginPage();
		lp.enterUserName(userId, userPass);
        //commonSleep();
		hp = new HomePage();
		String homePageTitle = hp.getHomePageTitle();
		//assertEquals(homePageTitle, "Dashboard","Home Page title not matched");
		
	}
	
	@AfterMethod
	public void logOutFromTheApplication() throws IOException, InterruptedException {
		System.out.println("Loging Out from the application");
		hp = new HomePage();		
		hp.logOutFromApplication();
		//driver.manage().deleteAllCookies();
		String loginPageTitle = lp.loginPageTitleTest();
		//assertEquals(loginPageTitle, "Welcome to Athma!","Page title not matched");
		
		
	}
	
	
	
	
	public static void testcloseBrowser() {
		driver.close();
	}
	
	public  static void commonWait(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, CommonUtils.common_Wait);
		wait.until(ExpectedConditions.visibilityOf(ele));
		}
	
	public  static void commonclickablewait(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, CommonUtils.common_Wait);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		}
	
	 public static void commonActions(WebElement ele) {	
		 commonWait(ele);
		 Actions act = new Actions(driver);
		 act.moveToElement(ele).click().build().perform();
		
		 
		 
	 }
	 
	 public static void commonSleep() throws InterruptedException {
		 Thread.sleep(3000);
	 }
	 public static void shortSleep() throws InterruptedException {
		 Thread.sleep(2000);
	 }
	
}
	
	