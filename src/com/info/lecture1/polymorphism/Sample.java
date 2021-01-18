package com.info.lecture1.polymorphism;

public class Sample extends SuperClass {

    @Override
    public Object add(Object a, Object b){
        System.out.println("Child Class Method");
        return new Object();
    }

    public static void main(String[] args) {
        SuperClass sample = new SuperClass();
        System.out.println(sample.add(new Integer(3), new Integer(4)));

        SuperClass sup = new Sample();
        System.out.println(sup.add(new Integer(3), new Integer(4)));
    }
}
