package com.info.lecture1;

// Given the list of salary packages of each employee based on their ids, {id, frequency, price}, where the frequency can be either yearly/monthly/quarterly/bi-weekly, the price is amount given to employee on that frequency.

// You need to calculate the final price for each employee per year and return the price array in the descending order of final price


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    static String packageData[][] = {{"1", "y", "700.0"},
            {"2", "m", "51.0"},
            {"3", "bw", "45.0"},
            {"4", "q", "150.0"},
            {"5", "bw", "40.0"}};

    // 700, 51*12, 45 * 26 , 150 * 4, 40 * 26

    // y, m, q, bw

    //  y ->1
    // m ->  12
    // bw -> 26
    // w -> 52

    public static List<Double> parsePackageData() {


        List<Double> sumList = new ArrayList<>();
        for (int i = 0; i < packageData.length; i++) {

            String[] packageInner = packageData[i];
            String empId = packageInner[0];
            String freq = packageInner[1];
            String amt = packageInner[2];

            Double actSum = calculateSum(freq, amt);
            sumList.add(actSum);
        }

        Collections.sort(sumList, Collections.reverseOrder());

        return sumList;
    }


    public static Double calculateSum(String freq, String amt) {

        int freqValue = 1;
        if (freq.equalsIgnoreCase("y")) {

            freqValue = 1;
        }

        if (freq.equalsIgnoreCase("q")) {

            freqValue = 4;
        }

        if (freq.equalsIgnoreCase("m")) {

            freqValue = 12;
        }

        if (freq.equalsIgnoreCase("bw")) {

            freqValue = 26;
        }

        if (freq.equalsIgnoreCase("w")) {

            freqValue = 52;
        }

        return freqValue * Double.valueOf(amt);

    }


    public static void main(String[] args) {
        System.out.println(parsePackageData());
    }
}
