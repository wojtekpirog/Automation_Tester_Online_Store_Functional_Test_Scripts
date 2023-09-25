package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
  private static final Logger log = LogManager.getLogger(ProductDetailsPage.class);
  private WebDriver browser;
  @FindBy(xpath = "//section[@id=\"content\"]/ul/li")
  private WebElement productFlag;
  @FindBy(id = "group_1")
  private WebElement sizeSelect;
  @FindBy(id = "quantity_wanted")
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
        log.info("Discount info element with text \"" + discountInfo + "\" inside Page Object \"ProductDetailsPage\" is displayed. The discount for the product is 20%.");
      } else {
        log.warn("⚠️Discount info element with text \"" + discountInfo + "\" inside Page Object \"ProductDetailsPage\" is displayed. The discount for the product though is different that 20%.⚠️");
      }
    } catch (NoSuchElementException e) {
      log.info("There is no discount info element inside Page Object \"ProductDetailsPage\". The product is not at a discount.");
    }
  }

  public void addProductToCart(int quantity, String size) {
    //Create an object of type `Select` to store a previously found dropdown
    //Create a list of valid sizes:
    List<String> validSizes = Arrays.asList("S", "M", "L", "XL");
    Select sizeDropdown = new Select(sizeSelect);
    //Select the desired size, then check if the size is correct, else fail the test
    try {
      sizeDropdown.selectByVisibleText(size);
      Assert.assertTrue(validSizes.contains(size));
      log.info("Size " + size + " was selected. The size is valid.");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"proceedToCheckoutAnchor\" inside Page Object \"ProductDetailsPage\". Make sure your selector is correct❌. More information: " + e.getMessage());
    } catch (AssertionError e) {
      log.fatal("❌Sweater size " + size + " is invalid❌. Available valid sizes of the product are: \"S\", \"M\", \"L\" and \"XL\".");
    }
    //Check if value of variable `quantity` is greater than 0, else fail the test
    //Force JavaScript to change the "value" attribute of `quantityWantedInput` (input of type number)
    JavascriptExecutor jsExecutor = (JavascriptExecutor)browser;
    try {
      Assert.assertTrue(quantity > 0);
      jsExecutor.executeScript("arguments[0].value='" + quantity + "';", quantityWantedInput);
      log.info("Number " + quantity + " entered into WebElement \"qualityWantedInput\" inside Page Object \"ProductDetailsPage\".");
    } catch (AssertionError e) {
      log.fatal("❌Value " + quantity + " is incorrect❌. Try using a positive whole number. Quantity of products must be positive (greater than 0).");
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"quantityWantedInput\" inside Page Object \"ProductDetailsPage\". Make sure your selector is correct❌. More information: " + e.getMessage());
    }
    //Add product to cart
    try {
      addToCartButton.click();
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"addToCartButton\" inside Page Object \"ProductDetailsPage\". Make sure your selector is correct❌. More information: " + e.getMessage());
    }
    //Add an explicit wait to explicitly wait for a pop-up to become ready for interaction
    WebDriverWait waitForPopup = new WebDriverWait(browser, Duration.ofSeconds(10));
    try {
      WebElement element = waitForPopup.until(ExpectedConditions.visibilityOf(proceedToCheckoutAnchor));
      element.click();
      log.info("Test clicked on WebElement \"proceedToCheckoutAnchor\", and then " + quantity + " pieces of product were successfully added to cart.");
    } catch (TimeoutException e) {
      log.fatal("❌Test failed to find WebElement \"proceedToCheckoutAnchor\" inside Page Object \"ProductDetailsPage\" within the defined timeout. Make sure this WebElement is fully visible and ready for interaction, and if testing conditions are uncertain, consider adjusting the timeout. You can also check if the selector is correct❌. More information: " + e.getMessage());
    } catch (ElementClickInterceptedException e) {
      log.fatal("❌Test failed to click WebElement \"proceedToCheckoutAnchor\" inside Page Object \"ProductDetailsPage\", because it might have been intercepted by another WebElement. Make sure this WebElement is fully visible and ready for interaction❌. More information: " + e.getMessage());
    } catch (NoSuchElementException e) {
      log.fatal("❌Test failed to find WebElement \"proceedToCheckoutAnchor\" inside Page Object \"ProductDetailsPage\". Make sure your selector is correct❌. More information: " + e.getMessage());
    }
  }
}
