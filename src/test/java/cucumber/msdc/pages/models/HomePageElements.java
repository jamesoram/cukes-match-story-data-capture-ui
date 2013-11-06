package cucumber.msdc.pages.models;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
@author Shahnaaz Rahamatullah
@version 1.0
 */
public class HomePageElements extends KeyElements{


	private static final String HOMEPAGE_ELEMENT_IDENTIFIER="elementidentifier//homepage.properties";
		
	protected HomePageElements(WebDriver webDriver, String url){
		super(webDriver,HOMEPAGE_ELEMENT_IDENTIFIER);
		webDriver.get(url);	
	
}
	
	protected HomePageElements(WebDriver webDriver){
		super(webDriver,HOMEPAGE_ELEMENT_IDENTIFIER);
		webDriver.get(elementIdentifier.getString("url"));	
	
}
	private List<WebElement> getCompetitionDropDownList(){
		
		return null;
	}
	
	private List<WebElement> getDateDropDownList(){
		
		return null;
	}
	
	protected WebElement getACompetition(String competition){
		return null;
	}
	
	protected WebElement getADate(String date){
		return null;
	}
	
	/**
	 * get "goto match summary page icon"
	 * @param 
	 */
	protected WebElement getGoToMatchSummaryPageIcon(){
		return null;
	}
}
