package com.info.lecture1.java8.functionalparadigm;

import java.util.*;



class TestAbstract {

    static final ArrayList<Integer> numbersList = new ArrayList<>();
    public static void main(String[] args) {
    //   int result = possibleTransformations("abba", new String[]{"aadd", "abbb", "dnnd", "lbbl"});

       //aabbcdbb


      /*  result = possibleTransformations("aabbcdbb", new String[]{"aabbcdbbb",
                "aabbcdb",
                "aabbxdbb",
                "aabbbdbb",
                "aacccdcc",
                "ddbbcdbb",
                "eebbcdbb"});*/

       // System.out.println(result);

        numbersList.add(2);

        System.out.println(numbersList);

        String line = "195";

        int result = 0;
        StringBuilder stringBuilder = new StringBuilder(line);
        Integer number = Integer.valueOf(stringBuilder.toString());
        Integer revNum = Integer.valueOf(stringBuilder.reverse().toString());

        Integer sum = Integer.sum(number , revNum);

        int count = 1;


        while(!isPalindrome(sum)){
            number = sum;
            StringBuilder sbr = new StringBuilder(String.valueOf(number));
            revNum = Integer.valueOf(sbr.reverse().toString());

            sum = number + revNum;
            count++;

            result = sum;

        }

        System.out.println(count + " "+ result);
    }



    private static boolean isPalindrome(Integer sum) {
        String str = String.valueOf(sum);
        StringBuilder stringBuilder = new StringBuilder(str);
        Integer number = Integer.valueOf(stringBuilder.toString());
        Integer revNum = Integer.valueOf(stringBuilder.reverse().toString());

        return number.equals(revNum);

    }

    static int possibleTransformations(String initialWord, String[] dictionary) {

        HashMap<Character, Integer> freq = new HashMap<>();

        for(Character ch : initialWord.toCharArray()){

            int val = freq.getOrDefault(ch, 0);

            freq.put(ch, val + 1);
        }


        int counter = 0;

        for(String string : dictionary){

            int diff = 0;
            if(string.length() == initialWord.length()) {
                for(Character ch : string.toCharArray()){

                    int val = freq.getOrDefault(ch, 0);

                    if(val == 0){
                        diff++;
                    }else{
                        diff--;
                    }
                }

                if(diff == 0){
                    counter++;
                }
            }




        }
        return counter;

    }

    public static String stringCompare(String str1, String str2)
    {
        int l1 = str1.length();
        int l2 = str2.length();

        char[] aa = str1.toCharArray();
        char[] bb = str2.toCharArray();


        return null;
    }

    }
public class Java8Demo {


    static String input = "Today is a nice day";
    static String output = "day nice a is Today";

    static Map<Integer, Integer> freqMap = new TreeMap<>();



    public static void main(String[] args) {


        findFrequency(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

/*        List<Integer> numsList = new ArrayList<>();
        numsList.add(2);
        numsList.add(3);
        numsList.add(4);
        numsList.add(5);

        DemoFunctionalInterface sampleInterfaceImpl = (int x) -> System.out.println(Math.pow(x, 2));

        numsList.forEach(x -> sampleInterfaceImpl.square(x));

        */

      /*  String s1 = null;

        String s2 = "";

        Optional<String> optionalS = Optional.ofNullable("Check");


        if(optionalS.isPresent()){
            System.out.println(optionalS.get());
        }else{
            System.out.println("No value");
        }
*/


    }


    public static List<Integer> returnTopNElements(int[] numbers, int k) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (freqMap.containsKey(numbers[i])) {
                int count = freqMap.get(numbers[i]);
                freqMap.put(numbers[i], count + 1);
            } else {
                freqMap.put(numbers[i], 1);
            }
        }

        System.out.println(freqMap);

        freqMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> result.add(x.getKey()));

        return result.subList(k - 1, result.size());

    }

    static void findFrequency(int[][] matrix) {
        int evenFreq = 0;
        int oddFreq = 0;
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] % 2 == 0) {
                    evenFreq++;
                } else {
                    oddFreq++;
                }
            }

        }

        System.out.println(evenFreq + "::" + oddFreq);
    }

    static String reverse(String input) {

        input.split("");
        String output = "";


        char[] chars = input.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {

            String temp = "" + chars[i];

            output += temp;
        }

        System.out.println(output);

        return output;

    }

    public static String divisible(int n){
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <=n; i++){
            if(i % 3 == 0) sb.append("XP");
            else if(i % 5 == 0) sb.append("Lab");
            else sb.append(i);

            if(i != n)  sb.append(", ");

        }

        return sb.toString();
    }

}

class Aucion{
    String id;
    String name;


}


@FunctionalInterface
interface DemoFunctionalInterface{
     void square(int x);
}