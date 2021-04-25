package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utility.factory.DriverFactory;
import utility.factory.DriverFactory.BrowserList;

public class TestBase {  
    public static WebDriver driver;  
   
    @BeforeSuite  
    public void initializeWebDriver() throws IOException {  
       
    	String browser_name="chrome";
    	driver = new DriverFactory().createInstance(browser_name);
         
    	// To maximize browser  
         driver.manage().window().maximize();  
     
         // Implicit wait  
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
     
         // To open daf-yomi site  
         driver.get("http://www.daf-yomi.com/");  
    }  
   
    @AfterSuite  
    public void quitDriver() {  
    	
    	driver.quit();  
    }  
}
