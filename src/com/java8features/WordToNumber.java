package com.java8features;

import java.util.*;

public class WordToNumber {

    static HashMap<String, Integer> numbers= new HashMap<String, Integer>();

    static HashMap<String, Integer> onnumbers = new HashMap<String, Integer>();
    static HashMap<String, Integer> tnnumbers = new HashMap<String, Integer>();

    static {
        numbers.put("zero", 0);
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);
        numbers.put("ten", 10);
        numbers.put("eleven", 11);
        numbers.put("twelve", 12);
        numbers.put("thirteen", 13);
        numbers.put("fourteen", 14);
        numbers.put("fifteen", 15);
        numbers.put("sixteen", 16);
        numbers.put("seventeen", 17);
        numbers.put("eighteen", 18);
        numbers.put("nineteen", 19);


        tnnumbers.put("twenty", 20);
        tnnumbers.put("thirty", 30);
        tnnumbers.put("fourty", 40);
        tnnumbers.put("fifty", 50);
        tnnumbers.put("sixty", 60);
        tnnumbers.put("seventy", 70);
        tnnumbers.put("eighty", 80);
        tnnumbers.put("ninety", 90);

        onnumbers.put("hundred", 100);
        onnumbers.put("thousand", 1000);
        onnumbers.put("million", 1000000);
        onnumbers.put("billion", 1000000000);

        // 532532
        //numbers.put("", );
    }

    public static void main(String args[]){

        String fivehundredThirtyTwo = "five hundred thirty two thousand five hundred thirty two";


        wordToNumber(fivehundredThirtyTwo);

        Map<String, String> stringMap = new HashMap<>();

        stringMap.put(new String("harika"), "123");
        stringMap.put(new String("harika"), "123");

        System.out.println(stringMap);

    }

    private static void wordToNumber(String input) {
        System.out.println("===========\nInput string = "+input);
        long sum=0;
        Integer temp=null;
        Integer previous=0;
        String [] splitted= input.toLowerCase().split(" ");


        for(String split:splitted){

            if( numbers.get(split)!=null){
                temp= numbers.get(split);

                sum=sum+temp;

                previous=previous+temp;
            }
            else if(onnumbers.get(split)!=null){
                if(sum!=0){
                    sum=sum-previous;
                }
                sum=sum+(long)previous*(long) onnumbers.get(split);
                previous=0;


            }
            else if(tnnumbers.get(split)!=null){
                temp= tnnumbers.get(split);
                sum=sum+temp;

                previous=temp;
            }

        }

        System.out.println(sum);
    }


}

class User{
    String id;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

