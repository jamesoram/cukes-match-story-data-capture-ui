package cucumber.msdc.pages.models;

import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
@author Shahnaaz Rahamatullah
@version 1.0
 */
public abstract class KeyElements {
	protected WebDriver webDriver;
	protected Configuration elementIdentifier;
	
	protected KeyElements(WebDriver webDriver,String elementIdentifierLocation) 
	{
		this.webDriver = webDriver;
		try 
		{
			elementIdentifier = new PropertiesConfiguration(elementIdentifierLocation);
		} 
		catch (ConfigurationException e) 
		{
			e.printStackTrace();
		}	

	}
	
	protected void takeScreenShot(RuntimeException e, String fileName) {
        File screenShot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(fileName + ".png"));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe.getMessage(), ioe);
        }
        throw e;
    }
	
	public void highlightElement(WebElement element) 
	{ for (int i = 0; i < 2; i++) { 
		JavascriptExecutor js = (JavascriptExecutor) webDriver; 
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 10px solid yellow;"); 
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, ""); 
	}

	}
	
	
}	


