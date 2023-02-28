package com.shpp.mentoring.okushin.task2;

import java.util.ArrayList;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App {
    public static final String MIN = "min";
    public static final String MAX = "max";
    public static final String INCREMENT = "increment";
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("I will have success!!!1!");
        logger.info("I will have success!!!1!");
        logger.info("I will have success!!!1!");
        logger.info("I will have success!!!1!");
        logger.info("I will have success!!!1!");
        Properties properties = new Properties();
        PropertyManager pm = new PropertyManager();
        pm.readPropertyFile("values.properties", properties);

        String type = System.getProperty("type");
        logger.info(type);
        MultiplyTable multiplyTable = new MultiplyTable();
        ArrayList<String> list = multiplyTable.writeMultiplyTableToArrayList(pm.getNumberPropertiesValue(properties, MIN, type),
                pm.getNumberPropertiesValue(properties, MAX, type),
                pm.getNumberPropertiesValue(properties, INCREMENT, type));
        for (String str : list) {
            logger.info(str);
        }


    }


}
