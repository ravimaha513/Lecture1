package com.coderpad.student.averageBest;

import com.info.lecture1.Student;

import java.util.*;
import java.util.stream.Collectors;

public class BestAverage {

   /* public static void main(String[] args) {
        String[][] tc1 = { { "Bobby", "87" },
                { "Charles", "100" },
                { "Eric", "64" },
                { "Charles", "22" } };
        System.out.println(bestAverageGrade(tc1));
    }*/

    public static void main(String[] args) {
        PriorityQueue<Integer> queue
                = new PriorityQueue<>();
        queue.add(11);
        queue.add(10);
        queue.add(22);
        queue.add(5);
        queue.add(12);
        queue.add(2);

        while (queue.isEmpty() == false)
            System.out.printf("%d ", queue.remove());

        System.out.println("\n");
    }
    
    public static Integer bestAverageGrade(String[][] scores)
    {
        // TODO: implement this function

        Map<String, List< Integer>> scoresMap = new HashMap<>();

        for(String[] strings : scores){

            String name = strings[0];
            Integer score = Integer.parseInt(strings[1]);

            if(scoresMap.containsKey(name)){

                List<Integer> scoresList = scoresMap.get(name);
                scoresList.add(score);
                scoresMap.put(name, scoresList);
            }else{
                List<Integer> scoresList = new ArrayList<>();
                scoresList.add(score);
                scoresMap.put(name, scoresList);

            }

        }

        Integer maAvgScore = Integer.MIN_VALUE;

        for(Map.Entry<String , List<Integer>> entrySet : scoresMap.entrySet())    {
            List<Integer> scoresList = entrySet.getValue();

            double localAvg = scoresList.stream().mapToInt(i -> i).average().getAsDouble();

            maAvgScore = Math.max((int) localAvg, maAvgScore);

        }


        return maAvgScore;

    }

    private static StudentScores mapStringToStudentScore(String[] x) {
        return new StudentScores(x[0], Integer.valueOf(x[1]));
    }
}
class StudentScores{
    String name;
    Integer score;

    public StudentScores(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

class EfficientShipping{

    private static long maxvalue=Long.MIN_VALUE;

    public static void main(String[] args) {
        long[] boxes = new long[]{2, 2, 3};
        long[] unitsPerBox = new long[]{ 2, 5, 1};
        long truckSize = 3;

        System.out.println(getMaxUnitsClass(boxes, unitsPerBox, truckSize));

        System.out.println(isPalindrome("ABAA"));

    }

    public static boolean isPalindrome(String str){

        StringBuilder sbr = new StringBuilder();
        sbr.append(str);
        return sbr.reverse().toString().equals(str);

    }

    public static long getMaxUnitsClass(long[] boxes, long[] unitsPerBox, long truckSize) {
        List<BoxItems> boxItemsList = new ArrayList<>();
        for(int i = 0; i < boxes.length; i++){
            BoxItems boxItem = new BoxItems(boxes[i], unitsPerBox[i]);
            boxItemsList.add(boxItem);
        }

        Collections.sort(boxItemsList);

        long pick = 0;

        for(BoxItems item : boxItemsList){
            Long unit = item.unitsPerBox;
            if(pick == truckSize){
                break;
            }else{
                if(unit + pick > truckSize){
                    pick = item.unitsPerBox;
                }
                pick +=  unit;

            }

        }
        System.out.println(boxItemsList);
        return pick;


    }
}

class BoxItems implements Comparable<BoxItems>{
    long box;
    long unitsPerBox;

    public BoxItems(long box, long unitsPerBox) {
        this.box = box;
        this.unitsPerBox = unitsPerBox;
    }


    @Override
    public int compareTo(BoxItems o) {
        return Long.valueOf(o.unitsPerBox ).compareTo(this.unitsPerBox);
    }

    @Override
    public String toString() {
        return "BoxItems{" +
                "box=" + box +
                ", unitsPerBox=" + unitsPerBox +
                '}';
    }
}