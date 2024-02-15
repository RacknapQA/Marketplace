package testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//		dryRun = true,
		monochrome= true,
		features = "src/test/resources/com/feature/",
		glue={"stepDefinitions","LoginIntoAdminPanel"},
		stepNotifications = true,
		plugin= {"pretty",
			"html:target/html-report/test-report",
			"junit:target/junit-xml-report.xml",
				"json:target/cucumber-report/json-report.json",
			"rerun:target/failedrerun.txt", 
				
	//		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
			}
		
		//,tags = "@OnlineBulkOrder"
		
				
		)


public class TestRunner {

}
