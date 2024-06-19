package com.tutorialsninja.qa.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Login extends Base{
	public Login() {
		super();
		
	}
    WebDriver driver;

    @BeforeMethod
    public void setup() {
    	
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        
       System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver-win64\\chromedriver.exe");
       driver = new ChromeDriver(); // Remove the WebDriver declaration here
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        driver.findElement(By.linkText("Login")).click();
    }

    @Test(priority = 1)
    public void verifyLoginWithValidCredentials() {
        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test(priority = 2)
    public void verifyLoginWithInvalidCredentials() {
        driver.findElement(By.id("input-email")).sendKeys("usertest00@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Pass@1234");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

       // String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissable')]")).getText();
        //String expectedWarningMessage = "Warning: No match for Email Address and/or Password";
        //Assert.assertTrue("Expected warning message is not displayed", actualWarningMessage.contains(expectedWarningMessage));
	
        // Capture screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Specify destination file path
        String destinationFilePath = "\\Users\\anush\\eclipse-workspace\\TutorialsNinja\\Screenshots\\screenshot1.png";

        try {
            // Copy the screenshot to the specified destination
            FileUtils.copyFile(src, new File(destinationFilePath));
            System.out.println("Screenshot captured and saved to: " + destinationFilePath);
        } catch (IOException e) {
            System.out.println("Error while capturing or saving screenshot: " + e.getMessage());
            e.printStackTrace();
        }

    
    }
}

	

	


