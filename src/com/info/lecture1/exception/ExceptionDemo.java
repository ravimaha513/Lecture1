package com.info.lecture1.exception;

import com.info.lecture1.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExceptionDemo {

    static Map<Integer, Student> studentMap = new HashMap<>();

    static{
        studentMap.put(1, new Student("123","ravi"));
        studentMap.put(2, new Student("123", "ravi"));
        studentMap.put(3, new Student("123", "ravi"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{

            Student s = findStudentById(scanner.next());
            System.out.println("Student Found "+ s);
        }
        catch (Exception e){


            if(e instanceof NoRecordFoundException){
                    System.out.println("No Student Found ");
            }

            if(e instanceof NumberFormatException){
                System.out.println("Its Number Format Excpetion");
            }


        }
        finally {
            scanner.close();
            System.out.println("Scanner closed");
        }


    }

    public static Student findStudentById(String studentId) throws NoRecordFoundException{

        if(studentMap.containsKey(Integer.valueOf(studentId))){
            return studentMap.get(Integer.valueOf(studentId));
        }else{
            throw new NoRecordFoundException("No Student Found with StudentId" + studentId);
        }


    }
}
