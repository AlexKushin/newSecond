package com.shpp.mentoring.okushin.task2.test;

import com.shpp.mentoring.okushin.task2.MultiTable;
import com.shpp.mentoring.okushin.task2.PropertyManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MultiTableTest extends MultiTable {
    @Mock
    Properties prop;


    private static final MultiTable multiTableTest = new MultiTable();
    public static final PropertyManager pm =new PropertyManager();




    @ParameterizedTest
    @CsvSource({
            "1, 9, 1, int",
           "1, 20, 5, int",
            "3, 30, 3, int"
    })
    void testPrintInt(int min, int max, int increment, String type) {
        Mockito.when(prop.getProperty("min")).thenReturn(String.valueOf(min));
        Mockito.when(prop.getProperty("max")).thenReturn(String.valueOf(max));
        Mockito.when(prop.getProperty("increment")).thenReturn(String.valueOf(increment));
        ArrayList<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = min; i <= max+increment; i += increment) {
            if(!stringBuilder.toString().equals("")) {
                res.add(stringBuilder.toString());
            }
            stringBuilder=new StringBuilder();
            for (int j = min; j <= max; j += increment) {
                stringBuilder.append(i).append(" * ").append(j).append(" = ").append(i * j).append("  ");
            }
        }
        assertEquals(res, multiTableTest.print(pm.getValue(prop, "min", type),
                                                pm.getValue(prop, "max", type),
                                               pm.getValue(prop, "increment", type)));

    }
    @ParameterizedTest
    @CsvSource({
            "5.5, 55, 1, flOAt"
    })
    void testPrintFloat(float min, float max, float increment, String type) {
        Mockito.when(prop.getProperty("min")).thenReturn(String.valueOf(min));
        Mockito.when(prop.getProperty("max")).thenReturn(String.valueOf(max));
        Mockito.when(prop.getProperty("increment")).thenReturn(String.valueOf(increment));
        ArrayList<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (float i = min; i <= max+increment; i += increment) {
            if(!stringBuilder.toString().equals("")) {
                res.add(stringBuilder.toString());
            }
            stringBuilder=new StringBuilder();
            for (float j = min; j <= max; j += increment) {
                stringBuilder.append(i).append(" * ").append(j).append(" = ").append(i * j).append("  ");
            }
        }
        assertEquals(res, multiTableTest.print(pm.getValue(prop, "min", type),
                pm.getValue(prop, "max", type),
                pm.getValue(prop, "increment", type)));

    }

    @Test
    void multyTest() {
        assertEquals(new BigDecimal(6), multiTableTest.multiply(new BigDecimal(2), new BigDecimal(3)));
    }


}