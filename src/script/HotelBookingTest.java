package script;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Excelsheet;
import page.HotelBookingPage;
import page.FlightBookingPage;
import page.SignInPage;


public class HotelBookingTest extends BaseTest{
	@Test(priority=1 ,groups={"hotelbooking"})
	public void testHotelBooking() throws InterruptedException{
		System.out.println("inside hotelbooking test");
		HotelBookingPage hb = new HotelBookingPage(driver);
		Thread.sleep(2000);
		hb.clickHotelLink(driver);
		Thread.sleep(2000);
		hb.setLocality("Indiranagar", "Bangalore");
		Thread.sleep(2000);
		hb.listofTravellersonHome();
		Thread.sleep(2000);
		hb.clickSearchButton();
	}
}
