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

  //Method to login user:
  public void loginUser(String email, String password) {
    try {
      fillInLoginForm(emailInput, passwordInput, signInButton, email, password);
      log.info("Login form inside Page Object \"LoginPage\" was submitted with username and password.");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find an element of login form inside \"LoginPage\". Make sure selectors for \"emailInputInLoginForm\" and \"passwordInputInLoginForm\" are correct.❌ More information: " + e.getMessage());
    }
  }
  //Method to clear form input and type in desired text:
  private void fillInLoginForm(WebElement emailInput, WebElement passwordInput, WebElement signInButton, String email, String password) {
    emailInput.clear();
    emailInput.sendKeys(email);
    passwordInput.clear();
    passwordInput.sendKeys(password);
    signInButton.click();
  }
}
