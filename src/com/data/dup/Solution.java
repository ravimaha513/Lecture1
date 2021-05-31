package com.data.dup;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(printDuplicateCharacters("Better Butter"));

        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0, 30);
        intervals[1] = new Interval(5, 10);
        intervals[2] = new Interval(15, 20);

        System.out.println(findMinMeetingRooms(intervals));

        String [] strings = new String[]{"ab", "abc", "abcd", "abcde", "a"};

        System.out.println(uniqueCharacters(strings));
    }

    /*
        Write a java program to find duplicate characters and their count in a given string.
        For example, in a string “Better Butter”,
        duplicate characters and their count is t : 4, e : 3, r : 2 and B : 2.
     */
    public static String printDuplicateCharacters(String str){


        char[] chars = str.toLowerCase().trim().replaceAll("\\s+","").toCharArray();

        Map<Character, Integer> freq = new HashMap<>();

        for(Character ch : chars){

            int val = freq.getOrDefault(ch, 0);

            freq.put(ch, val + 1);
        }

        return freq.entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .map(x -> x.getKey() + ": " + x.getValue())
                .collect(Collectors.joining("; "));
    }

    /*
        2. Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
         find the minimum number of conference rooms required. Write Java program to print output of # of meeting rooms required.
     */
    public static int findMinMeetingRooms(Interval[] intervals){
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 1;
        queue.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < queue.peek()) {
                count++;
            } else {
                queue.poll();
            }
            queue.offer(intervals[i].end);
        }

        return count;

    }

    //find out the occurrence of unique characters in the above array and print the result in the following format
    public static String uniqueCharacters(String[] strings){
        StringBuilder sb = new StringBuilder();
        Set<Character> treeSet = new TreeSet<>();

        for(String str : strings){

            for (int i = 0; i < str.length(); i++) {
                treeSet.add(str.charAt(i));
            }

        }

        for (Character c : treeSet) {
            sb.append(c);
            sb.append(",");
            sb.append("\n");
        }
        return sb.toString();
    }

}

class Interval{
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-1l, 30l));
    }
    public static String fractionToDecimal(long numerator, long denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}
