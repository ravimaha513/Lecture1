package com.info.lecture1;

import com.info.lecture1.interfaces.IInitialization;
import com.info.lecture1.interfaces.IStudentRepository;
import com.info.lecture1.interfaces.Impl.CassandraRepository;
import com.info.lecture1.interfaces.Impl.InitializationImpl;
import com.info.lecture1.interfaces.Impl.OracleRepository;

import java.util.HashMap;
import java.util.Map;

public class TestStudentInfo {
    public static void main(String[] args) {


        IInitialization initialization = new InitializationImpl();

        IStudentRepository iStudentRepository = initialization.init("oracle");

     //   System.out.println(iStudentRepository.createStudent(new Student("MRT")));

      //  System.out.println(iStudentRepository.createStudent(new Student("")));

        Map<Student, Integer> studentIntegerMap = new HashMap<>();


    }

}
