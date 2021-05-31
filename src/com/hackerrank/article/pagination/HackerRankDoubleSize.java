package com.hackerrank.article.pagination;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HackerRankDoubleSize {

    public static void main(String[] args) {
        System.out.println(doubleSize(Arrays.asList(1L, 2L, 4L, 11L, 12L, 8L), 2));
    }

    public static long doubleSize(List<Long> arr, long b) {
        // Write your code here
        Collections.sort(arr);
        long temp = arr.get(0);

        long max = Long.MIN_VALUE;

        if(!arr.contains(b)){
            return b;
        }
        for(Long num : arr){
            if(num == b){
                temp = num * 2;
                b = temp;
                if(max < temp){
                    max = temp;
                }
            }
        }

        return max;
    }
}
