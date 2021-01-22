package com.info.lecture1.multithreading;


public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_RED + "Hello from MyRunnable's implementation of run()");
    }
}
