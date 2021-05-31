package com.coderpad.student.Constructor;

import java.util.HashMap;
import java.util.Map;

public class Sample {
    int num;

    public Sample(int num) {
        this.num = num;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Sample sample = (Sample) Class.forName("Sample").newInstance();

        System.out.println(sample.num);

    }
}

//Write a program to find out duplicate characters in a string.
class Eteki
{
    public static void main(String[]args) throws java.lang.Exception
    {
        // your code goes here
        String str = "aabbccddef";

        printDuplicateChars(str);
    }

    public static void printDuplicateChars(String str){

        Map<Character, Integer> uniqChars = new HashMap<>();

        for(Character ch : str.toCharArray()){
            int count = uniqChars.getOrDefault(ch, 1);


            if(uniqChars.containsKey(ch)){
                uniqChars.put(ch, count + 1);
            }else{
                uniqChars.put(ch, count);
            }

        }

        for(Map.Entry<Character, Integer> entrySet : uniqChars.entrySet()){

            int count = entrySet.getValue();

            if(count > 1){
                System.out.println(entrySet.getKey() + ":" +entrySet.getValue());
            }
        }

    }
}
