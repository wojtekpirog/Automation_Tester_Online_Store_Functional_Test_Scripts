package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import java.io.IOException;

public class OnlineStoreSteps {
  private WebDriver browser;

  @Given("User is logged in to their homepage")
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

  @When("User places an order for a specific product")
  public void placeAnOrder() {
    MyAccountPage myAccountPage = new MyAccountPage(this.browser);
    myAccountPage.goToHomePage();

    MainPage mainPage = new MainPage(this.browser);
    mainPage.openProductDetailsPage();

    ProductDetailsPage pdp = new ProductDetailsPage(this.browser);
    pdp.addProductToCart();

    ShoppingCartPage shoppingCart = new ShoppingCartPage(this.browser);
    shoppingCart.proceedToCheckout();

    DeliveryAndPaymentInformationPage informationPage = new DeliveryAndPaymentInformationPage(this.browser);
    informationPage.AcceptAddressInformation();
  }

  @Then("User can see the order confirmation along with its amount")
  public void takeScreenshotWithOrderConfirmation() {
    String pathWithFile = "C:\\Users\\HARDPC\\Pictures\\Screenshots\\confirmation_screenshot.png";
    OrderConfirmationPage confirmationPage = new OrderConfirmationPage(this.browser);
    try {
      confirmationPage.takeScreenshot(pathWithFile);
      System.out.println("✅Screenshot has been taken and saved to " + pathWithFile);
    } catch (IOException e) {
      System.err.println("‼️An error occurred while copying file: " + e.getMessage());
    }
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
