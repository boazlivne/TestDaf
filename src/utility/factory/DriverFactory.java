package utility.factory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	 public WebDriver createInstance(String browser) 
	 {
	        WebDriver driver = null;
	        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());

	        switch (browserType) {

	            case CHROME:
	                driver = new ChromeBrowser().createDriver();
	                break;
	            default:
	            	throw new NullPointerException();
	        }
	        return driver;
	    }

	    public enum BrowserList {
	        CHROME, FIREFOX, EDGE, SAFARI, OPERA, IE
	    }
}
