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

  @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a")
  private WebElement signInAnchor;

  public void goToLoginPage() {
    this.signInAnchor.click();
  }
}
