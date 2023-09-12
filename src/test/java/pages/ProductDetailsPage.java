package pages;

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
