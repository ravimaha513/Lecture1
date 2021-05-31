package com.coderpad.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeletefromReverseList {

    public static void main(String[] args) {
        Node node = new Node('a',
                new Node('b',
                        new Node('c',
                                new Node('d', null))));

        removeNthFromEnd(node, 4);

        print(node);

        List<List<Integer>> nums = new ArrayList<>();

        Integer value = Integer.parseInt("123");
    }


    static void print(Node node) {
        while(node != null) {
            System.out.print(node.c + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static Node removeNthFromEnd(Node head, int n) {
        Node h1=head, h2=head;
        while(n-->0) h2=h2.next;
        if(h2==null)return head.next;  // The head need to be removed, do it.
        h2=h2.next;

        while(h2!=null){
            h1=h1.next;
            h2=h2.next;
        }
        h1.next=h1.next.next;   // the one after the h1 need to be removed
        return head;
    }


    static class Node {
        Node next;
        char c;

        Node(){

        }

        Node(char c, Node next) {
            this.next = next;
            this.c = c;
        }
    }

}

class Appointment{

    public static void main(String[] args) {
        System.out.println(largestMultipleOfThree(new int[]{5, 9 , 34, 30, 3}));
        //System.out.println();
    }
    public static String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        List<Integer> remain1Indices = new ArrayList<>(2); // Indices of up to 2 elements with remainder = 1
        List<Integer> remain2Indices = new ArrayList<>(2); // Indices of up to 2 elements with remainder = 2
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] % 3 == 1 && remain1Indices.size() < 2) remain1Indices.add(i);
            else if (digits[i] % 3 == 2 && remain2Indices.size() < 2) remain2Indices.add(i);
        }
        int remainSum = Arrays.stream(digits).sum() % 3;
        if (remainSum == 1) { // Delete 1 smallest digit with remainder = 1 or Delete 2 smallest digits the remainder = 2
            if (remain1Indices.size() >= 1) return getResult(digits, remain1Indices.get(0), -1);
            else return getResult(digits, remain2Indices.get(0), remain2Indices.get(1));
        } else if (remainSum == 2) { // Delete 1 smallest digit with remainder = 2 or Delete 2 smallest digits with remainder = 1
            if (remain2Indices.size() >= 1) return getResult(digits, remain2Indices.get(0), -1);
            else return getResult(digits, remain1Indices.get(0), remain1Indices.get(1));
        }
        return getResult(digits, -1, -1);
    }
    private static String getResult(int[] digits, int ban1, int ban2) {
        StringBuilder sb = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == ban1 || i == ban2) continue; // Skip banned digits
            sb.append(digits[i]);
        }
        if (sb.length() > 0 && sb.charAt(0) == '0') return "0"; // Remove leading 0 case [0,...,0]
        return sb.toString();
    }

}
