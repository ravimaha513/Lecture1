package com.leetcode.problems;

import java.util.*;

public class OrangesRotting {

    public static void main(String[] args) {


    }

    // [[2,1,1],
    // [1,1,0],
    // [0,1,1]]

    // add (0,0)

    // poll (0, 0)
    // [ , (0,1), (1,0), ]
    // visited, visited, visited

    // poll 0, 1
    // add((0, 2), (1,1)

    // [(1,0), (0, 2), (1,1)]

    // poll -> (1, 0)
    // (0, 2), (1, 1)

    //poll -> 0, 2

    // poll 1, 1
    // [(2, 1))

    // poll 2, 1
    // [2, 2]

    //poll 2, 2

    public int orangesRotting(int[][] grid) {

        Queue<Integer> queue = new LinkedList<>();


        return 0;
    }


}
 class CaseStudy {

    public static void main(String... doYourBest) {
        StringBuilder warriorProfession = new StringBuilder("Dragon ");
        String warriorWeapon = "Sword ";
        changeWarriorClass(warriorProfession, warriorWeapon);

        System.out.println("Warrior=" + warriorProfession + " Weapon=" + warriorWeapon);
    }

    static void changeWarriorClass(StringBuilder warriorProfession, String weapon) {
        warriorProfession.append("Knight");
        weapon = "Dragon " + weapon;

        weapon = null;
        warriorProfession = null;

    }

}

//Create a method(int[] findSum(int[] arr, int n)
// that takes an integer array arr and returns an array of the two
// integer elements that add up to integer n.
//If there are multiple, return only one. If there is no such pair, return the original array.

//Input = 10 , array 7,8,3, 5, 1
// 1, 3, 5, 7, 8 -> sort

// start at 0 -> 1
// end at arr.length -> 8

// 1 + 8 - 9 < 10 increment startIndex
// 3 + 8 = 11 > 10 decrement endIndex
// 3 + 7 == 10 ( print pair)



class Main {
    public static void main(String[] args) {

        System.out.println("Hello, world!");
        System.out.println(Add(2, 3));
    }

    //O(NLogN) - time complexity
    //O(1) - space
    public static int[] findPairWithTarget(int[] arr, int k){
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            if(arr[start] + arr[end] == k){
                return new int[]{arr[start], arr[end]};
            }
            else if(arr[start] + arr[end] > k){
                    end--;
            }
                else{
                    start++;
                }
            }
        return arr;
    }

    static int Add(int x, int y)
    {
        // Iterate till there is no carry
        while (y != 0)
        {
            // carry now contains common
            // set bits of x and y
            int carry = x & y;

            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;

            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry << 1;
        }
        return x;
    }
}


