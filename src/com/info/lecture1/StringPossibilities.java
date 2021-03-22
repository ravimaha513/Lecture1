package com.info.lecture1;

import java.util.*;

public class StringPossibilities {

    public static void main(String[] args) {
       // System.out.println(sameStrings("aabb", "aaad"));

        System.out.println(possibleCombination(new String[]{ "abbb"}, "abba"));

    }


    static int possibleCombination(String[] dictionary, String initialWord){
       /* int possibleCombo = 0;
        for(String str : dictionary){
            if(sameStrings(initialWord, str)){
                System.out.println(str);

                possibleCombo++;
            }
        }*/

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for(String str : dictionary){

            for(int i =0; i < alphabet.length; i++){
                //replaceCharacter(alphabet[i], str);
            }


        }

        return 0;
    }


    static boolean sameStrings(String str1,
                               String str2) {
        int N = str1.length();
        int M = str2.length();


        if (N != M) {
            return false;
        }
        int[] a = new int[256];
        int[] b = new int[256];

        for (int i = 0; i < N; i++) {
            int index = str1.charAt(i);
            a[index]++;

            int indexS = str2.charAt(i);
            b[indexS]++;

            System.out.println(index + "::"+ str1.charAt(i));
            System.out.println(indexS + "::"+ str2.charAt(i));

        }

        int count = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < 256; i++) {

            if (a[i] != b[i])
            {
                count = count + Math.abs(a[i] - b[i]);
            }
        }

        if(count > 2 ){
            return false;
        }

        return true;
    }

}



