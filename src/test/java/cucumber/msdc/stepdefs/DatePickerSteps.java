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
import cucumber.runtime.PendingException;
import cucumber.table.DataTable;

public class DatePickerSteps extends AbstractSteps {

	@Before
	public void setUp() {
		intSetUp();
	}

	@After
	public void tearDown() {
		intTearDown();
	}
	
	private String newDate;

	@Then("^the last match date should be displayed in the date field$")
	public void the_last_match_date_should_be_displayed_in_the_date_field()
			throws Throwable {
		HomePage homePage = cukesApp.getHomePage();
		homePage.clickOnDatePicker();
		Set<String> daysFromCalendar = homePage.getMatchDaysFromCalendar();
		String matchDayDate = homePage.getMatchDayDate();

		Date mDate = new SimpleDateFormat("EEE, dd MMM, yyyy")
				.parse(matchDayDate);
		Date today = new Date();

		Calendar instance = Calendar.getInstance();
		instance.setTime(mDate);

		Assert.assertTrue("Match day should be before today",
				mDate.before(today));

		Assert.assertTrue("Match day should be in green", daysFromCalendar
				.contains(String.valueOf(instance.get(Calendar.DAY_OF_MONTH))));

	}

	@Then("^the following days should be highlighted in green colour:$")
	public void the_following_days_should_be_highlighted_in_green_colour(
			DataTable matchDays) throws Throwable {

		Set<String> fixtureDaysFromCalendar = cukesApp.getHomePage()
				.getMatchDaysFromCalendar();

		for (DataTableRow currentRow : matchDays.getGherkinRows().subList(1,
				matchDays.getGherkinRows().size())) {

			Assert.assertTrue(
					"Match day does not exist: " + currentRow.getCells().get(0),
					fixtureDaysFromCalendar.contains(currentRow.getCells().get(
							0)));
		}
	}

	@Then("^the current date to be displayed in the date field$")
	public void the_current_date_to_be_displayed_in_the_date_field()
			throws Throwable {
		// Mon, 25 Nov, 2013

		String today = new SimpleDateFormat("EEE, dd MMM, yyyy")
				.format(new Date());
		cukesApp.getHomePage().verityMatchDate(today);
	}

	@When("^I click on the calendar icon from the date field$")
	public void I_click_on_the_calendar_icon_from_the_date_field()
			throws Throwable {
		cukesApp.getHomePage().clickOnDatePicker();
	}

	@Then("^today's date is highlighted in grey$")
	public void today_s_date_is_highlighted_in_grey() throws Throwable {
		Assert.assertEquals("Today's date is not highlighted", String
				.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)),
				cukesApp.getHomePage().getDayInGrey());
	}

	@Given("^I click on the Calendar icon from the date field$")
	public void I_click_on_the_Calendar_icon_from_the_date_field()
			throws Throwable {
		cukesApp.getHomePage().clickOnDatePicker();
	}

	@When("^I click on a new date$")
	public void I_click_on_a_new_date() throws Throwable {
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM, yyyy");

		Date mDate = dateFormat.parse(cukesApp.getHomePage().getMatchDayDate());
		Calendar cal = Calendar.getInstance();
		cal.setTime(mDate);
		cal.add(Calendar.DAY_OF_MONTH, 1);

		newDate = dateFormat.format(cal.getTime());
		cukesApp.getHomePage().enterDateInMatchDatePicker(newDate);

		

	}

	@Then("^the selected date should be displayed in the date field$")
	public void the_selected_date_should_be_displayed_in_the_date_field()
			throws Throwable {
		Assert.assertEquals("Input date is not updated in date picker",
				newDate, cukesApp.getHomePage().getMatchDayDate());
	}

}
