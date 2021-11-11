package com.java8features;

public class BalancedString {

    public static void main(String[] args) {

        System.out.println(returnBalancedString("([])"));
    }

    public static boolean returnBalancedString(String str){
        while (str.contains("()") || str.contains("[]") || str.contains("{}")) {
            str = str.replaceAll("\\(\\)", "")
                    .replaceAll("\\[\\]", "")
                    .replaceAll("\\{\\}", "");
        }
        return (str.length() == 0);
    }
}
