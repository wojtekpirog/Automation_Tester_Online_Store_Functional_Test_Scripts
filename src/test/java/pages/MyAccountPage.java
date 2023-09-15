package pages;

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
  private WebElement AddressesAnchor;
  @FindBy(xpath = "//*[@id=\"_desktop_logo\"]/a")
  private WebElement storeLogo;

  public void goToHomePage() {
    this.storeLogo.click();
  }

  public void goToAddressCreationForm() {
    this.AddressesAnchor.click();
  }
}
