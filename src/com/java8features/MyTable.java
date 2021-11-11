package com.java8features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyTable {

    public void printSomething(int num){

        for(int i = 0; i < 10; i++){
            System.out.println(num + " X " + i + " = " + (num * i));
        }

    }

    public static void main(String[] args) {
       /* MyTable o1 = new MyTable();
        Thread t1 = new Thread(() -> {
            o1.printSomething(2);
        });


        Thread t2 = new Thread(() -> {
            o1.printSomething(4);
        });

        t1.start();
        t2.start();*/

        Comparator<CusEmp> lNameComparator = new Comparator<CusEmp>() {
            @Override
            public int compare(CusEmp o1, CusEmp o2) {
                return o1.lName.compareTo(o2.lName);
            }
        };

        List<CusEmp> empList = new ArrayList<>();

        Collections.sort(empList, lNameComparator);

    }
}

class CusEmp{
    String lName;

}
