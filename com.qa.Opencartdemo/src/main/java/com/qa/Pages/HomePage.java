package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;
	

	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement myaccount;

	@FindBy(css="#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
	WebElement desktops;
	
	@FindBy(xpath="(//a[text()='Mac (1)'])[1]")
	WebElement Mac;
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[2]/a")
	WebElement LaptopsandNotebooks;
	
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a")
	WebElement ShowLaptopsandNotebooks;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/h4/a")
	WebElement HP_LP3065;
	
	@FindBy(xpath="//input[@name='option[225]']")
	WebElement Datebox;
	@FindBy(xpath="//input[@name='quantity']")
	WebElement Qty;

	@FindBy(xpath="//*[@id=\"button-cart\"]")
	WebElement add_to_cart;
	@FindBy(xpath="//span[text()='Shopping Cart']")
	WebElement Shoppingcart;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]/i")
	WebElement remove;
	@FindBy(xpath="//a[text()='Continue']")
	WebElement Continue;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[4]")
	WebElement cart;
	@FindBy(xpath="//span[@id='cart-total']")
	WebElement item_cart;
	@FindBy(id="input-coupon")
	WebElement couponcode;
	@FindBy(id="button-coupon")
	WebElement applycouponcode;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	WebElement MyAccount;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement orderhistory;
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")
	WebElement Continue1;
	@FindBy(xpath="//a[text()='Components']")
	WebElement components;
	@FindBy(xpath="//a[text()='Monitors (2)']")
	WebElement monitors;
	@FindBy(xpath="//a[text()='Apple Cinema 30\"']")
	WebElement applecinema;
	@FindBy(xpath="//*[@id=\"input-option223\"]/div[1]/label/input")
	WebElement checkbox;
	@FindBy(xpath="//*[@id=\"input-option208\"]")
	WebElement text;
	@FindBy(xpath="//*[@id=\"input-option217\"]")
	WebElement selectdrpdwn;
	@FindBy(xpath="//*[@id=\"input-option209\"]")
	WebElement textarea;
	@FindBy(xpath="//*[@id=\"button-upload222\"]")
	WebElement uploadfile;
	@FindBy(xpath="//*[@id=\"product\"]/div[7]/div/span/button/i")
	WebElement selectDate;
	@FindBy(xpath="//*[@id=\"product\"]/div[8]/div/span/button/i")
	WebElement selectTime;
	@FindBy(xpath="//*[@id=\"input-quantity\"]")
	WebElement Qty1;
	@FindBy(xpath="//*[@id=\"button-cart\"]")
	WebElement Addtocart;
	@FindBy(xpath="//*[@id=\"search\"]/input")
	WebElement SearchBox;
	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	WebElement SearchButton;
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]/span")
	WebElement AddtoCart;
	@FindBy(xpath="//*[@id=\"cart-total\"]")
	WebElement Cart;
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")
	WebElement CheckOut;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")
	WebElement QuntityBox;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[1]/i")
	WebElement Refresh;
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div[2]/a")
	WebElement CheckOutOption;
	 @FindBy(xpath="//*[@id=\"top-links\"]/ul/li[4]/a/span")
	 WebElement ShoppingCart;
	    @FindBy(xpath="//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")
	    WebElement E_SandT;
	    @FindBy(id="input-country")
	    WebElement SelectCountry;
	    @FindBy(id="input-zone")
	    WebElement SelectState;
	    @FindBy(xpath="//*[@id=\"input-postcode\"]")
	    WebElement PostCode;
	    @FindBy(xpath="//*[@id=\"button-quote\"]")
	    WebElement Quote;
	    @FindBy(xpath="//*[@id=\"modal-shipping\"]/div/div/div[2]/div/label/input")
	    WebElement SelectFlat;
	    @FindBy(xpath="//*[@id=\"button-shipping\"]")
	    WebElement ApplyShipping;
	
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")
	WebElement checkout;
	@FindBy(xpath="//input[@value='guest']")
	WebElement Guestcheckout;
	@FindBy(id="button-account")
	WebElement GuestContinue;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickMyaccount() {
		myaccount.click();
	}
	public void clickLogin() {
		loginbtn.click();
	}
	public void clickDesktop() {
		desktops.click();
	}
	public void clickMAC() {
		Mac.click();
	}
	public void clickLaptopsandNotebooks() {
		 LaptopsandNotebooks.click();
	}
	public void clickShowLaptopsandNotebooks() {
		ShowLaptopsandNotebooks.click();
	}
	
	public void clickHP_LP3065() {
		HP_LP3065.click();
		
	}
	public void clickShoppingcart() {
		Shoppingcart.click();
	}
	public void clickRemove() {
		remove.click();
	}
	public void clickContinue() {
		Continue.click();
	}
	public void selectProduct(String productname) {
		driver.findElement(By.partialLinkText(productname)).click();
		//HP_LP3065.click();
	}
	public void setTxtDatebox() {
		Datebox.sendKeys("2021-04-25");
	}
	public void setTxtQty() {
		Datebox.sendKeys("1");
	}
	public void setTxtcoupon() {
		couponcode.sendKeys("003");
	}
	public void clickapplycoupon() {
		applycouponcode.click();
	}
	public void Order_History() {
		MyAccount.click();
		orderhistory.click();
		Continue1.click();
	}
	public void addProductToCart() {
		add_to_cart.click();
	}
	public void Add_to_cart() {
		 
		 Actions action = new Actions(driver);
		 
		  action.moveToElement(components).build().perform();
		  action.click();
		  monitors.click();
		  applecinema.click();
		}
	public void Avbl_Information() {
		
		checkbox.click();
		text.sendKeys("test");
		Select DROPDOWN = new Select(selectdrpdwn);
		DROPDOWN.selectByVisibleText("Blue (+$3.00)");
		textarea.sendKeys("for testing" );
		selectDate.sendKeys("09252013");
		uploadfile.sendKeys("C:\\Users\\dell\\Desktop\\download.png");

        //Press tab to shift focus to time field
		
		selectTime.sendKeys("0245PM");
		Qty.sendKeys("2");
		Addtocart.click();
	}
	public void CheckOutProduct() {
		SearchBox.sendKeys("iphone");
		SearchButton.click();
		AddtoCart.click();
		Cart.click();
		CheckOut.click();
		QuntityBox.sendKeys("2");
		Refresh.click();
		CheckOutOption.click();

		
	}
	public void E_shipping() {
        ShoppingCart.click();
        E_SandT.click();
        Select COUNTRY = new Select(SelectCountry);
        COUNTRY.selectByVisibleText("India");
        Select STATE = new Select(SelectState);
        STATE.selectByVisibleText("Andhra Pradesh");
        PostCode.sendKeys("516002");
        Quote.click();
        SelectFlat.click();
        ApplyShipping.click();
	}
	
	public void viewitemCart() {
		item_cart.click();
	}
	public void viewCart() {
		cart.click();
	}
	public void clickCheckouts() {
		checkout.click();
	}
	public void clickGuestRdbtn() {
		Guestcheckout.click();
	}
	public void clickGuestCtnue() {
		GuestContinue.click();
	}
	
	public void enterQty(String qty){
		driver.findElement(By.id("input-quantity")).clear();
		driver.findElement(By.id("input-quantity")).sendKeys(qty);
	}
	public String getQtyErrorMessage(){
		String error = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).getText();
		error = error.substring(0, error.length()-2);
		return error;
	}
	


}
