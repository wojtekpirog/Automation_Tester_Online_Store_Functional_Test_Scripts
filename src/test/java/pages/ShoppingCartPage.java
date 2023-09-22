package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
  private static final Logger log = LogManager.getLogger(ShoppingCartPage.class);
  private WebDriver browser;
  @FindBy(xpath = "//a[text()='Proceed to checkout']")
  private WebElement proceedToCheckoutAnchor;

  public ShoppingCartPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }
  //Method to proceed to checkout page:
  public void proceedToCheckout() {
    try {
      proceedToCheckoutAnchor.click();
      log.info("ℹ️User clicked WebElement \"proceedToCheckoutAnchor\" inside Page Object \"ShoppingCartPage\" and was directed to PageObject \"DeliveryAndPaymentInformationPage\".ℹ️");
    } catch (NoSuchElementException e) {
      log.fatal("❌Failed to find an element \"proceedToCheckoutAnchor\" inside Page Object \"ShoppingCartPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }
}
