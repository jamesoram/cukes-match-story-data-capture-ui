package cucumber.msdc.pages.utils;

import java.util.NoSuchElementException;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.msdc.pages.models.HomePageElements;




/**
@author Shahnaaz Rahamatullah
@version 1.0
 */
public class HomePage extends HomePageElements {

	public HomePage(WebDriver webDriver, String url) {
		super(webDriver, url);
	
	}
	
	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}

	public HomePage selectACompetition(String competition){
		getACompetition(competition).click();
		return this;
		
	}
	
	public HomePage selectADate(String date){
		getACompetition(date).click();
		
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		try{
			webDriver.findElement(By.id(elementIdentifier.getString("")));
			
		}catch(NoSuchElementException e){
			Assert.fail("the click action did not happen as the loading was too quick");
			
		}
		return this;
		
	}
	
	

	

}
