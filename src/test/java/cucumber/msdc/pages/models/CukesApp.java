package cucumber.msdc.pages.models;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author archanaa
 * 
 */
public class CukesApp {

	private final String IMPLICIT_WAIT = "implicitWait";

	private final String baseUrl;
	private final WebDriver webDriver;
	public  WebDriverWait wait;
	private final Properties configProperties;
	private final int implicitWait;
	
	/**
	 * Stores home page object so that this can accessed from all step definition classes
	 */
	protected HomePage homePage;

	public CukesApp(Properties configProperties) {
		this.configProperties = configProperties;
		this.baseUrl = configProperties.getProperty("baseUrl");
		System.setProperty("webdriver.chrome.driver", "C:\\Arc\\cukes-match-story-data\\src\\test\\resources\\chromedriver.exe");
        // System.setProperty("webdriver.chrome.driver", configProperties.getProperty("chromeDriverLocation"));
		this.webDriver = new ChromeDriver();

		implicitWait = Integer.parseInt(configProperties
				.getProperty(IMPLICIT_WAIT));
		webDriver.manage().timeouts()
				.implicitlyWait(implicitWait, TimeUnit.SECONDS);
		this.wait = new WebDriverWait(webDriver, implicitWait);
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public Properties getConfigProperties() {
		return configProperties;
	}

	public int getImplicitWait() {
		return implicitWait;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public HomePage getHomePage() {
		return homePage;
	}

	public void logOut() {
		webDriver.findElement(
				By.xpath("//a[@title='Log off the CodeTrack System']")).click();
	}

	public HomePage gotoHomePage() {
		webDriver.get(baseUrl);
		homePage = new HomePage( this);
		return homePage;
		
	}

	public boolean isLoggedIn() {
		webDriver.get(getUrl(""));
		try {
			gotoHomePage();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void selectOption(By by, String text) {
		Select select = new Select(webDriver.findElement(by));
		select.selectByVisibleText(text);
	}

	public void submit() {
		webDriver.findElement(By.xpath("//input[@type='submit']")).click();
	}


	public void clickButtonWithId(String buttonId) {
		waitUntilVisibilityOfElementLocated(buttonId);
		webDriver.findElement(By.id(buttonId)).click();
	}

	public void clickButtonWithText(String buttonText) {
		String xpath = String.format("//button[text() ='%s']", buttonText);
		waitUntilVisibilityOfElementLocated(By.xpath(xpath));
		webDriver.findElement(By.xpath(xpath)).click();
	}
	private String getUrl(String relativePath) {
		return String.format("%s%s", baseUrl, relativePath);
	}

	

	/**
	 * waits until presence by ID
	 * @param id
	 */
	public void waitUntilPresenceOfElementLocated(String id) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.id(id)));
	}
	
	/**
	 * waits until presence by XPATH
	 * @param xpath
	 */
	public void waitUntilPresenceOfElementLocated(By xpath) {
		wait.until(ExpectedConditions.presenceOfElementLocated(xpath));		
	}
	
	/**
	 * wait until visibility by ID
	 * @param id
	 */
	public void waitUntilVisibilityOfElementLocated(String id) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id(id)));
	}

	/**
	 * wait until visibility by XPATH
	 * @param xpath
	 */
	public void waitUntilVisibilityOfElementLocated(By xpath) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));		
	}

    /*
    * @param: inputField - the field to check the state of
    *
    * returns true if the field has red borders and the input value text is red
     */
    public boolean isTheInputFieldInErrorState(WebElement inputField) {
        String EXPECTED_CSS = "rgb(185, 74, 72)";
        return (inputField.getCssValue("outline-color").equals(EXPECTED_CSS)
                && inputField.getCssValue("color").equals(EXPECTED_CSS));
    }
    
    public void clickClearAndSendKeys(WebElement elem, String keys) {
		elem.click();
		elem.clear();
		elem.sendKeys(keys);
	}
    
	public void sleep(int millisecs) {
		try {
			Thread.sleep(millisecs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


    public boolean doesTheFieldHaveFocus(WebElement focusElement) {
        WebElement element = webDriver.switchTo().activeElement();
        return(element == focusElement);
    }

}
