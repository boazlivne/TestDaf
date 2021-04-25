package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.DafYomiHomePage;

public class TestDafYomiHomePage extends TestBase {
	DafYomiHomePage homePage;
	@BeforeClass
	public void init() {
		   homePage=new DafYomiHomePage(driver);
	  }
	@Test(enabled=true, priority=0 )
    public void testShowPageView() {
	 homePage.showDSafView();
	 System.out.println("testShowPageView 111111111");
	}
	@AfterMethod
	public void returnBackPage() {
		homePage.returnToHomePage();
		System.out.println("returnBackPage 000000000000000000000");
	}
	@Test(enabled=true, priority=1 )
    public void testSearchButton() {
		String text_to_search="חתול";
		homePage.clickSearchButton(text_to_search);
		System.out.println("testSearchButton 22222222222222222222");
	}
	
}
