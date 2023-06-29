package tek.sdet.framework.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@regression",
        features = ("classpath:features"),
        glue="tek.sdet.framework",
        dryRun = false,
        //if dryRun = True: Step definition will be ignored
        //if dryRun = false: step definition will be check
        plugin = {
                "pretty",
                "html:target/htmlReports/cucumber-pretty.html",
                "json:target/jsonReports/cucumber.json"
        },
        snippets = CAMELCASE,
        monochrome = true)
public class TestRunner {
}