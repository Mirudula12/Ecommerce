package com.example;
     

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
public class SearchTest {      
        private WebDriver driver;   
        @BeforeTest
        public void beforeTest() { 
        	WebDriverManager.firefoxdriver().setup();
        	driver=new FirefoxDriver();
      
        	driver.get("https://www.flipkart.com/");
        }       
      
        @Test
  	  public void test3() throws InterruptedException {

		Dimension dimension2 = new Dimension(2256, 1504);
		driver.manage().window().setSize(dimension2);
		Thread.sleep(5000);
        }
   

		@AfterTest
		public void quitbrowser() {
			driver.quit();
		}

}