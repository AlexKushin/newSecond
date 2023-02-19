package com.shpp.mentoring.okushin.task2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Hello world!
 */
public class App {
    static String MIN = "min";
    static String MAX = "max";
    static String INCREMENT = "increment";

    public static void main(String[] args) {

        Properties properties = new Properties();
        PropertyManager.readPropertyFile("values.properties", properties);

        MultiTable.createMultiTable(MultiTable.getValue(properties, MIN), MultiTable.getValue(properties, MAX),
                MultiTable.getValue(properties, INCREMENT));
    }


}
