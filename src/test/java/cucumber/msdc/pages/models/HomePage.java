package cucumber.msdc.pages.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * @author archanaa
 * 
 */
public class HomePage extends AbstractViewPage {

    @FindBy(id = "competition-list")
    private WebElement competitionList;

    @FindBy(id = "match-date")
    private WebElement matchDate;

    @FindBy(xpath = "//div[@ng-switch-when='true'][1]/a")
    private WebElement firstMatchButton;

	private static final String XPATH_DIV_WITH_CLASS="//div[@class=\"%s\"]";
	private static final String XPATH_SPAN_WITH_CLASS="//span[@class=\"%s\"]";

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public static class Fixture {
		
		private final String time;
		private final String home;
		private final String away;
		private final String score;
		
		public Fixture(String time, String home,  String score, String away) {
			this.time = time;
			this.home = home;
			this.away = away;
			this.score = score;
		}

		public String getTime() {
			return time;
		}

		public String getHome() {
			return home;
		}

		public String getAway() {
			return away;
		}

		public String getScore() {
			return score;
		}

		@Override
		public String toString() {
			return "Fixture [time=" + time + ", home=" + home + ", away="
					+ away + ", score=" + score + "]";
		}
	}

	public HomePage enterDateInMatchDatePicker(String date) {
		driver.findElement(By.id("match-date")).clear();
		driver.findElement(By.id("match-date")).sendKeys(date);
		driver.findElement(By.cssSelector("div.title.ng-scope")).click();
        return this;
	}

    public MatchSummaryPage clickFirstMatchArrow() {
        firstMatchButton.click();
        return new MatchSummaryPage(driver);
    }

	public Set<Fixture> getFixturesFromTable() {
		Set<Fixture> list = new HashSet<Fixture>();
		List<WebElement> times = driver.findElements(By.xpath("//div[@class='game-date ng-binding']"));
		List<WebElement> homeTeams = driver.findElements(By.xpath("//div[@class='home-team']/span"));
		List<WebElement> awayTeams = driver.findElements(By.xpath("//div[@class='away-team']/span"));
		List<WebElement> scores = driver.findElements(By.xpath("//div[@class='score ng-binding']"));
		
		for (int i=0; i<homeTeams.size(); i++) {
			Fixture fixture = new Fixture(times.get(i).getText(), homeTeams.get(i).getText(), scores.get(i).getText(),  awayTeams.get(i).getText());
			list.add(fixture);
		}
		return list;
	}

	private By byDivXPath(String css) {
		return By.xpath(String.format(XPATH_DIV_WITH_CLASS, css));
	}

	private By bySpanXPath(String css) {
		return By.xpath(String.format(XPATH_SPAN_WITH_CLASS, css));
	}
	
	public String getSelectedCompetition() {
		return new Select(competitionList).getFirstSelectedOption().getText();
	}

    public HomePage selectCompetition(String visibleText) {
        new Select(competitionList).selectByVisibleText(visibleText);
        return this;
    }

	public String getMatchDayDate() {
		clickOnDatePicker();
		return matchDate.getAttribute("value");
	}

	public HomePage clickOnDatePicker() {
		wait.waitUntilVisibilityOfElementLocated("match-date");
		matchDate.click();
		wait.waitUntilVisibilityOfElementLocated(By.xpath("//table[@class='ui-datepicker-calendar']//a[1]"));
        return this;
	}

	public Set<String> getMatchDaysFromCalendar() {
		clickOnDatePicker();
		WebElement element = driver.findElement(By.id("ui-datepicker-div"));
		
		String matchDaysXPath = "table//td[contains(@class, 'highlightMatchDay')]/a";
		List<WebElement> elements = element.findElements(By.xpath(matchDaysXPath));
		Set<String> days = new TreeSet<String>();
		for(WebElement e : elements) {
			days.add(e.getText());
		}
		return days;
		
	}

	public String getDayInGrey() {
		String matchDaysXPath = "table//td[contains(@class, 'highlightToday')]/a";
		WebElement element = driver.findElement(By.id("ui-datepicker-div"));
		return element.findElement(By.xpath(matchDaysXPath)).getText();
	}
}
