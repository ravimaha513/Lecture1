package com.coderpad.student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubListContains {

    public static void main(String[] args) {
        //System.out.println(returnSubArrayIndex(new int[] {2,7,9,3,7,3,7,8,2,3,4,5,8,7,4,5,3,7,8,1,3,6}, new int[] {3,7,8}));

     //   System.out.println(carParkingRoof(Arrays.asList(6L, 7L, 2L, 12L), 3));
     //   System.out.println(carParkingRoof(Arrays.asList(2L, 10L, 8L, 17L), 3));
        System.out.println(carParkingRoof(Arrays.asList(1L, 2L, 3L, 10L), 4));

    }


    public static int slidingWindowProtocol(int[] arr, int[] subArray){

        int subLength = subArray.length;
        for(int i = arr.length; i>= 0; ){
           // int[] sub = System.arraycopy(arr, 0, subArray, subLength);
            i = i - subLength;
        }

        return 1;
    }

    public static long carParkingRoof(List<Long> cars, int k) {
        // Write your code here

        // 2, 6, 7, 12

        // 2  - 7 = 5 + 1 = 6

        // 6 - 12 = 6 + 1 = 7

        // 2, 8, 10, 17

        // 2- 10 = 8 + 1 = 9

        // 8 - 17 = 9 + 1 = 10

        Collections.sort(cars);

        long minimum = Long.MAX_VALUE;

        for(int i = 0; i <= cars.size() - k; i++){

            long start = cars.get(i);
            long end = cars.get(i + k - 1);

            long diff = Math.abs(end - start);

            minimum = Math.min(diff, minimum);


        }

        return minimum + 1;
    }


    public static int returnSubArrayIndex(int[] arr, int[] subArray) {


        int result = -1;

        int start = arr.length ;
        int end = start - 3;

        for(int i = arr.length ; i >= 0; ) {

            int[] sub = Arrays.copyOfRange(arr, end, start);

            System.out.println(Arrays.toString(sub));

            if(twoArraysAreEqual(sub, subArray)) {
                result = end;
                break;
            }

            i = i - 3;
            start = i;
            end = start - 3;
        }

        return result;
    }

    public static boolean twoArraysAreEqual(int[] arr, int[] sub) {

        return Arrays.equals(arr, sub);


    }
}
