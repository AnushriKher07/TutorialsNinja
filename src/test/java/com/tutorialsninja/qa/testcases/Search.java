package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search {
	@Test(priority=1)
	public void VerifySearchWithValidProduct(){
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anush\\eclipse-workspace\\TutorialsNinja\\Driver\\chromedriver.exe");
	    ChromeDriver driver= new ChromeDriver();
	    driver.get("https://tutorialsninja.com/demo/");
	    driver.findElementByName("search").sendKeys("MacBook");
	    driver.findElementByXPath("//div[@id='search']/descendant::button").click();
	    driver.findElementByXPath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/h4/a").click();
	    WebElement element = driver.findElementByLinkText("MacBook");
	    Assert.assertTrue(element.isDisplayed());
	    
	}
	}
@Test(priority=2)
public void VerifySearchWithInvalidProduct() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\anush\\eclipse-workspace\\TutorialsNinja\\Driver\\chromedriver.exe");
    ChromeDriver driver= new ChromeDriver();
    driver.get("https://tutorialsninja.com/demo/");
    driver.findElementByName("search").sendKeys("Honda");
    driver.findElementByXPath("//div[@id='search']/descendant::button").click();
    WebElement element = driver.findElementByLinkText("HP LP3065");
    Assert.assertTrue(element.isDisplayed());

	
}
}
	

