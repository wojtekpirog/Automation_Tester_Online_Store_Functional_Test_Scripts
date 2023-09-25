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
  private WebElement goToShippingMethodsButton;
  @FindBy(xpath = "//input[@id='delivery_option_8']/following-sibling::span")
  private WebElement pickUpInStore;
  @FindBy(name = "confirmDeliveryOption")
  private WebElement confirmDeliveryOption;
  @FindBy(id = "payment-option-1")
  private WebElement payByCheck;
  @FindBy(id = "conditions_to_approve[terms-and-conditions]")
  private WebElement approveConditions;
  @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
  private WebElement placeOrderButton;

  public DeliveryAndPaymentInformationPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  public void placeOrder() {
    try {
      selectOrderInformation(homeAddress, goToShippingMethodsButton, pickUpInStore, confirmDeliveryOption, payByCheck, approveConditions, placeOrderButton);
      log.info("User placed an order by selecting appropriate delivery and payment options and accepting conditions inside Page Object \"DeliveryAndPaymentInformationPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find form control(s) inside Page Object \"DeliveryAndPaymentInformationPage\"❌. Please check the selectors you defined for WebElements in this Page Object. More information: " + e.getMessage());
    }
  }

  public void selectOrderInformation(WebElement homeAddress, WebElement goToShippingMethodsButton, WebElement pickUpInStore, WebElement confirmDeliveryOption, WebElement payByCheck, WebElement approveConditions, WebElement placeOrderButton) {
    homeAddress.click();
    log.info("Shipping address was selected by clicking on WebElement \"homeAddress\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
    goToShippingMethodsButton.click();
    log.info("User was directed to shipping methods by clicking on WebElement \"goToShippingMethodsButton\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
    pickUpInStore.click();
    log.info("Delivery option \"pick up in store\" was selected by clicking on WebElement \"pickUpInStore\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
    confirmDeliveryOption.click();
    log.info("Delivery option was confirmed by clicking on WebElement \"confirmDeliveryOption\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
    payByCheck.click();
    log.info("Payment option \"Pay by Check\" was selected by clicking on WebElement \"payByCheck\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
    approveConditions.click();
    log.info("Conditions were approved by clicking on WebElement \"approveConditions\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
    placeOrderButton.click();
    log.info("WebElement \"PlaceOrderButton\" was clicked inside Page Object \"DeliveryAndPaymentInformationPage\".");
  }
}
