package cucumber.msdc.pages.utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.msdc.pages.models.MatchSummaryPageElements;

/**
 * @author Shahnaaz Rahamatullah
 * @version 1.0
 */
public class MatchSummaryPage extends MatchSummaryPageElements {

	public MatchSummaryPage(WebDriver webDriver, String url) {
		super(webDriver, url);
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
}