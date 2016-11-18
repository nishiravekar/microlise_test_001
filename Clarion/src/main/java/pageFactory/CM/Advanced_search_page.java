package pageFactory.CM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;
import utility.SeleniumFunctions;

public class Advanced_search_page {

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public Advanced_search_page(WebDriver driver)
	{	 
        this.driver = driver;
 
        //This initElements method will create all WebElements
        //PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.WebDriverWaitDuration), this);
	}
	
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 	
		@FindBy(css="#searchbox")
    	public WebElement Searchterm;
		
		@FindBy(css="#cat")
    	public WebElement Relevant_Industry_Dropdown;
		 
		@FindBy(css="#post_type")
    	public WebElement ResourceType_Dropdown;
		
		@FindBy(css="#year")
    	public WebElement Year_Dropdown;
		
		@FindBy(xpath="//input[@id='searchsubmit'][@class='button grey']")
    	public WebElement SearchNow_Button;
		
		@FindBy(css=".list-block>header>h1")
    	public WebElement SearchHeader_aftersearch;
		
		@FindBy(css=".page-title")
    	public WebElement InvalidSearch;
		
		
	



}
