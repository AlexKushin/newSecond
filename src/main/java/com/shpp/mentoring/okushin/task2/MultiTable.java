package com.shpp.mentoring.okushin.task2;

import com.shpp.mentoring.okushin.exceptions.NotExistPropertyKeyException;
import com.shpp.mentoring.okushin.exceptions.NotInputtedFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Properties;

public class MultiTable {


    private static final Logger logger = LoggerFactory.getLogger(MultiTable.class);



    //what a difference between valueOf() and ...parse() methods?
    //for a what we need to assign type of numbers? they have to be in certain range?
    //



    public ArrayList<String> print(Number min, Number max, Number increment) {
        System.out.println("class= " + min.getClass());
        ArrayList <String> resultTable = new ArrayList<>();
        StringBuilder a = new StringBuilder();
        BigDecimal i = new BigDecimal(min.toString());

        BigDecimal j = new BigDecimal(min.toString());
        BigDecimal maxBD = new BigDecimal(max.toString());
        BigDecimal incrementBD = new BigDecimal(increment.toString());

        for (; i.compareTo(maxBD.add(incrementBD))<=0; i = i.add(incrementBD)) {
            if (!a.toString().equals("")) {
                resultTable.add(a.toString());
            }
            a = new StringBuilder();
            for (; j.compareTo(maxBD)<=0; j = j.add(incrementBD)) {
                a.append(i).append(" * ").append(j).append(" = ").append(multiply(i,j)).append("  ");
            }
            j = new BigDecimal(min.toString());
        }
        return resultTable;
    }
    public BigDecimal multiply(BigDecimal i, BigDecimal j){
        return i.multiply(j);
    }

}
