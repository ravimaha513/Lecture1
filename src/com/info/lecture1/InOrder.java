package com.info.lecture1;

import java.util.HashMap;

public class InOrder {
    static int preIndex = 0;

    void printPost(int[] in, int[] pre, int inStrt,
                   int inEnd, HashMap<Integer, Integer> hm) {
        if (inStrt > inEnd)
            return;

        // Find index of next item in preorder traversal in
        // inorder.
        int inIndex = hm.get(pre[preIndex++]);

        // traverse left tree
        printPost(in, pre, inStrt, inIndex - 1, hm);

        // traverse right tree
        printPost(in, pre, inIndex + 1, inEnd, hm);

        // print root node at the end of traversal
        System.out.print(in[inIndex] + " ");
    }

    void printPostMain(int[] in, int[] pre) {
        int n = pre.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++)
            hm.put(in[i], i);

        printPost(in, pre, 0, n - 1, hm);
    }

    // Driver code
    public static void main(String ars[]) {
        // A B C D E F G
        // 1 ,2, 3, 4, 5 , 6
        int in[] = {3, 4, 5, 6, 2, 3, 1};

        //
        int pre[] = {1, 2, 4, 5, 3, 6};
        InOrder tree = new InOrder();
        tree.printPostMain(in, pre);
    }
}
