package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OrderConfirmationPage {
  private WebDriver browser;

  public OrderConfirmationPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  //Find the element with order confirmation and amount to take a screenshot:
  @FindBy(xpath = "//section[@id=\"content\"]")
  private WebElement orderDetails;

  public void takeScreenshot(String pathWithFile) {
    //Take a .png screenshot of a particular element of the page using Ashot API and save it to file "confirmation_screenshot.png"
    try {
      Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(this.browser, orderDetails);
      ImageIO.write(screenshot.getImage(), "png", new File(pathWithFile));
      System.out.println("✅Screenshot has been taken and saved to " + pathWithFile);
    } catch (NoSuchElementException e) {
      Assert.fail("❌Failed to find element: \"orderDetails\" from \"OrderConfirmationPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    } catch (IOException e) {
      Assert.fail("‼️An error occurred while copying file. More information: " + e.getMessage());
    }
  }
}
