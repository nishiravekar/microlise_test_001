package products.CM;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageFactory.CM.Advanced_search_page;
import utility.Browser;
import utility.Constants;
import utility.JavaHelpers;
import utility.SeleniumFunctions;

public class Search_Test {

	private WebDriver driver;
	private Browser b = new Browser();
	JavaHelpers JH = new JavaHelpers();
	
	
	@Parameters({ "browser", "environment", "os" })
	@BeforeMethod
	public void setUp(String browser, String environment , String OS) throws Exception 
	{		
		driver= b.setUp(browser, environment, OS);
		
	}

	@AfterMethod
	public void teardown() throws Exception
	{
		b.tearDown();
	}

	
	//  Verify user is able to Search only using Search Term field
	
	@Test(priority=1) 
	private void Search_Validation() throws Exception
	{
		System.out.println("====" + "\n" +
					"Test 1 : Verify user is able to Search only using Search Term field"  + "\n" +
		 			"====");
		Reporter.log("====" + "\n" +
		 			  "Test 1 : Verify user is able to Search only using Search Term field"  + "\n" +
				 	  "====");	
		
		int AssertFailedCount=0 ;
		SeleniumFunctions SeleniumFunc = new SeleniumFunctions(driver);
		Advanced_search_page search = new Advanced_search_page(driver);
		
		
		System.out.println("Step 1 : Navigate to Advance Search page : " + Constants.ApplicationURL_CM );
		Reporter.log("Step 1 : Navigate to Advance Search page : " + Constants.ApplicationURL_CM ); 
			
	    SeleniumFunc.ToGoToUrl(Constants.ApplicationURL_CM);
	
		System.out.println("Step 2 : Go to Advance Search section");
		Reporter.log("Step 2 : Go to Advance Search section"); 
		
		SeleniumFunc.JavaScriptExecutor(search.Searchterm);
		
		System.out.println("Step 3 : Entering text in Search Term field");
		Reporter.log("Step 3 : Entering text in Search Term field"); 
		
		SeleniumFunc.EnterText_action(search.Searchterm,"TESCO");
		
		
		System.out.println("Step 3: Clicking on Search Now button");
		Reporter.log("Step 3: Clicking on Search Now button"); 
		
		SeleniumFunc.ClickOnElement_action(search.SearchNow_Button);
	
		String string = SeleniumFunc.GetElementtext(search.SearchHeader_aftersearch) ;
		
	//	System.out.println(string);
		String[] parts = string.split("-");
        String part2 = parts[1];
		System.out.println("        Actual text is" +part2);
		
		String actualText= part2;
		String expText= " TESCO";
		
			if(actualText.equalsIgnoreCase(expText))
			{
				Thread.sleep(1000);
				System.out.println("Success !! Search successfully Done");
				Reporter.log("Success !! Search successfully Done"); 
			}
			else
			{
				System.out.println("Failure !! Search Unsuccessful");
				Reporter.log("Failure !! Search Unsuccessful");
				
				AssertFailedCount++;
			}
			
			// For failed test
			
			if(AssertFailedCount>0)	
			{
				
				//Marking this test as Failed
				
				System.out.println("---- Test Failed. Please check the console or TestNg report for details");
				Reporter.log("---- Test Failed. Please check the console or TestNg report for details");
				
				Assert.fail();
			}
		 
			
		}
	
	
// Verify user is able to Search using all fields which are available for Advance search
 
@Test(priority=2)
private void SearchWithAllFields() throws Exception
{
	System.out.println("====" + "\n" +
				"Test 2 : Verify user is able to Search using all fields which are available for Advance search"  + "\n" +
	 			"====");
	Reporter.log("====" + "\n" +
	 			  "Test 2 : Verify user is able to Search using all fields which are available for Advance search"  + "\n" +
			 	  "====");	
	
	int AssertFailedCount=0 ;
	SeleniumFunctions SeleniumFunc = new SeleniumFunctions(driver);
	Advanced_search_page search = new Advanced_search_page(driver);
	
	
	System.out.println("Step 1 : Navigate to Advance Search page : " + Constants.ApplicationURL_CM );
	Reporter.log("Step 1 : Navigate to Advance Search page : " + Constants.ApplicationURL_CM ); 
		
    SeleniumFunc.ToGoToUrl(Constants.ApplicationURL_CM);

	System.out.println("Step 2 : Go to Advance Search section");
	Reporter.log("Step 2 : Go to Advance Search section"); 
	
	Thread.sleep(2000);
	SeleniumFunc.JavaScriptExecutor(search.Searchterm);
	
	System.out.println("Step 3 : Entering text in Search Term field");
	Reporter.log("Step 3 : Entering text in Search Term field"); 
	
	SeleniumFunc.EnterText_action(search.Searchterm,"TESCO");
	
	System.out.println("Step 4 : Selecting dropdown options");
	Reporter.log("Step 4 : Selecting dropdown options"); 
	
	// SeleniumFunc.SelectValueFromDropdown(search.Relevant_Industry_Dropdown,"Defence & Government");
	SeleniumFunc.SelectValueFromDropdown(search.ResourceType_Dropdown, "Press Releases");
	SeleniumFunc.SelectValueFromDropdown(search.Year_Dropdown, "2016");
	
	System.out.println("Step 3:  Clicking on Search Now button");
	Reporter.log("Step 3: Clicking on Search Now button"); 
	
	SeleniumFunc.ClickOnElement_action(search.SearchNow_Button);

	String string = SeleniumFunc.GetElementtext(search.SearchHeader_aftersearch) ;
	
//	System.out.println(string);
	String[] parts = string.split("-");
    String part2 = parts[1];
	System.out.println("          Actual text is" +part2);
	
	String actualText= part2;
	String expText= " TESCO" ;
	
		if(actualText.equalsIgnoreCase(expText))
		{
			Thread.sleep(1000);
			System.out.println("Success !! Search successfully Done");
			Reporter.log("Success !! Search successfully Done"); 
		}
		else
		{
			System.out.println("Failure !! Search Unsuccessful");
			Reporter.log("Failure !! Search Unsuccessful");
			
			AssertFailedCount++;
		}
		
		// For failed test
		
		if(AssertFailedCount>0)	
		{
			
			//Marking this test as Failed
			
			System.out.println("---- Test Failed. Please check the console or TestNg report for details");
			Reporter.log("---- Test Failed. Please check the console or TestNg report for details");
			
			Assert.fail();
		}
	 
		
	}


// User is not able to search with invalid input

@Test(priority=3)
private void InvalidSearch() throws Exception
{
	System.out.println("====" + "\n" +
				"Test 3 : User is not able to search with invalid input"  + "\n" +
	 			"====");
	Reporter.log("====" + "\n" +
	 			  "Test 3 : User is not able to search with invalid input"  + "\n" +
			 	  "====");	
	
	int AssertFailedCount=0 ;
	SeleniumFunctions SeleniumFunc = new SeleniumFunctions(driver);
	Advanced_search_page search = new Advanced_search_page(driver);
	
	
	System.out.println("Step 1 : Navigate to Advance Search page : " + Constants.ApplicationURL_CM );
	Reporter.log("Step 1 : Navigate to Advance Search page : " + Constants.ApplicationURL_CM ); 
		
    SeleniumFunc.ToGoToUrl(Constants.ApplicationURL_CM);

	System.out.println("Step 2 : Go to Advance Search section");
	Reporter.log("Step 2 : Go to Advance Search section"); 
	
	Thread.sleep(2000);
	SeleniumFunc.JavaScriptExecutor(search.Searchterm);
	
	System.out.println("Step 3 : Entering text in Search Term field");
	Reporter.log("Step 3 : Entering text in Search Term field"); 
	
	SeleniumFunc.EnterText_action(search.Searchterm,"ABCD");
	
	System.out.println("Step 4 : Selecting dropdown options");
	Reporter.log("Step 4 : Selecting dropdown options"); 
	
	SeleniumFunc.SelectValueFromDropdown(search.Relevant_Industry_Dropdown,"Defence & Government");
	SeleniumFunc.SelectValueFromDropdown(search.ResourceType_Dropdown, "Press Releases");
	SeleniumFunc.SelectValueFromDropdown(search.Year_Dropdown, "2016");
	
	System.out.println("Step 3:  Clicking on Search Now button");
	Reporter.log("Step 3: Clicking on Search Now button"); 
	
	SeleniumFunc.ClickOnElement_action(search.SearchNow_Button);

	String actualText = SeleniumFunc.GetElementtext(search.SearchHeader_aftersearch) ;

	System.out.println("          Actual text is" +actualText);

	String expText= "Nothing Found" ;
	
		if(actualText.equalsIgnoreCase(expText))
		{
			Thread.sleep(1000);
			System.out.println("Success !! Invalid input for Search successfully Done");
			Reporter.log("Success !! Invalid input for Search successfully Done"); 
		}
		else
		{
			System.out.println("Failure !! Search Unsuccessful");
			Reporter.log("Failure !! Search Unsuccessful");
			
			AssertFailedCount++;
		}
		
		// For failed test
		
		if(AssertFailedCount>0)	
		{
			
			//Marking this test as Failed
			
			System.out.println("---- Test Failed. Please check the console or TestNg report for details");
			Reporter.log("---- Test Failed. Please check the console or TestNg report for details");
			
			Assert.fail();
		}
	 
		
	}

}



