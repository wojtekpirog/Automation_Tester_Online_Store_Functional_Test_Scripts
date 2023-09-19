package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
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
      clickAnElement(storeLogo);
    } catch (NoSuchElementException e) {
      handleNoSuchElementException(e);
    }
  }
  //Method to direct user to the address creation form:
  public void goToAddressCreationForm() {
    try {
      clickAnElement(addressesAnchor);
    } catch (NoSuchElementException e) {
      handleNoSuchElementException(e);
    }
  }
  //Method to click an element:
  private void clickAnElement(WebElement element) {
    element.click();
  }
  //Method to handle an exception (here: `NoSuchElementException`):
  private void handleNoSuchElementException(NoSuchElementException e) {
    Assert.fail("❌Failed to find element from \"MyAccountPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
  }
}
