package script;

import org.testng.annotations.Test;
import generic.Excelsheet;
import page.HotelBookingPage;
import page.FlightBookingPage;
import page.SignInPage;
import generic.BaseTest;

public class FlightBookingTest  extends BaseTest {
		@Test(priority=2 ,groups={"flightbooking"})
		public void testFlightBooking() throws InterruptedException{
		FlightBookingPage	fb = new FlightBookingPage(driver);
		Thread.sleep(2000);
        fb.clickOneWay();
        Thread.sleep(2000);
        fb.setFromTag("Bangalore");
        Thread.sleep(3000);
        fb.displayListOfOriginOptions("Bangalore");
        Thread.sleep(2000);
        fb.selectOriginOptions();
        Thread.sleep(2000);
        fb.setToTag("Delhi");
        Thread.sleep(2000);
        fb.displayListOfDestinationOptions("Delhi");
        Thread.sleep(2000);
        
        fb.selectDestinationOptions();
        Thread.sleep(2000);
        
        fb.selectDate();
        Thread.sleep(2000);
        fb.clickSearchButton();
        Thread.sleep(3000);
        fb.verifyFlightSearchResult();
		}
}