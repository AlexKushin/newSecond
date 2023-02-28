package com.shpp.mentoring.okushin.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * class MultiplyTable performs multiplication between 2 numeric values and writes result tu ArrayList for further using
 */
public class MultiplyTable {


    private static final Logger logger = LoggerFactory.getLogger(MultiplyTable.class);


    /**
     * returns ArrayList filled with strings that contains result of multiplication
     * casts every numeric type to BigDecimal type, performs operation of multiplication and creates string with results,
     * saves these strings to ArrayList
     *
     * @param min       - min value of multiplier
     * @param max       - max value of multiplier
     * @param increment - value of increase step
     * @return ArrayList filled with result strings
     */
    public ArrayList<String> writeMultiplyTableToArrayList(Number min, Number max, Number increment) {
        logger.info("class= {}", min.getClass());
        ArrayList<String> resultTable = new ArrayList<>();
        StringBuilder a = new StringBuilder();

        logger.info("values of type Number will be cast to BigDecimal Type");
        BigDecimal i = new BigDecimal(min.toString());
        BigDecimal j = new BigDecimal(min.toString());
        BigDecimal maxBD = new BigDecimal(max.toString());
        BigDecimal incrementBD = new BigDecimal(increment.toString());

        for (; i.compareTo(maxBD.add(incrementBD)) <= 0; i = i.add(incrementBD)) {
            if (!a.toString().equals("")) {
                resultTable.add(a.toString());
            }
            a = new StringBuilder();
            for (; j.compareTo(maxBD) <= 0; j = j.add(incrementBD)) {
                a.append(i).append(" * ").append(j).append(" = ").append(multiply(i, j)).append("\t");
            }
            j = new BigDecimal(min.toString());
        }
        return resultTable;
    }

    /**
     * performs multiplication of 2 values of BigDecimal type
     *
     * @param i - first multiplier
     * @param j - second multiplier
     * @return result value of multiplication
     */
    public BigDecimal multiply(BigDecimal i, BigDecimal j) {
        return i.multiply(j);
    }

}
