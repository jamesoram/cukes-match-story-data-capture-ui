/**
archanaa
 */
package cucumber.msdc.pages.models;

import com.pressassociation.test.PAWait;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class AbstractViewPage {

    protected final WebDriver driver;
    protected final PAWait wait;
    // TODO James Oram this should be loaded from the config file
    private final String baseUrl = "http://msdc.devb.pacpservices.net";
    protected HomePage homePage;

	public AbstractViewPage(WebDriver driver) {
		this.driver = driver;
        wait = new PAWait(driver);
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
}