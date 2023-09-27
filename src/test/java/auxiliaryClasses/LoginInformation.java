package auxiliaryClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginInformation {
  private static final Logger log = LogManager.getLogger(LoginInformation.class);
  private WebDriver browser;
  public LoginInformation(WebDriver browser) {
    this.browser = browser;
  }

  public void enterEmail(WebElement emailInput, String email) {
    try {
      emailInput.clear();
      emailInput.sendKeys(email);
      log.info("User email address: \"" + email + "\" was put into WebElement \"emailInput\" inside Page Object \"LoginPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"emailInput\" inside Page Object \"LoginPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script failed to put the user email into form control WebElement \"emailInput\" and reported \"NoSuchElementException\" because of not being able to find the WebElement inside Page Object \"LoginPage\". Check and modify your selector or pick a different locator strategy.❌");
    }
  }

  public void enterPassword(WebElement passwordInput, String password) {
    try {
      passwordInput.clear();
      passwordInput.sendKeys(password);
      log.info("User password: \"" + password + "\" was put into WebElement \"passwordInput\" inside Page Object \"LoginPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"passwordInput\" inside Page Object \"LoginPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script failed to put the user password into form control WebElement \"passwordInput\" and reported \"NoSuchElementException\" because of not being able to find the WebElement inside Page Object \"LoginPage\". Check and modify your selector or pick a different locator strategy.❌");
    }
  }

  public void signIn(WebElement signInButton) {
    try {
      signInButton.click();
      log.info("WebElement \"signInButton\" was found and clicked inside Page Object \"LoginPage\".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test script failed to find WebElement \"signInButton\" inside Page Object \"LoginPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script failed to submit login form by clicking on WebElement \"signInButton\" and reported \"NoSuchElementException\" because of not being able to find the WebElement inside Page Object \"LoginPage\". Check and modify your selector or pick a different locator strategy.❌");
    }
  }
}
