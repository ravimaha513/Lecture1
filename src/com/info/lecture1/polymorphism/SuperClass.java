package com.info.lecture1.polymorphism;

public class SuperClass {

    public Object add(Object a, Object b){
        System.out.println("Super Class Method");
        return new Integer((int) a) + new Integer((int) b);
    }
}
