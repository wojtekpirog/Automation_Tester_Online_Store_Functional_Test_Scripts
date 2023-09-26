package auxiliaryClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderInformation {
  private static final Logger log = LogManager.getLogger(OrderInformation.class);
  private WebDriver browser;
  public OrderInformation(WebDriver browser) {
    this.browser = browser;
  }

  public void selectShippingAddress(WebElement shippingAddress, WebElement confirmAddressButton) {
    shippingAddress.click();
    log.info("Shipping address was selected by clicking on WebElement \"homeAddress\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
    confirmAddressButton.click();
    log.info("User was directed to shipping methods by clicking on WebElement \"goToShippingMethodsButton\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
  }

  public void selectDeliveryMethod(WebElement deliveryMethod, WebElement confirmDeliveryMethod) {
    deliveryMethod.click();
    log.info("Delivery option \"pick up in store\" was selected by clicking on WebElement \"pickUpInStore\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
    confirmDeliveryMethod.click();
    log.info("Delivery option was confirmed by clicking on WebElement \"confirmDeliveryOption\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
  }

  public void selectPaymentMethod(WebElement paymentMethod) {
    paymentMethod.click();
    log.info("Payment option \"Pay by Check\" was selected by clicking on WebElement \"payByCheck\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
  }

  public void approveConditions(WebElement approveConditionsCheckbox) {
    approveConditionsCheckbox.click();
    log.info("Conditions were approved by clicking on WebElement \"approveConditions\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
  }

  public void submitForm(WebElement placeOrderButton) {
    placeOrderButton.click();
    log.info("WebElement \"PlaceOrderButton\" was clicked inside Page Object \"DeliveryAndPaymentInformationPage\".");
  }
}
