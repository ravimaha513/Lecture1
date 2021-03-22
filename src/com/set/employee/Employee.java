package com.set.employee;

abstract class Employee{

    abstract void setSalary(int salary);

    abstract int getSalary();

    abstract void setGrade(String grade);

    abstract String getGrade();

    void label(){
        System.out.println("Employee's data:\n");
    }
}

class Engineer extends Employee{

    private int salary;

    private String grade;


    @Override
    void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    int getSalary() {
        return 0;
    }

    @Override
    void setGrade(String grade) {

    }

    @Override
    String getGrade() {
        return null;
    }
}