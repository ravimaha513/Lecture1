package com.coderpad.student;/* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */

import java.io.*;
import java.util.*;

/*
 **  Instructions:
 **
 **  Given a list of student test scores, find the best average grade.
 **  Each student may have more than one test score in the list.
 **
 **  Complete the bestAverageGrade function in the editor below.
 **  It has one parameter, scores, which is an array of student test scores.
 **  Each element in the array is a two-element array of the form [student name, test score]
 **  e.g. [ "Bobby", "87" ].
 **  Test scores may be positive or negative integers.
 **
 **  If you end up with an average grade that is not an integer, you should
 **  use a floor function to return the largest integer less than or equal to the average.
 **  Return 0 for an empty input.
 **
 **  Example:
 **
 **  Input:
 **  [ [ "Bobby", "87" ],
 **    [ "Charles", "100" ],
 **    [ "Eric", "64" ],
 **    [ "Charles", "22" ] ].
 **
 **  Expected output: 87
 **  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
 **  respectively. 87 is the highest.
 */

class Student{

    String stuName;

    Integer stuScore;

    public Student(String stuName, Integer stuScore){

        this.stuName = stuName;
        this.stuScore = stuScore;

    }



    //override equals and hascode method

}

class Solution
{
    /*
     **  Find the best average grade.
     */
    public static Integer bestAverageGrade(String[][] scores)
    {
        // TODO: implement this function

        Map<String, List<Integer>> studentMap = new HashMap<>();

        for(String[] score : scores){

            Student student = mapStringToStudent(score);

            if(studentMap.containsKey(student.stuName)){

                List<Integer> innerScore = studentMap.get(student.stuName);

                innerScore.add(student.stuScore);


            }

            else{
                List<Integer> innerscores = new ArrayList<>();
                innerscores.add(student.stuScore);
                studentMap.put(student.stuName, innerscores);


            }

        }

        Student stu = findStudentWithMaxAverage(studentMap);





        return stu.stuScore;
    }

    public static Student findStudentWithMaxAverage(Map<String, List<Integer>> studentMap){

        Double maxResult = Double.MIN_VALUE;

        Iterator<Map.Entry<String, List<Integer>>> iterator = studentMap.entrySet().iterator();

        Student student = null;

        while(iterator.hasNext()){

            Map.Entry<String, List<Integer>> entry = iterator.next();

            List<Integer> scoresList = entry.getValue();

            Double average = scoresList.stream().mapToDouble(num -> num).average().getAsDouble();

            maxResult = Double.max(average, maxResult);

            student = new Student(entry.getKey(), (int) Math.round(maxResult));

        }


        return student;

    }

    public static Student mapStringToStudent(String[] student){

        return new Student(student[0], Integer.parseInt(student[1]));

    }


    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass()
    {
        // TODO: implement more test cases
        String[][] tc1 = { { "Bobby", "87" },
                { "Charles", "100" },
                { "Eric", "64" },
                { "Charles", "22" } };

        return bestAverageGrade(tc1) == 87;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args)
    {
        // Run the tests
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}
