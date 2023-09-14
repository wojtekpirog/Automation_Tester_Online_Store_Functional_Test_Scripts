package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

public class YourAddressesPage {
  private WebDriver browser;

  public YourAddressesPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]")
  private WebElement addressBody;
  @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[1]/h4")
  private WebElement addressAlias;
  @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[1]/address/text()[2]")
  private WebElement streetAddress;
  @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[1]/address/text()[3]")
  private WebElement city;
  @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[1]/address/text()[4]")
  private WebElement zipcode;
  @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[1]/address/text()[5]")
  private WebElement country;
  @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[1]/address/text()[6]")
  private WebElement phone;
  @FindBy(xpath = "//*[@id=\"content\"]/div[3]/a")
  private WebElement createNewAddressAnchor;
  @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]")
  private WebElement deleteAddressAnchor;

  public void deleteAddress() {
    this.deleteAddressAnchor.click();
  }

  public void assertThatAddressIsNotPresent() {
    //Check if address does not exist on the 'Addresses' page:
    if (this.browser.findElements(By.xpath("/html/body/main/section/div/div/section/section/div[2]")).isEmpty()) {
      System.out.println("Element is not present on the \"Your Addresses\" page");
    } else {
      //Fail the test if address is still visible on the "Your Addresses" page:
      Assert.fail("⚠️Element is still present on the \"Your Addresses\" page⚠️");
    }
  }

  public void goToAddressCreationForm() {
    this.createNewAddressAnchor.click();
  }

  //Checking if entered data is correct:
  public void checkData(String expectedAlias, String expectedStreetAddress, String expectedCity, String expectedZipcode, String expectedCountry, String expectedPhone) {
    String addressText = this.addressBody.getText();

    //Compare data in the address box with expected data:
    try {
      Assert.assertTrue(addressText.contains(expectedAlias));
      Assert.assertTrue(addressText.contains(expectedStreetAddress));
      Assert.assertTrue(addressText.contains(expectedCity));
      Assert.assertTrue(addressText.contains(expectedZipcode));
      Assert.assertTrue(addressText.contains(expectedCountry));
      Assert.assertTrue(addressText.contains(expectedPhone));
      System.out.println("✅All user address data is correct✅");
    } catch (AssertionError e) {
      Assert.fail("Assertion error. Failed to assert that entered data is correct.");
      System.err.println("Error message: " + e.getMessage());
    } finally {
      System.out.println("All assertions have been done");
    }
  }
}
