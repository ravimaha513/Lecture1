package com.info.lecture1.multithreading.locking;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    static ReentrantLock entrantLock = new ReentrantLock();

    public static void main(String[] args) {

        Set<Integer> integerSet = new HashSet<>();
        String[] stringCopy = new String[]{""};


        ExecutorService executor = Executors.newFixedThreadPool(2);

        ReentrantLock lock = new ReentrantLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println();
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };


        Future<String> future = executor.submit(callableTask);

        try {
            String result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }


        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        try{
            String r = executor.invokeAny(callableTasks);
           List<Future<String>> futures = executor.invokeAll(callableTasks);

           for(Future<String> stringFuture : futures){
               System.out.println(stringFuture.get());
           }
        }catch (Exception e){
            e.printStackTrace();
        }

        executor.submit(() -> {
            System.out.println("Locked: " + lock.isLocked());
            System.out.println("Held by me: " + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired: " + locked);
        });

        executor.shutdownNow();

    }


}


class AverageTime {
    String entryStation;
    String exitStation;
    int difference;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AverageTime that = (AverageTime) o;
        return entryStation.equals(that.entryStation) &&
                exitStation.equals(that.exitStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entryStation, exitStation);
    }

    public String getEntryStation() {
        return entryStation;
    }

    public void setEntryStation(String entryStation) {
        this.entryStation = entryStation;
    }

    public String getExitStation() {
        return exitStation;
    }

    public void setExitStation(String exitStation) {
        this.exitStation = exitStation;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }
}

class Record {
    int cardId;
    String entryStation;
    String exitStation;

    int entryTime;
    int exitTime;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getEntryStation() {
        return entryStation;
    }

    public void setEntryStation(String entryStation) {
        this.entryStation = entryStation;
    }

    public String getExitStation() {
        return exitStation;
    }

    public void setExitStation(String exitStation) {
        this.exitStation = exitStation;
    }

    public int getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(int entryTime) {
        this.entryTime = entryTime;
    }

    public int getExitTime() {
        return exitTime;
    }

    public void setExitTime(int exitTime) {
        this.exitTime = exitTime;
    }
}