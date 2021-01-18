package com.info.lecture1.interfaces.Impl;

import com.info.lecture1.Student;
import com.info.lecture1.interfaces.IStudentRepository;

public class CassandraRepository implements IStudentRepository {
    @Override
    public String createStudent(Student student) {
        return "In Cassandra";
    }
}
