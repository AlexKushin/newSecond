package com.shpp.mentoring.okushin.task2;

import com.shpp.mentoring.okushin.exceptions.NotExistPropertyKeyException;
import com.shpp.mentoring.okushin.exceptions.NotInputtedFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Properties;

public class MultiTable {



    private static final Logger logger = LoggerFactory.getLogger(MultiTable.class);



    public static String readValueFromProperties(Properties prop, String key) {

        if (prop.getProperty(key) == null) {
            throw new NotExistPropertyKeyException("Value of " + key + " doesn't exist ");
        }

        return prop.getProperty(key);
    }

    public static double  getValue(Properties prop, String key) {

        if (System.getProperty("type") == null) {
            throw new NotInputtedFormatException("format isn't inputted");
        }
        String type = System.getProperty("type");
        if (type.equalsIgnoreCase("int") || type.equalsIgnoreCase("integer")) {
            logger.info("Int value of " + key + " will be returned");
            return  Integer.parseInt(PropertyManager.readPropertiesValue(key,prop));
        }
        if (type.equalsIgnoreCase("byte")) {
            logger.info("Byte value of " + key + " will be returned");
            return Byte.parseByte(PropertyManager.readPropertiesValue(key,prop));
        }
        if (type.equalsIgnoreCase("long")) {
            logger.info("Long value of " + key + " will be returned");
            return Long.parseLong(PropertyManager.readPropertiesValue(key,prop));
        }
        if (type.equalsIgnoreCase("short")) {
            logger.info("Short value of " + key + " will be returned");
            return Short.parseShort(PropertyManager.readPropertiesValue(key,prop));

        }
        if (type.equalsIgnoreCase("float")) {
            logger.info("Float value of " + key + " will be returned");
            return Float.parseFloat(PropertyManager.readPropertiesValue(key,prop));

        }
        if (type.equalsIgnoreCase("double")) {
            logger.info("Double value of " + key + " will be returned");
            return Double.parseDouble(PropertyManager.readPropertiesValue(key,prop));

        }
        logger.info("Int value of " + key + " will be returned by default");

        return Integer.parseInt(PropertyManager.readPropertiesValue(key,prop));

    }




    public static void createMultiTable(double min, double max, double increment  ){
        // StringBuilder a = new StringBuilder();

        StringBuilder a = new StringBuilder();
        for(double i =  min; i <= max+1; i+=increment ){
            if(!a.toString().equals("")) {
                logger.info(a.toString());
            }
            a = new StringBuilder();
            for(double j = min; j<=max; j+=increment){

                a.append(i).append(" * ").append(j).append(" = ").append(j*i).append("  ");


            }
        }
    }

}
