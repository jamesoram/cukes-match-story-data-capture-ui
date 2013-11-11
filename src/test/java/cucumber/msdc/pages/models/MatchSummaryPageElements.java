package cucumber.msdc.pages.models;

import java.util.List;
import java.util.NoSuchElementException;

import junit.framework.Assert;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
@author Shahnaaz Rahamatullah
@version 1.0
 */
public class MatchSummaryPageElements extends KeyElements {
	
	private static final String MATCH_SUMMARY_PAGE_ELEMENT_IDENTIFIER="elementidentifier//matchsummarypage.properties";
	
	protected MatchSummaryPageElements(WebDriver webDriver, String url){
		super(webDriver,MATCH_SUMMARY_PAGE_ELEMENT_IDENTIFIER);
		webDriver.get(url);	
		
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		try{
			webDriver.findElements(By.xpath(elementIdentifier.getString("matchaction")));
			
		}catch(NoSuchElementException e){
			Assert.fail("the element is not loaded");
			
		}
	
}
	
	protected MatchSummaryPageElements(WebDriver webDriver){
		super(webDriver,MATCH_SUMMARY_PAGE_ELEMENT_IDENTIFIER);
		
	
}
	
	private List<WebElement> getMatchActions(){
	return	webDriver.findElements(By.xpath(elementIdentifier.getString("matchaction")));
	}
	
	protected List<WebElement> getMatchActionExclamationIcons(){
		return webDriver.findElements(By.xpath(elementIdentifier.getString("exclamationicon")));
	}
	
	protected List<WebElement> getMatchActionFavouriteIcons(){
		return webDriver.findElements(By.xpath(elementIdentifier.getString("favouriteicon")));
	}
	
	protected List<WebElement> getMatchActionGameChangingIcons(){
		return webDriver.findElements(By.xpath(elementIdentifier.getString("gamechangingicon")));
	}
	
	protected WebElement getAMatchActionExclamationICon(int i){
		if (i>=getMatchActions().size()){
			throw new IllegalArgumentException();
		}
		
	return	webDriver.findElement(By.xpath("(//div[@class='match-action'])["+i+"]/div[@class='single-action-flags']/input[1]"));

		
	}
	
	protected WebElement getAMatchActionFavouriteICon(int i){
		if (i>=getMatchActions().size()){
			throw new IllegalArgumentException();
		}
		
	return	webDriver.findElement(By.xpath("(//div[@class='match-action'])["+i+"]/div[@class='single-action-flags']/input[2]"));

		
	}
	
	protected WebElement getAMatchActionGameChangingICon(int i){
		if (i>=getMatchActions().size()){
			throw new IllegalArgumentException();
		}
		
	return	webDriver.findElement(By.xpath("(//div[@class='match-action'])["+i+"]/div[@class='single-action-flags']/input[3]"));

		
	}
	
	
	
	
	

}
