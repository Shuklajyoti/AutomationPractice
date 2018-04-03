package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.Reader;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Autoutil {
	public static String getPhoto( WebDriver driver,String screenshot,String s){
		String path = "";
		try{
		    String date = new Date().toString();
		    String datetime = date.replaceAll(":", "-");
		    path = screenshot+datetime+".png";
		    TakesScreenshot t = (TakesScreenshot)driver;
		     File src = t.getScreenshotAs(OutputType.FILE);
		     FileUtils.copyFile(src, new File(path)); 
		}
		catch(Exception e)
		{
		}
		return path;
	}     
	
	public static String getProperty(String path,String key){
		System.out.println(path);
		System.out.println(key);
		String prop = "";
		try{
			System.out.println("inside try");
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			prop= p.getProperty(key);  
		}
		catch(Exception e)
		{
		}
		return prop;
	}
	
}
