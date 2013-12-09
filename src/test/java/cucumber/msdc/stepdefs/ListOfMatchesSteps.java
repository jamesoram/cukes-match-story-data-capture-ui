package cucumber.msdc.stepdefs;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

import java.util.Set;

import org.junit.Assert;

import cucumber.msdc.pages.models.HomePage;
import cucumber.msdc.pages.models.HomePage.Fixture;

/**
 * @author archanaa
 * 
 */

public class ListOfMatchesSteps extends AbstractSteps {

	@Given("^I am on the home page$")
	public void I_am_on_the_home_page() throws Throwable {
		homePage = new HomePage(driver);
	}

	@When("^I select competition \"([^\"]*)\" and match date \"([^\"]*)\"$")
	public void I_select_competition_and_match_date(String competition,
			String matchDate) throws Throwable {
		homePage.selectCompetition(competition);
		homePage.enterDateInMatchDatePicker(matchDate);

	}

	@Then("^I should see the following list of matches with scores:$")
	public void I_should_see_the_following_list_of_matches_with_scores(
			DataTable matches) throws Throwable {
		Set<Fixture> actualFixtures = homePage.getFixturesFromTable();
		
		for (DataTableRow currentRow : matches.getGherkinRows().subList(1,
				matches.getGherkinRows().size())) {
			Fixture fixture = new Fixture(currentRow.getCells().get(0),
					currentRow.getCells().get(1), currentRow.getCells().get(2),
					currentRow.getCells().get(3));
			
			Assert.assertTrue("Fixture does not exist: " + fixture, actualFixtures.contains(fixture));
		}
	}
	
	@Then("^I should see an empty match list$")
	public void I_should_see_an_empty_match_list() throws Throwable {
		Set<Fixture> actualFixtures = homePage.getFixturesFromTable();
		Assert.assertTrue("Match list should be empty", actualFixtures.isEmpty());
	}

	@Then("^all the match dates to be highlighted in green colour$")
	public void all_the_match_dates_to_be_highlighted_in_green_colour()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}
}