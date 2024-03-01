package com.qa.base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase{
	
	@Test
	public void configureAppium() throws MalformedURLException, InterruptedException {

	  //Appium Server will run Automatically
	  AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Rukadar Laptop\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
	  service.start();
      
	  //Desired Capabilities
	  UiAutomator2Options options = new UiAutomator2Options();
	  options.setDeviceName("Pixel 6 Pro");
	  options.setPlatformVersion("9.0");
	  options.setApp(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\thescore-24-2-0.apk");

	  AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8000));

	  //Get Started
	  driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text")).click();
	  Thread.sleep(3000);
	  
         //Verify League Page displayed successfully or not
	  WebElement leaguePage = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/title_onboarding\"]"));
	  Assert.assertTrue(leaguePage.isDisplayed());
	  Thread.sleep(3000);
	  
	  //Select NHL tab
	  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"NHL Hockey\"]")).click();
	  Thread.sleep(3000);
          
          //Click on Continue Button
	  driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.fivemobile.thescore:id/btn_primary\"]")).click();
	  Thread.sleep(3000);
      
	  //May Be Later Button click
	  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/btn_disallow\"]")).click();
	  Thread.sleep(3000);
	  
	  
	  //Got to NHL League tab
	  driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text=\"NHL\" and @class=\"android.widget.TextView\"])[2]")).click();
	  
	  //Select Toronto Maple Leafs from the list of teams inside NHL League
	  driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Toronto Maple Leafs\"));"));
	  Thread.sleep(4000);
	  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"Toronto Maple Leafs\"]")).click();
	  
	  //CLick on Continue button
	  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/action_button_text\"]")).click();
	  
	  //Click on Done Button
	  driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.fivemobile.thescore:id/btn_primary\"]")).click();
	  
	  //Click on cross icon to dismiss pop-up
	  driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"com.fivemobile.thescore:id/dismiss_modal\"]")).click();
	  
	  //Click on Toronto Maple Leafs Team icon
	  driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"com.fivemobile.thescore:id/icon_team_logo\"]")).click();
	  
	  
	  //Click on Team Stats Tab
	  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"TEAM STATS\" and @class=\"android.widget.TextView\"]")).click();
	  Thread.sleep(5000);
	  
	  //Verify Team Stats displayed successfully or not
	  WebElement TeamStats = driver.findElement(By.xpath("//android.widget.TextView[@text=\"TEAM STATS\"]"));
	  Assert.assertTrue(TeamStats.isDisplayed());
	  Thread.sleep(3000);
	  
	   
	  driver.quit();
	  service.stop();

	}
	
	

}
