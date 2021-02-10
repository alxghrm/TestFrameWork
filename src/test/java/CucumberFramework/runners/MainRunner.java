package CucumberFramework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {"src/test/java/CucumberFramework/features/"},
    glue = {"step_definitions"},
    monochrome = true,
    tags = "",
    plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
)
public class MainRunner extends AbstractTestNGCucumberTests {
}
