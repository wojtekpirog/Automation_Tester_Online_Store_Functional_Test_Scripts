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

  //Method to assert that address is not present after deletion
  public void assertThatAddressWasDeleted() {
    //Check if address does not exist on the 'Addresses' page:
    try {
      Assert.assertTrue(successAlert.getText().contains("deleted"));
      log.info("✅Address has been deleted successfully.✅");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"successAlert\" inside Page Object \"YourAddressesPage\". Make sure your selector is correct.❌. More information: " + e.getMessage());
    } catch (AssertionError e) {
      log.error("Address is still visible on the \"Your addresses\" page. Make sure you defined an accurate selector for WebElement \"successAlert\". More information: " + e.getMessage());
    }
  }

  //Method to check if entered data is correct:
  public void checkData(String expectedAlias, String expectedStreetAddress, String expectedCity, String expectedZipcode, String expectedCountry, String expectedPhone) {
    try {
      String addressText = lastAddressBody.getText();
      //Compare data in the address box with expected data:
      try {
        assertContains(addressText, expectedAlias, expectedStreetAddress, expectedCity, expectedZipcode, expectedCountry, expectedPhone);
        log.info("✅All entries regarding user address information are verified and correct✅");
      } catch (AssertionError e) {
        log.error("Assertion error - test failed to assert that all actual user address data equal with the expected address data for tested field. More information on this error: " + e.getMessage());
      }
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\". Make sure your selector is correct.❌. More information: " + e.getMessage());
    }
  }
  //Method to compare data in the address box and assert it is correct:
  public void assertContains(String textContent, String alias, String streetAddress, String city, String zipcode, String country, String phone) {
    Assert.assertTrue(textContent.contains(alias));
    Assert.assertTrue(textContent.contains(streetAddress));
    Assert.assertTrue(textContent.contains(city));
    Assert.assertTrue(textContent.contains(zipcode));
    Assert.assertTrue(textContent.contains(country));
    Assert.assertTrue(textContent.contains(phone));
  }
}
