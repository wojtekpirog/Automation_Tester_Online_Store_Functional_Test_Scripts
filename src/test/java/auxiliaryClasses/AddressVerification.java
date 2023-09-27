package auxiliaryClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddressVerification {
  private static final Logger log = LogManager.getLogger(AddressVerification.class);
  private final WebDriver browser;
  public AddressVerification(WebDriver browser) {
    this.browser = browser;
  }

  public void assertAliasIsCorrect(String textContent, String alias) {
    try {
      Assert.assertTrue(textContent.contains(alias));
      log.info("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains address-related data (Alias) expected by scenario.");
    } catch (AssertionError e) {
      log.error("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" does not contain address-related data (Alias) expected by scenario. Actual data (alias): \"" + alias + "\" More information: " + e.getMessage());
    }
  }

  public void assertStreetAddressIsCorrect(String textContent, String streetAddress) {
    try {
      Assert.assertTrue(textContent.contains(streetAddress));
      log.info("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains address-related data (Address) expected by scenario.");
    } catch (AssertionError e) {
      log.error("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" does not contain data address-related (Address) expected by scenario. Actual data (streetAddress): \"" + streetAddress + "\" More information: " + e.getMessage());
    }
  }

  public void assertCityNameIsCorrect(String textContent, String city) {
    try {
      Assert.assertTrue(textContent.contains(city));
      log.info("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains address-related data (City) expected by scenario.");
    } catch (AssertionError e) {
      log.error("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" does not contain address-related data (City) expected by scenario. Actual data (City): \"" + city + "\" More information: " + e.getMessage());
    }
  }

  public void assertZipcodeIsCorrect(String textContent, String zipcode) {
    try {
      Assert.assertTrue(textContent.contains(zipcode));
      log.info("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains address-related data (Zip/Postal Code) expected by scenario.");
    } catch (AssertionError e) {
      log.error("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" does not contain address-related data (Zip/Postal Code) specified by scenario. Actual data (Zip/Postal Code): \"" + zipcode + "\" More information: " + e.getMessage());
    }
  }

  public void assertCountryIsCorrect(String textContent, String country) {
    try {
      Assert.assertTrue(textContent.contains(country));
      log.info("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains data address-related (Country) expected by scenario.");
    } catch (AssertionError e) {
      log.error("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" does not contain address-related data (Country) expected by scenario. Actual data (Country): \"" + country + "\" More information: " + e.getMessage());
    }
  }

  public void assertPhoneNumberIsCorrect(String textContent, String phoneNumber) {
    try {
      Assert.assertTrue(textContent.contains(phoneNumber));
      log.info("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" contains address-related data (PhoneNumber) expected by scenario.");
    } catch (AssertionError e) {
      log.error("Text content of WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\" does not contain address-related data (PhoneNumber) expected by scenario. Actual data (PhoneNumber): \"" + phoneNumber + "\" More information: " + e.getMessage());
    }
  }
}
