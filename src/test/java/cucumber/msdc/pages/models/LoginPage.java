package cucumber.msdc.pages.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object for the login page.
 */
public class LoginPage extends AbstractViewPage {

    @FindBy(css = ".login-submit")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String username, String password) {
        // the login is not implemented yet so we only have to click the button
        loginButton.click();
        return new HomePage(driver);
    }
}
