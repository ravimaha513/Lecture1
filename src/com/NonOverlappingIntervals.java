package com;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.stream.Stream;

public class NonOverlappingIntervals {

    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        int n = intervals.size();
        List<Double> starts = new ArrayList<>();
        List<Double> ends = new ArrayList<>();
        for(Interval x : intervals) {
            starts.add(x.start);
            ends.add(x.end);
        }

        Collections.sort(starts);
        Collections.sort(ends);
        int i = 0, j = 0, current = 0, result = 0;
        while(i < n) { // since last of ends would be greater than last of starts
            // hence i will reach to end before ends, so no need to check j < n
            if(starts.get(i) < ends.get(j)) {
                current++; // Need new meeting room
                result = Math.max(current, result); // Update result
                i++;
            } else {
                current--; // One meeting room is emptied, so need lesser meeting rooms now
                // No need to update result here because we only want to maximize result
                j++;
            }
        }

        return result;
    }

}

class Interval{

    Double start;
    Double end;


}
class AnagramTest{

    public static void main(String[] args) {
        List<AnagramPair> anagramPairs = createAnagramPairs("1634248407000,abc,1000 1634248408000,cba,10000");
        System.out.println(groupAnagramByDate(anagramPairs));

    }

    public static Map<String, AnagramPair> groupAnagramByDate(List<AnagramPair> anagramPairs){

        Map<String, AnagramPair> anagramPairMap = new HashMap<>();

        for(AnagramPair anagramPair : anagramPairs){
            String epochDate = anagramPair.getEpochDate();
            if(anagramPairMap.containsKey(epochDate)){
                int val = anagramPairMap.get(epochDate).getSeqCount();
                anagramPair.seqCount = val + anagramPair.getSeqCount();
                anagramPairMap.put(epochDate, anagramPair);
            }else{
                anagramPairMap.put(epochDate, anagramPair);
            }

        }
        return anagramPairMap;

    }
    public List<Integer> returnSpecialAndLuckyNums(List<Integer> nums){
        return nums.stream().filter(num -> (num % 3 == 0 || num % 2 == 0)).collect(Collectors.toList());
    }

    public static List<AnagramPair> createAnagramPairs(String input){
        String[] arr = input.split(" ");

        List<AnagramPair> anagramPairs = new ArrayList<>();
        for(String in : arr){
            anagramPairs.add(groupInputByAnagram(in));
        }

        return anagramPairs;
    }

    public static AnagramPair groupInputByAnagram(String input){
        String[] data = input.split(",");
        long timeInMillis = Long.parseLong(data[0]);
        Date currDate = new Date(timeInMillis);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");

        String currDf = sdf.format(currDate);
        char[] dT = data[1].toCharArray();
        Arrays.sort(dT);
        return new AnagramPair(currDf, String.valueOf(dT), Integer.parseInt(data[2]));
    }

}

class AnagramPair{
    String epochDate;
    String seq;
    Integer seqCount;

    public AnagramPair(String epochDate, String seq, Integer seqCount) {

        this.epochDate = epochDate;
        this.seq = seq;
        this.seqCount = seqCount;
    }

    @Override
    public String toString() {
        return "AnagramPair{" +
                "epochDate=" + epochDate +
                ", seq='" + seq + '\'' +
                ", seqCount=" + seqCount +
                '}';
    }

    public String getEpochDate() {
        return epochDate;
    }

    public String getSeq() {
        return seq;
    }

    public Integer getSeqCount() {
        return seqCount;
    }
}


