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
  private WebElement AddressesButton;

  public void goToAddressCreationForm() {
    this.AddressesButton.click();
  }
}
