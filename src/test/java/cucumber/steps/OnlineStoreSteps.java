package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class OnlineStoreSteps {
  private WebDriver browser;

  @Given("User is logged in to their homepage")
  public void LogInToUserAccount() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
    browser = new ChromeDriver();
    browser.manage().window().maximize();
    browser.get("https://mystore-testlab.coderslab.pl/index.php?");

    MainPage mainPage = new MainPage(browser);
    mainPage.goToLoginPage();

    LoginPage loginPage = new LoginPage(browser);
    loginPage.loginUser();
  }

  @When("User creates an address with {string}, {string}, {string}, {word}, {string}, {string}")
  public void createAnAddressWith(String alias, String address, String city, String zipcode, String country, String phone) {
    MyAccountPage myAccountPage = new MyAccountPage(browser);
    myAccountPage.goToAddressCreationForm();

    YourAddressesPage yourAddressesPage = new YourAddressesPage(browser);
    yourAddressesPage.goToAddressCreationForm();

    AddressCreationForm addressCreationForm = new AddressCreationForm(browser);
    addressCreationForm.fillInFormWith(alias, address, city, zipcode, country, phone);
  }

  @When("User places an order for {int} pieces of sweater of size {word}")
  public void placeAnOrder(int quantity, String size) {
    MyAccountPage myAccountPage = new MyAccountPage(browser);
    myAccountPage.goToHomePage();

    MainPage mainPage = new MainPage(browser);
    mainPage.openProductDetailsPage();

    ProductDetailsPage pdp = new ProductDetailsPage(browser);
    pdp.checkForDiscount();
    pdp.addProductToCart(quantity, size);

    ShoppingCartPage shoppingCart = new ShoppingCartPage(browser);
    shoppingCart.proceedToCheckout();

    DeliveryAndPaymentInformationPage informationPage = new DeliveryAndPaymentInformationPage(browser);
    informationPage.AcceptAddressInformation();
  }

  @Then("User can see the order confirmation along with its amount")
  public void takeScreenshotWithOrderConfirmation() {
    String pathWithFile = "C:\\Users\\HARDPC\\Pictures\\Screenshots\\confirmation_screenshot.png";
    OrderConfirmationPage confirmationPage = new OrderConfirmationPage(browser);
    confirmationPage.takeScreenshot(pathWithFile);
  }

  @Then("The address is created with appropriate data: {string}, {string}, {string}, {word}, {string}, {string}")
  public void checkData(String expectedAlias, String expectedAddress, String expectedCity, String expectedZipcode, String expectedCountry, String expectedPhone) {
    YourAddressesPage pageWithAddresses = new YourAddressesPage(browser);
    pageWithAddresses.checkData(expectedAlias, expectedAddress, expectedCity, expectedZipcode, expectedCountry, expectedPhone);
  }

  @And("User can delete the address")
  public void deleteAddress() {
    YourAddressesPage pageWithAddresses = new YourAddressesPage(browser);
    pageWithAddresses.deleteAddress();
  }

  @Then("The address is not visible in the Addresses page")
  public void assertAddressDeleted() {
    YourAddressesPage pageWithAddresses = new YourAddressesPage(browser);
    pageWithAddresses.assertThatAddressWasDeleted();
  }
}
