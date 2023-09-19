package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ProductDetailsPage {
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
  private WebElement proceedToCheckoutButton;

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
        System.out.println("Discount info element with text \"" + discountInfo + "\" is displayed on the product details page. The discount for the product is 20%");
      } else {
        System.out.println("Discount info element with text \"" + discountInfo + "\" is displayed on the product details page. The discount for the product though is not 20%");
      }
    } catch (NoSuchElementException e) {
      System.out.println("⚠️There is no discount info element on the product details page. Therefore the product is not at a discount⚠️");
    }
  }

  public void addProductToCart(int quantity, String size) {
    //Create an object of type `Select` to store a previously found dropdown
    try {
      Select sizeDropdown = new Select(sizeSelect);
      //Create a list of valid sizes:
      List<String> validSizes = Arrays.asList("S", "M", "L", "XL");
      //Check if size is correct, and fail the test if it is not correct
      try {
        Assert.assertTrue(validSizes.contains(size));
      } catch (AssertionError e) {
        handleAssertionError("Sweater size " + size + " is incorrect. Available sizes of the product are: \"S\", \"M\", \"L\" and \"XL\".");
      }
      sizeDropdown.selectByVisibleText(size);
      //Check if value of variable `quantity` is greater than 0, else fail the test
      try {
        Assert.assertTrue(quantity > 0);
      } catch (AssertionError e) {
        handleAssertionError("Value " + quantity + " is incorrect. Quantity of products must be greater than 0.");
      }
      //Force JavaScript to change the "value" attribute of `this.quantityWantedInput` (input of type number)
      JavascriptExecutor jsExecutor = (JavascriptExecutor)browser;
      jsExecutor.executeScript("arguments[0].value=\"" + quantity + "\";", quantityWantedInput);
      clickAnElement(addToCartButton);
      browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
      clickAnElement(proceedToCheckoutButton);
    } catch (NoSuchElementException e) {
      handleNoSuchElementException(e);
    }
  }
  //Method to click an element:
  private void clickAnElement(WebElement element) {
    element.click();
  }
  //Method to handle an exception (here: `NoSuchElementException`):
  private void handleNoSuchElementException(NoSuchElementException e) {
    Assert.fail("❌Test failed to find WebElement from \"ProductDetailsPage\". Make sure your selector is correct❌. More information: " + e.getMessage());
  }
  //Method to handle an exception (here: `AssertionError`):
  private void handleAssertionError(String errorMessage) {
    Assert.fail(errorMessage);
  }
}
