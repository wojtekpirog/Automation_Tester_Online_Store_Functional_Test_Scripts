package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
  private WebDriver browser;
  public ShoppingCartPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  @FindBy(xpath = "//a[text()='Proceed to checkout']")
  private WebElement proceedToCheckoutAnchor;

  public void proceedToCheckout() {
    try {
      this.proceedToCheckoutAnchor.click();
    } catch (NoSuchElementException e) {
      Assert.fail("❌Failed to find an element: \"proceedToCheckoutAnchor\" from \"ShoppingCartPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }
}
