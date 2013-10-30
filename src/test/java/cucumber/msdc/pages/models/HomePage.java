package cucumber.msdc.pages.models;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author archanaa
 * 
 */
public class HomePage extends AbstractViewPage {

	private static final String MEET_RACES_DIV_ID = "meetRaces";
	public static final String DATE_INPUT_DIV_ID = "datePickDiv";
	public static final String BODY_DIV_ID = "content";
	public static final String CURRENT_DAY_DIV_ID = "onThisDay";
	public static final String PAGE_TAB_DIV_ID = "pageTab";

	public static final String XPATH_COUNTRY_MEETING_RACE = "id('%s')/table//tr[th/a/text()='%s']//td/a[text()='%s']";
	public static final String XPATH_COUNTRY_INACTIVE_TAB = "id('%s')[contains(@class,'inactive')]";
	public static final String XPATH_MEETING_VIEW_RACE_DETAILS = "id('meetRaces')/table//tr[td[1]='%s' and contains(td[2], '%s') and td[3]='%s']";
	public static final String XPATH_MEETING_VIEW_RACE_LINK = "id('meetRaces')/table//tr[td[1]='%s']";

	public static final String XPATH_RACETIMELINK = "//*[@id='UK_and_Ireland']/table/tbody/tr[1]/td[1]/a";

	public static final String XPATH_RACE_ACTIVE_TAB_VIEW = "id('pageTab')/li[@class='active']/a[text()='%s']";
	public static final String XPATH_RACE_TAB_VIEW = "id('pageTab')/li/a[text()='%s']";

	public HomePage(CukesApp cukesApp) {
		super(cukesApp);
	}
	
	

	public void verifySelectedDayInDayNav(String day) {
		By xpath = By
				.xpath(String
						.format("id('dateRange')//li[@class='active']//span[text()='%s']",
								day));
		WebElement webElement = getWebDriver().findElement(xpath);
	}

	public void verifySelectedCountryInCountryNav(String country) {
		By xpath = By.xpath(String.format(
				"id('dateRange')//li[@class='active']//span[text()='%s']",
				country));
		WebElement webElement = getWebDriver().findElement(xpath);
	}

	public void enterDateInDatePicker(String date) {
		cukesApp.waitUntilVisibilityOfElementLocated(BODY_DIV_ID);
		cukesApp.waitUntilVisibilityOfElementLocated(DATE_INPUT_DIV_ID);
		getWebDriver().findElement(By.id(DATE_INPUT_DIV_ID)).clear();
		System.out.println("Finding element: " + DATE_INPUT_DIV_ID);
		getWebDriver().findElement(By.id(DATE_INPUT_DIV_ID)).sendKeys(date);
		getWebDriver().findElement(By.id(DATE_INPUT_DIV_ID)).sendKeys(
				Keys.RETURN);
		// getWebDriver().findElement(By.id(DATE_INPUT_DIV_ID)).click();
	}



	



}
