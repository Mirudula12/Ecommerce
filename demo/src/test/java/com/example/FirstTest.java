package com.example;


import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import io.github.bonigarcia.wdm.WebDriverManager;


public class FirstTest {
	
	WebDriver driver;
	@BeforeTest
	public void config() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		
	}
	

	@Test
	  public void test1() throws InterruptedException {
		
		
		driver.manage().window().maximize();
		long start=System.currentTimeMillis();
		driver.get("https://www.flipkart.com/");
		long stop=System.currentTimeMillis();
		long total=stop-start;
		System.out.println("Total time to load : " + total);
		
		
		long expected=3000;
		if(total < expected) {
			System.out.println("Loaded in time");
		}
		else {
			System.out.println("Not loaded in time");
		}
		
		
	   driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	   Thread.sleep(4000);
	   String execScript1 = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll down till the bottom of the page
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Boolean test1 = (Boolean) (js.executeScript(execScript1));
		if (test1 == true) {
			System.out.print("\nNavigates to bottom of page");
		} else if (test1 == false){
			System.out.print("\nDoes not Navigates to bottom of page");
		}
		 Thread.sleep(4000);
	   
	   driver.findElement(By.name("q")).sendKeys("iPhone 13");
	   Thread.sleep(4000);
	   driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")).click();
	   
	  // driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[1]/div[1]/div/div/img")).click();
	   Thread.sleep(9000);
	 
	   
	   String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
		JavascriptExecutor scrollBarPresent = (JavascriptExecutor)driver;
		Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript));
		if (test == true) {
			System.out.print("\nScroll feature is present.");
		} else if (test == false){
			System.out.print("\nScroll feature is not present.");
		}
		Thread.sleep(9000);
		
	}
	@Test
	  public void test2() throws InterruptedException {
		Dimension dimension = new Dimension(720, 1080);
		driver.manage().window().setSize(dimension);
		
		Thread.sleep(3000);
		Dimension dimension1 = new Dimension(1280, 800);
		driver.manage().window().setSize(dimension1);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int contentHeight = ((Number) js.executeScript("return window.innerHeight")).intValue();
		int contentWidth = ((Number) js.executeScript("return window.innerWidth")).intValue();
		System.out.println("\nHeight: " + contentHeight + " Width: " + contentWidth + "\n");
		Thread.sleep(9000);
		
	}
	
	@AfterTest
	public void quitbrowser() {
		driver.quit();
	}

	
	
}
