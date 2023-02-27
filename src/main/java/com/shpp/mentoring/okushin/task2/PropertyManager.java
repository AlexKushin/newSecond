package com.shpp.mentoring.okushin.task2;

import com.shpp.mentoring.okushin.exceptions.NotExistPropertyKeyException;
import com.shpp.mentoring.okushin.exceptions.NotInputtedFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
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
    public void readPropertyFile(String fileName, Properties prop) {

        try (FileInputStream inputStream = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            prop.load(isr);
            logger.debug("Property was successfully read");
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

    public Number getValue(Properties prop, String key, String type) {

        if (type == null) {
            throw new NotInputtedFormatException("format isn't inputted");
        }
        if (type.equalsIgnoreCase("byte")) {
            logger.info("Byte value of " + key + " will be returned");
            return Byte.parseByte(PropertyManager.readPropertiesValue(key, prop));
        }
        if (type.equalsIgnoreCase("long")) {
            logger.info("Long value of " + key + " will be returned");
            return Long.parseLong(PropertyManager.readPropertiesValue(key, prop));
        }
        if (type.equalsIgnoreCase("short")) {
            logger.info("Short value of " + key + " will be returned");
            return Short.parseShort(PropertyManager.readPropertiesValue(key, prop));
        }
        if (type.equalsIgnoreCase("float")) {
            logger.info("Float value of " + key + " will be returned");
            return Float.parseFloat(PropertyManager.readPropertiesValue(key, prop));
        }
        if (type.equalsIgnoreCase("double")) {
            logger.info("Double value of " + key + " will be returned");
            return Double.parseDouble(PropertyManager.readPropertiesValue(key, prop));
        }
        if (type.equalsIgnoreCase("BigInteger")) {
            logger.info("BigInteger value of " + key + " will be returned");
            return new BigInteger(PropertyManager.readPropertiesValue(key, prop));
        }
        if (type.equalsIgnoreCase("BigDecimal")) {
            logger.info("Double value of " + key + " will be returned");
            return new BigDecimal(PropertyManager.readPropertiesValue(key, prop));
        }

        logger.info("Int value of " + key + " will be returned by default");

        return Integer.parseInt(PropertyManager.readPropertiesValue(key, prop));

    }


}
