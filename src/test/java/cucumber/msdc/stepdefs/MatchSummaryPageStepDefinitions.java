package cucumber.msdc.stepdefs;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.msdc.pages.ConnectionManager;
import cucumber.msdc.pages.utils.HomePage;



/**
@author Shahnaaz Rahamatullah
@version 1.0
 */
public class MatchSummaryPageStepDefinitions extends ConnectionManager {
private HomePage homePage;
	@Before()
	public void setUp() {
		super.setUp();
	}

	@After()
	public void tearDown() {

		super.tearDown();
	}
	@Given("^I am on the summary page for a particular match \"([^\"]*)\"$")
	public void I_am_on_the_summary_page_for_a_particular_match(String matchId) throws Throwable {
		 homePage=new HomePage(webDriver, "http://msdc.devb.pacpservices.net/#/match-details/" +matchId);
	}

	

	@Then("^I should see the actions list displayed in descending order of time$")
	public void I_should_see_the_actions_list_displayed_in_descending_order_of_time() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
	

@Then("^I should see an exclamation icon for each action displayed and greyed out by default$")
public void I_should_see_an_exclamation_icon_for_each_action_displayed_and_greyed_out_by_default() throws Throwable {

    throw new PendingException();
}
}
