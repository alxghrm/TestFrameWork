package page_objects;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{

  public @FindBy(id = "container-special-offers")
  WebElement buttonSpecialOffers;

  public @FindBy(xpath = "//button[@type='button'][contains(.,'Proceed')]")
  WebElement buttonProceed;

  public ProductsPage() throws IOException {
    super();
  }

public ProductsPage clickOnProceedButtonPopUp() throws IOException, InterruptedException {
    waitAndClickElement(buttonProceed);
    return new ProductsPage();
}
}
