package cucumber.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;

public class OnlineStoreAccountCreationSteps {
  private WebDriver browser;

  @Given("User is logged in to his page")
  public void LogInToUserAccount() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
    this.browser = new ChromeDriver();
    this.browser.manage().window().maximize();
    this.browser.get("https://mystore-testlab.coderslab.pl/index.php?");

    MainPage mainPage = new MainPage(this.browser);
    mainPage.goToLoginPage();

    LoginPage loginPage = new LoginPage(this.browser);
    loginPage.loginUser();
  }
}
