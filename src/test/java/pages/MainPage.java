package pages;

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
    this.signInAnchor.click();
  }

  public void openProductDetailsPage() {
    this.productSelectionAnchor.click();
  }
}
