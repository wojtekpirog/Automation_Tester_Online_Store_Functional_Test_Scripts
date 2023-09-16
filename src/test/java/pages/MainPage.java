package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
  private WebDriver browser;

  public MainPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  @FindBy(xpath = "//a/span[text()='Sign in']")
  private WebElement signInAnchor;
  @FindBy(xpath = "//a[text()='Hummingbird printed sweater']")
  private WebElement productSelectionAnchor;

  public void goToLoginPage() {
    try {
      this.signInAnchor.click();
    } catch (NoSuchElementException e) {
      Assert.fail("❌Failed to find element: \"signInAnchor\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }

  public void openProductDetailsPage() {
    try {
      this.productSelectionAnchor.click();
    } catch (NoSuchElementException e) {
      Assert.fail("❌Failed to find element: \"productSelectAnchor\" from \"MainPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }
}
