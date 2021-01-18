package com.info.lecture1;


import java.util.Objects;
import java.util.UUID;

public class Student{

    private String studentId ;

    private String studentName;

    public Student() {
    }

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    private void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return studentId.equals(student.studentId) &&
                studentName.equals(student.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName);
    }


}
