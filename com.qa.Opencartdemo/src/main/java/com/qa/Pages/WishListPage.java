package com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WishListPage {
	
	WebDriver driver;

	
	@FindBy(xpath="//span[text()='Wish List (0)']")
	WebElement Wishlist;

	@FindBy(how = How.LINK_TEXT, using = "Components")
	 WebElement components;
	@FindBy(xpath="//a[text()='Monitors (2)']")
	WebElement Monitors;
	@FindBy(id="input-sort")
	WebElement Sortby;
	
	public WishListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void clickWishlist() {
		Wishlist.click();
	}
	
	public void clickcomponents() {
		components.click();
	}
	public void clickmonitors() {
		Monitors.click();}
	public void hoversort() {
			Select dropdown = new Select(Sortby);
	        dropdown.selectByVisibleText("Price (High > Low)");

			
	}
	
	
}
