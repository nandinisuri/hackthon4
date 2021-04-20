package com.qa.opencartdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo {
	
	
    WebDriver dr = null;
    JavascriptExecutor js = (JavascriptExecutor) dr;
    //js.executeScript("window.scrollBy(0,600)");
   
    @BeforeMethod


	public  void main() {
		// TODO Auto-generated method stub
    	
    	//WebDriver dr = null;
    	System.setProperty("webdriver.chrome.driver", "E:\\seleniumFiles\\Drivers\\chromedriver_win32\\chromedriver.exe");
        dr = new ChromeDriver();
        //JavascriptExecutor js = (JavascriptExecutor) dr;

 

        dr.get("https://demo.opencart.com/index.php?route=account/account");
        dr.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        dr.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        // js.executeScript("window.scrollBy(0,600)");
        dr.manage().window().maximize();

 

    }

 

    @Test
    public void select() {
        
        //JavascriptExecutor js = (JavascriptExecutor) dr;
        WebElement ele = dr.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/a")); // mouseover on the laptops
                                                                                            // and notebooks
        
        
        
        Actions action = new Actions(dr);
        action.moveToElement(ele).perform();

 

        dr.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a")).click(); // click on show all laptops&NB
        js.executeScript("window.scrollBy(0,600)");
        dr.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/h4/a")).click(); // Click on the
        // HP LP
js.executeScript("window.scrollBy(0,400)");



dr.findElement(By.xpath("//*[@id=\"product\"]/div[1]/div/span/button/i")).click(); // calender



dr.findElement(By.xpath("/html/body/div[4]/div/div[1]/table/tbody/tr[5]/td[6]")).click(); // future date



dr.findElement(By.id("button-cart")).click(); // Add to cart



dr.get("https://demo.opencart.com/index.php?route=checkout/checkout");

dr.findElement(By.name("email")).sendKeys("m.j.prathyusha12@gmail.com");
dr.findElement(By.name("password")).sendKeys("Mmurthy@2");
dr.findElement(By.id("button-login")).click();

}





@AfterMethod

public void EditExistingAccount ()

{ /*
* WebDriver dr=null; System.setProperty("webdriver.chrome.driver",
* "C:\\Users\\Apple\\Downloads\\chromedriver_win32\\chromedriver.exe"); dr=new
* ChromeDriver(); 
* 
*/

// JavascriptExecutor js = (JavascriptExecutor)dr;
dr.get("https://demo.opencart.com/index.php?route=account/edit");
dr.findElement(By.name("email")).sendKeys("m.j.prathyusha12@gmail.com");
dr.findElement(By.name("password")).sendKeys("Mmurthy@2");
dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).
click();
dr.findElement(By.name("lastname")).sendKeys("Mamidi");
dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click(
); //need to add screenshot syntx

js.executeScript("window.scrollBy(0,600)");
dr.findElement(By.className("list-group-item")).click();

//

	}

}
