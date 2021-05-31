package com.set.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Pagination {

    private static long SumOfNumbers(String str) {
        int digit = 0, number = 0;
        long sum = 0;

        for (int i = 0; i < str.length(); i++) {

            digit = Integer.valueOf(str.charAt(i)) - '0';

            // Check if the character is a integer
            // add the digits till a non-integer is encountered
            if (digit >= 0 && digit <= 9) {
                number = number * 10 + digit;
            } else {
                sum += number;
                number = 0;
            }
        }
        sum += number;
        return sum;
    }


    static void reverse(String str){

        int len = str.length();

        String temp = "";

        for(int i = len-1; i >=0; i--){
            temp += str.charAt(i);
        }

        System.out.println(temp);

    }

    public static void main(String[] args) {
        reverse("inside");

        System.out.println(SumOfNumbers("1a2b3c"));
    }

    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
        // Write your code here

        List<Page> pages = items.stream().map(x -> mapToItem(x)).collect(Collectors.toList());

        if(sortParameter == 0){

           Collections.sort(pages, Comparator.comparing(o -> o.item));

        }
        if(sortParameter == 1){
            Collections.sort(pages, Comparator.comparing(o -> o.itemNum));
        }
        if(sortParameter == 2){
            Collections.sort(pages, Comparator.comparing(o -> o.itemPrice));
        }

        if(sortOrder == 1){
            Collections.reverse(pages);
        }

        String result ;

        List<List<String>> pageNames = new ArrayList<>();
        List<String> sub = new ArrayList<>();
        int curr = 0;
        for (Page page : pages){

           String temp_item = page.item;
           if(itemsPerPage > curr){
               sub = new ArrayList<>();
               sub.add(temp_item);
           }
           pageNames.add(sub);
        }


        return pages.stream().map( x  -> x.item).collect(Collectors.toList());
    }


    private static Page mapToItem(List<String> x) {

        Page page = new Page();
        page.item = x.get(0);
        page.itemNum = Integer.parseInt(x.get(1));
        page.itemPrice = Integer.parseInt(x.get(2));

        return page;
    }
}

class Page{
    String item;
    int itemNum;
    int itemPrice;


}

class SomeClass {
    List<String> someField;

    public static void main(String[] args) {
        List<SomeClass> objs =  new ArrayList<>();
        /* [1,2,3]
        [123,123,123]
        [4,5,6]


        Each object contains:


        Transform it to:[1,2,3,123,123,123,4,5,6]

        */



    }
}


