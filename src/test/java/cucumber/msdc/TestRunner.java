package cucumber.msdc;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;



/**
@author Shahnaaz Rahamatullah
@version 1.0
 */

@RunWith(Cucumber.class)
@Cucumber.Options(
		format = {"html:target/cucumber-html-report/features/matchsummarypage" },
		//glue="classpath:com/pressassociation/stepassociations/media",
		features="classpath:cucumber/msdc/features/matchsummarypage",
		tags = {"@Shahnaaz"}
		)
public class TestRunner {

}

