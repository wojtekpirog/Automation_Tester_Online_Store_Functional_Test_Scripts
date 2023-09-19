package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DeliveryAndPaymentInformationPage {
  private WebDriver browser;
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

  public DeliveryAndPaymentInformationPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  public void AcceptAddressInformation() {
    try {
      WorkAddressSpan.click();
      continueToShippingMethodsBtn.click();
      JavascriptExecutor js = (JavascriptExecutor)browser;
      js.executeScript("arguments[0].click()", pickUpInStore);
      continueToPaymentButton.click();
      payByCheckInput.click();
      approveConditionsCheckbox.click();
      placeOrderButton.click();
    } catch (NoSuchElementException e) {
      Assert.fail("❌Test failed to find form control(s) from \"DeliveryAndPaymentInformationPage\"❌. More information: " + e.getMessage());
    }
  }
}
