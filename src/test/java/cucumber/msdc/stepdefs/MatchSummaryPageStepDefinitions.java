package cucumber.msdc.stepdefs;

import static org.junit.Assert.*;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.msdc.TitleBar;
import cucumber.msdc.pages.models.HomePage;
import cucumber.msdc.pages.models.LoginPage;
import cucumber.msdc.pages.models.MatchSummaryPage;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Shahnaaz Rahamatullah
 * @version 1.0
 */
public class MatchSummaryPageStepDefinitions extends AbstractSteps {

	private MatchSummaryPage matchSummaryPage;

    @Before
    public void before() {
        setUp();
        goToHomePage();
        homePage = new LoginPage(driver).login("", "");
    }

    @After
    public void after() {
        tearDown();
    }

    @Given("^I have the following selection:$")
    public void I_have_the_following_selection(DataTable dataTable) throws Throwable {
        List<Map<String, String>> strings = dataTable.asMaps();
        for (Map<String, String> map : strings) {
            homePage.selectCompetition(map.get("Competition"));
            homePage.enterDateInMatchDatePicker(map.get("Date"));
        }
    }

	@Given("^I am on the summary page for a particular match \"([^\"]*)\"$")
	public void I_am_on_the_summary_page_for_a_particular_match(String matchId)
			throws Throwable {
		matchSummaryPage = new MatchSummaryPage(driver);
	}

	@Then("^I should see the actions list displayed in descending order of time$")
	public void I_should_see_the_actions_list_displayed_in_descending_order_of_time()
			throws Throwable {

		assertTrue("the actions list is not in descending order of time",
				matchSummaryPage
						.areActionsDisplayedInDecendingOrderOfTimeDuration());
	}

	@Then("^I should see an exclamation icon for each action displayed and greyed out by default$")
	public void I_should_see_an_exclamation_icon_for_each_action_displayed_and_greyed_out_by_default()
			throws Throwable {
		assertTrue(
				"not all exclamation icons which needs to be greyed out are greyed out",
				matchSummaryPage.isExclamationIconGreyedOut());

	}

