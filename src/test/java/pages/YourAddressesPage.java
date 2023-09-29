package pages;

import auxiliaryClasses.AddressVerification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddressesPage {
  private static final Logger log = LogManager.getLogger(YourAddressesPage.class);
  private final WebDriver browser;
  @FindBy(xpath = "//section[@id=\"content\"]/div[last()-2]")
  private WebElement lastAddressBody;
  @FindBy(xpath = "//a[@data-link-action=\"add-address\"]")
  private WebElement createNewAddressAnchor;
  @FindBy(xpath = "//section[@id=\"content\"]/div[last()-2]//a[@data-link-action=\"delete-address\"]")
  private WebElement deleteAddressAnchor;
  @FindBy(xpath = "//article[@data-alert='success']/ul/li")
  private WebElement successAlert;

  public YourAddressesPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  public void deleteAddress() {
    try {
      deleteAddressAnchor.click();
      log.info("The \"Delete\" anchor inside Page Object \"YourAddressesPage\" was clicked. Waiting for deletion confirmation...");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find an element \"deleteAddressAnchor\" inside Page Object \"YourAddressesPage\". Make sure your selector is correct.❌. More information: " + e.getMessage());
      Assert.fail("❌Test script failed to delete the address and reported \"NoSuchElementException\" because of not being able to locate WebElement \"deleteAddressAnchor\" inside Page Object \"YourAddressesPage\". Check your selector or pick a different locator strategy.❌");
    }
  }

  public void goToAddressCreationForm() {
    try {
      createNewAddressAnchor.click();
      log.info("User clicked WebElement \"createNewAddressAnchor\" inside Page Object \"YourAddressesPage\" and was directed to Page Object \"AddressCreationForm\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"createNewAddressAnchor\" inside Page Object \"YourAddressesPage\". Make sure your selector is correct.❌. More information: " + e.getMessage());
      Assert.fail("❌Test script failed to direct user to PageObject \"AddressCreationForm\" and reported \"NoSuchElementException\" because of not being able to find WebElement \"createNewAddressAnchor\" inside Page Object \"YourAddressesPage\". Check your selector or pick a different locator strategy.❌");
    }
  }

  public void assertThatAddressWasDeleted() {
    try {
      Assert.assertTrue(successAlert.getText().contains("deleted"));
      log.info("✅Address has been deleted successfully.✅");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"successAlert\" inside Page Object \"YourAddressesPage\". Make sure your selector is correct.❌. More information: " + e.getMessage());
      Assert.fail("❌Test script failed to check the text content of WebElement \"successAlert\" and assert that address was successfully deleted because of not being able to locate WebElement \"successAlert\" inside Page Object \"YourAddressesPage\". Check your selector or pick a different locator strategy.❌");
    } catch (AssertionError e) {
      log.error("WebElement \"successAlert\" does not provide information on the address deletion success, so the address may still be present inside Page Object \"YourAddressesPage\". Make sure you defined a correct selector and picked the most suitable locator strategy for WebElement \"successAlert\" and that it is fully visible on the page. More information: " + e.getMessage());
      Assert.fail("❌Test script failed to assert that address was deleted successfully and reported the following exception: \"" + e.getClass().getSimpleName() + "\".❌ Make sure you provided an appropriate selector and/or picked the most suitable locator strategy for WebElement \"successAlert\", and also check its locating code for any spelling or punctuation errors.");
    }
  }

  public void checkData(String expectedAlias, String expectedStreetAddress, String expectedCity, String expectedZipcode, String expectedCountry, String expectedPhoneNumber) {
    AddressVerification addressVerification = new AddressVerification(browser);
    try {
      String textContentOfAddress = lastAddressBody.getText();
      addressVerification.assertAliasIsCorrect(textContentOfAddress, expectedAlias);
      addressVerification.assertStreetAddressIsCorrect(textContentOfAddress, expectedStreetAddress);
      addressVerification.assertCityNameIsCorrect(textContentOfAddress, expectedCity);
      addressVerification.assertZipcodeIsCorrect(textContentOfAddress, expectedZipcode);
      addressVerification.assertCountryIsCorrect(textContentOfAddress, expectedCountry);
      addressVerification.assertPhoneNumberIsCorrect(textContentOfAddress, expectedPhoneNumber);
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"lastAddressBody\" inside Page Object \"YourAddressesPage\". Make sure your selector is correct.❌. More information: " + e.getMessage());
    }
  }
}
