package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressCreationForm {
  private static final Logger log = LogManager.getLogger(AddressCreationForm.class);
  private WebDriver browser;
  @FindBy(id = "field-alias")
  private WebElement aliasInput;
  @FindBy(id = "field-address1")
  private WebElement addressInput;
  @FindBy(id = "field-city")
  private WebElement cityInput;
  @FindBy(id = "field-postcode")
  private WebElement zipcodeInput;
  @FindBy(id = "field-id_country")
  private WebElement countryDropdown;
  @FindBy(id = "field-phone")
  private WebElement phoneInput;
  @FindBy(xpath = "//section[@id=\"content\"]//button")
  private WebElement saveButton;

  public AddressCreationForm(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  public void fillInFormWith(String alias, String address, String city, String zipcode, String country, String phone) {
    try {
      clearAndType(aliasInput, alias);
      clearAndType(addressInput, address);
      clearAndType(cityInput, city);
      clearAndType(zipcodeInput, zipcode);
      countryDropdown.click();
      Select countrySelect = new Select(countryDropdown);
      countrySelect.selectByVisibleText(country);
      clearAndType(phoneInput, phone);
      saveButton.click();
      log.info("The form inside Page Object \"AddressCreationForm\" was filled with data from scenario and WebElement \"saveButton\" was clicked to submit the form.");
    } catch (NoSuchElementException e) {
//      log.error("Test encountered an exception while filling the form inside Page Object \"AddressCreationForm\". Error type: " + e.getClass().getSimpleName() + ". More information: " + e.getMessage());
      log.fatal("❌Test failed to find a form control or a submit button inside Page Object \"AddressCreationForm\"❌. Please check the selector you defined for form elements. More information: " + e.getMessage());
      e.printStackTrace();
    }
  }

  private void clearAndType(WebElement element, String text) {
    element.clear();
    element.sendKeys(text);
    log.info("Form control \"" + element + "\" inside Page Object \"AddressCreationForm\" was filled with the specific piece of data: " + text);
  }
}
