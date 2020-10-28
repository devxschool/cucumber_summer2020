package runners;

//chose 10 scenarios among all features to be included in the Smoke test.
//implement the SmokeRunner

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //folder of feature files to be considered(scanned) for run
        features = {"classpath:features"},
        //specify the package of step defs
        glue = {"step_definitions"},
        //is responsible for creating(generating) junit reports in json format
        plugin = {"json:target/cucumber.json"},
        format = {"pretty", "html:target/reports"},
        //when set to true it will generate step def snippets.
        dryRun = false,
        //Is there any way I can run only specific features and/or scenarios?
        //ex: smoke or regression
        tags = {"@smoke", "~@ignore"}
)
public class SmokeRunner {

}
