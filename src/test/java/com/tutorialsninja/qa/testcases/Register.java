package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Register {
	@Test(priority=1)
	public void verifyRegisterWIthValidData(){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\anush\\eclipse-workspace\\TutorialsNinja\\Driver\\chromedriver.exe");
    ChromeDriver driver= new ChromeDriver();
    driver.get("https://tutorialsninja.com/demo/");
    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
    driver.findElement(By.linkText("Register")).click();
    driver.findElement(By.id("input-firstname")).sendKeys("DummyTest2");
    driver.findElement(By.id("input-lastname")).sendKeys("Snamedummy2");
    driver.findElement(By.id("input-email")).sendKeys("dtest123@gmail.com");
    driver.findElement(By.id("input-telephone")).sendKeys("7634096493");
    driver.findElement(By.id("input-password")).sendKeys("Pass@123");
    driver.findElement(By.id("input-confirm")).sendKeys("Pass@123");
    driver.findElement(By.name("agree")).click();
    driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
    
    String actualSuccessHeading= driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
    Assert.assertEquals(actualSuccessHeading, "Your Account Has Been Created!"," Account Success page not displayed");
    
    driver.quit();
	}
	
	@Test(priority=2)
	public void VerifyRegisterWithExixtingEmail() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anush\\eclipse-workspace\\TutorialsNinja\\Driver\\chromedriver.exe");
	    ChromeDriver driver= new ChromeDriver();
	    driver.get("https://tutorialsninja.com/demo/");
	    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
	    driver.findElement(By.linkText("Register")).click();
	    driver.findElement(By.id("input-firstname")).sendKeys("DummyTest1");
	    driver.findElement(By.id("input-lastname")).sendKeys("Snamedummy");
	    driver.findElement(By.id("input-email")).sendKeys("dtest123@gmail.com");
	    driver.findElement(By.id("input-telephone")).sendKeys("7634096493");
	    driver.findElement(By.id("input-password")).sendKeys("Pass@123");
	    driver.findElement(By.id("input-confirm")).sendKeys("Pass@123");
	    driver.findElement(By.name("agree")).click();
	    driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	    
	    String actualWarning= driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
	    Assert.assertEquals(actualWarning,"Warning:Email Address is already registered","Warning message not displayed");
	    
	    driver.quit();
		
		
	}

	@Test(priority=3)
	public void verifyRegiserwithoutfillingData() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anush\\eclipse-workspace\\TutorialsNinja\\Driver\\chromedriver.exe");
	    ChromeDriver driver= new ChromeDriver();
	    driver.get("https://tutorialsninja.com/demo/");
	    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
	    driver.findElement(By.linkText("Register")).click();
	    driver.findElement(By.xpath("//input[@value='Continue']")).click(); //without filling details click submit button
	    
		String actualPrivacyPolicyWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissale')]")).getText();
				Assert.assertTrue(actualPrivacyPolicyWarning.contains("Warning: You must agree to the Privacy Policy!"));
		
	}

}
