package com.qa.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {
   
    @FindBy(id = "input-firstname")
    WebElement firstNameTxtBox;
    @FindBy(id = "input-lastname")
    WebElement lastNameTxtBox;
    @FindBy(id = "input-email")
    WebElement emailTxtBox;
    @FindBy(id = "input-telephone")
    WebElement TelephoneTxtBox;
    @FindBy(id = "input-password")
    WebElement passwordTxtBox;
    @FindBy(id = "input-confirm")
    WebElement confirmPasswordTxtBox;
    @FindBy(xpath = "//input[@value='0']")
    WebElement newsletterRdoBtn;
    @FindBy(xpath = "//input[@name='agree']")
    WebElement privacypolicy;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement ContinueBtn;

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void userRegistration(String firstName, String lastName,
                                 String email,String telephone, String password, String confirmPassword) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        clickOnElement(newsletterRdoBtn);
        setTxtElement(firstNameTxtBox, firstName);
        setTxtElement(lastNameTxtBox, lastName);
        setTxtElement(emailTxtBox, email);       
        setTxtElement(TelephoneTxtBox,telephone);
        setTxtElement(passwordTxtBox, password);
        setTxtElement(confirmPasswordTxtBox, confirmPassword);
        clickOnElement(newsletterRdoBtn);
        clickOnElement(privacypolicy);

        clickOnElement(ContinueBtn);
    }


}
