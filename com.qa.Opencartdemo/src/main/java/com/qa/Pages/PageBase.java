package com.qa.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
	 WebDriver driver;
	    public JavascriptExecutor jse;
	    public Select select;
	    public Actions actions;
	    public static Properties config = new Properties();
		FileInputStream fig_config,fig_org;
		public static Properties org = new Properties();
	    

	    public PageBase(WebDriver driver) throws IOException {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    		fig_config = new FileInputStream("./resource/config.properties");
	    		config.load(fig_config);
	    		fig_org =new FileInputStream("./resource/org.properties");
	    		org.load(fig_org);
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
	        public void Click(WebDriver driver,String xpath) {
				
				try {
					driver.findElement(By.xpath(xpath)).click();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			public void Sendkeys(WebDriver driver,String xpath,String value) {
				
				try {
					driver.findElement(By.xpath(xpath)).sendKeys(value);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		}
	    	
	    
	

}
