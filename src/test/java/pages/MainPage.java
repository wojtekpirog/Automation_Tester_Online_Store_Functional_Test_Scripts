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
      clickElement(signInAnchor);
    } catch (NoSuchElementException e) {
      handleNoSuchElementException(e);
    }
  }
  //Method to go to PDP (Product Details Page):
  public void openProductDetailsPage() {
    try {
      clickElement(productSelectionAnchor);
    } catch (NoSuchElementException e) {
      handleNoSuchElementException(e);
    }
  }
  //Method to click an element:
  private void clickElement(WebElement element) {
    element.click();
  }
  //Method to handle exception (here: `NoSuchElementException`):
  private void handleNoSuchElementException(NoSuchElementException e) {
    Assert.fail("❌Failed to find an element from \"MainPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
  }
}
