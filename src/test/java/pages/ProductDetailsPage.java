package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ProductDetailsPage {
  private WebDriver browser;

  public ProductDetailsPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  @FindBy(xpath = "//select[@id=\"group_1\"]")
  private WebElement sizeSelect;
  @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]")
  private WebElement productQuantityIncreaseBtn;
  @FindBy(xpath = "//button[@data-button-action=\"add-to-cart\"]")
  private WebElement addToCartButton;
  @FindBy(xpath = "//a[text()='Proceed to checkout']")
  private WebElement proceedToCheckoutButton;

  //Method created to determine whether span element with text "Save 20%" exists within the PDP (Product Details Page) structure:
  public void checkForDiscount() {
    By elementSelector = By.cssSelector("span.discount.discount-percentage");
    WebElement discountElement = null;

    if (!this.browser.findElements(elementSelector).isEmpty()) {
      //Element exists within the page structure
      discountElement = this.browser.findElement(elementSelector);

      if (discountElement.getText().equals("Save 20%") || discountElement.getText().equals("SAVE 20%") || discountElement.getText().equals("-20%")) {
        System.out.println("Discount info element with text " + discountElement.getText() + " exists within the PDP structure, thus the product is at 20% discount🛒🛒🛒");
      } else {
        System.out.println("Discount info element with text " + discountElement.getText() + " exists within the PDP structure, thus the product is at a discount. The discount though is different than 20%");
      }
    } else {
      //Element does not exist within the page structure
      System.out.println("Discount info element does not exist within the PDP structure, thus the product is not at a discount");
    }
  }

  public void addProductToCart() {
    Select sizeDropdown = new Select(this.sizeSelect);
    sizeDropdown.selectByVisibleText("M");

    this.productQuantityIncreaseBtn.click();
    this.productQuantityIncreaseBtn.click();
    this.productQuantityIncreaseBtn.click();
    this.productQuantityIncreaseBtn.click();
    this.addToCartButton.click();
    this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    this.proceedToCheckoutButton.click();
  }
}
