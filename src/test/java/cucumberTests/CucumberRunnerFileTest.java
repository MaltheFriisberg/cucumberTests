package cucumberTests;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		//"src/test/java/cucumber/CucumberTest.feature",
		"features/create_account.feature"
},plugin =  {"pretty","html:target/html", "json:target/cucumber.json"},
glue = "",
strict = true
)
public class CucumberRunnerFileTest {
	//random comment

}

