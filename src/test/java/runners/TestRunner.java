package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {"pretty",                       // console BDD output
                "summary",                      // console summary
                "html:target/cucumber.html",    // HTML BDD report
                "json:target/cucumber.json",    // JSON report
                "junit:target/cucumber.xml" },
        tags = "@Bank",
        monochrome = true,
        dryRun = false
)
public class TestRunner {
}
