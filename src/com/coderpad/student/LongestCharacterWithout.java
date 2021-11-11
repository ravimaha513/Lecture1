package com.coderpad.student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LongestCharacterWithout {

        public static void main(String[] args) {
            // Longest Substring without repeating characters
            // input :
            // output :

        /*
        Given a string s, find the length of the longest substring without repeating characters.

            Example 1:
            Input: s = "abcabcbb"
            Output: 3
            Explanation: The answer is "abc", with the length of 3.
            Example 2:
            Input: s = "bbbbb"
            Output: 1
            Explanation: The answer is "b", with the length of 1.
            Example 3:
            Input: s = "pwwkew"
            Output: 3
            Explanation: The answer is "wke", with the length of 3.
            Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
            Example 4:
            Input: s = ""
            Output: 0
         */

            System.out.println(longestSubStringWithoutRepeatChars("abcabcbb"));

            System.out.println(longestSubStringWithoutRepeatChars("bbbbb"));

            System.out.println(longestSubStringWithoutRepeatChars("pwwkew"));
            System.out.println(longestSubStringWithoutRepeatChars(""));

            List<String> nums = new ArrayList<>();
            nums.stream().map(String::toLowerCase).collect(Collectors.toList());



        }

        public static int longestSubStringWithoutRepeatChars(String s){

            // abcabcbb

            // a
            // ab
            // abc

            int[] chars  = new int[128];

            int left = 0;
            int right  = 0;

            int res = 0;

            while(right < s.length()){
                char r = s.charAt(right);
                chars[r]++;

                while(chars[r] > 1){
                    char l = s.charAt(left);
                    chars[l]--;
                    left++;
                }

                res = Math.max(res, right - left + 1);

                right++;
            }

            return res;



        }



}

final class MyClass{
    Age age;
    
}

class Age{

}