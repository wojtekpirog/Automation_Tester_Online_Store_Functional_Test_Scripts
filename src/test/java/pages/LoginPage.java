package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  private static final Logger log = LogManager.getLogger(LoginPage.class);
  private WebDriver browser;

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
    try {
      fillInLoginForm(emailInput, passwordInput, signInButton, email, password);
      log.info("Login form inside Page Object \"LoginPage\" was filled with username and password and submitted.");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find an element of login form inside \"LoginPage\". Make sure selectors for \"emailInputInLoginForm\" and \"passwordInputInLoginForm\" are correct.❌ More information: " + e.getMessage());
    }
  }

  private void fillInLoginForm(WebElement emailInput, WebElement passwordInput, WebElement signInButton, String email, String password) {
    emailInput.clear();
    log.info("WebElement \"emailInput\" inside Page Object \"LoginPage\" was cleared and is ready to put in new data.");
    emailInput.sendKeys(email);
    log.info("User email address: \"" + email + "\" was put into WebElement \"emailInput\" inside Page Object \"LoginPage\".");
    passwordInput.clear();
    log.info("WebElement \"passwordInput\" inside Page Object \"LoginPage\" was cleared and is ready to put in new data.");
    passwordInput.sendKeys(password);
    log.info("User password: \"" + password + "\" was put into WebElement \"passwordInput\" inside Page Object \"LoginPage\".");
    signInButton.click();
    log.info("WebElement \"signInButton\" was found and clicked inside Page Object \"LoginPage\".");
  }
}
