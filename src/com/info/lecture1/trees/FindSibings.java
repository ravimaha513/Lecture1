package com.info.lecture1.trees;

import java.util.Arrays;
import java.util.List;

public class FindSibings {

        public static void main(String[] args) {

            System.out.println(Arrays.toString(findSiblings(6, new int[]{1, 2, 3, 4, 5, 6}, 5)));

        }
        public static int[] findSiblings(int input1, int[] input2, int input3) {
            int[] result = new int[] {-1};
            if (input2[0] == input3) {
                return result;
            }

            int siblingFindIndex = -1;
            for(int i=0;i<input2.length;i++){
                if(input2[i]==input3) {
                    siblingFindIndex = i;
                    break;
                }
            }
            if(siblingFindIndex >-1){
                result = new int[]{input2[siblingFindIndex-1],input2[siblingFindIndex+1]};
            }

            Arrays.sort(result);

            List<Integer> list = Arrays.asList(1, 2, 3);
            list.stream()
                    .filter(i -> i%2 == 0)
                    .reduce(0, Integer::sum);
            return result;

        }

    }


