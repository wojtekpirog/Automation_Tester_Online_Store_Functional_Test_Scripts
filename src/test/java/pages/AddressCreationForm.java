package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressCreationForm {
  private static final Logger log = Logger.getLogger(AddressCreationForm.class);
  private WebDriver browser;
  @FindBy(xpath = "//input[@id=\"field-alias\"]")
  private WebElement aliasInput;
  @FindBy(xpath = "//input[@id=\"field-address1\"]")
  private WebElement addressInput;
  @FindBy(xpath = "//input[@id=\"field-city\"]")
  private WebElement cityInput;
  @FindBy(xpath = "//input[@id=\"field-postcode\"]")
  private WebElement zipcodeInput;
  @FindBy(xpath = "//select[@id=\"field-id_country\"]")
  private WebElement countryDropdown;
  @FindBy(xpath = "//input[@id=\"field-phone\"]")
  private WebElement phoneInput;
  @FindBy(xpath = "//section[@id=\"content\"]//button")
  private WebElement saveButton;

  public AddressCreationForm(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  //Method to fill in a form:
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
      log.info("ℹ️Form in Page Object \"AddressCreationForm\" was filled and saved.ℹ️");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find an element inside Page Object \"AddressCreationForm\"❌. Please check the selector you defined for form elements. More information: " + e.getMessage());
    }
  }
  //Method to clear form input and type in desired text:
  private void clearAndType(WebElement element, String text) {
    element.clear();
    element.sendKeys(text);
  }
}
