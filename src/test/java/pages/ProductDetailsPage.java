package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ProductDetailsPage {
  private WebDriver browser;

  public ProductDetailsPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  @FindBy(xpath = "//section[@id=\"content\"]/ul/li")
  private WebElement productFlag;
//  @FindAll({@FindBy(xpath = "//section[@id=\"content\"]/ul/li]")})
//  private List<WebElement> listOfProductFlags;
  @FindBy(xpath = "//select[@id=\"group_1\"]")
  private WebElement sizeSelect;
  @FindBy(xpath = "//input[@id=\"quantity_wanted\"]")
  private WebElement quantityWantedInput;
  @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]")
  private WebElement productQuantityIncreaseBtn;
  @FindBy(xpath = "//button[@data-button-action=\"add-to-cart\"]")
  private WebElement addToCartButton;
  @FindBy(xpath = "//a[text()='Proceed to checkout']")
  private WebElement proceedToCheckoutButton;

  //Method created to determine whether <li> element with text exists within the PDP (Product Details Page) structure and contains `20%`:
  public void checkForDiscount() {
    String discountInfo = null;
    try {
      discountInfo = this.productFlag.getText();
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
    Select sizeDropdown = new Select(this.sizeSelect);
    //Create a list of valid sizes:
    List<String> validSizes = Arrays.asList("S", "M", "L", "XL");
    //Check if size is correct, and fail the test if it is not correct
    try {
      Assert.assertTrue(validSizes.contains(size));
    } catch (AssertionError e) {
      Assert.fail("Sweater size " + size + " is incorrect. Available sizes of the product are: \"S\", \"M\", \"L\" and \"XL\".");
    }
    sizeDropdown.selectByVisibleText(size);
    //Check if value of variable `quantity` is greater than 0, else fail the test
    try {
      Assert.assertTrue(quantity > 0);
    } catch (AssertionError e) {
      Assert.fail("Value " + quantity + " is incorrect. Quantity of products must be greater than 0.");
    }
    //Force JavaScript to change the "value" attribute of `this.quantityWantedInput` (input of type number)
    JavascriptExecutor jsExecutor = (JavascriptExecutor)browser;
    jsExecutor.executeScript("arguments[0].value=\"" + quantity + "\";", this.quantityWantedInput);
    this.addToCartButton.click();
    this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    this.proceedToCheckoutButton.click();
  }
}
