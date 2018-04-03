package generic;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements Iautoconst {
	public WebDriver driver;
	static{
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	@BeforeMethod(alwaysRun = true)
	public void OpenAPP() throws InterruptedException{
		String appURL = Autoutil.getProperty(CONFIG_PATH,"URL");
		String strITO = Autoutil.getProperty(CONFIG_PATH,"ITO");
		Long ITO = Long.parseLong(strITO);
		
		driver = new FirefoxDriver(); //open the browser
		driver.get(appURL);//enter the URL
		
	    driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
	    
	    System.out.println(driver.getCurrentUrl());
	}	
	
	@AfterMethod(alwaysRun = true)
	public void CloseAPP(ITestResult testResult){
		
		String name = testResult.getName();
		System.out.println(name);
		int status = testResult.getStatus(); 
		if(status==1){
			Reporter.log(name+"is passed",true); 
		}
		else {
			Reporter.log(name+ " is Failed ",true);
			Autoutil.getPhoto(driver,IMG_PATH, name);
		} 
		driver.close();  //closing Browser 
	}		
}
