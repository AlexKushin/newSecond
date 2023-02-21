package com.shpp.mentoring.okushin.task2;

import com.shpp.mentoring.okushin.exceptions.NotExistPropertyKeyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyManager {
    private static final Logger logger = LoggerFactory.getLogger(PropertyManager.class);


    public PropertyManager() {
    }

    /**
     * Reads data from file.properties by FILE_NAME in UTF-8 format and writes this data to instance of Properties
     */
    public static void readPropertyFile(String fileName, Properties prop) {

        try (FileInputStream inputStream = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            prop.load(isr);
            logger.debug("Property waas successfully read yes no");
        } catch (IOException e) {
            logger.error("Can't read property file{}", e.getMessage(), e);

        }






        /*logger.debug("Try to read property");
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)){
             //InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            prop.load(inputStream);
            logger.debug("Property was successfully read");
        } catch (IOException e) {
            logger.error("Can't read property file{}", e.getMessage(), e);
        }

         */


    }

    public static String readPropertiesValue(String propKey, Properties prop) {

        if (prop.getProperty(propKey) == null) {
            throw new NotExistPropertyKeyException("Value of PROPERTY_KEY: " + propKey + " doesn't exist ");
        }
        return prop.getProperty(propKey);
    }


}
