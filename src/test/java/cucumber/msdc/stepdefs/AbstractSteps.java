package cucumber.msdc.stepdefs;

import com.pressassociation.test.BaseWebDriverTest;
import cucumber.msdc.pages.models.HomePage;

/**
 * @author archanaa
 * 
 */
public abstract class AbstractSteps extends BaseWebDriverTest {

    // TODO James Oram this should be loaded from the config file
    private final String baseUrl = "http://msdc.devb.pacpservices.net";
    protected HomePage homePage;

    public HomePage goToHomePage() {
        driver.get(baseUrl);
        homePage = new HomePage(driver);
        return homePage;

    }
}
