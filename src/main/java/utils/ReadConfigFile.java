package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {


  protected Properties properties;
  protected File src;
  protected FileInputStream inputStream;

  public ReadConfigFile() {
    try {
      src = new File(Constant.CONFIG_PROPERTIES_DIRECTORY);
      inputStream = new FileInputStream(src);
      properties = new Properties();
      properties.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public String getBrowser() {
    if (properties.getProperty("browser") == null) {
      return "";
    }
    return properties.getProperty("browser");
  }
}
