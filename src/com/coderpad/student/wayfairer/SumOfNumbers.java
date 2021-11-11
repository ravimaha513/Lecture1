package com.coderpad.student.wayfairer;

import java.util.*;

public class SumOfNumbers {

        public static void main(String [] args) {
            // you can write to stdout for debugging purposes, e.g.
            System.out.println("This is a debug message");
            System.out.println(sumOfNumbers("923", "733"));
        }

        public static String sumOfNumbers(String num1, String num2 ){

            // 5544
            // 5234

            // 4 + 4 = 8 = temp( 8)
            // 4 + 3 = 7 = temp( 7 8)
            // 5 + 2 = 7 = (temp( 778))
            // 5 + 5 = 10 = (temp 10778)

            StringBuilder sbr = new StringBuilder();

            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int rem = 0;
            int carry = 0;
            while( i >= 0 && j >= 0){
                char ch1 = num1.charAt(i);
                char ch2 = num2.charAt(j);

                int temp =  Character.getNumericValue(ch1) + Character.getNumericValue(ch2) + rem;

                if(temp > 9){
                    // divide by 10
                    rem = temp / 10;
                    carry = temp % 10;
                    sbr.append( carry);
                }

                else{
                    sbr.append(temp);
                }
                i--;
                j--;
            }

            return sbr.toString();
        }

}/*
class Employee{
    int id;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Map<Employee, Integer> map = new HashMap<>();
        Employee e1 = new Employee(1, "Ravi");
        Employee e2 = new Employee(1, "Ravi");
     //   Employee e3 = new Employee(1, "Ravi");
        map.put(e1, 1);
        map.put(e2, 2);

        System.out.println(map.get(e1));
    }
}*/