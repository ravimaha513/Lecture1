package com.info.lecture1.multithreading;

public class ThreadImpl {

    static SyncImpl sync = new SyncImpl();

    public static void main(String[] args) {
        // System.out.println("Current Thread ::" );
        CustomThread customThread = new CustomThread() ;
        customThread.setName("Thread 1");

        CustomThreadTwo customThreadTwo = new CustomThreadTwo();
        customThread.setName("Thread 2");

        customThread.start();
        customThreadTwo.start();

    }
}
