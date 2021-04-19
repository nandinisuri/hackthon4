package com.qa.Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Browser.LoadDriver;

public class LoginPage {
	private WebDriver driver;

	@FindBy(id="input-email")
	WebElement username;

	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(css="#content > div > div:nth-child(2) > div > form > input")
	WebElement loginbtn;


	public LoginPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		 FileInputStream f= new FileInputStream("C:\\\\Users\\\\dell\\\\Desktop\\\\excellogin.xlsx");
			XSSFWorkbook wb =new XSSFWorkbook(f);
			XSSFSheet sh=wb.getSheet("Sheet1");
			
			int rc=sh.getLastRowNum();
			
			String row1=sh.getRow(0).getCell(0).getStringCellValue();
			String col2=sh.getRow(1).getCell(1).getStringCellValue();
			String row2=sh.getRow(1).getCell(0).getStringCellValue();
			
			System.out.println(rc+"   "+row1+"  "+ row2+   col2 );
			driver.findElement(By.id("input-email")).sendKeys(row2);
			
			driver.findElement(By.id("input-password")).sendKeys(col2);
	
	}
	public void clickLogin() {
		loginbtn.click();
	}
}