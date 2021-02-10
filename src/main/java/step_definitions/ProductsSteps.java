package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import org.openqa.selenium.By;
import utils.DriverFactory;

public class ProductsSteps extends DriverFactory {


  @Given("user navigates to {string} website")
  public void userNavigatesToWebsite(String url) {
    getDriver().get(url);
  }

  @When("user clicks on {string} button")
  public void userClicksOnButton(String button) throws InterruptedException {
    basePage.WaitUntilWebElementIsVisibleUsingByLocator(By.id(button));
    getDriver().findElement(By.id(button)).click();
  }

  @Then("user should be presented with a promo alert")
  public void userShouldBePresentedWithAPromoAler() throws InterruptedException, IOException {
    productsPage.clickOnProceedButtonPopUp();
  }
}
