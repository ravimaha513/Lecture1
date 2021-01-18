package com.info.lecture1;

import java.util.Scanner;

public class Trojan {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 5};

        int trojan ;
        if(isEven(arr)){
           trojan = findEven(arr);
        }else{
            trojan = findOdd(arr);
        }

        System.out.println(trojan);
    }

    public static boolean isEven(int[] arr){
        int trackEven = 0;
        for(int i = 0; i < 3; i++){
            if(arr[i] % 2 == 0){
                trackEven++;
            }
        }
        return trackEven > 1 ;
    }


    public static int findOdd(int[] arr_values){

        int trackOdd = 0;
        for (int i = 0; i < arr_values.length; i++) {
            if (arr_values[i] % 2 == 0) {
                trackOdd = arr_values[i];
                break;
            }

        }

        return trackOdd;
    }

    public static int findEven(int[] arr_values) {

        int trackEven = 0;
        for (int i = 0; i < arr_values.length; i++) {
            if (arr_values[i] % 2 != 0) {
                trackEven = arr_values[i];
                break;
            }

        }

        return trackEven;
    }
}
