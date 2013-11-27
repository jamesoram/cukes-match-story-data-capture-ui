package cucumber.msdc.pages.models;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Shahnaaz Rahamatullah
 * @version 1.0
 */
public class MatchSummaryPageElements extends KeyElements {

	private static final String MATCH_SUMMARY_PAGE_ELEMENT_IDENTIFIER = "elementidentifier//matchsummarypage.properties";
	private int actionNo;

	protected MatchSummaryPageElements(WebDriver driver, String url){
		super(driver,MATCH_SUMMARY_PAGE_ELEMENT_IDENTIFIER);
		driver.get(url);	

		try {
			driver.findElements(By.xpath(elementIdentifier.getString("matchaction")));
		} catch (NoSuchElementException e) {
			throw new AssertionError("the element is not loaded");

		}
    }
	
	protected MatchSummaryPageElements(WebDriver driver){
		super(driver,MATCH_SUMMARY_PAGE_ELEMENT_IDENTIFIER);
    }
	
	private List<WebElement> getMatchActions(){
	return	driver.findElements(By.xpath(elementIdentifier.getString("matchaction")));
	}
	
	protected List<WebElement> getMatchActionExclamationIcons(){
		return driver.findElements(By.xpath(elementIdentifier.getString("exclamationicon")));
	}
	
	protected List<WebElement> getMatchActionFavouriteIcons(){
		return driver.findElements(By.xpath(elementIdentifier.getString("favouriteicon")));
	}
	
	protected List<WebElement> getMatchActionGameChangingIcons(){
		return driver.findElements(By.xpath(elementIdentifier.getString("gamechangingicon")));

	}

	protected WebElement getAMatchActionExclamationICon(int i) {
		if (i >= getMatchActions().size()) {
			throw new IllegalArgumentException();
		}
		
	    return	driver.findElement(By.xpath(
                "(//div[@class='match-action'])["+i+"]/div[@class='single-action-flags']/input[1]"));
	}

	protected WebElement getAMatchActionFavouriteICon(int i) {
		if (i >= getMatchActions().size()) {
			throw new IllegalArgumentException();
		}
    	return	driver.findElement(By.xpath("(//div[@class='match-action'])["+i+"]/div[@class='single-action-flags']/input[2]"));
	}

	protected WebElement getAMatchActionGameChangingICon(int i) {
		if (i >= getMatchActions().size()) {
			throw new IllegalArgumentException();
		}
		
	    return	driver.findElement(By.xpath("(//div[@class='match-action'])["+i+"]/div[@class='single-action-flags']/input[3]"));
	}

	protected int getActionNo() {

		return actionNo;
	}

	protected void setActionNo(int actionNo) {

		this.actionNo = actionNo;
	}

	protected WebElement getActionForYellowCard(int actionNo) throws NoSuchElementException {
		setActionNo(actionNo);
	    return driver.findElement(By.xpath(
                "(//div[@class='match-action']/div[@class='action-icon booking'])[position()=" + getActionNo() + "]"));

	}

	protected WebElement getActionForRedCard(int actionNo) {
		setActionNo(actionNo);
		return driver
					.findElement(By
							.xpath("(//div[@class='match-action']/div[@class='action-icon dismissal'])[position()="
									+ getActionNo() + "]"));
	}

	protected WebElement getActionForGoalFromPenalty(int actionNo) {
		setActionNo(actionNo);
			return driver
					.findElement(By
							.xpath("(//div[@class='match-action']/div[@class='action-icon goal-from-penalty'])[position()="
									+ getActionNo() + "]"));
	}

	protected WebElement getActionForGoal(int actionNo) {
		setActionNo(actionNo);
		return driver
		    .findElement(By
			    .xpath("(//div[@class='match-action']/div[@class='action-icon goal'])[position()="
			    + getActionNo() + "]"));

	}

	protected WebElement getActionForOwnGoal(int actionNo) {
		setActionNo(actionNo);
		return driver
    		.findElement(By
			    .xpath("(//div[@class='match-action']/div[@class='action-icon own-goal'])[position()="
	        	+ getActionNo() + "]"));
	}

	protected WebElement getActionForGoalFromPenaltyShootOut(int actionNo) {
		setActionNo(actionNo);
		return driver
					.findElement(By
							.xpath("(//div[@class='match-action']/div[@class='action-icon shootoutgoal'])[position()="
									+ getActionNo() + "]"));
	}

	protected WebElement getHomeTeam() {
		return driver
				.findElement(By
						.xpath("//div[@class='header']/div[@class='teams']/div[@class='home-team ng-binding']"));

	}

	protected WebElement getAwayTeam() {
		return driver
				.findElement(By
						.xpath("//div[@class='header']/div[@class='teams']/div[@class='away-team ng-binding']"));

	}

	protected WebElement getScoreElement() {
		return driver
				.findElement(By
						.xpath("//div[@class='header']/div[@class='teams']/div[@class='score ng-binding']"));

	}

	protected WebElement getHomeTeamImage() {
		return driver
				.findElement(By
						.xpath("//div[@class='header']/div[@class='home-badge']/img[@class='club-badge']"));
	}

	protected WebElement getAwayTeamImage() {
		return driver
				.findElement(By
						.xpath("//div[@class='header']/div[@class='away-badge']/img[@class='club-badge']"));
	}

	protected List<WebElement> getDurationElementForEachAction() {
		return driver
				.findElements(By
						.xpath("//div[@class='match-action']/div[@class='time']/span[@class='normal-time ng-binding']"));
	}
}