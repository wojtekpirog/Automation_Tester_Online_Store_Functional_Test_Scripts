package pages;

import auxiliaryClasses.AddressInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressCreationForm {
  private final WebDriver browser;
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
    AddressInformation addressInformation = new AddressInformation(browser);
    addressInformation.enterAlias(aliasInput, alias);
    addressInformation.enterStreetAddress(streetAddressInput, streetAddress);
    addressInformation.enterCity(cityInput, city);
    addressInformation.enterZipcode(zipcodeInput, zipcode);
    addressInformation.selectCountry(countryDropdown, country);
    addressInformation.enterPhoneNumber(phoneInput, phoneNumber);
    addressInformation.submitForm(submitFormButton);
  }
}
