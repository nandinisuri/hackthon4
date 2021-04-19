package com.qa.Pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
	 protected WebDriver driver;
	    public JavascriptExecutor jse;
	    public Select select;
	    public Actions actions;

	    public PageBase(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    protected static void clickOnElement(WebElement element) {
	        element.click();
	    }

	    protected static void setTxtElement(WebElement element, String text) {
	        element.sendKeys(text);
	    }

	    protected static void clearTxtElement(WebElement element){
	        element.clear();
	    }

	    protected static void openPage(WebElement pageLink) {
	        pageLink.click();
	    }

	    public void scrollTo(String scroll) {
	        jse = (JavascriptExecutor) driver;
	        jse.executeScript("scrollBy(0," + scroll + ")");
	     
	       
	    		}
	    	
	    
	

}
