package cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/course_search.feature",
		glue= {"stepDefinitions"},
		plugin =   {"pretty", 
					"json:target/report/cucumber-report.json",
					"html:target/report/cucumber.html"
					}
		)

public class TestRunner {

}
