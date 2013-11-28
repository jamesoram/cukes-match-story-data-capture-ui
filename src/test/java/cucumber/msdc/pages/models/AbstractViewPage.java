/**
archanaa
 */
package cucumber.msdc.pages.models;

import com.pressassociation.test.PAWait;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public abstract class AbstractViewPage {

    protected WebDriver driver;
    protected final PAWait wait;
    // TODO James Oram this should be loaded from the config file
    private final String baseUrl = "http://msdc.devb.pacpservices.net";
    protected HomePage homePage;

    protected Configuration elementIdentifier;


	public AbstractViewPage(WebDriver driver, String elementIdentifierLocation) {
		this.driver = driver;
        wait = new PAWait(driver);
        try {
            elementIdentifier = new PropertiesConfiguration(elementIdentifierLocation);
        } catch (ConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
	}

    public void logOut() {
        driver.findElement(
                By.xpath("//a[@title='Log off the CodeTrack System']")).click();
    }

    public HomePage gotoHomePage() {
        driver.get(baseUrl);
        homePage = new HomePage(driver);
        return homePage;

    }

    public boolean isLoggedIn() {
        driver.get(getUrl(""));
        try {
            gotoHomePage();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void selectOption(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public void submit() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }


    public void clickButtonWithId(String buttonId) {
        wait.waitUntilVisibilityOfElementLocated(buttonId);
        driver.findElement(By.id(buttonId)).click();
    }

    public void clickButtonWithText(String buttonText) {
        String xpath = String.format("//button[text() ='%s']", buttonText);
        wait.waitUntilVisibilityOfElementLocated(By.xpath(xpath));
        driver.findElement(By.xpath(xpath)).click();
    }
    private String getUrl(String relativePath) {
        return String.format("%s%s", baseUrl, relativePath);
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

    protected void takeScreenShot(RuntimeException e, String fileName) {
        driver = new Augmenter().augment(driver);
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(fileName + ".png"));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe.getMessage(), ioe);
        }
        throw e;
    }

    public void highlightElement(WebElement element) {
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 10px solid yellow;");
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
        }
    }
}