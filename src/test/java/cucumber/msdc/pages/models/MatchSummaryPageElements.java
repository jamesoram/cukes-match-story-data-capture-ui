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
	private int actionNo;
	
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
	
	protected int getActionNo(){
		
		return actionNo;
	}
	
	protected void setActionNo(int actionNo){
		
		this.actionNo=actionNo;
	}
	
	protected WebElement getActionForYellowCard(int actionNo){
		setActionNo(actionNo);
		try{return  webDriver.findElement(By.xpath("(//div[@class='match-action']/div[@class='action-icon booking'])[position()="+getActionNo()+"]"));
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		return null;
	}
	
	protected WebElement getActionForRedCard(int actionNo){
		setActionNo(actionNo);
		try{return  webDriver.findElement(By.xpath("(//div[@class='match-action']/div[@class='action-icon dismissal'])[position()="+getActionNo()+"]"));
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		return null;
	}
	
	protected WebElement getActionForGoalFromPenalty(int actionNo){
		
				setActionNo(actionNo);
				try{return  webDriver.findElement(By.xpath("(//div[@class='match-action']/div[@class='action-icon goal-from-penalty'])[position()="+getActionNo()+"]"));
				}
				catch(NoSuchElementException e){
					e.printStackTrace();
				}
				return null;
	}
	
	protected WebElement getActionForGoal(int actionNo) {
		setActionNo(actionNo);
		try{return  webDriver.findElement(By.xpath("(//div[@class='match-action']/div[@class='action-icon goal'])[position()="+getActionNo()+"]"));
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		return null;
	}
	
	protected WebElement getActionForOwnGoal(int actionNo) {
		setActionNo(actionNo);
		try{return  webDriver.findElement(By.xpath("(//div[@class='match-action']/div[@class='action-icon own-goal'])[position()="+getActionNo()+"]"));
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		return null;
	}
	
	protected WebElement getActionForGoalFromPenaltyShootOut(int actionNo) {
		setActionNo(actionNo);
		try{return  webDriver.findElement(By.xpath("(//div[@class='match-action']/div[@class='action-icon shootoutgoal'])[position()="+getActionNo()+"]"));
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		return null;
	}
	
	protected WebElement getHomeTeam(){
		return webDriver.findElement(By.xpath("//div[@class='header']/div[@class='teams']/div[@class='home-team ng-binding']"));
		
	}
	
	protected WebElement getAwayTeam(){
		return webDriver.findElement(By.xpath("//div[@class='header']/div[@class='teams']/div[@class='away-team ng-binding']"));
		
	}
	
	protected WebElement getScoreElement(){
		return webDriver.findElement(By.xpath("//div[@class='header']/div[@class='teams']/div[@class='score ng-binding']"));
		
	}
	
	protected WebElement getHomeTeamImage(){
		return webDriver.findElement(By.xpath("//div[@class='header']/div[@class='home-badge']/img[@class='club-badge']"));
	}

	protected WebElement getAwayTeamImage(){
		return webDriver.findElement(By.xpath("//div[@class='header']/div[@class='away-badge']/img[@class='club-badge']"));
	}
}
