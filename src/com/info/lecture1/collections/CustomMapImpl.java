package com.info.lecture1.collections;

import com.info.lecture1.Student;

import java.util.*;
import java.util.Map.Entry;


public class CustomMapImpl {

    public static void main(String[] args) {

      /*  Map<Student, String> studentMap = new HashMap<>();

        System.out.println(new Student("123", "MRT"));
        studentMap.put(new Student("123","MRT"), "Value1");
        studentMap.put(new Student("123", "MRT"), "Value2");

        studentMap.put(new Student("123", "MRT1"), "Value2");

        System.out.println(studentMap);*/

        Map<String, UserStats >[] visits = new Map[2];

        Map<String, UserStats> userStatsMap = new HashMap<>();
        userStatsMap.put("null", new UserStats(Optional.of(12L)));
        visits[0] = userStatsMap;


      //  System.out.println(count(visits));

        System.out.println(MaximumPossible(235));


    }

    static Map<Long, Long> count(Map<String, UserStats>... visits) {

        Map<Long, Long> userCountMap = new HashMap<>();

        if(visits.length == 0){
            return Collections.emptyMap();
        }
        for(Map<String, UserStats> userStatsMap : visits){

            if(userStatsMap != null && !userStatsMap.containsKey(null)){
                for (Entry<String, UserStats> entry : userStatsMap.entrySet()) {

                    String userLong = entry.getKey();

                    UserStats userStats = entry.getValue();

                    if (isStringtoLong(userLong) && userStats != null && userStats.getVisitCount().isPresent()) {
                        Long userCount = userStats.getVisitCount().get();
                        if(userCountMap.containsKey(Long.valueOf(userLong))){
                            userCountMap.put(Long.valueOf(userLong), userCount + userCountMap.get(Long.valueOf(userLong))) ;
                        }else{
                            userCountMap.put(Long.valueOf(userLong), userCount);
                        }

                    }
                }
            }
            else{

            }



        }

        return userCountMap;

    }

    static boolean isStringtoLong(String userId){
        try {
            Long value = Long.valueOf(userId);
        }catch(Exception e){
            return false;
        }

        return true;
    }



    static int MaximumPossible(int N) {
        int digit = 5;

        if (N == 0) {
            return digit * 10;
        }

        int neg = N / Math.abs(N);

        N = Math.abs(N);
        int n = N;

        int maxVal = Integer.MIN_VALUE;
        int counter = 0;
        int pos = 1;


        while (n > 0) {
            counter++;
            n = n / 10;
        }


        for (int i = 0; i <= counter; i++) {
            int nVal = ((N / pos) * (pos * 10)) + (digit * pos) + (N % pos);

            if (nVal * neg > maxVal) {
                maxVal = nVal * neg;
            }

            pos = pos * 10;
        }

        return maxVal;
    }


}

class UserStats{

    Optional<Long> visitCount;


    public UserStats(Optional<Long> visitCount) {
        this.visitCount = visitCount;
    }



    public Optional<Long> getVisitCount() {
        return visitCount;
    }
}