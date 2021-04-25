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
	   
	     public void returnToHomePage() {
	    	 homePageButton.click();
	     }
	     // This method show  daf yomi view   
	     public DafYomiViewPage showDSafView() {  
	          dafViewButton.click();  
	          return new DafYomiViewPage(driver);  
	     } 
	    /**
	     * @This method fill in search box and show content table
	     * @return
	     */
	    public ContentTablePage clickSearchButton(String text) {  
	    	//fill the search box with input text
	    	searchTextBox.sendKeys(text);
	    	 searchButton.click();
	    	 //update the max row result to show 200 rows
	    	 String max_row_num="200";
	    	  WebElement element= driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolderMain_ddlPageSize\"]"));
	    	 element.sendKeys(max_row_num);
	    	 
	    	  
	    	  
	    	 
	    	 //wait until the content table is visible
	    	 WebDriverWait wait = new WebDriverWait(driver, 100);
	    		 wait.until(
	    			        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'form1\']/div[4]/table/tbody/tr[3]/td[2]/a")));
	    	 String data=driver.findElement(By.xpath("//*[@id=\'form1\']/div[4]/table/tbody/tr[3]/td[2]/a")).getText();
	    	 System.out.println("table content: "+data);
	    	 
	    	 
	    	  
	    	
	    	
	    	//col number
	    	 List  col = driver.findElements(By.xpath("//*[@id=\"form1\"]/div[4]/table/thead/tr/th"));
	         System.out.println("No of cols are : " +col.size());
	         
	       //row number
	    	 List  row = driver.findElements(By.xpath("//*[@id=\"form1\"]/div[4]/table/tbody/tr"));
	         System.out.println("No of rows are : " +row.size());
	          return new ContentTablePage(driver);
	        
	     }
	     
	     
	     
	     
	     
	     
}
