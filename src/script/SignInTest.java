package script;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Excelsheet;
import page.HotelBookingPage;
import page.FlightBookingPage;
import page.SignInPage;

public class SignInTest extends BaseTest {
	@Test(priority=2 ,groups={"signin"})
	public void testInvalidSignIn() throws InterruptedException{
		
		SignInPage s = new SignInPage(driver);
		Thread.sleep(1000);
		s.clickYourTripsLink(driver);//click your trips link
		Thread.sleep(1000);
		s.clickSignInLink();//click signIn link
		Thread.sleep(2000);
		s.switchToFrame(driver); //switch to popup
		Thread.sleep(3000);
		s.clickSignInButton(driver);//click sign in button
		s.verifyErrorMessage();//verify error message
		
	}
	
}
