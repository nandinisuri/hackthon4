package com.qa.opencartdemo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.Browser.LoadDriver;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.Pages.PageBase;
import com.qa.Pages.UserRegistrationPage;

public class UserRegistrationTest extends LoadDriver {
     WebDriver driver;
    HomePage home;
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;
    
    	

    @BeforeClass
	public  void launchBrowser(){    	
		 driver = LoadDriver.loadBrowser("chrome", "http://demo.opencart.com/");	
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @DataProvider(name = "userRegistrationData")
    public static Object[][] userRegistrationData() {
        return new Object[][]
                {{"nandini", "suri", "nandini.suri24@gmail.com","9494220178", "Mahika@124","Mahika@124"},
                        {"suri", "nandini", "nandini.suri24@gmail.com","9494220178","Mahika@124","Mahika@124"}};
    }
		 @Test(priority = 0, alwaysRun = true, dataProvider = "userRegistrationData")
	 public void UserCanRegisterSuccessfully(String firstName, String lastName, String email,String Telephone, String password,String confirmPassword) throws IOException {
       WebElement MyAccount=driver.findElement(By.xpath("//span[text()='My Account']"));
    		MyAccount.click();
    	 WebElement Register=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
    	 Register.click();
	
	    userRegistrationPage = new UserRegistrationPage(driver);
        loginPage = new LoginPage(driver); 
        
        userRegistrationPage.userRegistration(firstName, lastName,
                email, password,confirmPassword, confirmPassword);
       	
	

}}
