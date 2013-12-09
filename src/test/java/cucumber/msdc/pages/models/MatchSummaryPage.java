package cucumber.msdc.pages.models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.google.common.base.Strings;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * @author Shahnaaz Rahamatullah
 * @version 1.0
 */
public class MatchSummaryPage extends AbstractViewPage {

    @FindBy(css = ".teams")
    private WebElement teamsDiv;

    @CacheLookup
    @FindBy(css = ".back>a")
    private WebElement backButton;

    @FindBy(xpath = "//div[@class='match-action'][1]/div/input[@class='delete']")
    private WebElement firstDeleteButton;

    @FindBy(id = "play")
    private WebElement playButton;

    @FindBy(id = "normal-time")
    private WebElement timer;

    @FindBy(id = "time")
    private WebElement timerDiv;

    @CacheLookup
    @FindBy(id = "forward")
    private WebElement forwardButton;

    @FindBy(css = ".current-action>.time>span")
    private WebElement currentActionTime;

    @CacheLookup
    @FindBy(id = "rewind")
    private WebElement rewindButton;

    @FindBy(id = "match-start")
    private WebElement kickOffDiv;

	private static final String MATCH_SUMMARY_PAGE_ELEMENT_IDENTIFIER = "elementidentifier//matchsummarypage.properties";
	private int actionNo;

	protected MatchSummaryPage(WebDriver driver, String url){
		super(driver, MATCH_SUMMARY_PAGE_ELEMENT_IDENTIFIER);
    }
	
	public  MatchSummaryPage(WebDriver driver){
		super(driver,MATCH_SUMMARY_PAGE_ELEMENT_IDENTIFIER);
    }

