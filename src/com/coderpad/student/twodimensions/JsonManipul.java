package com.coderpad.student.twodimensions;

import java.io.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.*;

import org.json.simple.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

 ratio(zipcode) = "rx in a month per that population" for that zip code

 for which zipcode is ratio(zipcode) greatest?

 1st month of 2021 = 27,

 90001 -> 66/57110

 */

class RxPrescription{
    public int xYear;
    public int xMonth;

    public String state;

    public String county;

    public int zip;

    public String schedule_Group;
    public String rundatetime;

    public int rxCount;

    public int population;
}


class Solution {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream("/home/coderpad/data/PrescriptionsByMonthAndSchedule.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        StringBuffer buf = new StringBuffer();



        JSONObject dataset = (JSONObject) JSONValue.parse(buf.toString());
        JSONArray data = (JSONArray) dataset.get("SASTableData+REPORT_TABLE8");

        JSONObject v = (JSONObject) data.get(1);
        // System.out.println(v);
        // System.out.println((Long) v.get("xYear"));
        // System.out.println((String) v.get("State"));

        listZipCodes(data);
    }

    public static void listZipCodes(JSONArray data) {
        AtomicReference<Double> result = new AtomicReference<>((double) Integer.MIN_VALUE);
        AtomicReference<Double> resPopulation = new AtomicReference<>((double) Integer.MIN_VALUE);
        IntStream.range(0, data.size()).limit(10).forEach(i -> {
            double zipPopulation = 0.0; double rxCount = 0.0 ;
            if(((JSONObject) data.get(i)).get("Population") != null){
                zipPopulation = Double.parseDouble(((JSONObject) data.get(i)).get("Population").toString());

            }

            if(((JSONObject) data.get(i)).get("RxCount") != null){
                rxCount = Double.parseDouble(((JSONObject) data.get(i)).get("RxCount").toString());
            }

            double ratio = rxCount/zipPopulation;
            result.set(Math.max(result.get(), ratio));

        });

        System.out.println(result);
    }

}