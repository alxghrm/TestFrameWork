package page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

public class BasePage extends DriverFactory {

  protected WebDriverWait wait;

  public BasePage() {
    this.wait = new WebDriverWait(driver, 15);
  }

  /**********************************************************************************
   **CLICK METHODS
   **********************************************************************************/
  public void waitAndClickElement(WebElement element) {
    boolean clicked = false;
    int attempts = 0;
    while (!clicked && attempts < 10) {
      try {
        this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        System.out.println("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
        clicked = true;
      } catch (Exception e) {
        System.out.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
        Assert.fail("Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
      }
      attempts++;
    }
  }

  public void clickOnElementUsingCustomTimeout(WebElement locator, WebDriver driver, int timeout) {
    try {
      final WebDriverWait customWait = new WebDriverWait(driver, timeout);
      customWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
      locator.click();
      System.out.println("Successfully clicked on the WebElement, using locator: " + "<" + locator + ">"+ ", using a custom Timeout of: " + timeout);
    } catch (Exception e) {
      System.out.println("Unable to click on the WebElement, using locator: " + "<" + locator + ">" + ", using a custom Timeout of: " + timeout);
      Assert.fail("Unable to click on the WebElement, Exception: " + e.getMessage());
    }
  }

  /**********************************************************************************
   **SEND KEYS METHODS /
   **********************************************************************************/
  public void sendKeysToWebElement(WebElement element, String textToSend) {
    try {
      this.WaitUntilWebElementIsVisible(element);
      element.clear();
      element.sendKeys(textToSend);
      System.out.println("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<"+ element.toString() + ">");
    } catch (Exception e) {
      System.out.println("Unable to locate WebElement: " + "<" + element.toString() + "> and send the following keys: " + textToSend);
      Assert.fail("Unable to send keys to WebElement, Exception: " + e.getMessage());
    }
  }

  /**********************************************************************************
   **WAIT METHODS
   **********************************************************************************/
  public void WaitUntilWebElementIsVisible(WebElement element) {
    try {
      this.wait.until(ExpectedConditions.visibilityOf(element));
      System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
    } catch (Exception e) {
      System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
      Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
    }
  }

  public void WaitUntilWebElementIsVisibleUsingByLocator(By element) {
    try {
      this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
      System.out.println("Element is visible using By locator: " + "<" + element.toString() + ">");
    } catch (Exception e) {
      System.out.println("WebElement is NOT visible, using By locator: " + "<" + element.toString() + ">");
      Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
    }
  }
}
