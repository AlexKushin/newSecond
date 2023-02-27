package com.shpp.mentoring.okushin.task2;

import java.util.ArrayList;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App {
    static String MIN = "min";
    static String MAX = "max";
    static String INCREMENT = "increment";
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        Properties properties = new Properties();
        PropertyManager pm = new PropertyManager();
        pm.readPropertyFile("values.properties", properties);

        String type = System.getProperty("type");
        System.out.println(type);
        MultiTable multiTable = new MultiTable();
        ArrayList<String> list = multiTable.print(pm.getValue(properties, MIN, type),
                                                    pm.getValue(properties, MAX, type),
                                                    pm.getValue(properties, INCREMENT, type));
        for (String str : list) {
            logger.info(str);
        }


    }


}
