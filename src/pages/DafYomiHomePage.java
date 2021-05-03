package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DafYomiHomePage {

	   WebDriver driver;  
	   
	     @FindBy(xpath="//*[@id=\"oPageLinksBox\"]/a[1]") 
	     WebElement dafViewButton; 
	     
	    
	     @FindBy(xpath="//*[@id=\"Logo\"]")  
	     WebElement homePageButton;
	     
	     @FindBy(name="term")
	     WebElement searchTextBox;
	     
	    
	    @FindBy(xpath="//*[@value='חיפוש']")
	     WebElement searchButton;
	    
	     public DafYomiHomePage (WebDriver driver) {  
	          this.driver = driver;  
	          PageFactory.initElements(driver, this);  
	     }
	     
	   
	     public String returnToHomePage() {
	    	 homePageButton.click();
	          String page_title=driver.getTitle();
		     return page_title;


	     }
	     // This method show  daf yomi view   
	     public String showDSafView() {  
	          dafViewButton.click();
	          String page_title=driver.getTitle();
	          return page_title;  
	     } 
	    /**
	     * @This method fill in search box and show content table
	     * @return
	     */
	    public String clickSearchButton(String text) {  
	    	//fill the search box with input text
	    	searchTextBox.sendKeys(text);
	    	 searchButton.click();
	    	 //update the max row result to show 25 rows
	    	 String max_row_num="25";
	    	  WebElement element= driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolderMain_ddlPageSize\"]"));
	    	 element.sendKeys(max_row_num);
	    	 
	    	  
	    	  
	    	 String result="";
	    	 //wait until the content table is visible
	    	 
	    	 WebDriverWait wait = new WebDriverWait(driver, 10);
	    	 try {
	    		
	    		 wait.until(
	    			        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form1\"]/div[4]/table/tbody/tr")));
	    	
			} 
	    	 catch (Exception e) {
	    		 result= driver.findElement(By.xpath("//*[@id=\"divNoResults\"]/p")).getText();
				 return result;
			}
	    	 List  col = driver.findElements(By.xpath("//*[@id=\"form1\"]/div[4]/table/thead/tr/th"));
	         System.out.println("No of cols are : " +col.size());
	         
	       //row number
	    	 List  row = driver.findElements(By.xpath("//*[@id=\"form1\"]/div[4]/table/tbody/tr"));
	         System.out.println("No of rows are : " +row.size());
	          return result;
	        
	     }
	     
	     
	     
	     
	     
	     
}
