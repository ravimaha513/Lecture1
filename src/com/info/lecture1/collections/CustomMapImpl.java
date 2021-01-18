package com.info.lecture1.collections;

import com.info.lecture1.Student;

import java.util.*;
import java.util.stream.Collectors;

public class CustomMapImpl {

    public static void main(String[] args) {

        Map<Student, String> studentMap = new HashMap<>();

        System.out.println(new Student("123", "MRT"));
        studentMap.put(new Student("123","MRT"), "Value1");
        studentMap.put(new Student("123", "MRT"), "Value2");

        studentMap.put(new Student("123", "MRT1"), "Value2");

        System.out.println(studentMap);

    }
}
