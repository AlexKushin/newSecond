package com.shpp.mentoring.okushin.task2;


import java.util.List;
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

        Properties properties = new Properties();
        PropertyManager pm = new PropertyManager();
        pm.readPropertyFile("values.properties", properties);

        String type = System.getProperty("type");

        MultiplyTable multiplyTable = new MultiplyTable();
        List<String> list = multiplyTable.writeMultiplyTableToArrayList(pm.getNumberPropertiesValue(properties, MIN, type),
                pm.getNumberPropertiesValue(properties, MAX, type), pm.getNumberPropertiesValue(properties, INCREMENT, type));

        logger.info("------my Multiplication Table will be print under this log message------");

        for (String str : list) {
            logger.info(str);
        }
    }
}
