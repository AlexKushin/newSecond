package com.shpp.mentoring.okushin.task2.test;

import com.shpp.mentoring.okushin.task2.PropertyManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PropertyManagerTest extends PropertyManager {

    @Test
    void testReadPropertyFile() {
    }

    @Test
    void testReadPropertiesValue() {

    }
    public static final PropertyManager pm =new PropertyManager();

    @Mock
    Properties prop;
    @ParameterizedTest
    @CsvSource({
            "1, 1, min, byte",
            "9, 9, max, byte",
            "1, 1, increment, byte"
    })
    void testGetValueOfByte(String expStr, byte expNum, String key, String type) {
        Mockito.when(prop.getProperty(key)).thenReturn(expStr);
        assertEquals(expNum, pm.getValue(prop, key, type));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, min, short",
            "9, 9, max, Short",
            "1, 1, increment, ShOrt"
    })
    void testGetValueOfShort(String expStr, short expNum, String key, String type) {
        Mockito.when(prop.getProperty(key)).thenReturn(expStr);
        assertEquals(expNum, pm.getValue(prop, key, type));

    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, min, int",
            "9, 9, max, iNt",
            "1, 1, increment, Integer"
    })
    void testGetValueOfInt(String expStr, int expNum, String key, String type) {
        Mockito.when(prop.getProperty(key)).thenReturn(expStr);
        assertEquals(expNum, pm.getValue(prop, key, type));
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,min,long",
            "9,9,max,loNg",
            "1,1,increment,LONg"
    })
    void testGetValueOfLong(String expStr, long expNum, String key, String type) {
        Mockito.when(prop.getProperty(key)).thenReturn(expStr);
        assertEquals(expNum, pm.getValue(prop, key, type));
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,min,float",
            "9,9,max,Float",
            "1,1,increment,flOat"
    })
    void testGetValueOfFloat(String expStr, float expNum, String key, String type) {
        Mockito.when(prop.getProperty(key)).thenReturn(expStr);
        assertEquals(expNum, pm.getValue(prop, key, type));
    }
    @ParameterizedTest
    @CsvSource({
            "1,1,min,double",
            "9,9,max,Double",
            "1,1,increment,dOUBle"
    })
    void testGetValueOfDouble(String expStr, double expNum, String key, String type) {
        Mockito.when(prop.getProperty(key)).thenReturn(expStr);
        assertEquals(expNum, pm.getValue(prop, key, type));
    }
    @ParameterizedTest
    @CsvSource({
            "1,1,min,BiGIntegeR",
            "9,9,max,biginteger",
            "1,1,increment,BigInteger"
    })
    void testGetValueOfBigInteger(String expStr, BigInteger expNum, String key, String type) {
        Mockito.when(prop.getProperty(key)).thenReturn(expStr);
        assertEquals(expNum, pm.getValue(prop, key, type));
    }
    @ParameterizedTest
    @CsvSource({
            "1,1,min,BIgDecimAL",
            "9,9,max,bigdecimal",
            "1,1,increment,BigDecimal"
    })
    void testGetValueOfBigDecimal(String expStr, BigDecimal expNum, String key, String type) {
        Mockito.when(prop.getProperty(key)).thenReturn(expStr);
        // MultiTable multiTableTest = new MultiTable();
        //Mockito.when(prop.getProperty("max")).thenReturn("9");
        //    Mockito.when(prop.getProperty("increment")).thenReturn("1");
        // assertEquals(expStr, prop.getProperty(key));
        // assertEquals(expStr, prop.getProperty(key));
        //assertEquals(expStr, prop.getProperty(key));
        assertEquals(expNum, pm.getValue(prop, key, type));
    }
}