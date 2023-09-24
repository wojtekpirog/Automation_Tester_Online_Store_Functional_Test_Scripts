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
  private WebElement homeAddressSpan;
  @FindBy(name = "confirm-addresses")
  private WebElement continueToShippingMethodsBtn;
  @FindBy(id = "delivery_option_8")
  private WebElement pickUpInStore;
  @FindBy(name = "confirmDeliveryOption")
  private WebElement confirmDeliveryOption;
  @FindBy(id = "payment-option-1")
  private WebElement payByCheck;
  @FindBy(id = "conditions_to_approve[terms-and-conditions]")
  private WebElement approveConditionsCheckbox;
  @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
  private WebElement placeOrderButton;

  public DeliveryAndPaymentInformationPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  public void AcceptAddressInformation() {
    try {
      homeAddressSpan.click();
      continueToShippingMethodsBtn.click();
      JavascriptExecutor js = (JavascriptExecutor)browser;
      js.executeScript("arguments[0].click()", pickUpInStore);
      confirmDeliveryOption.click();
      payByCheck.click();
      approveConditionsCheckbox.click();
      placeOrderButton.click();
      log.info("Details on user address, delivery & payment methods were selected in Page Object \"DeliveryAndPaymentInformationPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find form control(s) inside Page Object \"DeliveryAndPaymentInformationPage\"❌. Please check the selectors you defined for WebElements in this Page Object. More information: " + e.getMessage());
    }
  }
}
