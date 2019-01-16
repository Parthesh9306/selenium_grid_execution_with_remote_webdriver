package gridtestexecution;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenSeleniumGrid {

	public static RemoteWebDriver rdriver;
	private static String appurl = "http://www.google.com";
	
	@BeforeClass
	public void setRemoteDriver() throws MalformedURLException
	{
	  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	  rdriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	  rdriver.manage().window().maximize();
	}
	
	@Test
	public void testGooglePageTitle()
	{
		rdriver.get(appurl);
		
		String actualtitle = rdriver.getTitle();
		String expectedtitle = "Google";
		
		Assert.assertEquals(actualtitle, expectedtitle, "Title is different");
	}
	
	//@AfterClass
	public void quit() throws MalformedURLException
	{
	  if(rdriver!=null)
	  {
		  rdriver.quit();
	  }
	}
	
	
}
