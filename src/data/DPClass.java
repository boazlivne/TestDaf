/**
 * 
 */
package data;


import org.testng.annotations.DataProvider; 
public class DPClass {
  	
	/**
	 * @return Object[][] where first column contains 'text to search'
	 *  and second column contains 'expected result'
	 *
	 */
	@DataProvider(name = "test-data")
  	public static Object[][] dataProvFunc(){
        	return new Object[][]{
        		{"����","fdf"},
        		{"����",""},
        		{"Selenium","�� ����� ������"}
        	};
  	}
	
	/**
     * Returns the expected page title.
     * 
     * 
     */
    @DataProvider(name = "page-titel")
    public static Object[][] gePageTitle() {
    	return new Object[][]{
    		{"����� ��� �����: ���� ���"},
    		{"����� ��� �����: ���� ���"}
    	};
    }
}