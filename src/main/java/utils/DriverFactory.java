package utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePage;
import page_objects.ContactUsPage;
import page_objects.ProductsPage;

public class DriverFactory {

  public static WebDriver driver;
  public static ContactUsPage contactUsPage;
  public static ProductsPage productsPage;
  public static BasePage basePage;

  public WebDriver getDriver() {
    try {
      //Read config
      ReadConfigFile file = new ReadConfigFile();
      String browserName = file.getBrowser();
      switch (browserName) {
        case "firefox": {
          if (driver == null) {
            System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
          }
        }
        break;
        case "chrome": {
          if (driver == null) {
            System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
          }
          break;
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
      contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
      productsPage = PageFactory.initElements(driver, ProductsPage.class);
      basePage = PageFactory.initElements(driver, BasePage.class);
    }
    return driver;
  }

  public void resetDriver() {
    driver = null;
  }
}
