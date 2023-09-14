package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

  public void takeScreenshot(String pathWithFile) throws IOException {
    //Convert web driver object to TakeScreenshot:
//    TakesScreenshot screenshot = ((TakesScreenshot)this.browser);
    //Call getScreenshotAs method to create image file:
//    File srcImgFile = screenshot.getScreenshotAs(OutputType.FILE);
    //Move image file to new destination:
//    File destImgFile = new File(pathWithFile);
    //Copy file destination:
//    FileUtils.copyFile(srcImgFile, destImgFile);
    //Take a .png screenshot of a particular element of the page using Ashot API and save it to file "confirmation_screenshot.png"
    Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(this.browser, orderDetails);
    ImageIO.write(screenshot.getImage(), "png", new File(pathWithFile));
  }
}
