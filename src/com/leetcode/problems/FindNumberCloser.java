package com.leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class FindNumberCloser {

    public static void main(String[] args) {
     //   System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
      //  System.out.println(findClosestElements(new int[]{1,1,1,10,10,10}, 1, 9));

    //    System.out.println(binarySearchII(new int[]{1,2,5}, 3, 0, 5));

       // System.out.println(isPossibleToFindWord("batman", new String[]{"bat", "man" , "hit", "rat", "mat" ,"ma","m"}));

    //    System.out.println(getMin(")("));

        String input = "??eteki????????";
        System.out.println(String.format("Input[%s]:%s ", input, qSignReplacer(input)));
    }



    public static int getMin(String s) {
        // Write your code here

       int count = 0;
       for(int i = 0; i < s.length(); i++){
           if(s.charAt(i) == '(') count++;
           if(s.charAt(i) == ')') count--;
       }

        return count;

    }


    public static String qSignReplacer(String input) {
        StringBuilder sbr = new StringBuilder();

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '?'){
                sbr.append(returnRandomChar());
            }else{
                sbr.append(input.charAt(i));
            }

        }
        return sbr.toString();
    }

    public static String returnRandomChar(){
        Random random = new Random();
        return String.valueOf((char) (random.nextInt(95) + 32));

    }


    public static List<Integer> findClosestElements(int[] arr, int k, int x) {



        return null;

    }

    public static Integer binarySearch(int[] arr, int target, int left, int right){
        if (right >= left) {
            if (target > arr[arr.length - 1] || target < arr[0]) {
                return -1;
            }
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                return binarySearch(arr, target, mid, right);
            } else if (target < arr[mid]) {
                return binarySearch(arr, target, left, mid);
            }

        }
        return -1;
    }

    static int binarySearchII(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearchII(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearchII(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }




}
