package com.info.lecture1;

public class DFS {

    public static void main(String[] args) {
        canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5);
    }

    public static boolean canReach(int[] arr, int st) {
        if (st >= 0 && st < arr.length && arr[st] < arr.length) {
            int jump = arr[st];
            System.out.println(arr[st]);
            arr[st] += arr.length;
            return jump == 0 || canReach(arr, st + jump) || canReach(arr, st - jump);
        }
        return false;
    }
}
