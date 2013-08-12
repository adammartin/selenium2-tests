package com.pillar.driver;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
  public static final String MAX_WAIT = "selenium.pageLoadWaitSeconds";
  public static final String PASSWORD = "selenium.auth.password";
  public static final String USER_GROUP = "selenium.auth.usergroup";
  public static final String AUTHENTICATION_REQUIRED = "selenium.auth.active";
  public static final String APPLICATION_URL = "selenium.application.url";
  public static final String DEFAULT_PROPERTY_FILE_NAME = "selenium.properties";
  public static final String DRIVER_TYPE = "selenium.driver";

  public PropertyLoader() {
  }
  
  public final Properties loadProperties(final String propertyFileName) {
    Properties properties = new Properties();
    try {
      properties.load(PropertyLoader.class.getClassLoader().getResourceAsStream(DEFAULT_PROPERTY_FILE_NAME));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return properties;
  }
}
