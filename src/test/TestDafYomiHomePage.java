package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.DPClass;
import pages.DafYomiHomePage;

public class TestDafYomiHomePage extends TestBase {
	DafYomiHomePage homePage;
	@BeforeClass
	public void init() {
		   homePage=new DafYomiHomePage(driver);
	  }
	
	@Test(enabled=false, priority=0,dataProvider ="page-titel", dataProviderClass=DPClass.class) 
    public void testShowPageView( String expected_title) {
		String page_title = homePage.showDSafView();
		Assert.assertEquals(expected_title, page_title);
	}
	
	@AfterMethod(enabled=false)
	public void returnBackPage() {
		String page_title;
		page_title=homePage.returnToHomePage();
		String expectedTitle="פורטל הדף היומי: יומא כב";
		Assert.assertEquals(expectedTitle, page_title);
		System.out.println("@AfterMethod has been called ");
	}
	
	
	@Test(enabled=true, priority=1,dataProvider ="test-data", dataProviderClass=DPClass.class) 
    public void testSearchButton(String search_text, String expected_result) {
		String result;
		result=homePage.clickSearchButton(search_text);
		Assert.assertEquals(expected_result, result);

	}
	
}
