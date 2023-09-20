package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryAndPaymentInformationPage {
  private static final Logger log = Logger.getLogger(DeliveryAndPaymentInformationPage.class);
  private WebDriver browser;
  @FindBy(xpath = "//span[text()='Home Address']")
  private WebElement workAddressSpan;
  @FindBy(xpath = "//button[@name=\"confirm-addresses\"]")
  private WebElement continueToShippingMethodsBtn;
  @FindBy(xpath = "//form/div/div[1]/div[1]/div/span/input")
  private WebElement pickUpInStore;
  @FindBy(xpath = "//button[@name=\"confirmDeliveryOption\"]")
  private WebElement continueToPaymentButton;
  @FindBy(xpath = "//input[@data-module-name=\"ps_checkpayment\"]")
  private WebElement payByCheckInput;
  @FindBy(xpath = "//input[@id=\"conditions_to_approve[terms-and-conditions]\"]")
  private WebElement approveConditionsCheckbox;
  @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
  private WebElement placeOrderButton;

  public DeliveryAndPaymentInformationPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  public void AcceptAddressInformation() {
    try {
      workAddressSpan.click();
      continueToShippingMethodsBtn.click();
      JavascriptExecutor js = (JavascriptExecutor)browser;
      js.executeScript("arguments[0].click()", pickUpInStore);
      continueToPaymentButton.click();
      payByCheckInput.click();
      approveConditionsCheckbox.click();
      placeOrderButton.click();
      log.info("ℹ️Details on user address, delivery & payment methods were selected in Page Object \"DeliveryAndPaymentInformationPage\".ℹ️");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find form control(s) inside Page Object \"DeliveryAndPaymentInformationPage\"❌. Please check the selectors you defined for WebElements in this Page Object. More information: " + e.getMessage());
    }
  }
}
