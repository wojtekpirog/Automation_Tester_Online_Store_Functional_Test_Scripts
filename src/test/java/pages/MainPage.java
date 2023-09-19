package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
  private WebDriver browser;
  @FindBy(xpath = "//a/span[text()='Sign in']")
  private WebElement signInAnchor;
  @FindBy(xpath = "//a[text()='Hummingbird printed sweater']")
  private WebElement productSelectionAnchor;

  public MainPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  //Method to go to login page:
  public void goToLoginPage() {
    try {
      signInAnchor.click();
    } catch (NoSuchElementException e) {
      Assert.fail("❌Failed to find an element \"signInAnchor\" from \"MainPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }
  //Method to go to PDP (Product Details Page):
  public void openProductDetailsPage() {
    try {
      productSelectionAnchor.click();
    } catch (NoSuchElementException e) {
      Assert.fail("❌Failed to find an element \"productSelectionAnchor\" from \"MainPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }
}
