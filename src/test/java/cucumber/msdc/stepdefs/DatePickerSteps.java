package cucumber.msdc.stepdefs;

import com.pressassociation.test.BaseWebDriverTest;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.junit.Assert;

import cucumber.msdc.pages.models.HomePage;

public class DatePickerSteps extends BaseWebDriverTest {

    private HomePage homePage;

	@Before
	public void before() {
		setUp();
        homePage = new HomePage(driver);
	}

	@After
	public void after() {
		tearDown();
	}
	
	private String newDate;

	@Then("^the last match date should be displayed in the date field$")
	public void the_last_match_date_should_be_displayed_in_the_date_field()
			throws Throwable {
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

		Set<String> fixtureDaysFromCalendar = homePage
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
	}

    public void verityMatchDate(String today) {
        Assert.assertEquals("Invalid match date in date picker", today, homePage.getMatchDayDate()); // TODO james oram fix this
    }

	@When("^I click on the calendar icon from the date field$")
	public void I_click_on_the_calendar_icon_from_the_date_field()
			throws Throwable {
		homePage.clickOnDatePicker();
	}

	@Then("^today's date is highlighted in grey$")
	public void today_s_date_is_highlighted_in_grey() throws Throwable {
		Assert.assertEquals("Today's date is not highlighted", String
				.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)),
				homePage.getDayInGrey());
	}

	@Given("^I click on the Calendar icon from the date field$")
	public void I_click_on_the_Calendar_icon_from_the_date_field()
			throws Throwable {
		homePage.clickOnDatePicker();
	}

	@When("^I click on a new date$")
	public void I_click_on_a_new_date() throws Throwable {
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM, yyyy");

		Date mDate = dateFormat.parse(homePage.getMatchDayDate());
		Calendar cal = Calendar.getInstance();
		cal.setTime(mDate);
		cal.add(Calendar.DAY_OF_MONTH, 1);

		newDate = dateFormat.format(cal.getTime());
		homePage.enterDateInMatchDatePicker(newDate);
	}

	@Then("^the selected date should be displayed in the date field$")
	public void the_selected_date_should_be_displayed_in_the_date_field()
			throws Throwable {
		Assert.assertEquals("Input date is not updated in date picker",
				newDate, homePage.getMatchDayDate());
	}
}