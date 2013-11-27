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
	
	for (WebElement icon : getMatchActionExclamationIcons()) {
			
			String backgroundPosition =	icon.getCssValue("background-position");
		
			if ( !backgroundPosition.equals("4px -116px")){
				return false;
			}
		}
		return true;
	}

	public Boolean isFavouriteIconGreyedOut() {
	
for (WebElement icon : getMatchActionFavouriteIcons()) {
			
			String backgroundPosition =	icon.getCssValue("background-position");
		
			if ( !backgroundPosition.equals("4px -176px")){
				return false;
			}
		}
		return true;
	}
	
	public Boolean isGameChangingIconGreyedOut() {
	
		for (WebElement icon : getMatchActionGameChangingIcons()) {
			
			String backgroundPosition =	icon.getCssValue("background-position");
		
			if ( !backgroundPosition.equals("4px -296px")){
				return false;
			}
		}
		return true;
	}

	private Boolean isIconGreyedOut(List<WebElement> Icons) {
		for (WebElement icon : Icons) {
			//String Color = icon.getCssValue("color");
			//String outerColor = icon.getCssValue("outline-color");
			String backgroundPosition =	icon.getCssValue("background-position");
		//	if ((!Color.equals("rgba(0, 0, 0, 1)"))	&& (!outerColor.equals("rgba(0, 0, 0, 1)")) ) {
			if ( !backgroundPosition.equals("4px -296px")){
				return false;
			}
		}
		return true;

	}

	
	
	public MatchSummaryPage clickMatchActionExclamationICon(int i) {
		
		new Actions(driver).moveToElement(getAMatchActionExclamationICon(i)).click().perform();
		return this;
	}
	
	public String getColorForMatchActionExclamationIcon(int i){
		
			return getAMatchActionExclamationICon(i).getAttribute("class");
		
	}
	public String getBackGroundPositionForMatchActionExclamationIcon(int i){
		
		return getAMatchActionExclamationICon(i).getCssValue("background-position");
		
			
		}
	
public MatchSummaryPage clickMatchActionFavouriteICon(int i) {
		
		new Actions(driver).moveToElement(getAMatchActionFavouriteICon(i)).click().perform();
		return this;
	}
	
	public String getColorForMatchActionFavouriteIcon(int i){
		
			return getAMatchActionExclamationICon(i).getAttribute("class");
		
	}
	public String getBackGroundPositionForMatchActionFavouriteIcon(int i){
		
		return getAMatchActionFavouriteICon(i).getCssValue("background-position");
		
			
		}
	
public MatchSummaryPage clickMatchActionGameChangingICon(int i) {
		
		new Actions(driver).moveToElement(getAMatchActionGameChangingICon(i)).click().perform();
		return this;
	}
	
	public String getColorForMatchActionGameChangingIcon(int i){
		
			return getAMatchActionGameChangingICon(i).getAttribute("class");
		
	}
	public String getBackGroundPositionForMatchActionGameChangingIcon(int i){
		
		return getAMatchActionGameChangingICon(i).getCssValue("background-position");
		
			
		}

public int getActionNo(){
		
		return super.getActionNo();
	}
	
public void setActionNo(int actionNo){
		
		super.setActionNo(actionNo);
	}

public Boolean isYellowCardDisplayedForAction(int actionNo){
	if (!(getActionForYellowCard(actionNo)==null)){
		return true;
	}
	return false;
} 

public Boolean isRedCardDisplayedForAction(int actionNo){
	if (!(getActionForRedCard(actionNo)==null)){
		return true;
	}
	return false;
} 


public Boolean isGoalIconDisplayedForGoalFromPenaltyAction(int actionNo) {
	
	if (!(getActionForGoalFromPenalty(actionNo)==null)){
		return true;
	}
	return false;
}



public Boolean isGoalIconDisplayedForGoalAction(int actionNo) {
	
	if (!(getActionForGoal(actionNo)==null)){
		return true;
	}
	return false;
}



public Boolean isGoalIconDisplayedForOwnGoalAction(int actionNo) {
	
	if (!(getActionForOwnGoal(actionNo)==null)){
		return true;
	}
	return false;
}

public Boolean isGoalIconDisplayedForGoalFromPenaltyShootOutAction(int actionNo) {
	
	if (!(getActionForGoalFromPenaltyShootOut(actionNo)==null)){
		return true;
	}
	return false;
}

public String getHomeTeamName(){
	return getHomeTeam().getText();
	
}

public String getAwayTeamName(){
	return getAwayTeam().getText();
	
}

public String getScore(){
	return getScoreElement().getText();
	
}

public String getSrcForHomeTeam(){
	return getHomeTeamImage().getAttribute("src");
}

public String getHeightForHomeTeam(){
	return getHomeTeamImage().getAttribute("height");
}

public String getWidthForHomeTeam(){
	return getHomeTeamImage().getAttribute("width");
}

public String getSrcForAwayTeam(){
	return getAwayTeamImage().getAttribute("src");
}

public String getHeightForAwayTeam(){
	return getAwayTeamImage().getAttribute("height");
}

public String getWidthForAwayTeam(){
	return getAwayTeamImage().getAttribute("width");
}

}
