package cucumber.msdc.stepdefs;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.msdc.pages.models.CukesApp;

/**
 * @author archanaa
 * 
 */
public abstract class AbstractSteps {

	public static final String STR = "(\\S+)";
	
	public static final String STR_WITH_SPACES = "(.*\\S.*)";

	protected static CukesApp cukesApp;
	
	protected void intSetUp()
	 {
	  if (cukesApp == null)
	  {
	   Properties properties = new Properties();
	   java.io.InputStream is = this.getClass().getResourceAsStream("/config.properties");
	   try {
	    if (is != null) {
	     properties.load(is);
	    }
	   }
	   catch (IOException e)
	   {
	    throw new RuntimeException("Failed to load config.properties");
	   }
	   cukesApp = new CukesApp(properties);

	  }
	 }

	protected void intTearDown() {
		if (cukesApp != null) {

			try {
				File scrFile = ((TakesScreenshot) cukesApp.getWebDriver())
						.getScreenshotAs(OutputType.FILE);
				// Now you can do whatever you need to do with it, for example
				// copy somewhere
				FileUtils.copyFile(scrFile,
						new File("c:\\temp\\screenshot.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cukesApp.getWebDriver().quit();
			cukesApp = null;
		}
	}

	

	

	

}
