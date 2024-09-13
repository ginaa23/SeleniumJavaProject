package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/results/hdi/cucumber-report.json",  "html:target/results/hdi/index.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@hdi"

)
public class HDITestRunner extends BaseTestRunner
{

}
