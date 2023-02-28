package com.shpp.mentoring.okushin.task2;

import com.shpp.mentoring.okushin.exceptions.NotExistPropertyKeyException;
import com.shpp.mentoring.okushin.exceptions.NotInputtedFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Class PropertyManager was created for handy performing property files, it has methods for reading property file
 * to object, getting string and numeric values which is tied with property keys
 */
public class PropertyManager {
    private static final Logger logger = LoggerFactory.getLogger(PropertyManager.class);

    /**
     * reads data from property file in UTF-8 format and writes this data to instance of Properties
     *
     * @param fileName - name of proprty file
     * @param prop     - Object for storing data from property file
     */
    public void readPropertyFile(String fileName, Properties prop) {

        try (FileInputStream inputStream = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            prop.load(isr);
            logger.debug("Property was successfully read");
        } catch (IOException e) {
            logger.error("Can't read property file{}", e.getMessage(), e);

        }
    }

    /**
     * returns string value which is tied with property key
     * throws NotExistPropertyKeyException if value of key does not exist
     *
     * @param propKey - string value of key which is tied with property value
     * @param prop    - Object which stores data from property file
     * @return - string value which is tied with property key
     */
    public static String getStringPropertiesValue(String propKey, Properties prop) {

        if (prop.getProperty(propKey) == null) {
            throw new NotExistPropertyKeyException("Value of PROPERTY_KEY: " + propKey + " doesn't exist ");
        }
        return prop.getProperty(propKey);
    }

    /**
     * returns numeric value which is tied with property key in accordance with assigned type
     *
     * @param prop - Object which stores data from property file
     * @param key - string value of key which is tied with property value
     * @param type - type of numeric value which is assigned by System variable
     * @return numeric value from property file in accordance with assigned type
     */
    public Number getNumberPropertiesValue(Properties prop, String key, String type) {

        if (type == null) {
            throw new NotInputtedFormatException("format isn't inputted");
        }
        if (type.equalsIgnoreCase("byte")) {
            logger.info("Byte value of {} will be returned", key);
            return Byte.parseByte(PropertyManager.getStringPropertiesValue(key, prop));
        }
        if (type.equalsIgnoreCase("long")) {
            logger.info("Long value of {} will be returned", key);
            return Long.parseLong(PropertyManager.getStringPropertiesValue(key, prop));
        }
        if (type.equalsIgnoreCase("short")) {
            logger.info("Short value of {} will be returned", key);
            return Short.parseShort(PropertyManager.getStringPropertiesValue(key, prop));
        }
        if (type.equalsIgnoreCase("float")) {
            logger.info("Float value of {} will be returned", key);
            return Float.parseFloat(PropertyManager.getStringPropertiesValue(key, prop));
        }
        if (type.equalsIgnoreCase("double")) {
            logger.info("Double value of {} will be returned", key);
            return Double.parseDouble(PropertyManager.getStringPropertiesValue(key, prop));
        }
        if (type.equalsIgnoreCase("BigInteger")) {
            logger.info("BigInteger value of {} will be returned", key);
            return new BigInteger(PropertyManager.getStringPropertiesValue(key, prop));
        }
        if (type.equalsIgnoreCase("BigDecimal")) {
            logger.info("Double value of {} will be returned", key);
            return new BigDecimal(PropertyManager.getStringPropertiesValue(key, prop));
        }

        logger.info("Int value of {} will be returned by default", key);
        return Integer.parseInt(PropertyManager.getStringPropertiesValue(key, prop));

    }
}
