package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryAndPaymentInformationPage {
  private static final Logger log = LogManager.getLogger(DeliveryAndPaymentInformationPage.class);
  private WebDriver browser;
  @FindBy(xpath = "//span[text()='Home Address']")
  private WebElement homeAddress;
  @FindBy(name = "confirm-addresses")
  private WebElement toShippingMethods;
  @FindBy(xpath = "//input[@id='delivery_option_8']/following-sibling::span")
  private WebElement pickUpInStore;
  @FindBy(name = "confirmDeliveryOption")
  private WebElement confirmDeliveryOption;
  @FindBy(id = "payment-option-1")
  private WebElement payByCheck;
  @FindBy(id = "conditions_to_approve[terms-and-conditions]")
  private WebElement approveConditions;
  @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
  private WebElement placeOrder;

  public DeliveryAndPaymentInformationPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  public void placeOrder() {
    try {
      acceptAddressInformation(homeAddress, toShippingMethods, pickUpInStore, confirmDeliveryOption, payByCheck, approveConditions, placeOrder);
      log.info("Details on user address, delivery & payment methods were selected in Page Object \"DeliveryAndPaymentInformationPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find form control(s) inside Page Object \"DeliveryAndPaymentInformationPage\"❌. Please check the selectors you defined for WebElements in this Page Object. More information: " + e.getMessage());
    }
  }
  //Method to accept address information:
  public void acceptAddressInformation(WebElement homeAddress, WebElement toShippingMethods, WebElement pickUpInStore, WebElement confirmDeliveryOption, WebElement payByCheck, WebElement approveConditions, WebElement placeOrder) {
    homeAddress.click();
    toShippingMethods.click();
    pickUpInStore.click();
    confirmDeliveryOption.click();
    payByCheck.click();
    approveConditions.click();
    placeOrder.click();
  }
}
