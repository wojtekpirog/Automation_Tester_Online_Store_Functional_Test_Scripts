package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
  private static final Logger log = LogManager.getLogger(OrderConfirmationPage.class);
  private WebDriver browser;
  //Find the element with order confirmation and amount to take a screenshot of:
  @FindBy(id = "content")
  private WebElement orderDetails;

  public OrderConfirmationPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  //Method to take a screenshot which depicts order confirmation information with the order's amount:
  public void takeScreenshot(String pathWithFile) {
    //Take a screenshot with a .png extension of a particular element of the page using Ashot API and save it to file "confirmation_screenshot.png"
    try {
      Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(browser, orderDetails);
      ImageIO.write(screenshot.getImage(), "png", new File(pathWithFile));
      log.info("Screenshot showing order details was taken and saved to " + pathWithFile + ".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"orderDetails\" inside Page Object \"OrderConfirmationPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
    } catch (IOException e) {
      log.error("An error occurred while copying the file. More information: " + e.getMessage());
    }
  }
}
