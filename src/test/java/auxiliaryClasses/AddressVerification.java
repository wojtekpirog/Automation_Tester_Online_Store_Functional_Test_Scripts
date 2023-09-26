package auxiliaryClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddressVerification {
  private static final Logger log = LogManager.getLogger(AddressVerification.class);
  private WebDriver browser;
  public AddressVerification(WebDriver browser) {
    this.browser = browser;
  }

  public void assertAliasIsCorrect(String textContent, String alias) {
    try {
      Assert.assertTrue(textContent.contains(alias));
      log.info("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains data (Alias) expected by scenario.");
    } catch (AssertionError e) {
      log.error("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" does not contain data (Alias) expected by scenario. More information: " + e.getMessage());
    }
  }

  public void assertStreetAddressIsCorrect(String textContent, String streetAddress) {
    try {
      Assert.assertTrue(textContent.contains(streetAddress));
      log.info("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains data (Address) expected by scenario.");
    } catch (AssertionError e) {
      log.error("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" does not contain data (Address) expected by scenario. More information: " + e.getMessage());
    }
  }

  public void assertCityNameIsCorrect(String textContent, String city) {
    try {
      Assert.assertTrue(textContent.contains(city));
      log.info("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains data (City) expected by scenario.");
    } catch (AssertionError e) {
      log.error("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" does not contain data (City) expected by scenario. More information: " + e.getMessage());
    }
  }

  public void assertZipcodeIsCorrect(String textContent, String zipcode) {
    try {
      Assert.assertTrue(textContent.contains(zipcode));
      log.info("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains data (Zip/Postal Code) expected by scenario.");
    } catch (AssertionError e) {
      log.error("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" does not contain data (Zip/Postal Code) specified by scenario. More information: " + e.getMessage());
    }
  }

  public void assertCorrectCountryWasSelected(String textContent, String country) {
    try {
      Assert.assertTrue(textContent.contains(country));
      log.info("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains data (Country) expected by scenario.");
    } catch (AssertionError e) {
      log.error("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" does not contain data (Country) expected by scenario. More information: " + e.getMessage());
    }
  }

  public void assertPhoneNumberIsCorrect(String textContent, String phoneNumber) {
    try {
      Assert.assertTrue(textContent.contains(phoneNumber));
      log.info("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains data (PhoneNumber) expected by scenario.");
    } catch (AssertionError e) {
      log.error("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" does not contain data (PhoneNumber) expected by scenario. More information: " + e.getMessage());
    }
  }
}
