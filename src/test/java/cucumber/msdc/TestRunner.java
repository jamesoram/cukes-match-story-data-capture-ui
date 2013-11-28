package cucumber.msdc;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
@author Shahnaaz Rahamatullah
@version 1.0
 */

@RunWith(Cucumber.class)
@CucumberOptions(
  format = {"html:target/cucumber-html-report/features/matchsummarypage"},
 // features = "src/test/resources/cucumber/msdc/features/matchsummarypage/exclamation_icon_63.feature",
  tags = {"@Complete"}
)
public class TestRunner {

}