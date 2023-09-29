package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
  private static final Logger log = LogManager.getLogger(ShoppingCartPage.class);
  private final WebDriver browser;
  @FindBy(xpath = "//a[text()='Proceed to checkout']")
  private WebElement proceedToCheckoutAnchor;

  public ShoppingCartPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  public void proceedToCheckout() {
    try {
      proceedToCheckoutAnchor.click();
      log.info("User clicked WebElement \"proceedToCheckoutAnchor\" inside Page Object \"ShoppingCartPage\" and was directed to PageObject \"DeliveryAndPaymentInformationPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Failed to find an element \"proceedToCheckoutAnchor\" inside Page Object \"ShoppingCartPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script failed to direct user to Page Object \"DeliveryAndPaymentInformationPage\" reported \"NoSuchElementException\" because of not being able to find WebElement \"proceedToCheckoutAnchor\" inside Page Object \"ShoppingCartPage\". Check your selector or pick a different locator strategy.❌");
    }
  }
}
