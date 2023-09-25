package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
  private static final Logger log = LogManager.getLogger(MyAccountPage.class);
  private WebDriver browser;
  @FindBy(id = "addresses-link")
  private WebElement addressesAnchor;
  @FindBy(id = "_desktop_logo")
  private WebElement storeLogo;

  public MyAccountPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  public void goToHomePage() {
    try {
      storeLogo.click();
      log.info("User clicked on WebElement \"storeLogo\" and was directed to Page Object \"MainPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"storeLogo\" inside Page Object \"MyAccountPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }

  public void goToAddressCreationForm() {
    try {
      addressesAnchor.click();
      log.info("User clicked on WebElement \"addressesAnchor\" inside Page Object \"MyAccountPage\" and was directed to Page Object \"YourAddressesPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"addressesAnchor\" inside Page Object \"MyAccountPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }
}
