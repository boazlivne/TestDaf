package utility.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser implements FactoryBrowser {

	@Override
	public WebDriver createDriver() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","src\\drivers\\chromedriver.exe");
		return new ChromeDriver();
	}

	

	

}
