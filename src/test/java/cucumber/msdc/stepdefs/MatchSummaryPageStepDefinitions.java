package cucumber.msdc.stepdefs;

import static org.junit.Assert.*;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.msdc.pages.ConnectionManager;
import cucumber.msdc.pages.utils.MatchSummaryPage;

/**
 * @author Shahnaaz Rahamatullah
 * @version 1.0
 */
public class MatchSummaryPageStepDefinitions extends ConnectionManager {
	private MatchSummaryPage matchSummaryPage;
	
	@Before()
	public void setUp() {
		super.setUp();
	}

	@After()
	public void tearDown() {

	 //super.tearDown();
	}

	@Given("^I am on the summary page for a particular match \"([^\"]*)\"$")
	public void I_am_on_the_summary_page_for_a_particular_match(String matchId)
			throws Throwable {
		matchSummaryPage = new MatchSummaryPage(webDriver,
				"http://msdc.devb.pacpservices.net/#/match-details/" + matchId);
	}

	@Then("^I should see the actions list displayed in descending order of time$")
	public void I_should_see_the_actions_list_displayed_in_descending_order_of_time()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Then("^I should see an exclamation icon for each action displayed and greyed out by default$")
	public void I_should_see_an_exclamation_icon_for_each_action_displayed_and_greyed_out_by_default()
			throws Throwable {
		assertTrue(
				"not all exclamation icons which needs to be greyed out are greyed out",
				matchSummaryPage.isExclamationIconGreyedOut());

	}

	
	
