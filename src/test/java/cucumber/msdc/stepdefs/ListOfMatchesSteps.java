package cucumber.msdc.stepdefs;

import com.pressassociation.test.BaseWebDriverTest;
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

public class ListOfMatchesSteps extends BaseWebDriverTest {

	private HomePage homePage;

    @Before
    public void before() {
        setUp();
        driver.get("http://msdc.devb.pacpservices.net/");
    }

    @After
    public void after() {
        tearDown();
    }

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

	@Given("^I am logged into Match story data capture system$")
	public void I_am_logged_into_Match_story_data_capture_system()
			throws Throwable {

	}

	@Then("^I should see \"([^\"]*)\" as a label$")
	public void I_should_see_as_a_label(String arg1) throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Then("^I should see a field with a calendar icon to pick a date$")
	public void I_should_see_a_field_with_a_calendar_icon_to_pick_a_date()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Then("^the current date to be displayed in the date field$")
	public void the_current_date_to_be_displayed_in_the_date_field()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Given("^I am on the Home page$")
	public void I_am_on_the_Home_page() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@When("^I click on the Calendar icon from the date field$")
	public void I_click_on_the_Calendar_icon_from_the_date_field()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Then("^I calendar should open below the field$")
	public void I_calendar_should_open_below_the_field() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Then("^I should see weekdays displayed by single charecters between left and right arrows$")
	public void I_should_see_weekdays_displayed_by_single_charecters_between_left_and_right_arrows()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Then("^current date is highlighted in grey on the calendar$")
	public void current_date_is_highlighted_in_grey_on_the_calendar()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Given("^I have clicked on the Calendar icon from the date field$")
	public void I_have_clicked_on_the_Calendar_icon_from_the_date_field()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Given("^I am on the calendar$")
	public void I_am_on_the_calendar() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@When("^I click on the left arrow the calendar view should display previous month$")
	public void I_click_on_the_left_arrow_the_calendar_view_should_display_previous_month()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@When("^I click on the left arrow again$")
	public void I_click_on_the_left_arrow_again() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Then("^correct month should be displayed$")
	public void correct_month_should_be_displayed() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@When("^I click on the right arrow the calendar view should display future month$")
	public void I_click_on_the_right_arrow_the_calendar_view_should_display_future_month()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@When("^I click on the right arrow again$")
	public void I_click_on_the_right_arrow_again() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@When("^I click on a new date$")
	public void I_click_on_a_new_date() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Then("^the selected date to be displayed correctly in the date field$")
	public void the_selected_date_to_be_displayed_correctly_in_the_date_field()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@When("^I select Barclay's Premier League from the drop down list$")
	public void I_select_Barclay_s_Premier_League_from_the_drop_down_list()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@When("^I select a date from the calendar$")
	public void I_select_a_date_from_the_calendar() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Then("^all the match dates to be highlighted in green colour$")
	public void all_the_match_dates_to_be_highlighted_in_green_colour()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}
}