package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
  private static final Logger log = Logger.getLogger(MyAccountPage.class);
  private WebDriver browser;
  @FindBy(xpath = "//*[@id=\"addresses-link\"]")
  private WebElement addressesAnchor;
  @FindBy(xpath = "//*[@id=\"_desktop_logo\"]/a")
  private WebElement storeLogo;

  public MyAccountPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  //Method to direct user to the home page:
  public void goToHomePage() {
    try {
      storeLogo.click();
      log.info("ℹ️User clicked on WebElement \"storeLogo\" and was directed to Page Object \"MainPage\".ℹ️");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"storeLogo\" inside Page Object \"MyAccountPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }
  //Method to direct user to the address creation form:
  public void goToAddressCreationForm() {
    try {
      addressesAnchor.click();
      log.info("ℹ️User has been directed to the address creation form.ℹ️");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"addressesAnchor\" inside Page Object \"MyAccountPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }
}
