package com.qa.opencartdemo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Browser.LoadDriver;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.Pages.UserRegistrationPage;

public class UserregistrationUnsuccess extends LoadDriver {
    WebDriver driver;
   HomePage homePage;
   UserRegistrationPage userRegistrationPage;
   LoginPage loginPage;

   @DataProvider(name = "userRegistrationData")
   public static Object[][] userRegistrationData() {
       return new Object[][]
               {{"nandini", "suri", "nandini.suri124@gmail.com", "9494220178"},
                       {"suri", "nandini", "nandini.suri124@gmail.com", "Mahika@124"}};
   }

   @Test(priority = 1, alwaysRun = true, dataProvider = "userRegistrationData")
   public void UserCanRegisterUnSuccessfully(String firstName, String lastName, String email,String Telephone, String password) throws IOException {
       homePage = new HomePage(driver);
       userRegistrationPage = new UserRegistrationPage(driver);
       loginPage = new LoginPage(driver); 

}}
