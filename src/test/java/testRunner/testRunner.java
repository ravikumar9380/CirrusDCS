package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SuppressWarnings("ALL")
@RunWith(Cucumber.class)
@CucumberOptions( 
		features="src/test/java/features",
		glue="stepDefnition",
		strict=true,
		tags = {" @TC_01"},
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/jsonReports/cucumber-report.html",
				"json:target/cucumber-report.json"},
		monochrome=true)

public class testRunner {

}
