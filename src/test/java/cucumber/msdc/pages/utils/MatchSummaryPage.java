package cucumber.msdc.pages.utils;

import java.util.List;
import java.util.NoSuchElementException;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.msdc.pages.models.MatchSummaryPageElements;

/**
 * @author Shahnaaz Rahamatullah
 * @version 1.0
 */
public class MatchSummaryPage extends MatchSummaryPageElements {

	public MatchSummaryPage(WebDriver webDriver, String url) {
		super(webDriver, url);

	}

	public MatchSummaryPage(WebDriver webDriver) {
		super(webDriver);

	}

	public Boolean isExclamationIconGreyedOut() {
		return isIconGreyedOut(getMatchActionExclamationIcons());
	}

	public Boolean isFavouriteIconGreyedOut() {
		return isIconGreyedOut(getMatchActionFavouriteIcons());
	}
	
	public Boolean isGameChangingIconGreyedOut() {
		return isIconGreyedOut(getMatchActionGameChangingIcons());
	}

	private Boolean isIconGreyedOut(List<WebElement> Icons) {
		for (WebElement icon : Icons) {
			//String Color = icon.getCssValue("color");
			//String outerColor = icon.getCssValue("outline-color");
			String backgroundPosition =	icon.getCssValue("background-position");
		//	if ((!Color.equals("rgba(0, 0, 0, 1)"))	&& (!outerColor.equals("rgba(0, 0, 0, 1)")) ) {
			if (!backgroundPosition.equals("4px -116px")){
				return false;
			}
		}
		return true;

	}

	
	
	public MatchSummaryPage clickMatchActionExclamationICon(int i) {
		
		new Actions(webDriver).moveToElement(getAMatchActionExclamationICon(i)).click().perform();
		return this;
	}
	
	public String getColorForMatchActionExclamationIcon(int i){
		
			return getAMatchActionExclamationICon(i).getAttribute("class");
		
	}
	public String getBackGroundPositionForMatchActionExclamationIcon(int i){
		
		return getAMatchActionExclamationICon(i).getCssValue("background-position");
		
			
		}
	
public MatchSummaryPage clickMatchActionFavouriteICon(int i) {
		
		new Actions(webDriver).moveToElement(getAMatchActionExclamationICon(i)).click().perform();
		return this;
	}
	
	public String getColorForMatchActionFavouriteIcon(int i){
		
			return getAMatchActionExclamationICon(i).getAttribute("class");
		
	}
	public String getBackGroundPositionForMatchActionFavouriteIcon(int i){
		
		return getAMatchActionExclamationICon(i).getCssValue("background-position");
		
			
		}
	
public MatchSummaryPage clickMatchActionGameChangingICon(int i) {
		
		new Actions(webDriver).moveToElement(getAMatchActionGameChangingICon(i)).click().perform();
		return this;
	}
	
	public String getColorForMatchActionGameChangingIcon(int i){
		
			return getAMatchActionGameChangingICon(i).getAttribute("class");
		
	}
	public String getBackGroundPositionForMatchActionGameChangingIcon(int i){
		
		return getAMatchActionGameChangingICon(i).getCssValue("background-position");
		
			
		}

	
	
}
