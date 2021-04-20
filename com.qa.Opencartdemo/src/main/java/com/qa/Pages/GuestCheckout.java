package com.qa.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.Browser.LoadDriver;

public class GuestCheckout{
	
	static WebDriver driver;
    public JavascriptExecutor jse;
	
	static ExtentHtmlReporter report=new ExtentHtmlReporter("\"user.dir\")+\"/test-output4//Application.html");
	static ExtentReports extent=new ExtentReports();
	static ExtentTest logger;
	static HomePage home;
	static PageBase base;
	 CheckoutPage checkoutPage;
	    String fname = "Anamika";
	    String lname = "mahika";
	    String email = "user5@test.com";
	    String country = "Egypt";
	    String city = "Cairo";
	    String address = "Cairo";
	    String zip = "12345";
	    String phone = "010000000";
	public GuestCheckout() {
		super();
	}
	


	@BeforeClass
	public static void launchBrowser() throws IOException{    	
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
	public void launchBrowserTest() throws IOException {
		if(driver == null)
			logger.log(Status.FAIL, "Launch Browser Failure");
		else
			logger.log(Status.PASS, "Launch Browser Success");
		extent.flush();		
	
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
		  home.viewitemCart();
		  home.clickCheckouts();
		  home.clickGuestRdbtn();
		  home.clickGuestCtnue();
		  checkoutPage = new CheckoutPage(driver);
	        try {
				checkoutPage.checkoutAsGuestUser(fname, lname, email,country,city,address,zip,phone);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        Assert.assertTrue(checkoutPage.checkoutCompletedMessage
	                .getText().contains("Your order has been successfully processed!"));
	    }
	}


