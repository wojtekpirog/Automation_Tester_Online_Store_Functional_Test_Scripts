package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class OrderConfirmationPage {
  private WebDriver browser;

  public OrderConfirmationPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  File orderConfirmationScreenshot = ((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);
  String pathForScreenshot = "C:\\Users\\HARDPC\\Pictures\\Screenshots\\order_confirmation.png";
  FileUtils.copyFile(orderConfirmationScreenshot, new File(pathForScreenshot));
}
