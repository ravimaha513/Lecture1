package com.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Employee{
    String name;
    long id;
}
public class Solution {

    static final List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2, 3, 4));

    static List<Employee> empList = new ArrayList<>();
    public static void main(String[] args) {

    }

    static double[][] increaseSharpness(int[][] img) {
        System.out.println("---------");
        double[][] computedAverage = new double[img.length][img.length];
        int rows = img.length;
        int columns = img.length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                computedAverage[i][j] = computeAverage(img, i, j);
            }
        }

        return computedAverage;
    }

    static float computeAverage(int[][] arr, int row, int col){

        System.out.println("-------------------------------------");
        System.out.println(arr[row - 1][col - 1] );
        System.out.println(arr[row - 1][col]);
        System.out.println(arr[row - 1][col + 1]);
        System.out.println(arr[row][col - 1]);
        System.out.println(arr[row][col + 1]);
        System.out.println(arr[row + 1][col - 1]);
        System.out.println(arr[row + 1][col]);
        System.out.println(arr[row + 1][col + 1]);


        float sum = arr[row - 1][col - 1] + arr[row - 1][col] +
                arr[row - 1][col + 1] + arr[row][col - 1] +
                arr[row][col + 1] + arr[row + 1][col - 1] +
                arr[row + 1][col] + arr[row + 1][col + 1];
        return (float) sum/8;
    }

    public static void method(final List myList) {
        myList.clear();
    }


    static String readingVertically(String[] arr) {

        // find maximum length of the word
        int maximum = Arrays.stream(arr).max(Comparator.comparing(String::length)).get().length();

        StringBuilder sbr = new StringBuilder();

        int i = 0;

        while(i < maximum){
            StringBuilder sb = new StringBuilder();
            for(String word : arr){
                sb.append((i < word.length()) ? word.charAt(i) : ' ');
            }

            while(sb.length() > 0){
                if(sb.charAt(sb.length() - 1) == ' '){
                    sb.deleteCharAt(sb.length() - 1);
                }
                else{
                    break;
                }
            }

            System.out.println(sb.toString());
            sbr.append(sb.toString());
            i++;
        }
        return sbr.toString().replaceAll(" ", "");

    }

}

class LinkedList{

    // head of linked list
    Node head = null;
    class Node
    {

        // value in the node
        int val;
        Node next;
        Node(int v)
        {

            // default value of the next
            // pointer field
            val = v;
            next = null;
        }
    }

    // Function to insert data nodes into
// the Linked List at the front
    public void insert(int data)
    {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    // Function to remove all occurrences
// of duplicate elements
    public void removeAllDuplicates()
    {
        Node current = head, index = null, temp = null;

        if(head == null) {
            return;
        }
        else {
            while(current != null){

                temp = current;

                index = current.next;

                while(index != null) {

                    if(current.val == index.val) {

                        temp.next = index.next;
                    }
                    else {

                        temp = index;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    // Function to print the list elements
    public void printList()
    {
        Node trav = head;
        if (head == null)
            System.out.print(" List is empty" );

        while (trav != null)
        {
            System.out.print(trav.val + " ");
            trav = trav.next;
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();
        ll.insert(53);
        ll.insert(53);
        ll.insert(49);
        ll.insert(49);
        ll.insert(35);
        ll.insert(28);
        ll.insert(28);
        ll.insert(23);

        System.out.println("Before removal of duplicates");
        ll.printList();

        ll.removeAllDuplicates();

        System.out.println("\nAfter removal of duplicates");
        ll.printList();
    }
}


/**
 *
 *
 */
class Luhn {

    /**
     * @param args
     */
    public static void main(String[] args) {

        isValidLuhn("23498523");
        System.out.println("Whether 23498523 is valid luhn number -- >>>"+isValidLuhn("23498523"));

        String obtainednum = generateCheckDigit("23498523");
        System.out.println("Obtained luhn number is"+obtainednum);

        String startRange = "23498523";
        String endRange = "23498600";
        int i =countRange(startRange, endRange);
        System.out.println("Number of luhn numbers"+i);

    }

    /**
     * Accepts a card number and determines if the card number is a valid number with
     respect to the
     * Luhn algorithm.
     * @param cardNumber the card number
     * @return true if the card number is valid according to the Luhn algorithm, false
    if not
     */
    public static boolean isValidLuhn(String cardNumber) {
        int numberOfDigits = cardNumber.length();

        int luhnSum = 0;
        boolean alternateSecondDigit = false;
        for (int i = numberOfDigits - 1; i >= 0; i--)
        {

            int posNum = cardNumber.charAt(i) - '0';

            if (alternateSecondDigit == true)
                posNum = posNum * 2;

            // Summing values after multiplying by 2 as per luhn algorithm
            // for cases of double digit number

            luhnSum += posNum / 10;
            luhnSum += posNum % 10;

            alternateSecondDigit = !alternateSecondDigit;
        }
        return (luhnSum % 10 == 0);
    }
    /**
     * Accepts a partial card number (excluding the last digit) and generates the
     appropriate Luhn
     * check digit for the number.
     * @param cardNumber the card number (not including a check digit)
     * @return the check digit
     */
    public static String generateCheckDigit(String cardNumber) {
        int cardNum = Integer.parseInt(cardNumber);
        String resultCardNum = "";

        for(int i = 0; i < 10; i ++) {
            int tempCardNum = cardNum * 10 + i;
            if(isValidLuhn(tempCardNum+"")) {
                resultCardNum = tempCardNum+"";
                break;
            }
        }
        return resultCardNum;
    }

    /**
     * Accepts two card numbers representing the starting and ending numbers of a
     range of card numbers
     * and counts the number of valid Luhn card numbers that exist in the range,
     inclusive.
     * @param startRange the starting card number of the range
     * @param endRange the ending card number of the range
     * @return the number of valid Luhn card numbers in the range, inclusive
     */
    public static int countRange(String startRange, String endRange) {
        int validCount = 0;
        int lastNumber = Integer.parseInt(endRange);
        int initialNumber = Integer.parseInt(startRange);

        for (int i = initialNumber; i <= lastNumber; i++)
        {
            if (isValidLuhn(i+"")) {
                validCount ++;
            }
        }
        return validCount;
    }




}

