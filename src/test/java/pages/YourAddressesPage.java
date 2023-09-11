package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.NoSuchElementException;

public class YourAddressesPage {
  private WebDriver browser;

  public YourAddressesPage(WebDriver browser) {
    this.browser = browser;
    PageFactory.initElements(browser, this);
  }

  @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
  private WebElement successAlert;

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

  public void goToAddressCreationForm() {
    this.createNewAddressAnchor.click();
  }

  //Checking if entered data is correct:
  public void checkData(String expectedAlias, String expectedAddress, String expectedCity, String expectedZipcode, String expectedCountry, String expectedPhone) {
    //Checking if address was created successfully:
    try {
      Assert.assertEquals("Address successfully added!", this.successAlert.getText());
      System.out.println("✅Address has been created successfully✅");
    } catch (NoSuchElementException e) {
      Assert.fail("There is no success alert. Read the error message: " + e.getMessage());
      System.out.println("‼️Failed to add a new address‼️");
    }
    //Checking address alias:
    Assert.assertEquals(expectedAlias, this.addressAlias.getText());
    //Checking street address:
    Assert.assertEquals(expectedAddress, this.streetAddress.getText());
    //Checking city:
    Assert.assertEquals(expectedCity, this.city.getText());
    //Checking zipcode:
    Assert.assertEquals(expectedZipcode, this.zipcode.getText());
    //Checking country:
    Assert.assertEquals(expectedCountry, this.country.getText());
    //Checking phone number:
    Assert.assertEquals(expectedPhone, this.phone.getText());
  }
}
