package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import auxiliaryClasses.LoginInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  private static final Logger log = LogManager.getLogger(LoginPage.class);
  private final WebDriver browser;

  @FindBy(id = "field-email")
  private WebElement emailInput;
  @FindBy(id = "field-password")
  private WebElement passwordInput;
  @FindBy(id = "submit-login")
  private WebElement signInButton;

  public LoginPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  public void loginUser(String email, String password) {
    LoginInformation loginInformation = new LoginInformation(browser);
    loginInformation.enterEmail(emailInput, email);
    loginInformation.enterPassword(passwordInput, password);
    loginInformation.signIn(signInButton);
    log.info("Form inside Page Object \"LoginPage\" was filled with email (\"" + email + "\") and password (\"" + password + "\") and submitted.");
  }
}
