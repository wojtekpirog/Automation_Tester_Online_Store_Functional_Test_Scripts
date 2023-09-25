package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
  private static final Logger log = LogManager.getLogger(MainPage.class);
  private WebDriver browser;
  @FindBy(xpath = "//a/span[text()='Sign in']")
  private WebElement signInAnchor;
  @FindBy(xpath = "//a[text()='Hummingbird printed sweater']")
  private WebElement productSelectionAnchor;

  public MainPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  public void goToLoginPage() {
    try {
      signInAnchor.click();
      log.info("User clicked on WebElement \"signInAnchor\" and was directed to Page Object \"Login Page\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Failed to find an element \"signInAnchor\" from \"MainPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      throw e;
    }
  }

  public void openProductDetailsPage() {
    try {
      productSelectionAnchor.click();
      log.info("User selected \"Hummingbird Printed Sweater\" and was directed to Page Object \"Product Details Page\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Failed to find an element \"productSelectionAnchor\" from \"MainPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }
}
