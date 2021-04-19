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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.CaptureScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.Browser.LoadDriver;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.TestUtil.ExcelReader;

public class ApplicationTest {

		static WebDriver driver;
		static HomePage home;
		static LoginPage login;
		//static CheckoutPage checkout;
		int addresscount=1;
		int qtycount=1;
		private ExcelReader reader;
		private ExcelReader qtyreader;
		static ExtentHtmlReporter report=new ExtentHtmlReporter("\"user.dir\")+\"/test-output4//Application.html");9u8
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
		
		@Test(priority=2)	
		
		@SuppressWarnings("deprecation")
           public void logout(){
			
			  WebDriverWait logout=new WebDriverWait(driver, 5000);
			  logout.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout"))).click();
			  
			  AssertJUnit.assertEquals("Logout Failed",driver.getTitle(), "Account Logout");
}}
