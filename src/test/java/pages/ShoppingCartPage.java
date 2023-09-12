package pages;

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
    this.proceedToCheckoutAnchor.click();
  }
}
