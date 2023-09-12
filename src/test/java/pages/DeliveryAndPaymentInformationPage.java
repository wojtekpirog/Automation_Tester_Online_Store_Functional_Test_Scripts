package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryAndPaymentInformationPage {
  private WebDriver browser;
  public DeliveryAndPaymentInformationPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

//  @FindBy(xpath = "//span[text()='Home Address']")
//  private WebElement deliveryAddressSpan;
  @FindBy(xpath = "//span[text()='Home Address']")
  private WebElement WorkAddressSpan;
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

  public void AcceptAddressInformation() {
    this.WorkAddressSpan.click();
    this.continueToShippingMethodsBtn.click();
    JavascriptExecutor js = (JavascriptExecutor)browser;
    js.executeScript("arguments[0].click()", this.pickUpInStore);
    this.continueToPaymentButton.click();
    this.payByCheckInput.click();
    this.approveConditionsCheckbox.click();
    this.placeOrderButton.click();
  }
}
