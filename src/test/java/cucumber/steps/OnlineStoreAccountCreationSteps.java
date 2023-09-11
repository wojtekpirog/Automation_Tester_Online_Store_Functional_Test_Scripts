package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.time.Duration;
import java.util.NoSuchElementException;

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

  @When("User creates an address with {string}, {string}, {string}, {word}, {string}, {string}")
  public void createAnAddressWith(String alias, String address, String city, String zipcode, String country, String phone) {
    MyAccountPage myAccountPage = new MyAccountPage(this.browser);
    myAccountPage.goToAddressCreationForm();

    YourAddressesPage pageWithAddresses = new YourAddressesPage(this.browser);
    pageWithAddresses.goToAddressCreationForm();

    AddressCreationForm addressCreationForm = new AddressCreationForm(this.browser);
    addressCreationForm.fillInFormWith(alias, address, city, zipcode, country, phone);
  }

  @Then("The address is created with appropriate data: {string}, {string}, {string}, {word}, {string}, {string}")
  public void checkData(String expectedAlias, String expectedAddress, String expectedCity, String expectedZipcode, String expectedCountry, String expectedPhone) {
    YourAddressesPage pageWithAddresses = new YourAddressesPage(this.browser);
    pageWithAddresses.checkData(expectedAlias, expectedAddress, expectedCity, expectedZipcode, expectedCountry, expectedPhone);
  }

  @And("User can delete the address")
  public void deleteAddress() {
    YourAddressesPage pageWithAddresses = new YourAddressesPage(this.browser);
    pageWithAddresses.deleteAddress();
  }

  @Then("The address is not visible in the Addresses page")
  public void assertAddressDeleted() {
    YourAddressesPage pageWithAddresses = new YourAddressesPage(this.browser);
    pageWithAddresses.assertThatAddressIsNotPresent();
  }
}
