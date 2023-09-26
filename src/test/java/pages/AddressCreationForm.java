package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import auxiliaryClasses.AddressInformation;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressCreationForm {
  private static final Logger log = LogManager.getLogger(AddressCreationForm.class);
  private WebDriver browser;
  @FindBy(id = "field-alias")
  private WebElement aliasInput;
  @FindBy(id = "field-address1")
  private WebElement streetAddressInput;
  @FindBy(id = "field-city")
  private WebElement cityInput;
  @FindBy(id = "field-postcode")
  private WebElement zipcodeInput;
  @FindBy(id = "field-id_country")
  private WebElement countryDropdown;
  @FindBy(id = "field-phone")
  private WebElement phoneInput;
  @FindBy(xpath = "//section[@id=\"content\"]//button")
  private WebElement submitFormButton;

  public AddressCreationForm(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  public void fillInFormWith(String alias, String streetAddress, String city, String zipcode, String country, String phoneNumber) {
    try {
      AddressInformation addressInformation = new AddressInformation(browser);
      addressInformation.enterAlias(aliasInput, alias);
      addressInformation.enterStreetAddress(streetAddressInput, streetAddress);
      addressInformation.enterCity(cityInput, city);
      addressInformation.enterZipcode(zipcodeInput, zipcode);
      addressInformation.selectCountry(countryDropdown, country);
      addressInformation.enterPhoneNumber(phoneInput, phoneNumber);
      addressInformation.submitForm(submitFormButton);
      log.info("The address creation form inside Page Object \"AddressCreationForm\" was filled with data from scenario and submitted.");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find a form control or a submit button inside Page Object \"AddressCreationForm\"❌. Please check the selector you defined for form elements. More information: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
