package com.coderpad.student.wayfairer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    Integer input;

    public static void main(String[] args) {
        System.out.println(findPairsWithPositiveSum(new int[]{-5, -4, -3, 2, 3, 5}));

    }

    public static List<Pair> findPairsWithPositiveSum(int[] arr){
        List<Pair> result = new ArrayList<>();
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;

        for(int index = j; index >= 0; index--){
            int curr = arr[index];
            while(i < j){
                if(curr + arr[j] >= 0){
                    result.add(new Pair(arr[i], arr[j]));
                    i++;
                }

                else{
                    j--;
                }
            }
        }


        return result;
    }
}

class Pair{
    int num1;
    int num2;

    public Pair(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }
}