	@When("^I select the exclamation icon for a particular action in the match$")
	public void I_select_the_exclamation_icon_for_a_particular_action_in_the_match() throws Throwable {
		
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
	public void an_exclamation_icon_for_a_particular_action_already_selected() throws Throwable {
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
	public void I_should_see_that_the_exclamation_icon_is_greyed_out() throws Throwable {
		Thread.sleep(1000);
		assertEquals("the color is not grey", "4px -116px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionExclamationIcon(5));
		assertEquals("the color is not grey", "quality",
				matchSummaryPage.getColorForMatchActionExclamationIcon(5));
	}
	
	@Then("^I should see an favourite icon for each action displayed and greyed out by default$")
	public void I_should_see_an_favourite_icon_for_each_action_displayed_and_greyed_out_by_default() throws Throwable {
		assertTrue(
				"not all favourite icons which needs to be greyed out are greyed out",
				matchSummaryPage.isFavouriteIconGreyedOut());
	}

	@When("^I select the favourite icon for a particular action in the match$")
	public void I_select_the_favourite_icon_for_a_particular_action_in_the_match() throws Throwable {
		assertEquals("the color is not grey", "4px -116px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionFavouriteIcon(5));
		assertEquals("the color is not grey", "key-action",
				matchSummaryPage.getColorForMatchActionFavouriteIcon(5));
		matchSummaryPage.clickMatchActionFavouriteICon(5);
	}

	@Then("^I should see that the favourite icon is highlighted in yellow$")
	public void I_should_see_that_the_favourite_icon_is_highlighted_in_red() throws Throwable {
		Thread.sleep(1000);
		assertEquals("the color is not yellow", "-56px -116px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionExclamationIcon(5));
		assertEquals("the color is not red", "key-action flagged",
				matchSummaryPage.getColorForMatchActionExclamationIcon(5));
		matchSummaryPage.clickMatchActionExclamationICon(5);
	}

	@Given("^an favourite icon for a particular action already selected$")
	public void an_favourite_icon_for_a_particular_action_already_selected() throws Throwable {
		matchSummaryPage.clickMatchActionFavouriteICon(5);
		Thread.sleep(1000);
		assertEquals("the color is not yellow", "-56px -116px",
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
	public void I_should_see_that_the_favourite_icon_is_greyed_out() throws Throwable {
		Thread.sleep(1000);
		assertEquals("the color is not grey", "4px -116px",
				matchSummaryPage
						.getBackGroundPositionForMatchActionFavouriteIcon(5));
		assertEquals("the color is not grey", "key-action",
				matchSummaryPage.getColorForMatchActionFavouriteIcon(5));
	}
	

@Then("^I should see a circle \\(game changing event flag\\) icon for each action displayed and greyed out by default$")
public void I_should_see_a_circle_game_changing_event_flag_icon_for_each_action_displayed_and_greyed_out_by_default() throws Throwable {
	assertTrue(
			"not all gamechanging icons which needs to be greyed out are greyed out",
			matchSummaryPage.isGameChangingIconGreyedOut());
}

@Then("^I should see that the circle \\(game changing event flag\\) icon is highlighted in red$")
public void I_should_see_that_the_circle_game_changing_event_flag_icon_is_highlighted_in_red() throws Throwable {
	Thread.sleep(1000);
	assertEquals("the color is not red", "-56px -296px",
			matchSummaryPage
					.getBackGroundPositionForMatchActionGameChangingIcon(5));
	assertEquals("the color is not red", "impact flagged",
			matchSummaryPage.getColorForMatchActionGameChangingIcon(5));
	matchSummaryPage.clickMatchActionGameChangingICon(5);
}

@Given("^a circle \\(game changing event flag\\) icon for a particular action already selected$")
public void a_circle_game_changing_event_flag_icon_for_a_particular_action_already_selected() throws Throwable {
	matchSummaryPage.clickMatchActionGameChangingICon(5);
	Thread.sleep(1000);
	assertEquals("the color is not red", "-56px -296px",
			matchSummaryPage
					.getBackGroundPositionForMatchActionGameChangingIcon(5));
	assertEquals("the color is not red", "impact flagged",
			matchSummaryPage.getColorForMatchActionGameChangingIcon(5));

}

@When("^I select the circle \\(game changing event flag\\) icon again$")
public void I_select_the_circle_game_changing_event_flag_icon_again() throws Throwable {
	Thread.sleep(1000);
	matchSummaryPage.clickMatchActionGameChangingICon(5);

}

@Then("^I should see that the circle \\(game changing event flag\\) icon greyed out$")
public void I_should_see_that_the_circle_game_changing_event_flag_icon_greyed_out() throws Throwable {
	Thread.sleep(1000);
	assertEquals("the color is not grey", "4px -296px",
			matchSummaryPage
					.getBackGroundPositionForMatchActionGameChangingIcon(5));
	assertEquals("the color is not grey", "impact",
			matchSummaryPage.getColorForMatchActionGameChangingIcon(5));
}


@When("^I select the circle \\(game changing event flag\\) icon for a particular action in the match$")
public void I_select_the_circle_game_changing_event_flag_icon_for_a_particular_action_in_the_match() throws Throwable {
	
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
public void I_should_see_a_yellow_card_icon_displayed_for_that_particular_action() throws Throwable {
    assertTrue("yellow card does not exist", matchSummaryPage.isYellowCardDisplayedForAction(1));
}

@Given("^a player has got a red card$")
public void a_player_has_got_a_red_card() throws Throwable {
	matchSummaryPage.setActionNo(1);
}

@Then("^I should see a red card icon displayed for that particular action$")
public void I_should_see_a_red_card_icon_displayed_for_that_particular_action() throws Throwable {
	  assertTrue("red card does not exist", matchSummaryPage.isRedCardDisplayedForAction(1));
}

@Given("^a player has scored a goal from penalty action$")
public void a_player_has_scored_a_goal_from_penalty_action() throws Throwable {
	matchSummaryPage.setActionNo(1);
}

@Then("^I should see a football icon for the goal from penalty action$")
public void I_should_see_a_football_icon_for_the_goal_from_penalty_action() throws Throwable {
	 assertTrue("red card does not exist", matchSummaryPage.isGoalIconDisplayedForGoalFromPenaltyAction(1));
}

@Given("^a player has scored a goal action$")
public void a_player_has_scored_a_goal_action() throws Throwable {
	matchSummaryPage.setActionNo(1);
}

@Then("^I should see a football icon for the goal action$")
public void I_should_see_a_football_icon_for_the_goal_action() throws Throwable {
	 assertTrue("red card does not exist", matchSummaryPage.isGoalIconDisplayedForGoalAction(1));
}


@Given("^a player has scored a goal from penalty shootout action$")
public void a_player_has_scored_a_goal_from_penalty_shootout_action() throws Throwable {
	matchSummaryPage.setActionNo(1);
}

@Then("^I should see a football icon for the penalty shootout action$")
public void I_should_see_a_football_icon_for_the_penalty_shootout_action() throws Throwable {
	 assertTrue("red card does not exist", matchSummaryPage.isGoalIconDisplayedForGoalFromPenaltyShootOutAction(1));
}

@Given("^a player has scored an own goal$")
public void a_player_has_scored_an_own_goal() throws Throwable {
	matchSummaryPage.setActionNo(1);}

@Then("^I should see a football icon for the own goal action$")
public void I_should_see_a_football_icon_for_the_own_goal_action() throws Throwable {
	 assertTrue("red card does not exist", matchSummaryPage.isGoalIconDisplayedForOwnGoalAction(1));
}
}
