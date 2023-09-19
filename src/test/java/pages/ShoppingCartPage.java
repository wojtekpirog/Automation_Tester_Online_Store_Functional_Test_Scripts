package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
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
      clickAnElement(proceedToCheckoutAnchor);
    } catch (NoSuchElementException e) {
      handleNoSuchElementException(e);
    }
  }
  //Method to click an element:
  private void clickAnElement(WebElement element) {
    element.click();
  }
  //Method to handle an exception (here: `NoSuchElementException`):
  private void handleNoSuchElementException(NoSuchElementException e) {
    Assert.fail("❌Failed to find an element from \"ShoppingCartPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
  }
}
