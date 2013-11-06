package cucumber.msdc.pages.utils;

import org.openqa.selenium.WebDriver;

import com.pressassociation.pages.models.HomePageElements;


/**
@author Shahnaaz Rahamatullah
@version 1.0
 */
public class HomePage extends HomePageElements {

	protected HomePage(WebDriver webDriver) {
		super(webDriver);
	
	}
	
	public HomePage selectACompetition(String competition){
		getACompetition(competition).click();
		return this;
		
	}
	
	public HomePage selectADate(String date){
		getACompetition(date).click();
		return this;
		
	}

	

}
