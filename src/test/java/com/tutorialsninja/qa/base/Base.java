package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
WebDriver driver;
public Properties prop;


public Base() {
    prop = new Properties();
    File propFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
    
    try (FileInputStream fis = new FileInputStream(propFile)) {
        prop.load(fis);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
    if (browserName.equals("chrome")) {
        driver = new ChromeDriver();
    } else if (browserName.equals("firefox")) {
        driver = new FirefoxDriver();
    }
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10).getSeconds(), TimeUnit.SECONDS);
    
    // Replace the following line with the actual URL you want to navigate to
    driver.get(prop.getProperty("http://tutorialsninja.com/demo/"));

    return driver;
}
}
