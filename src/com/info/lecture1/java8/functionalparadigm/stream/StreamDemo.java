package com.info.lecture1.java8.functionalparadigm.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {


        HashSet<Employee> employeeHashMap = new HashSet<>();

        employeeHashMap.add(new Employee(123, "ravi", 2300.00, 28.0));
        employeeHashMap.add(new Employee(123, "ravi", 2300.00, 28.0));
        employeeHashMap.add(new Employee(123, "ravi", 2300.00, 28.0));

        System.out.println(employeeHashMap);

        String str = "Tesing";

        if (str == "Tesing") {
            System.out.println(str);
        }

        if (str.equals("Tesing")) {
            System.out.println(str + "::" + true);
        }

  /*      List<StreamingDynamic> streamDemos = new ArrayList<>();
        streamDemos.add(new StreamingDynamic(80.0, 7, 400.00, 1000.00, 4000));
        streamDemos.add(new StreamingDynamic(40.0, 3, 400.00, 1000.00, 360));
        streamDemos.add(new StreamingDynamic(60.0, 5, 400.00, 1000.00, 1080));
        streamDemos.add(new StreamingDynamic(50.0, 4, 400.00, 1000.00, 720));

        streamDemos.add(new StreamingDynamic(70.0, 6, 400.00, 1000.00, 2086));
*/

     /*   Collections.sort(streamDemos, new Comparator<StreamingDynamic>() {
            @Override
            public int compare(StreamingDynamic o1, StreamingDynamic o2) {
                return o1.getInternetSpeed() - o2.getInternetSpeed();
            }
        });

        Collections.sort(streamDemos, new Comparator<StreamingDynamic>() {
            @Override
            public int compare(StreamingDynamic o1, StreamingDynamic o2) {
                return o1.getQualityOfVideo() - o2.getQualityOfVideo();
            }
        });
*/
        //  System.out.println(streamDemos);

        String fileName = "/Users/raviteja/Desktop/assignments/Lecture1/src/com/info/lecture1/java8/functionalparadigm/stream/lines.csv";

        //read file into stream, try-with-resources


        List<Employee> employee = new ArrayList<>();

        // try with resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            employee = stream.map(x -> readFromFile(x)).filter(x -> x.getEmpSalary() >= 3000)
                    .filter(x -> x.getEmpAge() > 25).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("After Streams---------" + employee);


    }

    private static Employee readFromFile(String x) {
        String[] vals = x.split(",");

        return new Employee(Integer.valueOf(vals[0]), vals[1], Double.valueOf(vals[2]), Double.valueOf(vals[3]));

    }
}


class Employee {
    int empId;
    String empName;

    Double empSalary;

    Double empAge;

    public Double getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Double empAge) {
        this.empAge = empAge;
    }

    public Employee(int empId, String empName, Double empSalary, Double empAge) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAge = empAge;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", empAge=" + empAge +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId &&
                Objects.equals(empName, employee.empName) &&
                Objects.equals(empSalary, employee.empSalary) &&
                Objects.equals(empAge, employee.empAge);
    }

    @Override
    public int hashCode() {
        Random random = new Random();
        return random.nextInt();
    }
}

class StreamingDynamic {

    Double amountofData;
    Integer internetSpeed;
    Double lengthofVideo;
    Double tempMemoryAvailable;
    Integer qualityOfVideo;

    @Override
    public String toString() {
        return "StreamingDynamic{" +
                "amountofData=" + amountofData +
                ", internetSpeed=" + internetSpeed +
                ", lengthofVideo=" + lengthofVideo +
                ", tempMemoryAvailable=" + tempMemoryAvailable +
                ", qualityOfVideo=" + qualityOfVideo +
                '}';
    }

    public StreamingDynamic(Double amountofData, Integer internetSpeed, Double lengthofVideo, Double tempMemoryAvailable, Integer qualityOfVideo) {
        this.amountofData = amountofData;
        this.internetSpeed = internetSpeed;
        this.lengthofVideo = lengthofVideo;
        this.tempMemoryAvailable = tempMemoryAvailable;
        this.qualityOfVideo = qualityOfVideo;
    }

    public Double getAmountofData() {
        return amountofData;
    }

    public void setAmountofData(Double amountofData) {
        this.amountofData = amountofData;
    }

    public Integer getInternetSpeed() {
        return internetSpeed;
    }

    public void setInternetSpeed(Integer internetSpeed) {
        this.internetSpeed = internetSpeed;
    }

    public Double getLengthofVideo() {
        return lengthofVideo;
    }

    public void setLengthofVideo(Double lengthofVideo) {
        this.lengthofVideo = lengthofVideo;
    }

    public Double getTempMemoryAvailable() {
        return tempMemoryAvailable;
    }

    public void setTempMemoryAvailable(Double tempMemoryAvailable) {
        this.tempMemoryAvailable = tempMemoryAvailable;
    }

    public Integer getQualityOfVideo() {
        return qualityOfVideo;
    }

    public void setQualityOfVideo(Integer qualityOfVideo) {
        this.qualityOfVideo = qualityOfVideo;
    }
}
/*
 *
 Given a number of parenthesis to build, find all possible combinations of the number of parenthesis that are valid.
 Input: n = 3
 Output: ["((()))","(()())","(())()","()(())","()()()"]
 invalid = "(()))("
 */


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */


class Solution {

    static void _printParenthesis(char str[], int pos, int n, int open, int close) {
        if (close == n) {
            // print the possible combinations
            for (int i = 0; i < str.length; i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        } else {
            if (open > close) {
                str[pos] = '}';
                _printParenthesis(str, pos + 1, n, open, close + 1);
            }
            if (open < n) {
                str[pos] = '{';
                _printParenthesis(str, pos + 1, n, open + 1, close);
            }
        }
    }

    // Wrapper over _printParenthesis()
    static void printParenthesis(char str[], int n) {
        if (n > 0)
            _printParenthesis(str, 0, n, 0, 0);
        return;
    }

    // driver program
    public static void main(String[] args) {
        int n = 3;
        char[] str = new char[2 * n];
        printParenthesis(str, n);
    }


}


class Main {
    public static class FileSystem {
        static void delete(Long file) {
            System.out.println("Deleting " + file);
        }
    }

    public static void cleanUp(List<Long> files, int N) {

        Collections.sort(files);

        for (int i = 0; i < files.size(); i++) {

            if (i >= (files.size() - 3)) {
                //  files.remove(i);
                FileSystem.delete(files.get(i));
            }

        }


    }

    public static void main(String[] args) {
        cleanUp(new ArrayList(Arrays.asList(1L, 3L, 5L, 7L, 9L, 2L, 18L, 4L, 100L, 50L, 3L)), 3);
    }
}
// Java program to find n'th
// term in look and say sequence

class GFG {

    static String lookAndSay(int l, int k) {
        if(k == 1) return ""+ l;

        if(k ==  2) return 1+""+l;

        String str = 1 + "" + l;

        for (int i = 3; i <= k; i++) {
            str += '$';
            int len = str.length();

            int cnt = 1;

            String tmp = "";

            char[] arr = str.toCharArray();

            for (int j = 1; j < len; j++) {
                if (arr[j] != arr[j - 1]) {

                    tmp += cnt + 0;


                    tmp += arr[j - 1];

                    cnt = 1;
                } else cnt++;
            }

            str = tmp;
        }

        return str;
    }

    // Driver Code
    public static void main(String[] args) {
        int N = 3;
        System.out.println(lookAndSay(4, 3));
    }
}





