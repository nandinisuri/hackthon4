package com.qa.opencartdemo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.Pages.WishListPage;

public class WishlistTest {
	static WebDriver driver;
    public JavascriptExecutor jse;
    static WishListPage Wishlist;
	static LoginPage login;
	static HomePage home;

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
         WebDriverWait wait0=new WebDriverWait(driver, 05);
		 WebElement wishlist = wait0.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Wish List (0)']"))); 
		 wishlist. click();	
				   
	     WebDriverWait wait1=new WebDriverWait(driver, 05);
		 WebElement Components = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Components']"))); 
		  Components. click();
		  
		  WebDriverWait wait2=new WebDriverWait(driver, 05);
			 WebElement Monitors = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Monitors (2)']"))); 
			  Monitors. click();
			  
	      WebDriverWait wait3=new WebDriverWait(driver, 05);
		  WebElement Sortby = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-sort\"]"))); 
		  Select dropdown = new Select(Sortby);
		  dropdown.selectByVisibleText("Price (High > Low)");
		  Reporter.log("Sortby",true);

			        
		  driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[2]")).click();
		  Reporter.log("product",true);

			        // Wish list count
			       
		  driver.findElement(By.xpath("//*[@id=\"wishlist-total\"]/span")).click(); 
			 Reporter.log("wishlists",true);

		  driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/button")).click();
		 
		  driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/button")).click();
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

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
	 		
		  //driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
	}}}
	
	
		      
		      
		

