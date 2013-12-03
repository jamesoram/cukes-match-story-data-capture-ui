/**
 * @author archanaa
 * 
 */
package cucumber.msdc;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

//Below is to run the whole test suite
//@Cucumber.Options(format = {"pretty", "html:target/cucumber-html-report", "json-pretty:target/cucumber-report.json"})

//Below is to run an individual test
@Cucumber.Options(features = "classpath:cucumber/msdc/datepicker_23.feature", format = {"pretty", "html:target/cucumber-html-report", "json-pretty:target/cucumber-report.json"})

public class RunCukesTest {

}