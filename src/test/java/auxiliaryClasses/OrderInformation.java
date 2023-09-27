package auxiliaryClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderInformation {
  private static final Logger log = LogManager.getLogger(OrderInformation.class);
  private final WebDriver browser;
  public OrderInformation(WebDriver browser) {
    this.browser = browser;
  }

  public void selectShippingAddress(WebElement shippingAddress, WebElement confirmAddressButton) {
    try {
      shippingAddress.click();
      log.info("Shipping address was selected by clicking on WebElement \"homeAddress\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"shippingAddress\" inside Page Object \"DeliveryAndPaymentInformationPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script failed to select the preferred shipping address and reported \"NoSuchElementException\" because of not being able to locate WebElement \"deliveryMethod\" inside Page Object \"DeliveryAndPaymentInformationPage\". Check and modify your selector or pick a different locator strategy.❌");
    }
    try {
      confirmAddressButton.click();
      log.info("User was directed to shipping methods by clicking on WebElement \"goToShippingMethodsButton\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"confirmAddressButton\" inside Page Object \"DeliveryAndPaymentInformationPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script failed to confirm the preferred shipping address and go delivery method selection and reported \"NoSuchElementException\" because of not being able to locate WebElement \"confirmAddressButton\" inside Page Object \"DeliveryAndPaymentInformationPage\". Check and modify your selector or pick a different locator strategy.❌");
    }
  }

  public void selectDeliveryMethod(WebElement deliveryMethod, WebElement confirmDeliveryMethod) {
    try {
      deliveryMethod.click();
      log.info("Delivery option \"pick up in store\" was selected by clicking on WebElement \"pickUpInStore\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"deliveryMethod\" inside Page Object \"DeliveryAndPaymentInformationPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script failed to select the preferred delivery method and reported \"NoSuchElementException\" because of not being able to locate WebElement \"deliveryMethod\" inside Page Object \"DeliveryAndPaymentInformationPage\". Check and modify your selector or pick a different locator strategy.❌");
    } catch (ElementClickInterceptedException e) {
      log.fatal("❌Test failed to click on WebElement \"deliveryMethod\" inside Page Object \"DeliveryAndPaymentInformationPage\" because it might have been intercepted or covered by another WebElement, like pop-up notifications, <span></span> HTML elements or alerts during interaction attempt❌. More information: " + e.getMessage());
      Assert.fail("❌Test script failed to click the intended WebElement and reported \"ElementClickInterceptedException\" because WebElement \"deliveryMethod\" inside Page Object \"DeliveryAndPaymentInformationPage\" might have been intercepted or covered by another WebElement. Make sure the WebElement has been loaded and is fully visible and active before next interaction attempt.❌");
    }
    try {
      confirmDeliveryMethod.click();
      log.info("Delivery option was confirmed by clicking on WebElement \"confirmDeliveryOption\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("Test script failed to find WebElement \"confirmDeliveryMethod\" inside Page Object \"DeliveryAndPaymentInformationPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script failed to confirm user's preferred delivery method and reported \"NoSuchElementException\" because of not being able to locate WebElement \"confirmDeliveryMethod\" inside Page Object \"DeliveryAndPaymentInformationPage\". Check and modify your selector or pick a different locator strategy.❌");
    }
  }
  public void selectPaymentMethod(WebElement paymentMethod) {
    try {
      paymentMethod.click();
      log.info("Payment option \"Pay by Check\" was selected by clicking on WebElement \"paymentMethod\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"paymentMethod\" inside Page Object \"DeliveryAndPaymentInformationPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script failed to select the preferred payment method and reported \"NoSuchElementException\" because of not being able to locate WebElement \"paymentMethod\" inside Page Object \"DeliveryAndPaymentInformationPage\". Check and modify your selector or pick a different locator strategy.❌");
    }
  }public void approveConditions(WebElement approveConditionsCheckbox) {
    try {
      approveConditionsCheckbox.click();
      log.info("Conditions were approved by clicking on WebElement \"approveConditionsCheckbox\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"approveConditionsCheckbox\" inside Page Object \"DeliveryAndPaymentInformationPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script failed to approve terms and conditions of the website and reported \"NoSuchElementException\" because of not being able to locate WebElement \"approveConditionsCheckbox\" inside Page Object \"DeliveryAndPaymentInformationPage\". Check and modify your selector or pick a different locator strategy.❌");
    } catch (ElementClickInterceptedException e) {
      log.fatal("Test failed to click on WebElement \"approveConditionsCheckbox\" inside Page Object \"DeliveryAndPaymentInformationPage\" because it might have been intercepted or covered by another WebElement like pop-up notifications, <span></span> HTML elements or alerts during interaction attempt.❌ More information: " + e.getMessage());
      Assert.fail("❌Text script failed to approve terms and conditions of the website and reported \"ElementClickInterceptedException\" because WebElement \"approveConditionsCheckbox\" inside Page Object \"DeliveryAndPaymentInformationPage\" might have been intercepted or covered by another WebElement. Make sure the WebElement has been loaded and is fully visible and active before next interaction attempt.❌");
    }
  }

  public void submitForm(WebElement placeOrderButton) {
    try {
      placeOrderButton.click();
      log.info("User placed an order after selecting preferred delivery and payment options and approving terms and conditions, then clicking WebElement \"PlaceOrderButton\" inside Page Object \"DeliveryAndPaymentInformationPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"placeOrderButton\" inside Page Object \"DeliveryAndPaymentInformationPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script failed to place an order and reported \"NoSuchElementException\" because of not being able to locate WebElement \"placeOrderButton\" inside Page Object \"DeliveryAndPaymentInformationPage\". Check and modify your selector or pick a different locator strategy.❌");
    }
  }
}
