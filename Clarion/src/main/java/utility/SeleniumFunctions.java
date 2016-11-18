package utility;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class SeleniumFunctions 
{

    WebDriver driver; 
	
	public SeleniumFunctions(WebDriver driver) 
	{
			this.driver=driver;
	}
	
	
	// Function for Enter text in textbox
	
	public  void Entertext(WebElement element,String text){
		
		waitForElement(element);
		element.clear();
		element.click();
		
	}
	
	public void EnterText_action(WebElement element,String text){
		
		Actions action = new Actions(driver);
		action.sendKeys(element, text).build().perform();
	}
	
	public void ClickOnElement_action(WebElement element)
	{
		waitForElement(element);
		element.click();
	}
	
	//Function for 
	public   void ClcikOnElement(WebElement element){
		
		waitForElement(element);
		element.click();
	}
	
	public  void SelectValueFromDropdown(WebElement element,String visibleText){
		
		Select dropdown = new Select(element);
		
		waitForElement(element);
		
		dropdown.selectByVisibleText(visibleText);
		
	}
	 public void JavaScriptExecutor(WebElement element){
		 
		 JavascriptExecutor je = (JavascriptExecutor) driver;
		 
		 waitForElement(element);
		 
		 je.executeScript("arguments[0].scrollIntoView(true);",element);

	 }
	 
	 
     public   void waitForElement(WebElement element){
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	 	}
	
	
	public  String GetElementtext(WebElement element){
		
		waitForElement(element);
		return element.getText();
		
	}
	

	/*
	For getting attribute value for element on page
	*/
	public  void GetAttributeValue(WebElement element, String attributename)
	{
		waitForElement(element);
		
		element.getAttribute(attributename);
			
	}

	
	/*
	To navigate given Url
	*/
	public void ToGoToUrl(String Url) throws InterruptedException
	{
		Thread.sleep(10000);
		driver.get(Url);
	}
	

	
	/*
	To select value from drop down list using Index
	 */
	public  void SelectValueFromDropdownListUsingIndex(WebElement element,int index){
		
		
	   Select select = new Select(element);
	   waitForElement(element);
	   select.selectByIndex(index);
	
	}
	
	
	
	/*
	Accept JS alert and get it's text
	*/
	public String AcceptAlertAndGetText()
	{
		Alert alert = driver.switchTo().alert();
        String AlertText = alert.getText();
        alert.accept();
        
        return AlertText;
	}
	
	
	/*
	Dismiss JS alert and get it's text
	*/
	public String DismisAlertAndGetText()
	{
		Alert alert = driver.switchTo().alert();
        String AlertText = alert.getText();
        alert.dismiss();
        
        return AlertText;
	}
	
	
	/*
	To get current page url
	*/
	public String ToGetCurrentPageUrl()
	{
		return driver.getCurrentUrl();
		
	}
	//getText()
	public String ToGetCurretText(String Locater)
	{
		return  driver.findElement(By.cssSelector(Locater)).getText();
		
	}
	
	//Get Element Count
	public static int GetElementCount(List<WebElement> element){
		
		int ele = element.size();
		
		return ele;
	}
	
		


	/*To mouse hover on element*/
	public void ToMouseHover(String locator, String locatorvalue ) throws InterruptedException
	{
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.cssSelector(locatorvalue));
		action.moveToElement(element).build().perform();
		Thread.sleep(5000);
		
		
		String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";

		WebElement element1 = driver.findElement(By.cssSelector(locatorvalue));
		((JavascriptExecutor)driver).executeScript(javaScript, element1);
		
		Thread.sleep(5000);
		
		/*if(locator.equalsIgnoreCase("id"))
		{
			element = driver.findElement(By.id(locatorvalue));
		}
		
		if(locator.equalsIgnoreCase("name"))
		{
			element = driver.findElement(By.name(locatorvalue));
		}
		
		if(locator.equalsIgnoreCase("css"))
		{
			element =driver.findElement(By.cssSelector(locatorvalue));
		}
		
		if(locator.equalsIgnoreCase("xpath"))
		{
			element =driver.findElement(By.xpath(locatorvalue));
		}
		*/
		
		
	}
	
	public void VerifyDropDownOptions(String locator, String locatorvalue, String[] dropdownvalues)
	{
		WebElement dropdown = null;
		int count = 0;

		 
		if(locator.equals("css"))
		{
			dropdown = driver.findElement(By.cssSelector(locatorvalue));
		}
		
		if(locator.equals("id"))
		{
			dropdown = driver.findElement(By.id(locatorvalue));
		}
		
		if(locator.equals("name"))
		{
			dropdown = driver.findElement(By.name(locatorvalue));
		}
		
		Select select = new Select(dropdown);

		List<WebElement> options = select.getOptions();
		for (WebElement we : options) {
		    for (int i = 0; i < dropdownvalues.length; i++) {
		         if (we.getText().equals(dropdownvalues[i])) {
		             count++;
		              System.out.println(dropdownvalues[i]);
		          }
		      }
		}
		if (count == dropdownvalues.length) 
		 {
		   	System.out.println("Success !! Correct Dropdown values present");
			Reporter.log("Success !! Correct Dropdown values present"); 
		} 
		else 
		{
		   	System.out.println("Failure !! Not displaying Correct values for dropdown");
			Reporter.log("Failure !! Not displaying Correct values for dropdown"); 
					
			Assert.fail();
		}
	}	
	/*
	 To verify whether element is Jump  on Page  or not
	*/
	
	public void jumpToPage(String locator ){	
	    List<WebElement> PageNo = driver.findElements(By.cssSelector(locator));
	    if (PageNo.size() == 0){
	        List<WebElement> nextPage = driver.findElements(By.xpath(locator));
	        if(nextPage.size() >= 1){
	            nextPage.get(0).click();
	        }
	    }
	    else
	    	PageNo.get(0).click();
	    
	}

	/*
	 To verify whether element is present on page or not
	*/
	public boolean IsElementPresent(WebElement element) 
	{
		boolean b= false;
	    try 
	    { 	
	    	if (element.isDisplayed())
	    		{
	    		b=true;
	    		}
	    	
	    	
	    }
	    catch (NoSuchElementException e) 
	    {
	      b=false;
	    }
	    
	    return b;
	}
	
}