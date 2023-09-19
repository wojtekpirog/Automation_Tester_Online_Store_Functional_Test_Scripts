package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
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
      clearAndType(passwordInputInLoginForm, "Passwd@$$");
      signInButton.click();
    } catch (NoSuchElementException e) {
      Assert.fail("❌Test failed to find a user login form element from \"LoginPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    }
  }
  //Method to clear form input and type in desired text:
  private void clearAndType(WebElement element, String text) {
    element.clear();
    element.sendKeys(text);
  }
}
