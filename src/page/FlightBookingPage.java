package page;
import java.util.List;
import java.util.NoSuchElementException;
import generic.BaseTest;
import generic.Autoutil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlightBookingPage {
	
	@FindBy(id="OneWay")
	private WebElement radioButtont;
	@FindBy(id="FromTag")
	private WebElement fromTextbox;
	@FindBy(id="ui-id-1")
	private  WebElement orginOptionsTextbox ;
	@FindBy(tagName="li")
	private List< WebElement> originOptions;
	@FindBy(id="ui-id-2")
	private  WebElement destinationOptionsTextbox ;
	@FindBy(tagName="li")
	private List< WebElement> destinationOptions;
	@FindBy( xpath="//input[@id='ToTag']")
	private WebElement toTextbox;	
	@FindBy( className="searchSummary")
	private WebElement searchSummary;
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
	private  WebElement datePicker ;
	 	
	@FindBy(id="SearchBtn")
	private  WebElement searchButton;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement bookButton;
	 	
	public FlightBookingPage(WebDriver driver){ 
		PageFactory.initElements(driver, this); 
	}
	
	public void clickOneWay() {
		radioButtont.click();
	} 
	
	 public void setFromTag(String city) {
		 fromTextbox.clear();
		 fromTextbox.sendKeys(city);
	 }
	 
	 public void displayListOfOriginOptions(String s) {
		 orginOptionsTextbox.sendKeys(s);
	 }
	 
	 public void selectOriginOptions() {
		originOptions.get(0).click();	
     } 
	 
	 public void setToTag(String city) {
		 toTextbox.clear();
		 toTextbox.sendKeys(city);
	 }   

	 public void displayListOfDestinationOptions(String s) {
		 destinationOptionsTextbox.sendKeys(s);
	 }
	 
	 public void selectDestinationOptions() {
		 destinationOptions.get(0).click();
	 } 
	 
	 public void selectDate() {
		 datePicker.click();
	 } 
	 
	 public void clickSearchButton() {
		 searchButton.click();
	 } 
	 public void verifyFlightSearchResult(){
		 String expectedText ="Book";
		 String actualText = bookButton.getText();
		 Assert.assertEquals(actualText, expectedText);
	 }
} 
	 
	  
	 
	 

