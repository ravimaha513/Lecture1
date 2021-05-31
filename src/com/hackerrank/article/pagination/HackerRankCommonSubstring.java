package com.hackerrank.article.pagination;

import java.util.Arrays;
import java.util.List;

public class HackerRankCommonSubstring {

    public static void main(String[] args) {

        commonSubstring(Arrays.asList("hello", "hi"), Arrays.asList("world", "bye"));
    }

    public static void commonSubstring(List<String> a, List<String> b) {
        // Write your code here
       if(a.size() == b.size()){
           for(int i = 0; i < a.size(); i++){
               if(twoStrings(a.get(i), b.get(i))){
                   System.out.println("YES");
               }else{
                   System.out.println("NO");
               }
           }
       }
    }

    static boolean twoStrings(String s1, String s2)
    {
        boolean v[]=new boolean[26];
        Arrays.fill(v,false);

        for (int i = 0; i < s1.length(); i++)
            v[s1.charAt(i) - 'a'] = true;

        for (int i = 0; i < s2.length(); i++)
            if (v[s2.charAt(i) - 'a'])
                return true;

        return false;
    }
}
