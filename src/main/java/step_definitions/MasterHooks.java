package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverFactory;

public class MasterHooks extends DriverFactory {

  @Before
  public void setup() {
    driver = getDriver();
  }

  @After
  public void tearDown(Scenario scenario) {
    try {
      if(scenario.isFailed()){
        final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","screenshot");
      }
      if (driver != null) {
        driver.manage().deleteAllCookies();
        driver.quit();
        resetDriver();
      }
    } catch (Exception e) {
      e.getMessage();
    }
  }

}
