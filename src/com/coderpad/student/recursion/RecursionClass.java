package com.coderpad.student.recursion;

public class RecursionClass {

    public static void main(String[] args) {

    }

    public static int sum(int n, int r){

        int targetSum = 0;
        while( r > 0){
            targetSum += product(n, r);
            r--;
        }
        return targetSum;
    }

    public static int product(int N, int r){


        if( r == 1){
            return ( N + 1);
        }

        else{
           return (N + r) * product(N, r - 1);
        }


    }
}
