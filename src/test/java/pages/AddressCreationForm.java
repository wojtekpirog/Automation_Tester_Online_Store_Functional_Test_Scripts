package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressCreationForm {
  private WebDriver browser;
  public AddressCreationForm(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  @FindBy(xpath = "//*[@id=\"field-alias\"]")
  private WebElement aliasInput;
  @FindBy(xpath = "//*[@id=\"field-address1\"]")
  private WebElement addressInput;
  @FindBy(xpath = "//*[@id=\"field-city\"]")
  private WebElement cityInput;
  @FindBy(xpath = "//*[@id=\"field-postcode\"]")
  private WebElement zipcodeInput;
  @FindBy(xpath = "//*[@id=\"field-id_country\"]")
  private WebElement countryDropdown;
  @FindBy(xpath = "//*[@id=\"field-phone\"]")
  private WebElement phoneInput;
  @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
  private WebElement saveButton;

  public void fillInFormWith(String alias, String address, String city, String zipcode, String country, String phone) {
    this.aliasInput.sendKeys(alias);
    this.addressInput.sendKeys(address);
    this.cityInput.sendKeys(city);
    this.zipcodeInput.sendKeys(zipcode);
    Select countrySelect = new Select(this.countryDropdown);
    countrySelect.selectByVisibleText(country);
    this.phoneInput.sendKeys(phone);
    this.saveButton.click();
  }
}