	@When("^I select the exclamation icon for a particular action in the match$")
	public void I_select_the_exclamation_icon_for_a_particular_action_in_the_match()
			throws Throwable {

		assertEquals("the color is not grey", "4px -116px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionExclamationIcon(5));
		assertEquals("the color is not grey", "quality",
				matchSummaryPage.getColorForMatchActionExclamationIcon(5));
		matchSummaryPage.clickMatchActionExclamationICon(5);
	}

	@Then("^I should see that the exclamation icon is highlighted in red$")
	public void I_should_see_that_the_exclamation_icon_is_highlighted_in_red()
			throws Throwable {
		Thread.sleep(1000);
		assertEquals("the color is not red", "-56px -116px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionExclamationIcon(5));
		assertEquals("the color is not red", "quality flagged",
				matchSummaryPage.getColorForMatchActionExclamationIcon(5));
		matchSummaryPage.clickMatchActionExclamationICon(5);

	}

	@Given("^an exclamation icon for a particular action already selected$")
	public void an_exclamation_icon_for_a_particular_action_already_selected()
			throws Throwable {
		matchSummaryPage.clickMatchActionExclamationICon(5);
		Thread.sleep(1000);
		assertEquals("the color is not red", "-56px -116px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionExclamationIcon(5));
		assertEquals("the color is not red", "quality flagged",
				matchSummaryPage.getColorForMatchActionExclamationIcon(5));
	}

	@When("^I select the exclamation icon again$")
	public void I_select_the_exclamation_icon_again() throws Throwable {
		Thread.sleep(1000);
		matchSummaryPage.clickMatchActionExclamationICon(5);
	}

	@Then("^I should see that the exclamation icon is greyed out$")
	public void I_should_see_that_the_exclamation_icon_is_greyed_out()
			throws Throwable {
		Thread.sleep(1000);
		assertEquals("the color is not grey", "4px -116px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionExclamationIcon(5));
		assertEquals("the color is not grey", "quality",
				matchSummaryPage.getColorForMatchActionExclamationIcon(5));
	}

	@Then("^I should see an favourite icon for each action displayed and greyed out by default$")
	public void I_should_see_an_favourite_icon_for_each_action_displayed_and_greyed_out_by_default()
			throws Throwable {
		assertTrue(
				"not all favourite icons which needs to be greyed out are greyed out",
				matchSummaryPage.isFavouriteIconGreyedOut());
	}

	@When("^I select the favourite icon for a particular action in the match$")
	public void I_select_the_favourite_icon_for_a_particular_action_in_the_match()
			throws Throwable {
		assertEquals("the color is not grey", "4px -176px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionFavouriteIcon(5));
		assertEquals("the color is not grey", "key-action",
				matchSummaryPage.getColorForMatchActionFavouriteIcon(5));
		matchSummaryPage.clickMatchActionFavouriteICon(5);
	}

	@Then("^I should see that the favourite icon is highlighted in yellow$")
	public void I_should_see_that_the_favourite_icon_is_highlighted_in_red()
			throws Throwable {
		Thread.sleep(1000);
		assertEquals("the color is not yellow", "-56px -176px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionFavouriteIcon(5));
		assertEquals("the color is not red", "key-action flagged",
				matchSummaryPage.getColorForMatchActionFavouriteIcon(5));
		matchSummaryPage.clickMatchActionFavouriteICon(5);
	}

	@Given("^an favourite icon for a particular action already selected$")
	public void an_favourite_icon_for_a_particular_action_already_selected()
			throws Throwable {
		matchSummaryPage.clickMatchActionFavouriteICon(5);
		Thread.sleep(1000);
		assertEquals("the color is not yellow", "-56px -176px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionFavouriteIcon(5));
		assertEquals("the color is not yellow", "key-action flagged",
				matchSummaryPage.getColorForMatchActionFavouriteIcon(5));
	}

	@When("^I select the favourite icon again$")
	public void I_select_the_favourite_icon_again() throws Throwable {
		Thread.sleep(1000);
		matchSummaryPage.clickMatchActionFavouriteICon(5);
	}

	@Then("^I should see that the favourite icon is greyed out$")
	public void I_should_see_that_the_favourite_icon_is_greyed_out()
			throws Throwable {
		Thread.sleep(1000);
		assertEquals("the color is not grey", "4px -176px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionFavouriteIcon(5));
		assertEquals("the color is not grey", "key-action",
				matchSummaryPage.getColorForMatchActionFavouriteIcon(5));
	}

	@Then("^I should see a game changing event flag for each action displayed and greyed out by default$")
	public void I_should_see_a_circle_game_changing_event_flag_icon_for_each_action_displayed_and_greyed_out_by_default()
			throws Throwable {
		assertTrue(
				"not all gamechanging icons which needs to be greyed out are greyed out",
				matchSummaryPage.isGameChangingIconGreyedOut());
	}

	@Then("^I should see that the game changing event flag is highlighted in red$")
	public void I_should_see_that_the_circle_game_changing_event_flag_icon_is_highlighted_in_red()
			throws Throwable {
		Thread.sleep(1000);
		assertEquals("the color is not red", "-56px -296px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionGameChangingIcon(5));
		assertEquals("the color is not red", "impact flagged",
				matchSummaryPage.getColorForMatchActionGameChangingIcon(5));
		matchSummaryPage.clickMatchActionGameChangingICon(5);
	}

	@Given("^a game changing event flag for a particular action already selected$")
	public void a_circle_game_changing_event_flag_icon_for_a_particular_action_already_selected()
			throws Throwable {
		matchSummaryPage.clickMatchActionGameChangingICon(5);
		Thread.sleep(1000);
		assertEquals("the color is not red", "-56px -296px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionGameChangingIcon(5));
		assertEquals("the color is not red", "impact flagged",
				matchSummaryPage.getColorForMatchActionGameChangingIcon(5));

	}

	@When("^I select the game changing event flag again$")
	public void I_select_the_circle_game_changing_event_flag_icon_again()
			throws Throwable {
		Thread.sleep(1000);
		matchSummaryPage.clickMatchActionGameChangingICon(5);

	}

	@Then("^I should see that the game changing event flag greyed out$")
	public void I_should_see_that_the_circle_game_changing_event_flag_icon_greyed_out()
			throws Throwable {
		Thread.sleep(1000);
		assertEquals("the color is not grey", "4px -296px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionGameChangingIcon(5));
		assertEquals("the color is not grey", "impact",
				matchSummaryPage.getColorForMatchActionGameChangingIcon(5));
	}

	@When("^I select the game changing event flag for a particular action in the match$")
	public void I_select_the_circle_game_changing_event_flag_icon_for_a_particular_action_in_the_match()
			throws Throwable {

		assertEquals("the color is not grey", "4px -296px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionGameChangingIcon(5));
		assertEquals("the color is not grey", "impact",
				matchSummaryPage.getColorForMatchActionGameChangingIcon(5));
		matchSummaryPage.clickMatchActionGameChangingICon(5);
	}

	@Given("^a player has got a yellow card$")
	public void a_player_has_got_a_yellow_card() throws Throwable {

		matchSummaryPage.setActionNo(1);
	}

	@Then("^I should see a yellow card icon displayed for that particular action$")
	public void I_should_see_a_yellow_card_icon_displayed_for_that_particular_action()
			throws Throwable {
		assertTrue("yellow card does not exist",
				matchSummaryPage.isYellowCardDisplayedForAction(1));
	}

	@Given("^a player has got a red card$")
	public void a_player_has_got_a_red_card() throws Throwable {
		matchSummaryPage.setActionNo(1);
	}

	@Then("^I should see a red card icon displayed for that particular action$")
	public void I_should_see_a_red_card_icon_displayed_for_that_particular_action()
			throws Throwable {
		assertTrue("red card does not exist",
				matchSummaryPage.isRedCardDisplayedForAction(1));
	}

	@Given("^a player has scored a goal from penalty action$")
	public void a_player_has_scored_a_goal_from_penalty_action()
			throws Throwable {
		matchSummaryPage.setActionNo(1);
	}

	@Then("^I should see a football icon for the goal from penalty action$")
	public void I_should_see_a_football_icon_for_the_goal_from_penalty_action()
			throws Throwable {
		assertTrue("red card does not exist",
				matchSummaryPage.isGoalIconDisplayedForGoalFromPenaltyAction(1));
	}

	@Given("^a player has scored a goal action$")
	public void a_player_has_scored_a_goal_action() throws Throwable {
		matchSummaryPage.setActionNo(1);
	}

	@Then("^I should see a football icon for the goal action$")
	public void I_should_see_a_football_icon_for_the_goal_action()
			throws Throwable {
		assertTrue("red card does not exist",
				matchSummaryPage.isGoalIconDisplayedForGoalAction(1));
	}

	@Given("^a player has scored a goal from penalty shootout action$")
	public void a_player_has_scored_a_goal_from_penalty_shootout_action()
			throws Throwable {
		matchSummaryPage.setActionNo(1);
	}

	@Then("^I should see a football icon for the penalty shootout action$")
	public void I_should_see_a_football_icon_for_the_penalty_shootout_action()
			throws Throwable {
		assertTrue("red card does not exist",
				matchSummaryPage
						.isGoalIconDisplayedForGoalFromPenaltyShootOutAction(1));
	}

	@Given("^a player has scored an own goal$")
	public void a_player_has_scored_an_own_goal() throws Throwable {
		matchSummaryPage.setActionNo(1);
	}

	@Then("^I should see a football icon for the own goal action$")
	public void I_should_see_a_football_icon_for_the_own_goal_action()
			throws Throwable {
		assertTrue("red card does not exist",
				matchSummaryPage.isGoalIconDisplayedForOwnGoalAction(1));
	}

	@Then("^I should see the following details in the title bar:$")
	public void I_should_see_the_following_details_in_the_title_bar(
			DataTable expectedTitleBar) throws Throwable {

		List<TitleBar> actualTitleBar = new ArrayList();
		actualTitleBar.add(new TitleBar(matchSummaryPage.getHomeTeamName(),
				matchSummaryPage.getAwayTeamName(),
				matchSummaryPage.getScore(), matchSummaryPage
						.getSrcForHomeTeam(), matchSummaryPage
						.getHeightForHomeTeam(), matchSummaryPage
						.getWidthForHomeTeam(), matchSummaryPage
						.getSrcForAwayTeam(), matchSummaryPage
						.getHeightForAwayTeam(), matchSummaryPage
						.getWidthForAwayTeam()));
		expectedTitleBar.diff(actualTitleBar);

	}

    @When("^I click on right arrow button for a match$")
    public void I_click_on_right_arrow_button_for_a_match() {
        homePage.clickFirstMatchArrow();
    }

    @Then("^I should be taken to the match summary page$")
    public void I_should_be_taken_to_the_match_summary_page() {
        Assert.assertTrue(new MatchSummaryPage(driver).isPageLoaded());
    }

    @When("^I see the list of matches$")
    public void I_see_the_list_of_matches() throws Throwable {
        // this step requires no code
    }

    @Then("^the right arrow button is not seen$")
    public void the_right_arrow_button_is_not_seen() throws Throwable {
        Assert.assertFalse(new HomePage(driver).isFirstMatchButtonVisible());
    }

    @Given("^I am on the match summary page$")
    public void I_am_on_the_match_summary_page() {
       matchSummaryPage = new HomePage(driver).clickFirstMatchArrow();
    }

    @Given("^I am on match summary page$")
    public void I_am_on_match_summary_page() {
        I_am_on_the_match_summary_page();
    }

    @When("^I click on back button$")
    public void I_click_on_back_button() {
        matchSummaryPage.clickBackButton();
    }

    @Then("^I should be on the home page$")
    public void should_be_on_home_page() {
        Assert.assertTrue(new HomePage(driver).isPageLoaded());
    }

    @Given("^I click on the play button$")
    public void I_click_on_play_button() {
        matchSummaryPage.clickPlayButton();
    }

    @When("^I click on the pause button$")
    public void I_click_on_pause_button() {
        matchSummaryPage.clickPauseButton();
    }

    @Then("^the timer should stop ticking$")
    public void timer_should_stop_ticking() {
        Assert.assertTrue(new MatchSummaryPage(driver).isTimerStopped());
    }

    @Then("^time stamp is correctly displayed in yellow$")
    public void time_stamp_is_correctly_displayed_in_yellow() {
        Assert.assertTrue(matchSummaryPage.isTimerPaused());
    }

    @Then("^play button is shown$")
    public void play_button_is_shown() {
        Assert.assertTrue(matchSummaryPage.isPlayButtonVisible());
    }

    @When("^I click on the forward button$")
    public void I_click_on_forward_button() {
        matchSummaryPage = matchSummaryPage.clickForwardButton();
    }

    @Then("^the action list scrolls to the last action$")
    public void action_list_scrolls_to_the_last_action() {
        Assert.assertTrue(matchSummaryPage.isLastActionAtEndOfMatch());
    }

    @When("^I click on rewind button$")
    public void I_click_on_rewind_button() {
        matchSummaryPage = matchSummaryPage.clickRewindButton();
    }

    @Then("^the action list scrolls to the Kick-Off$")
    public void action_list_scrolls_to_the_Kick_Off() {
        Assert.assertTrue(matchSummaryPage.isKickOffMessageVisible());
    }

    @Then("^timer resets to (\\d+):(\\d+) in yellow$")
    public void timer_resets_to_in_yellow(String minutes, String seconds) {
       Assert.assertTrue(matchSummaryPage.isTimerSetTo(minutes, seconds));
       Assert.assertTrue(matchSummaryPage.isTimerPaused());
    }

    @Then("^the timer starts from (\\d+):(\\d+)$")
    public void the_timer_starts_from_(String minutes, String seconds) {
        Assert.assertTrue(matchSummaryPage.isTimerSetTo(minutes, seconds));
    }

    @Then("^the timer starts ticking$")
    public void the_timer_starts_ticking() {
        Assert.assertFalse(matchSummaryPage.isTimerPaused());
    }

    @Then("^actions drop in from the top when the timer reaches their time stamp$")
    public void actions_drop_in_from_the_top_when_the_timer_reaches_their_time_stamp() {
       // this is not easily automatable without having test data
    }

    @Then("^the pause button is shown$")
    public void the_pause_button_is_shown() {
       Assert.assertFalse(matchSummaryPage.isPlayButtonVisible());
    }
}