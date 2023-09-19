package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddressCreationForm {
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
    } catch (NoSuchElementException e) {
      Assert.fail("❌Failed to find form element(s) from \"AddressCreationForm\"❌. More information: " + e.getMessage());
    }
  }
  //Method to clear form input and type in desired text:
  private void clearAndType(WebElement element, String text) {
    element.clear();
    element.sendKeys(text);
  }
}
