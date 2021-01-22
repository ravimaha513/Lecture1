package com.info.lecture1.multithreading;

public class SyncImpl {

    int i = 0;

     public void increment(){
        i = i + 1;

        System.out.println(i);
    }
}
