package com.shpp.mentoring.okushin.task2.test;

import com.shpp.mentoring.okushin.task2.MultiplyTable;
import com.shpp.mentoring.okushin.task2.PropertyManager;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MultiplyTableTest extends MultiplyTable {
    @Mock
    Properties prop;


    private static final MultiplyTable multiplyTable = new MultiplyTable();
    public static final PropertyManager pm = new PropertyManager();


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
        for (int i = min; i <= max + increment; i += increment) {
            if (!stringBuilder.toString().equals("")) {
                res.add(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            for (int j = min; j <= max; j += increment) {
                stringBuilder.append(i).append(" * ").append(j).append(" = ").append(i * j).append("\t");
            }
        }
        assertEquals(res, multiplyTable.writeMultiplyTableToArrayList(pm.getNumberPropertiesValue(prop, "min", type),
                pm.getNumberPropertiesValue(prop, "max", type),
                pm.getNumberPropertiesValue(prop, "increment", type)));

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

        for (float i = min; i <= max + increment; i += increment) {
            if (!stringBuilder.toString().equals("")) {
                res.add(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            for (float j = min; j <= max; j += increment) {
                stringBuilder.append(i).append(" * ").append(j).append(" = ").append(i * j).append("\t");
            }
        }
        assertEquals(res, multiplyTable.writeMultiplyTableToArrayList(pm.getNumberPropertiesValue(prop, "min", type),
                pm.getNumberPropertiesValue(prop, "max", type),
                pm.getNumberPropertiesValue(prop, "increment", type)));

    }

    @ParameterizedTest
    @CsvSource({
            "6, 2, 3",
            "578, 17, 34",
            "62658, 354, 177"
    })
    void multiplicationIntTest(int exceptRes, int x, int y) {
        assertEquals(new BigDecimal(exceptRes), multiplyTable.multiply(new BigDecimal(x), new BigDecimal(y)));
    }

    @ParameterizedTest
    @CsvSource({
            "109.375, 12.5, 8.75",
            "30.4319, 3.47, 8.77",
            "54.39, 7.77, 7",
    })
    void multiplyFloatTest(float exceptRes, float x, float y) {
        BigDecimal exceptResBD = new BigDecimal(exceptRes);
        BigDecimal resultBD = multiplyTable.multiply(new BigDecimal(x), new BigDecimal(y));
        assertTrue(exceptResBD.compareTo(resultBD) <= 0.00000001);

    }


}