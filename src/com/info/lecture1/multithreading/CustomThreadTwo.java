package com.info.lecture1.multithreading;

public class CustomThreadTwo extends Thread {

    @Override
    public void run() {
        System.out.println("Current Thread ::" + currentThread().getName());

    }
}
