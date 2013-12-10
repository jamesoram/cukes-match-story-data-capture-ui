package cucumber.msdc;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by James Oram on 10/12/2013.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"html:target/cucumber-html-report/features/matchsummarypage"},
        features = "src/test/resources/cucumber/msdc/titlebar_59.feature")
public class TitlebarTestRunner {
}
