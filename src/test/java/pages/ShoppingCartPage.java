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
      proceedToCheckoutAnchor.click();
    } catch (NoSuchElementException e) {
      Assert.fail("❌Failed to find an element \"proceedToCheckoutAnchor\" from \"ShoppingCartPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }
}
