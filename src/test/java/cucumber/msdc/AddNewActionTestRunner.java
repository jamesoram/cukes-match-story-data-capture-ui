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
        features = "src/test/resources/cucumber/msdc/addnewaction_155.feature",
        tags = {"@Complete"})
public class AddNewActionTestRunner {
}
