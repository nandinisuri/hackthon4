package com.qa.opencartdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.Browser.LoadDriver;
import com.qa.Pages.CheckoutPage;
//import com.qa.Pages.CheckoutPage;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.Pages.WishListPage;

public class ApplicationTest {

		static WebDriver driver;
	    public JavascriptExecutor jse;
        static WishListPage Wishlist;
		static HomePage home;
		static LoginPage login;
		static CheckoutPage checkout;
		int addresscount=1;
		int qtycount=1;
	
		static ExtentHtmlReporter report=new ExtentHtmlReporter("\"user.dir\")+\"/test-output4//Application.html");
		static ExtentReports extent=new ExtentReports();
		static ExtentTest logger;
		

		@BeforeClass
		public static void launchBrowser(){    	
			 driver = LoadDriver.loadBrowser("chrome", "http://demo.opencart.com/");	
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 home = new HomePage(driver);
			// checkout = new CheckoutPage(driver);
			 extent.attachReporter(report);
		}
		
		@BeforeMethod
		public void setup(Method method) {
	    	logger=extent.createTest(method.getName());
		}
		
		@AfterMethod
		public void checkStatus(ITestResult result) {
			
				if(result.getStatus()== ITestResult.FAILURE) {
					TakesScreenshot ts = (TakesScreenshot)driver;
			 		File src = ts.getScreenshotAs(OutputType.FILE);
				
			 		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
			 		File destination = new File(path);
				
			 		try {
			 			FileUtils.copyFile(src, destination);
			 			return;
			 		}catch(IOException e) {
			 			e.printStackTrace();
			 			return;
			 		}
				}
			extent.flush();
		}
		
		@Test(priority = 0)
		public void launchBrowserTest() {
			if(driver == null)
				logger.log(Status.FAIL, "Launch Browser Failure");
			else
				logger.log(Status.PASS, "Launch Browser Success");
			extent.flush();		
		}

		@Test(priority=1)
		public void login() throws IOException{
			home.clickMyaccount();
			home.clickLogin();
			
			 login = new LoginPage(driver);

			      login.clickLogin();
			
			String title=driver.getTitle();
			
			if(title.equals("My Account")) // verify title to check if user is successfully logged in or not.
				logger.log(Status.PASS, "Login Successfull");
			else
				logger.log(Status.FAIL, "Login Failure");
		}
		
		@SuppressWarnings("deprecation")
		@Test(priority = 2)
		public void browseProduct() {
			home.clickDesktop();
			logger.log(Status.INFO, "Selects Desktop");		
			
			home.clickMAC();
			logger.log(Status.INFO, "Selects Mac");		
			
			home.selectProduct("iMac");			
			logger.log(Status.INFO, "Success Product 'iMac' Selected");
			
			home.Add_to_cart();
			
			//..product availablity..//
			home.Avbl_Information();
			
			
			TakesScreenshot ts = (TakesScreenshot)driver;
	 		File src = ts.getScreenshotAs(OutputType.FILE);
	 		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
	 		File destination = new File(path);
	 		try {
	 			FileUtils.copyFile(src, destination);
	 			return;
	 		}catch(IOException e) {
	 			e.printStackTrace();
	 			return;
	 		}		

		}
		
		@Test(priority = 3)
		public void browseProduct2() throws Throwable {
		
			home.clickLaptopsandNotebooks();
			logger.log(Status.INFO, "Selects LaptopsandNotebooks");		
			
			home.clickShowLaptopsandNotebooks();
			logger.log(Status.INFO, "Selects ShowLaptopsandNotebooks");	
			home.clickHP_LP3065();
			logger.log(Status.INFO, "Selects clickHP_LP3065");	
			
			 jse = (JavascriptExecutor) driver;
		     jse.executeScript("scrollBy(0," +450 + ")");
		        
		     home.setTxtDatebox();
			logger.log(Status.INFO, "Picks Deliever date");	
            
			 home.addProductToCart();
		    logger.log(Status.INFO, "addProductToCart");	

			 home.CheckOutProduct();
			logger.log(Status.INFO, "CheckOutProduct");	

			  
			 home.clickShoppingcart();
			logger.log(Status.INFO, "clickShoppingcart");	

			

             home.clickRemove();
  			logger.log(Status.INFO, "clickRemove");	

			  home.clickContinue();
		   logger.log(Status.INFO, "Selects clickcontinue");	


			 /* home.clickCheckouts();
			  home.clickGuestRdbtn();
			  home.clickGuestCtnue();*/
			
			TakesScreenshot ts = (TakesScreenshot)driver;
	 		File src = ts.getScreenshotAs(OutputType.FILE);
	 		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
	 		File destination = new File(path);
	 		try {
	 			FileUtils.copyFile(src, destination);
	 			return;
	 		}catch(IOException e) {
	 			e.printStackTrace();
	 			return;
	 		}}
		

		@Test(priority = 4)
		public void browseProduct1() throws Throwable {
		
			home.clickLaptopsandNotebooks();
			logger.log(Status.INFO, "Selects LaptopsandNotebooks");		
			
			home.clickShowLaptopsandNotebooks();
			logger.log(Status.INFO, "Selects ShowLaptopsandNotebooks");	
			home.clickHP_LP3065();
			logger.log(Status.INFO, "Selects clickHP_LP3065");	
			
			 jse = (JavascriptExecutor) driver;
		     jse.executeScript("scrollBy(0," +450 + ")");
		        
		    home.setTxtDatebox();
			logger.log(Status.INFO, "Picks Deliever date");	
			home.setTxtQty();
			logger.log(Status.INFO, "Picks Qty");	
			home.addProductToCart();
			//...E-shipping../
			//home.E_shipping();
			home.clickShoppingcart();
			
			//..coupon code...//
		   WebElement testDropDown = driver.findElement(By.xpath("//a[text()='Use Coupon Code ']"));  
			  testDropDown.click();
			 home.setTxtcoupon();
		    logger.log(Status.INFO, "Selects setTxtcoupon");	
			  home.clickapplycoupon();
			  
			  //..order history...//
		  home.Order_History();
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		 		File destination = new File(path);
		 		try {
		 			FileUtils.copyFile(src, destination);
		 			return;
		 		}catch(IOException e) {
		 			e.printStackTrace();
		 			return;
		 		}}}
			
		
	/*
	 * @Test(priority=5)
	 * 
	 * @SuppressWarnings("deprecation") public void logout(){
	 * 
	 * WebDriverWait logout=new WebDriverWait(driver, 5000);
	 * logout.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(
	 * "Logout"))).click();
	 * 
	 * AssertJUnit.assertEquals("Logout Failed",driver.getTitle(),"Account Logout");
	 * } }
	 */

