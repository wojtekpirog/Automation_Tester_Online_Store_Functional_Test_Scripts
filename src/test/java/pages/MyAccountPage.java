package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
  private WebDriver browser;
  public MyAccountPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  @FindBy(xpath = "//*[@id=\"addresses-link\"]")
  private WebElement addressesAnchor;
  @FindBy(xpath = "//*[@id=\"_desktop_logo\"]/a")
  private WebElement storeLogo;

  public void goToHomePage() {
    try {
      this.storeLogo.click();
    } catch (NoSuchElementException e) {
      Assert.fail("❌Failed to find an element: \"storeLogo\" from \"MyAccountPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }

  public void goToAddressCreationForm() {
    try {
      this.addressesAnchor.click();
    } catch (NoSuchElementException e) {
      Assert.fail("❌Failed to find element: \"addressesAnchor\" from \"MyAccountPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }
}
