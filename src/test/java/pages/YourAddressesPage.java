package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddressesPage {
  private static final Logger log = LogManager.getLogger(YourAddressesPage.class);
  private WebDriver browser;
  @FindBy(xpath = "//section[@id=\"content\"]/div[last()-2]")
  private WebElement lastAddressBody;
  @FindBy(xpath = "//a[@data-link-action=\"add-address\"]")
  private WebElement createNewAddressAnchor;
  @FindBy(xpath = "//section[@id=\"content\"]/div[last()-2]//a[@data-link-action=\"delete-address\"]")
  private WebElement deleteAddressAnchor;
  @FindBy(xpath = "//article[@data-alert='success']/ul/li")
  private WebElement successAlert;

  public YourAddressesPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }
  //Method to delete an address:
  public void deleteAddress() {
    try {
      deleteAddressAnchor.click();
      log.info("The \"Delete\" anchor inside Page Object \"YourAddressesPage\" was clicked. Waiting for deletion confirmation...");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find an element \"deleteAddressAnchor\" inside Page Object \"YourAddressesPage\". Make sure your selector is correct.❌. More information: " + e.getMessage());
    }
  }
  //Method to start creating a new address by going to an address creation form:
  public void goToAddressCreationForm() {
    try {
      createNewAddressAnchor.click();
      log.info("User clicked WebElement \"createNewAddressAnchor\" inside Page Object \"YourAddressesPage\" and was directed to Page Object \"AddressCreationForm\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"createNewAddressAnchor\" inside Page Object \"YourAddressesPage\". Make sure your selector is correct.❌. More information: " + e.getMessage());
    }
  }

  public void assertThatAddressWasDeleted() {
    //Check if address does not exist on the 'Addresses' page:
    try {
      Assert.assertTrue(successAlert.getText().contains("deleted"));
      log.info("✅Address has been deleted successfully.✅");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"successAlert\" inside Page Object \"YourAddressesPage\". Make sure your selector is correct.❌. More information: " + e.getMessage());
    } catch (AssertionError e) {
      log.error("WebElement \"successAlert\" does not provide information on the address deletion success, so the address may still be visible on the \"Your addresses\" page. Make sure you defined a correct selector for WebElement \"successAlert\" and it is fully visible on the page. More information: " + e.getMessage());
    }
  }

  public void checkData(String expectedAlias, String expectedStreetAddress, String expectedCity, String expectedZipcode, String expectedCountry, String expectedPhone) {
    try {
      String addressText = lastAddressBody.getText();
      try {
        assertContains(addressText, expectedAlias, expectedStreetAddress, expectedCity, expectedZipcode, expectedCountry, expectedPhone);
        log.info("✅All entries regarding user address information are verified and correct✅");
      } catch (AssertionError e) {
        log.error("Assertion error emerged - test failed to assert that all user address data contained within text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" match the ones specified in scenario. More information: " + e.getMessage());
      }
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\". Make sure your selector is correct.❌. More information: " + e.getMessage());
    }
  }

  public void assertContains(String textContent, String alias, String streetAddress, String city, String zipcode, String country, String phone) {
    Assert.assertTrue(textContent.contains(alias));
    log.info("Test checked if text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains the following alias: " + alias + ".");
    Assert.assertTrue(textContent.contains(streetAddress));
    log.info("Test checked if text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains the following street address: " + streetAddress + ".");
    Assert.assertTrue(textContent.contains(city));
    log.info("Test checked if text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains the following city name: " + city + ".");
    Assert.assertTrue(textContent.contains(zipcode));
    log.info("Test checked if text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains the following zipcode: " + zipcode + ".");
    Assert.assertTrue(textContent.contains(country));
    log.info("Test checked if text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains the following country: " + country + ".");
    Assert.assertTrue(textContent.contains(phone));
    log.info("Test checked if text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains the following phone number: " + phone + ".");
  }
}
