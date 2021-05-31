package com.coderpad.student;
import java.util.*;
import java.util.stream.Collectors;

public class SpecialNumbersDivisorsEqualsSum {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{1, 2, 3, 4, 5, 6, 7, 8 , 9, 10}));

    }

    public static int trap(int[] A){
        int a=0;
        int b=A.length-1;
        int max=0;
        int leftmax=0;
        int rightmax=0;
        while(a<=b){
            leftmax=Math.max(leftmax,A[a]);
            rightmax=Math.max(rightmax,A[b]);
            if(leftmax<rightmax){
                max+=(leftmax-A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            }
            else{
                max+=(rightmax-A[b]);
                b--;
            }
        }
        return max;
    }

    public static void printIfSumIsEqualToDivisor(){

        for(int i = 5; i <= 6; i++){
            findDivisor(i);

        }


    }

    public static void findDivisor(int n){

        List<Integer> divisors = new ArrayList<>();
        for(int i = 1; i < n; i++){
            if(n % i == 0 ){
                divisors.add(i);

            }
        }

        if(ifSumEqualsDivisor(divisors, n)){
            System.out.println(n);
        }
    }

    public static boolean ifSumEqualsDivisor(List<Integer> divisors, int num){
        Integer sum = divisors.stream().reduce(0, Integer::sum);
        return sum == num;
    }
}


class Consultant implements CommonCheck, CreditCheck{
    String name ;
    int age;
    String gender ;

    public Consultant(){
        this.name = "Venaktesh";

        this.age = 27;
        this.gender = "Male" ;
    }

    @Override
    public boolean validateNegative() {
        return false;
    }

    @Override
    public boolean validate700() {
        return false;
    }
}

interface CommonCheck extends FelonyCheck, DrugTest{


}
interface FelonyCheck{
    boolean validateNegative();
}

interface CreditCheck{

    boolean validate700();
}

interface DrugTest{
    boolean validateNegative();
}