package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

public class OnlineStoreRunner {
  @RunWith(Cucumber.class)
  @CucumberOptions(features = "src/test/cucumber/features/", plugin = {"pretty", "html:report.html"})
  public class OnlineStoreTest {

  }
}
