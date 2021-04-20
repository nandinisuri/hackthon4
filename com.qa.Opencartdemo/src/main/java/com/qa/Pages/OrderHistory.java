package com.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistory extends PageBase{
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	WebElement MyAccount;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement orderhistory;
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")
	WebElement Continue;
	public OrderHistory(WebDriver driver) throws IOException {
		super(driver);
		// TODO Auto-generated constructor stub
	}
public void Order_History() {
	MyAccount.click();
	orderhistory.click();
	Continue.click();
}

}
