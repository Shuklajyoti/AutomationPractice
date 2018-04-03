package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import generic.Autoutil;
import generic.BaseTest;
import generic.Iautoconst;

public class SignInPage {
	@FindBy(linkText="Your trips")//
	private WebElement lnkTxt;
	@FindBy(id="SignIn")
	private WebElement signinLink;
	@FindBy( id ="email")
	private WebElement usernameTextBox;
	@FindBy(id="password")
	private WebElement passwordTextBox;
	@FindBy(id="signInButton")
	private WebElement signinButton;
	@FindBy(xpath="//div[@id='errors1']/span")
	private WebElement errMsg;
	@FindBy(id="modal_window")
	private WebElement signinPopUP;
	
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}  
	public void setUserName(String un) {
		usernameTextBox.sendKeys(un); 
	} 
	public void setPassword(String pw) {
		passwordTextBox.sendKeys(pw);
	}   

	public void clickSignInButton(WebDriver driver) {
		String strETO = Autoutil.getProperty(Iautoconst.CONFIG_PATH,"ETO");
		Long ETO = Long.parseLong(strETO);
		
		new WebDriverWait(driver, ETO).until(ExpectedConditions.elementToBeClickable(signinButton)).click(); 
	}   
	public void clickYourTripsLink(WebDriver driver) {
		String strETO = Autoutil.getProperty(Iautoconst.CONFIG_PATH,"ETO");
		Long ETO = Long.parseLong(strETO);
         new WebDriverWait(driver, ETO).until(ExpectedConditions.elementToBeClickable(lnkTxt)).click();
	} 
	public void clickSignInLink() {
		signinLink.click();   
	} 
	public void switchToFrame(WebDriver driver) {
	    driver.switchTo().frame(signinPopUP);   
	} 
	
	public void verifyErrorMessage(){
		String expectedMsg = "There were errors in your submission" ;
		String actualMsg = errMsg.getText(); 
		Assert.assertEquals(actualMsg, expectedMsg);
	}     
}
