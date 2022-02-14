package com.coderpad.student.twodimensions;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TwoD {

    public static void main(String[] args) {
        //  System.out.println(Arrays.deepToString());


        String a = "2134";
        String b = new String("2134");

      //  System.out.println(a.equals(b));

        System.out.println(isPalindrome("List"));
        
    }

    public static boolean isPalindrome(String text) {
        // white space removal
        text = text.trim().replaceAll(" ", "").toLowerCase();

        System.out.println(text);
        StringBuilder sbr = new StringBuilder(text);

        return text.equals(sbr.reverse().toString());

    }


}

 class TestClass {
    public final int value = 4;
    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;
            public void run(){
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    } public static void main(String...args) {
        TestClass m = new TestClass();
        m.doIt();
    }}


class t1{

    public static void main(String[] args) {
        SolutionTest solutionTest = new SolutionTest();

        System.out.println(SolutionTest.getPonds(new int[][]{
                {1, 2, 1},
                {1, 0, 1},
                {1, 1, 1},
        }));

      //  System.out.println(isBalanced("(()"));

    }

    public static boolean isBalanced(String str){
        while (str.contains("()") ) {
            str = str.replaceAll("\\(\\)", "");
        }
        return (str.length() == 0);
    }



}

class SolutionTest {
    private int[] p;
    private int[] size;

    public int[] pondSizes(int[][] land) {
        int m = land.length, n = land[0].length;
        p = new int[m * n];
        size = new int[m * n];
        for (int i = 0; i < p.length; ++i) {
            p[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (land[i][j] != 0) {
                    continue;
                }
                int idx = i * n + j;
                if (i < m - 1 && land[i + 1][j] == 0) {
                    union(idx, (i + 1) * n + j);
                }
                if (j < n - 1 && land[i][j + 1] == 0) {
                    union(idx, i * n + j + 1);
                }
                if (i < m - 1 && j < n - 1 && land[i + 1][j + 1] == 0) {
                    union(idx, (i + 1) * n + j + 1);
                }
                if (i < m - 1 && j > 0 && land[i + 1][j - 1] == 0) {
                    union(idx, (i + 1) * n + j - 1);
                }
            }
        }
        Set<Integer> s = new HashSet<>();
        List<Integer> t = new ArrayList<>();
        for (int i = 0; i < m * n; ++i) {
            if (land[i / n][i % n] != 0) {
                continue;
            }
            int root = find(i);
            if (!s.contains(root)) {
                s.add(root);
                t.add(size[root]);
            }
        }
        Collections.sort(t);
        int[] res = new int[t.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = t.get(i);
        }
        return res;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) {
            return;
        }
        size[pb] += size[pa];
        p[pa] = pb;
    }

    public static List<Integer> getPonds(int[][] area) {
        List<Integer> ponds = new ArrayList<>();
        boolean[][] visited = new boolean[area.length][area[0].length];

        for (int row = 0; row < area.length; row++) {
            for (int col = 0; col < area[0].length; col++) {
                if (hasWater(area, row, col) && isNotVisited(visited, row, col)) {
                    ponds.add(computePondArea(area, visited, row, col));
                }
            }
        }
        return ponds;
    }



    private static Integer computePondArea(int[][] area, boolean[][] visited, int row, int col) {
        int size = 1;
        int maxRow = area.length;
        int maxCol = area[0].length;

        visited[row][col] = true;

        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {

                int tempRow = r + row;
                int tempCol = c + col;

                if (isValidCell(tempRow, tempCol, maxRow, maxCol) &&
                        hasWater(area, tempRow, tempCol) &&
                        isNotVisited(visited, tempRow, tempCol)) {

                    size += computePondArea(area, visited, tempRow, tempCol);

                }
            }
        }
        return size;
    }

    public static boolean isValidCell(int row, int col, int maxRow, int maxCol) {
        return ((row >= 0 && row < maxRow) &&
                (col >= 0 && col < maxCol));
    }

    public static boolean hasWater(int[][] area, int row, int col) {
        return area[row][col] == 0;
    }

    public static boolean isNotVisited(boolean[][] visited, int row, int col) {
        return !visited[row][col];
    }

}


