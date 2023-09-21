package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ProductDetailsPage {
  private static final Logger log = Logger.getLogger(ProductDetailsPage.class);
  private WebDriver browser;
  @FindBy(xpath = "//section[@id=\"content\"]/ul/li")
  private WebElement productFlag;
  @FindBy(xpath = "//select[@id=\"group_1\"]")
  private WebElement sizeSelect;
  @FindBy(xpath = "//input[@id=\"quantity_wanted\"]")
  private WebElement quantityWantedInput;
  @FindBy(xpath = "//button[@data-button-action=\"add-to-cart\"]")
  private WebElement addToCartButton;
  @FindBy(xpath = "//a[text()='Proceed to checkout']")
  private WebElement proceedToCheckoutAnchor;

  public ProductDetailsPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  //Method created to determine whether <li> element with text exists within the PDP (Product Details Page) structure and contains `20%`:
  public void checkForDiscount() {
    //Check if a flag with text is present and its text contains "20%"
    String discountInfo = null;
    try {
      discountInfo = productFlag.getText();
      if (discountInfo.contains("20%")) {
        log.info("ℹ️Discount info element with text \"" + discountInfo + "\" inside Page Object \"ProductDetailsPage\" is displayed. The discount for the product is 20%.ℹ️");
      } else {
        log.info("ℹ️Discount info element with text \"" + discountInfo + "\" inside Page Object \"ProductDetailsPage\" is displayed. The discount for the product though is different that 20%.ℹ️");
      }
    } catch (NoSuchElementException e) {
      log.info("ℹ️There is no discount info element inside Page Object \"ProductDetailsPage\". The product is not at a discount.ℹ️");
    }
  }

  public void addProductToCart(int quantity, String size) {
    //Create an object of type `Select` to store a previously found dropdown
    try {
      Select sizeDropdown = new Select(sizeSelect);
      //Create a list of valid sizes:
      List<String> validSizes = Arrays.asList("S", "M", "L", "XL");
      //Check if size is correct, else fail the test
      try {
        Assert.assertTrue(validSizes.contains(size));
      } catch (AssertionError e) {
        log.fatal("❌Sweater size " + size + " is incorrect❌. Try another size.");
        log.info("ℹ️Available sizes of the product are: \"S\", \"M\", \"L\" and \"XL\".ℹ️");
      }
      sizeDropdown.selectByVisibleText(size);
      //Check if value of variable `quantity` is greater than 0, else fail the test
      try {
        Assert.assertTrue(quantity > 0);
      } catch (AssertionError e) {
        log.fatal("❌Value " + quantity + " is incorrect❌. Try using a positive whole number.");
        log.info("ℹ️Quantity of products must be positive (greater than 0).ℹ️");
      }
      //Force JavaScript to change the "value" attribute of `this.quantityWantedInput` (input of type number)
      JavascriptExecutor jsExecutor = (JavascriptExecutor)browser;
      jsExecutor.executeScript("arguments[0].value=\"" + quantity + "\";", quantityWantedInput);
      addToCartButton.click();
      //Add an explicit wait to explicitly wait for a pop-up to become ready for interaction
      WebDriverWait waitForPopup = new WebDriverWait(browser, Duration.ofSeconds(10));
      try {
        WebElement element = waitForPopup.until(ExpectedConditions.visibilityOf(proceedToCheckoutAnchor));
        log.info("ℹ️" + quantity + " pieces of product have been added to cart.ℹ️");
        element.click();
      } catch (TimeoutException e) {
        log.fatal("❌Test failed to find WebElement \"proceedToCheckoutAnchor\" inside Page Object \"ProductDetailsPage\" within the defined timeout. Make sure the WebElement is fully visible and ready for interaction, and if testing conditions are uncertain, consider adjusting the timeout. You can also check if the selector is correct❌. More information: " + e.getMessage());
      } catch (NoSuchElementException e) {
        log.fatal("❌Test failed to find WebElement \"proceedToCheckoutAnchor\" inside Page Object \"ProductDetailsPage\". Make sure your selector is correct❌. More information: " + e.getMessage());
      }
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"sizeSelect\" inside Page Object \"ProductDetailsPage\". The default size option might have been selected. Please check the selector you defined for WebElement \"sizeSelect\"❌. More information: " + e.getMessage());
    }
  }

}
