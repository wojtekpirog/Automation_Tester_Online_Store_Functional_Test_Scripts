package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddressCreationForm {
  private WebDriver browser;
  public AddressCreationForm(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

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

  public void fillInFormWith(String alias, String address, String city, String zipcode, String country, String phone) {
    try {
      this.aliasInput.clear();
      this.aliasInput.sendKeys(alias);
      this.addressInput.clear();
      this.addressInput.sendKeys(address);
      this.cityInput.clear();
      this.cityInput.sendKeys(city);
      this.zipcodeInput.clear();
      this.zipcodeInput.sendKeys(zipcode);
      this.countryDropdown.click();
      Select countrySelect = new Select(this.countryDropdown);
      countrySelect.selectByVisibleText(country);
      this.phoneInput.clear();
      this.phoneInput.sendKeys(phone);
      this.saveButton.click();
      System.out.println("✅All inputs were found and filled correctly✅");
    } catch (NoSuchElementException e) {
      Assert.fail("❌Test failed to find an element from \"AddressCreationForm\". Make sure your selector is correct❌ More information: " + e.getMessage());
    }
  }
}
