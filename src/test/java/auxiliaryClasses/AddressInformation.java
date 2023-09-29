package auxiliaryClasses;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressInformation {
  private static final Logger log = LogManager.getLogger(AddressInformation.class);
  private final WebDriver browser;
  public AddressInformation(WebDriver browser) {
    this.browser = browser;
  }

  public void enterAlias(WebElement aliasInput, String alias) {
    try {
      aliasInput.clear();
      aliasInput.sendKeys(alias);
      log.info("Form control WebElement \"aliasInput\" inside Page Object \"AddressCreationForm\" was filled with the following data: " + alias + ".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"aliasInput\" inside Page Object \"AddressCreationForm\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script reported \"NoSuchElementException\" because of not being able to find WebElement \"aliasInput\" inside Page Object \"AddressCreationForm\".❌");
    }
  }

  public void enterStreetAddress(WebElement addressInput, String streetAddress) {
    try {
      addressInput.clear();
      addressInput.sendKeys(streetAddress);
      log.info("Form control WebElement \"addressInput\" inside Page Object \"AddressCreationForm\" was filled with the following data: " + streetAddress + ".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"addressInput\" inside Page Object \"AddressCreationForm\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script reported \"NoSuchElementException\" because of not being able to find WebElement \"addressInput\" inside Page Object \"AddressCreationForm\".❌");
    }
  }

  public void enterCity(WebElement cityInput, String city) {
    try {
      cityInput.clear();
      cityInput.sendKeys(city);
      log.info("Form control WebElement \"cityInput\" inside Page Object \"AddressCreationForm\" was filled with the following data: " + city);
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"cityInput\" inside Page Object \"AddressCreationForm\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script reported \"NoSuchElementException\" because of not being able to find WebElement \"cityInput\" inside Page Object \"AddressCreationForm\".❌");
    }
  }

  public void enterZipcode(WebElement zipcodeInput, String zipcode) {
    try {
      zipcodeInput.clear();
      zipcodeInput.sendKeys(zipcode);
      log.info("Form control WebElement \"cityInput\" inside Page Object \"AddressCreationForm\" was filled with the following data: " + zipcode + ".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"zipcodeInput\" inside Page Object \"AddressCreationForm\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script reported \"NoSuchElementException\" because of not being able to find WebElement \"zipcodeInput\" inside Page Object \"AddressCreationForm\".❌");
    }
  }

  public void selectCountry(WebElement countryDropdown, String country) {
    Select countrySelect = new Select(countryDropdown);
    try {
      countryDropdown.click();
      log.info("Dropdown list WebElement \"countryDropdown\" inside Page Object \"AddressCreationForm\" was clicked and available options were displayed.");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"countryDropdown\" inside Page Object \"AddressCreationForm\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script reported \"NoSuchElementException\" because of not being able to find WebElement \"countryDropdown\" inside Page Object \"AddressCreationForm\".❌");
    }
    try {
      countrySelect.selectByVisibleText(country);
      log.info("Dropdown list option \"" + country + "\" was selected.");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test was unable to find and select option of drop-down WebElement \"countryDropdown\" inside Page Object \"AddressCreationForm\" that corresponds with the option value provided by scenario (\"" + country + "\").❌ More information: " + e.getMessage());
      Assert.fail("❌Test script reported \"NoSuchElementException\" because of not being able to find and select any visible option inside drop-down WebElement \"countryDropdown\" inside Page Object \"AddressCreationForm\". Make sure to provide an option value that corresponds to any of the option value available in the drop-down menu option list.❌ More information: " + e.getMessage());
    }
  }

  public void enterPhoneNumber(WebElement phoneInput, String phoneNumber) {
    try {
      phoneInput.clear();
      phoneInput.sendKeys(phoneNumber);
      log.info("Form control WebElement \"phoneNumberInput\" inside Page Object \"AddressCreationForm\" was filled with the following data: " + phoneNumber + ".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"phoneInput\" inside Page Object \"AddressCreationForm\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script reported \"NoSuchElementException\" because of not being able to find WebElement \"phoneNumberInput\" inside Page Object \"AddressCreationForm\".❌");
    }
  }

  public void submitForm(WebElement submitFormButton) {
    try {
      submitFormButton.click();
      log.info("Button WebElement \"submitFormButton\" inside Page Object \"AddressCreationForm\" was clicked and the form was submitted.");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"submitFormButton\" inside Page Object \"AddressCreationForm\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script reported \"NoSuchElementException\" because of not being able to find WebElement \"submitInputButton\" inside Page Object \"AddressCreationForm\".❌");
    }
  }
}
