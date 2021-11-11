package com.coderpad.student;

import java.util.HashMap;
import java.util.Map;

public class FindPairWithtargetSum {

    public static void main(String[] args) {

     //   findPairWithtarget(new int[]{7, 5, 2, 1, -4, 11});
        printFreqOfString(new String[]{"ravi", "ravi", "teja", "teja", "ravi"});
    }

    public static String findPairWithtarget(int[] arr){

        int target = arr[0];

        Map<Integer, Integer> targetMap = new HashMap<>();

        for(int i = 1; i< arr.length; i++){

            int diff = target - arr[i];

            if(targetMap.containsKey(arr[i])){
                System.out.println(arr[i] + ": " + diff);
            }else{
                targetMap.put(Math.abs(diff), arr[i]);
            }
        }

        return null;
    }

    public static void printFreqOfString(String[] names){

        Map<String, Integer> freqMap = new HashMap<>();

        for(String word : names){

            int count = freqMap.getOrDefault(word, 0);

            freqMap.put(word, count + 1);

        }

        System.out.println(freqMap);

        for(Map.Entry<String, Integer> entry : freqMap.entrySet()){

            System.out.println(entry.getKey() + "::"+entry.getValue());

        }

    }
}
