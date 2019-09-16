package com.celltrak.test.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * Class that contains all the methods related with Properties.
 * @author alexis.alvarez
 */
public class PropertyUtils {

  private static final Logger LOGGER = Logger.getLogger(PropertyUtils.class);

  /**
   * Method to read a property in resources package.
   *
   * @param name property name
   * @param prop Properties
   * @param clazz class where is the resource
   * @return properties variable loaded
   * @author alexis.alvarez
   */
  public static Properties readProperty(String name, Properties prop, Class clazz) {
    if (prop == null) {
      prop = new Properties();
    }

    InputStream stream = clazz.getClassLoader().getResourceAsStream(name);

    try {
      prop.load(stream);
    } catch (IOException e) {
      LOGGER.error("ERROR: " + e.getMessage());
    }

    return prop;
  }
}