class A{
    public static void main(String[] args) {

    }

    public void doSome(){
        System.out.println("A");
    }
}

class B extends A{
    public static void main(String[] args) {
    }

    public void doSome(){
        System.out.println("B");
    }

    public static int degreeOfArray(List<Integer> arr) {
        // Write your code here
        Map<Integer, DegreeIndex> degreeMap = new HashMap<>();

        int maxCountSoFar = 0;
        for(int i = 0; i < arr.size(); i++){
            Integer element = arr.get(i);
            DegreeIndex dIndex = new DegreeIndex();

            if(degreeMap.containsKey(element)){
                dIndex = degreeMap.get(element);
                dIndex.endIndex = i;
                dIndex.count = dIndex.count + 1;

                maxCountSoFar = Math.max(dIndex.count, maxCountSoFar);
            }
            else{

                dIndex.startIndex = i;
                dIndex.count = 1;

            }

            degreeMap.put(element, dIndex);

        }

        AtomicInteger maxFound = new AtomicInteger(maxCountSoFar);

        OptionalInt minimumLength = degreeMap.values().stream()
                .filter(x -> x.count.equals(maxFound.intValue()))
                .mapToInt(x -> x.endIndex - x.startIndex + 1)
                .min();




        if(minimumLength.isPresent()){

        }
        return -1;
    }
}
class DegreeIndex{
    Integer count;
    Integer startIndex;
    Integer endIndex;

    @Override
    public String toString() {
        return "DegreeIndex{" +
                "count=" + count +
                ", startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                '}';
    }
}

/*
 * Click `Run` to execute the snippet below!
 */


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*

next -> first -> add queue -> poll (first)
next -> [second,third] -> queue[second, third] -> poll (second)

if(queue is Empty()) -> poll(third);

else(call mock next()) ->



*/

class Boto3Helper {
    public static int currentDataIndex = 0;
    public static final String[] fakeData = {
            "first\n",
            "second\nthird\n",
            ""
    };
    public static String next() {
        return fakeData[currentDataIndex++];
    }
}

class Solution2 {

    static Queue<String> linesQueue = new LinkedList<>();
    public static String next() {
        // implement your solution here

        if(linesQueue.isEmpty()){
            String mockData = Boto3Helper.next();

            if(mockData.equals("")) {

                return "";

            }
           String[] lines = mockData.split("\\r?\\n");
            addElementsToQueue(lines);



        }
        return linesQueue.poll();
    }

    public static void addElementsToQueue(String[] lines){

        for(String word : lines){

            linesQueue.add(word + "\r\n");
        }

    }

    public static void main(String[] args) {
        // -> the third line -> "third\n"
        while (true) {
            String line = next();
            if (line.length() == 0) break;
            System.out.println(line);
        }
    }

}

class TreeNode {

    public static void main(String[] args) {
        String a1 = "a";
        String a2 = "a";
        String a3 = new String("a");

        System.out.println(a1 == a2); // false
        System.out.println(a1 == a3); // false
        System.out.println(a1.equals(a3)); // true
        System.out.println(calculateAverage(Arrays.asList(5.6, 5.8)));
    }

    public static double calculateAverage(List<Double> x) {
        double sum = 0;
        for (double i: x) {
            sum += i;
        }
        return Math.round(sum / x.size());
    }
    public static String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts.push(1);
            } else {
                int incremented = counts.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    counts.push(incremented);
                }
            }
        }
        return sb.toString();
    }
}

/*

We have various workflows that crunch over large amounts of data, emitting data files at intermediate steps. Given our AWS architecture, we store these in S3.

Observation 1: The files output by these jobs can be very large and therefore impractical to fully download before working with them.
Observation 2: They also usually have a per-line structure that consumers of the data would like to take advantage of.

 */