    public boolean isPageLoaded() {
        try {
            return teamsDiv.isDisplayed();
        } catch (Exception e) {
            return false;
        }
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

	public void setActionNo(int actionNo) {

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

    public Boolean isExclamationIconGreyedOut() {
        return doAllBackgroundsEqualCss(getMatchActionExclamationIcons(), "4px -116px");
    }

    public Boolean isFavouriteIconGreyedOut() {
        return doAllBackgroundsEqualCss(getMatchActionFavouriteIcons(), "4px -176px");
    }

    public Boolean isGameChangingIconGreyedOut() {
        return doAllBackgroundsEqualCss(getMatchActionGameChangingIcons(), "4px -296px");
    }

    private Boolean isIconGreyedOut(List<WebElement> icons) {
        return doAllBackgroundsEqualCss(icons, "4px -296px");
    }

    private boolean doAllBackgroundsEqualCss(List<WebElement> elements, String expectedValue) {
        for (WebElement element : elements) {
            String cssValue = element.getCssValue("background-position");
            if (!cssValue.equals(expectedValue)) {
                return false;
            }
        }
        return true;
    }

    public MatchSummaryPage clickMatchActionExclamationICon(int i) {
        new Actions(driver).moveToElement(getAMatchActionExclamationICon(i))
                .click().perform();
        return this;
    }

    public String getColorForMatchActionExclamationIcon(int i) {
        return getAMatchActionExclamationICon(i).getAttribute("class");

    }

    public String getBackGroundPositionForMatchActionExclamationIcon(int i) {
        return getAMatchActionExclamationICon(i).getCssValue(
                "background-position");

    }

    public MatchSummaryPage clickMatchActionFavouriteICon(int i) {
        new Actions(driver).moveToElement(getAMatchActionFavouriteICon(i))
                .click().perform();
        return this;
    }

    public String getColorForMatchActionFavouriteIcon(int i) {
        return getAMatchActionExclamationICon(i).getAttribute("class");

    }

    public String getBackGroundPositionForMatchActionFavouriteIcon(int i) {
        return getAMatchActionFavouriteICon(i).getCssValue(
                "background-position");

    }

    public MatchSummaryPage clickMatchActionGameChangingICon(int i) {
        new Actions(driver)
                .moveToElement(getAMatchActionGameChangingICon(i)).click()
                .perform();
        return this;
    }

    public String getColorForMatchActionGameChangingIcon(int i) {

        return getAMatchActionGameChangingICon(i).getAttribute("class");

    }

    public String getBackGroundPositionForMatchActionGameChangingIcon(int i) {

        return getAMatchActionGameChangingICon(i).getCssValue(
                "background-position");

    }

    public Boolean isYellowCardDisplayedForAction(int actionNo) {
        return !(getActionForYellowCard(actionNo) == null);
    }

    public Boolean isRedCardDisplayedForAction(int actionNo) {
        return !(getActionForRedCard(actionNo) == null);
    }

    public Boolean isGoalIconDisplayedForGoalFromPenaltyAction(int actionNo) {
        return !(getActionForGoalFromPenalty(actionNo) == null);
    }

    public Boolean isGoalIconDisplayedForGoalAction(int actionNo) {
        return !(getActionForGoal(actionNo) == null);
    }

    public Boolean isGoalIconDisplayedForOwnGoalAction(int actionNo) {
        return !(getActionForOwnGoal(actionNo) == null);
    }

    public Boolean isGoalIconDisplayedForGoalFromPenaltyShootOutAction(
            int actionNo) {
        return !(getActionForGoalFromPenaltyShootOut(actionNo) == null);
    }

    public String getHomeTeamName() {
        return getHomeTeam().getText();

    }

    public String getAwayTeamName() {
        return getAwayTeam().getText();

    }

    public String getScore() {
        return getScoreElement().getText();

    }

    public String getSrcForHomeTeam() {
        return getHomeTeamImage().getAttribute("src");
    }

    public String getHeightForHomeTeam() {
        return getHomeTeamImage().getAttribute("height");
    }

    public String getWidthForHomeTeam() {
        return getHomeTeamImage().getAttribute("width");
    }

    public String getSrcForAwayTeam() {
        return getAwayTeamImage().getAttribute("src");
    }

    public String getHeightForAwayTeam() {
        return getAwayTeamImage().getAttribute("height");
    }

    public String getWidthForAwayTeam() {
        return getAwayTeamImage().getAttribute("width");
    }

    public List<String> getTimeDurationForEachAction() {
        List<String> durations = new ArrayList();
        int index = 0;
        for (WebElement duration : getDurationElementForEachAction()) {
            durations.add(index, duration.getText());
            index++;
        }
        return durations;

    }

    public Boolean areActionsDisplayedInDecendingOrderOfTimeDuration()
            throws ParseException {
        PeriodFormatter formatter = new PeriodFormatterBuilder()
                .appendMinutes().appendSeparator(":").appendSeconds()
                .toFormatter();

        List<String> durations = getTimeDurationForEachAction();

        for (int i = 0; i < durations.size() - 1; i++) {

            String str1 = durations.get(i);
            String str2 = durations.get(i + 1);

            Period period1 = formatter.parsePeriod(str1);
            Period period2 = formatter.parsePeriod(str2);

            Duration duration1 = period1.toStandardDuration();
            Duration duration2 = period2.toStandardDuration();

            if (!((duration1.isLongerThan(duration2) || (duration1
                    .isEqual(duration2))))) {
                return false;
            }

        }
        return true;
    }

    public HomePage clickBackButton() {
        backButton.click();
        return new HomePage(driver);
    }

    public MatchSummaryPage clickPlayButton() {
        wait.forElementVisible(firstDeleteButton);
        playButton.click();
        return this;
    }

    public MatchSummaryPage clickPauseButton() {
        return clickPlayButton();
    }

    public boolean isTimerStopped() {
        String time = timer.getText();
        // incredible - a legitimate use of wait.sleep!
        wait.sleep(1500);
        return time.equals(timer.getText());
    }

    public boolean isTimerPaused() {
        try {
            return timerDiv.getAttribute("class").contains("paused");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPlayButtonVisible() {
        try {
            // when the class name is "pause", it means it's showing the pause icon
            return !playButton.getAttribute("class").equals("pause");
        } catch (Exception e) {
            // if there is no class name it means play is being shown
            return true;
        }
    }

    public MatchSummaryPage clickForwardButton() {
        wait.forElementVisible(firstDeleteButton);
        forwardButton.click();
        return this;
    }

    public boolean isLastActionAtEndOfMatch() {
        try {
            // we assume that minute 90 or more is the last action
            return currentActionTime.getText().contains("90:00");
        } catch (Exception failed) {
            return false;
        }
    }

    public MatchSummaryPage clickRewindButton() {
        wait.forElementVisible(firstDeleteButton);
        rewindButton.click();
        return this;
    }

    public boolean isKickOffMessageVisible() {
        try {
            return kickOffDiv.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTimerSetTo(String minutes, String seconds) {
        try {
            String[] time = getTimerArray(timer.getText());
            return time[1].contains(minutes) && time[0].contains(seconds);
        } catch (Exception e) {
            return false;
        }
    }

    private String[] getTimerArray(String time) {
        String[] times = time.split(":");
        times[0].replace(":", "");
        return times;
    }
}