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
  features = "src/test/resources/cucumber/msdc/timerfunction_79.feature",
  tags = {"@Complete"}
)
public class TimerFunctionTestRunner {

}