package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"definitions", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
        }
)
public class TestRunner {
}