package com.java8features;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class NewSolve {
    /**
     * Iterate through each line of input.
     */
    /*public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        System.out.println(Arrays.toString(add(new String[]{"A", "B", "C"}, "D")));
        System.out.println(Arrays.toString(add(new String[]{"A", "B", "C", "D"}, "D")));

    }*/

    public static void main(String[] args){

        System.out.println(reverseString("hello"));
    }

    public static String reverseString(String str){
        char[] revs = new char[str.length()];
        int index = 0;
        for(int i = str.length() - 1; i >= 0; i--){
            revs[index] = str.charAt(i);
            index++;
        }

        return new String(revs);
    }

    public static String[] add(String[] array, String newString){

        String[] copy = new String[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(newString)) {
                return array;
            }else{
                copy[i] = array[i];
            }

        }

        copy[array.length] = newString;
        return copy;
    }





}
