package page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import generic.Autoutil;
import generic.Iautoconst;


public class HotelBookingPage {
	@FindBy(xpath= "//a[text()='Hotels']")
	private WebElement hotelLink;
    @FindBy(xpath="//input[@id='Tags']")
	private WebElement localityTextBox;
    @FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;
    @FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;
    
    public void clickHotelLink(WebDriver driver) {
    	String strETO = Autoutil.getProperty(Iautoconst.CONFIG_PATH,"ETO");
		Long ETO = Long.parseLong(strETO);
    	WebDriverWait wait1 = new WebDriverWait(driver, ETO);
        hotelLink = wait1.until(ExpectedConditions.elementToBeClickable(hotelLink));
    
    	hotelLink.click();   
     } 

    //elementToBeClickable(By.xpath("//a[text()='Hotels']")));
    public HotelBookingPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
     }
    
    public void setLocality(String place,String city) {
    	localityTextBox.sendKeys(place,city); 
    } 
 
    public void listofTravellersonHome() {
    	new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
    }  
    
    public void clickSearchButton() {
    	searchButton.click();
    } 
    
             
}
