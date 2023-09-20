package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  private static final Logger log = Logger.getLogger(LoginPage.class);
  private WebDriver browser;
  @FindBy(xpath = "//*[@id=\"field-email\"]")
  private WebElement emailInputInLoginForm;
  @FindBy(xpath = "//*[@id=\"field-password\"]")
  private WebElement passwordInputInLoginForm;
  @FindBy(xpath = "//*[@id=\"submit-login\"]")
  private WebElement signInButton;

  public LoginPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  //Method to login user:
  public void loginUser() {
    try {
      clearAndType(emailInputInLoginForm, "wojciechkowalski@gmail.com");
      clearAndType(passwordInputInLoginForm, "Voyt@$$");
      signInButton.click();
      log.info("ℹ️Login form inside Page Object \"LoginPage\" was submitted with username and password.ℹ️");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find an element of login form inside \"LoginPage\". Make sure selectors for \"emailInputInLoginForm\" and \"passwordInputInLoginForm\" are correct.❌ More information: " + e.getMessage());
    }
  }
  //Method to clear form input and type in desired text:
  private void clearAndType(WebElement element, String text) {
    element.clear();
    element.sendKeys(text);
  }
}
