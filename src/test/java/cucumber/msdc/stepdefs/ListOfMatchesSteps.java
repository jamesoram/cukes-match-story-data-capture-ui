package cucumber.msdc.stepdefs;

import gherkin.formatter.model.DataTableRow;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.junit.Assert;

import com.ibm.icu.util.Calendar;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.msdc.pages.models.HomePage;
import cucumber.msdc.pages.models.HomePage.Fixture;
import cucumber.runtime.PendingException;
import cucumber.table.DataTable;

/**
 * @author archanaa
 * 
 */
public class ListOfMatchesSteps extends AbstractSteps {

	private HomePage homePage;

	@Before
	public void setUp() {
		intSetUp();
		cukesApp.sleep(1000);

	}

	@After
	public void tearDown() {
		intTearDown();
	}

	@Given("^I am on the home page$")
	public void I_am_on_the_home_page() throws Throwable {
		cukesApp.gotoHomePage();
		homePage = cukesApp.getHomePage();
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
	
	
	
	





}
