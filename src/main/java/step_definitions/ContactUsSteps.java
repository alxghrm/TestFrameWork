package step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import utils.DriverFactory;

public class ContactUsSteps extends DriverFactory {

  @Given("I access website contact us form")
  public void iAccessWebsiteContactUsForm() throws IOException {
    contactUsPage.getContactUsPage();
  }

  @When("I enter a valid firstname")
  public void iEnterAValidFirstname() throws Exception {
    contactUsPage.enterFirstName();
  }

  @And("I enter a valid lastname")
  public void iEnterAValidLastname(DataTable dataTable) throws Exception {
    contactUsPage.enterLastName(dataTable, 0, 1);
  }

  @And("I enter a valid email address")
  public void iEnterAValidEmailAddress() throws Exception {
    contactUsPage.enterEmail("test@mail.com");
  }

  @And("I enter comments")
  public void iEnterComments(DataTable dataTable) throws Exception {
    contactUsPage.enterMessage(dataTable, 0, 1);
  }

  @And("submit the data")
  public void submitTheData() throws IOException {
    contactUsPage.clickOnSubmitButton();
  }

  @Then("the data is successfully submitted")
  public void theDataIsSuccessfullySubmitted() throws IOException {
    contactUsPage.confirmContactUsFormSubmitted();
  }

}
