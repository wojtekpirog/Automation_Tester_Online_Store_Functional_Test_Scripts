package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/cucumber/features/", plugin = {"pretty", "html:report.html"})
public class OnlineStoreRunner {
}
