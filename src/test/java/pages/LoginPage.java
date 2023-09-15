package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  private WebDriver browser;

  public LoginPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  @FindBy(xpath = "//*[@id=\"field-email\"]")
  private WebElement emailInputInLoginForm;

  @FindBy(xpath = "//*[@id=\"field-password\"]")
  private WebElement passwordInputInLoginForm;

  @FindBy(xpath = "//*[@id=\"submit-login\"]")
  private WebElement signInButton;

  public void loginUser() {
    this.emailInputInLoginForm.clear();
    this.emailInputInLoginForm.sendKeys("wojciechkowalski@gmail.com");
    this.passwordInputInLoginForm.clear();
    this.passwordInputInLoginForm.sendKeys("Voyt@$$");
    this.signInButton.click();
  }
}
