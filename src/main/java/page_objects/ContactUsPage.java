package page_objects;

import io.cucumber.datatable.DataTable;
import java.io.IOException;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

  public @FindBy(name = "first_name")
  WebElement textfieldFirstName;

  public @FindBy(name = "last_name")
  WebElement textfieldLastName;

  public @FindBy(name = "email")
  WebElement textfieldEmail;

  public @FindBy(name = "message")
  WebElement textfieldMessage;

  public @FindBy(css = "input.contact_button:nth-child(2)")
  WebElement buttonSubmit;

  public ContactUsPage() throws IOException {
    super();
  }

  public ContactUsPage getContactUsPage() throws IOException {

    getDriver().get("http://webdriveruniversity.com/Contact-Us/contactus.html");
    return new ContactUsPage();
  }

  public ContactUsPage enterFirstName() throws Exception {

    sendKeysToWebElement(textfieldFirstName, "alex");
    return new ContactUsPage();
  }

  public ContactUsPage enterLastName(@NotNull DataTable dataTable,
      int row, int column) throws Exception {

    List<List<String>> data = dataTable.cells();
    sendKeysToWebElement(textfieldLastName, data.get(row).get(column));
    return new ContactUsPage();
  }

  public ContactUsPage enterEmail(String email) throws Exception {

    sendKeysToWebElement(textfieldEmail, email);
    return new ContactUsPage();
  }

  public ContactUsPage enterMessage(@NotNull DataTable dataTable,
      int row, int column) throws Exception {

    List<List<String>> data = dataTable.cells();
    sendKeysToWebElement(textfieldMessage, data.get(row).get(column));
    return new ContactUsPage();
  }

  public ContactUsPage clickOnSubmitButton() throws IOException {

    clickOnElementUsingCustomTimeout(buttonSubmit,getDriver(),3000);
    return new ContactUsPage();
  }

  public ContactUsPage confirmContactUsFormSubmitted() throws IOException {
    WebElement thankYouContactPage = getDriver().findElement(By.xpath("/html/body/div/div/div/h1"));
    WaitUntilWebElementIsVisible(thankYouContactPage);
    Assert.assertEquals("Thank You for your Message!".toLowerCase().trim(),thankYouContactPage.getText().toLowerCase().trim());
    return new ContactUsPage();
  }

}
