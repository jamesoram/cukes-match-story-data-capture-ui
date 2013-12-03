package cucumber.msdc.pages.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author archanaa
 * 
 */
public class HomePage extends AbstractViewPage {

	
	public static final String XPATH_DIV_WITH_CLASS="//div[@class=\"%s\"]";
	
	public static final String XPATH_SPAN_WITH_CLASS="//span[@class=\"%s\"]";

	public HomePage(CukesApp cukesApp) {
		super(cukesApp);
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
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((away == null) ? 0 : away.hashCode());
			result = prime * result + ((home == null) ? 0 : home.hashCode());
			result = prime * result + ((score == null) ? 0 : score.hashCode());
			result = prime * result + ((time == null) ? 0 : time.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Fixture other = (Fixture) obj;
			if (away == null) {
				if (other.away != null)
					return false;
			} else if (!away.equals(other.away))
				return false;
			if (home == null) {
				if (other.home != null)
					return false;
			} else if (!home.equals(other.home))
				return false;
			if (score == null) {
				if (other.score != null)
					return false;
			} else if (!score.equals(other.score))
				return false;
			if (time == null) {
				if (other.time != null)
					return false;
			} else if (!time.equals(other.time))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Fixture [time=" + time + ", home=" + home + ", away="
					+ away + ", score=" + score + "]";
		}
		
		
		
		
	}
	
	



	public void enterDateInMatchDatePicker(String date) {
		driver.findElement(By.id("match-date")).clear();
		driver.findElement(By.id("match-date")).sendKeys(date);
		driver.findElement(By.cssSelector("div.title.ng-scope")).click();
		
	}


	public void selectCompetition(String competetion) {
		new Select(driver.findElement(By.id("competition-list"))).selectByVisibleText(competetion);
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
		cukesApp.waitUntilVisibilityOfElementLocated("competition-list");
		return new Select(driver.findElement(By.id("competition-list"))).getFirstSelectedOption().getText();
	}

	public String getMatchDayDate() {
		clickOnDatePicker();
		return driver.findElement(By.id("match-date")).getAttribute("value");
	}


	public void verityMatchDate(String today) {
		Assert.assertEquals("Invalid match date in date picker", today, getMatchDayDate());
	}
	
	public void clickOnDatePicker() {
		cukesApp.waitUntilVisibilityOfElementLocated("match-date");
		driver.findElement(By.id("match-date")).click();
		cukesApp.waitUntilVisibilityOfElementLocated(By.xpath("//table[@class='ui-datepicker-calendar']//a[1]"));
	}


	public Set<String> getMatchDaysFromCalendar() {
		// TODO Auto-generated method stub
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
