package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import auxiliaryClasses.OrderInformation;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryAndPaymentInformationPage {
  private static final Logger log = LogManager.getLogger(DeliveryAndPaymentInformationPage.class);
  private WebDriver browser;
  @FindBy(xpath = "//span[text()='Home Address']")
  private WebElement shippingAddress;
  @FindBy(name = "confirm-addresses")
  private WebElement confirmShippingAddress;
  @FindBy(xpath = "//input[@id='delivery_option_8']/following-sibling::span")
  private WebElement deliveryMethod;
  @FindBy(name = "confirmDeliveryOption")
  private WebElement confirmDeliveryMethod;
  @FindBy(id = "payment-option-1")
  private WebElement paymentMethod;
  @FindBy(id = "conditions_to_approve[terms-and-conditions]")
  private WebElement approveConditionsCheckbox;
  @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
  private WebElement placeOrderButton;

  public DeliveryAndPaymentInformationPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  public void placeOrder() {
    try {
      OrderInformation orderInformation = new OrderInformation(browser);
      orderInformation.selectShippingAddress(shippingAddress, confirmShippingAddress);
      orderInformation.selectDeliveryMethod(deliveryMethod, confirmDeliveryMethod);
      orderInformation.selectPaymentMethod(paymentMethod);
      orderInformation.approveConditions(approveConditionsCheckbox);
      orderInformation.submitForm(placeOrderButton);
      log.info("User placed an order by selecting appropriate delivery and payment options and accepting conditions inside Page Object \"DeliveryAndPaymentInformationPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find form control(s) inside Page Object \"DeliveryAndPaymentInformationPage\"❌. Please check the selectors you defined for WebElements in this Page Object. More information: " + e.getMessage());
    }
  }
}
