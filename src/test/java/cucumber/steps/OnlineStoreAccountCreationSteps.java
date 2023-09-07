package cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddressCreationForm;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;

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

  @When("User creates an address with {string}, {string}, {string}, {word}, {string}, {word}")
  public void createAnAddress(String alias, String address, String city, String zipcode, String country, String phone) {
    MyAccountPage myAccountPage = new MyAccountPage(this.browser);
    myAccountPage.goToAddressCreationForm();

    AddressCreationForm addressCreationForm = new AddressCreationForm(this.browser);
    addressCreationForm.fillInForm(alias, address, city, zipcode, country, phone);
  }
}
