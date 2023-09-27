package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
  private static final Logger log = LogManager.getLogger(OrderConfirmationPage.class);
  private final WebDriver browser;
  //Find the element with order confirmation and amount to take a screenshot of:
  @FindBy(id = "content")
  private WebElement orderDetails;

  public OrderConfirmationPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  public void takeScreenshot(String pathWithFile) {
    //Take a screenshot with a .png extension of a particular element of the page using Ashot API and save it to file "confirmation_screenshot.png"
    try {
      Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(browser, orderDetails);
      ImageIO.write(screenshot.getImage(), "png", new File(pathWithFile));
      log.info("Screenshot showing order details was taken and saved to " + pathWithFile + ".");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"orderDetails\" inside Page Object \"OrderConfirmationPage\". Make sure your selector is correct.❌ More information: " + e.getMessage());
      Assert.fail("❌Test script reported \"NoSuchElementException\" when trying to take a screenshot because of not being able to find WebElement \"orderDetails\" inside Page Object \"OrderConfirmationPage\", that contains necessary information about order confirmation and its amount. Make sure to pick an accurate selector or try a different locator strategy.❌ More information: " + e.getMessage());
    } catch (IOException e) {
      log.error("An error occurred while copying or saving the file. Check the file path and make sure the destination location exists and the destination folder or directory allows I/O operations. Also, make sure there is enough space on your system's hard drive and it allows the resulting output file's format. More information: " + e.getMessage());
      Assert.fail("❌Test script reported \"IOException\" when attempting an I/O operation because of not being able to take a screenshot or save it on the provided location. Make sure the location exists and is correct and has permissions to write files.❌");
    }
  }
}
