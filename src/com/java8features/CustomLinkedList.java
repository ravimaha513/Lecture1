package com.java8features;


import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CustomLinkedList {

    Node head1, head2, result, cur;
    int carry;

    public CustomLinkedList() {
    }

    void push(int val, int list) {
        Node newnode = new Node(val);
        if (list == 1) {
            newnode.next = head1;
            head1 = newnode;
        } else if (list == 2) {
            newnode.next = head2;
            head2 = newnode;
        } else {
            newnode.next = result;
            result = newnode;
        }

    }
    int getsize(Node head)
    {
        int count = 0;
        while (head != null)
        {
            count++;
            head = head.next;
        }
        return count;
    }


    void addsamesize(Node n, Node m) {
        if (n == null)
            return;

        addsamesize(n.next, m.next);

        int sum = n.data + m.data + carry;
        carry = sum / 10;
        sum = sum % 10;

        push(sum, 3);

    }

    public Node reverse() {
        Node previous = null;
        Node current = head1;
        Node next;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
    }

    void propogatecarry(Node head1) {

        if (head1 != cur)
        {
            propogatecarry(head1.next);
            int sum = carry + head1.data;
            carry = sum / 10;
            sum %= 10;
            push(sum, 3);
        }
    }


    void addlists() {

        if (head1 == null)
        {
            result = head2;
            return;
        }


        if (head2 == null)
        {
            result = head1;
            return;
        }

        int size1 = getsize(head1);
        int size2 = getsize(head2);


        if (size1 == size2)
        {
            addsamesize(head1, head2);
        }
        else
        {

            if (size1 < size2)
            {
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }
            int diff = Math.abs(size1 - size2);


            Node temp = head1;
            while (diff-- >= 0)
            {
                cur = temp;
                temp = temp.next;
            }

            addsamesize(cur, head2);

            propogatecarry(head1);
        }

        if (carry > 0)
            push(carry, 3);
    }


    public void printList(Node head) {

        while(head != null) {
            System.out.println(head.data + " ");
            head = head.next;
        }
    }



}

class Node {

    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class RunnerList{
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.head1 = null;
        list.head2 = null;
        list.result = null;
        list.carry = 0;

        int[] arr1 = {5, 2, 8};
        int[] arr2 = {2, 8, 1};
        for (int j : arr1) {
            list.push(j, 1);
        }

        for (int j : arr2) {
            list.push(j, 2);
        }

        list.addlists();

        list.printList(list.result);

        List<String> words = Arrays.asList("test" , "test");

        Map<String, Long> cardsMap = words
                .stream()
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

        List<String> carPlate = Arrays.asList("ABC123", "DEF123");
       // Map<String, List<String>>
        System.out.println(cardsMap);
    }
}

class A{
    A(int a){

    }
    public static List<Integer> findIntersectionOfArrays(List<Integer> arr1, List<Integer> arr2){

        return arr1.stream().filter(arr2::contains).distinct().collect(Collectors.toList());

    }

}

class Emp{

    public static void main(String args[]){



    }

}

/*
 * Click `Run` to execute the snippet below!
 */


/*

played('blink182', 'song1')
print(getTopSongForBand('blink182')) -> song1

played('blink182', 'song2')
played('blink182', 'song2')
print(getTopSongForBand('blink182')) -> song2

print(getTopSongForBand('dne'))-> not found


 */

class Solution {

    static Map<String, List<BandSong>> freqBandMap = new HashMap<>();

    public static void played(String bandName, String songName) {
        List<BandSong> bandSongList = new ArrayList<>();
        BandSong bandSong;
        if(freqBandMap.containsKey(bandName)){

            bandSongList = freqBandMap.get(bandName);
            bandSong = returnBandSongWithBandName(songName, bandSongList);

            if(bandSong == null){
                bandSong = new BandSong(songName, 1);
            }else{
                int count = bandSong.countSong;
                bandSong.countSong = count +  1;
            }

        }else{
            bandSong = new BandSong(songName, 1);

        }
        bandSongList.add(bandSong);

        freqBandMap.put(bandName, bandSongList);

    }

    public static String getTopSongForBand(String bandName) {

        List<BandSong> maxSongCountWithBand = freqBandMap.getOrDefault(bandName, null);

        if(maxSongCountWithBand == null){
            return "not found";
        }

        return maxSongCountWithBand.stream().max(Comparator.comparing(o -> o.countSong)).get().songName;

    }

    public static BandSong returnBandSongWithBandName( String songName, List<BandSong> bandSongList){

        BandSong bandSong = null;
        boolean available = bandSongList.stream()
                .anyMatch(y -> y.songName.equalsIgnoreCase(songName));
        if(available){
            bandSong = bandSongList.stream().filter(x -> x.songName.equalsIgnoreCase(songName)).findFirst().orElse(bandSong);
        }

        return bandSong;
    }

    public static void main(String[] args) {
        played("jb", "song1");

        System.out.println(getTopSongForBand("jb"));

        played("jb", "song2");
        played("jb", "song2");
        System.out.println(getTopSongForBand("jb"));
        played("jb", "song1");
        played("jb", "song1");
        System.out.println(getTopSongForBand("jb"));
    }
}

class BandSong{
    String songName;
    Integer countSong;

    public BandSong(String songName, Integer countSong) {
        this.songName = songName;
        this.countSong = countSong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BandSong bandSong = (BandSong) o;
        return songName.equals(bandSong.songName) && Objects.equals(countSong, bandSong.countSong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songName);
    }
}

 class Test{


    static int alpha = 1111;
    static
    {
        alpha = alpha-- - --alpha;
    }
    {
        alpha = alpha++ + ++alpha;
    }
    public static void main(String[] args) {

        List<String> listOfString = Arrays.asList("john", "smith", "jack");

        Test test = new Test();
        System.out.println(test.maximumProfit(Arrays.asList(new StockPrices(1), new StockPrices(9), new StockPrices(3), new StockPrices(12)  )));

    }


     public List<StockPrices> maximumProfit(List<StockPrices> stockPrices){

         double minPrice = Double.MAX_VALUE;

         double maxProfit = 0.0;

         StockPrices minStockPriceDay = null;

         StockPrices maxstockPriceDay = null;

         for(StockPrices stock : stockPrices){
             if(stock.stockPrice < minPrice){
                 minPrice = stock.stockPrice;
                 minStockPriceDay = stock;
             }

             else if(stock.stockPrice - minPrice > maxProfit){
                 maxProfit = stock.stockPrice - minPrice;
                 maxstockPriceDay = stock;

             }

         }

         List<StockPrices> result = new ArrayList<>();
         result.add(minStockPriceDay);
         result.add(maxstockPriceDay);

         return result;

     }
 }



class StockPrices {


    int stockPrice;

    public StockPrices(int stockPrice) {
        this.stockPrice = stockPrice;
    }

    @Override
    public String toString() {
        return "StockPrices{" +
                "stockPrice=" + stockPrice +
                '}';
    }
}

class BackTracking{

    public static void main(String[] args) {
        System.out.println(findAllCombinations( 8, 2));
    }
    protected static void backtrack(int remain, LinkedList<Integer> comb, int start, int[] candidates, List<List<Integer>> results) {

        if (remain == 0) {
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
            comb.add(candidates[i]);
            backtrack(remain - candidates[i], comb, i, candidates, results);
            comb.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();

        backtrack(target, comb, 0, arr, results);
        return results;
    }

    public static List<List<Integer>> findAllCombinations(int target, int n){

        int[] arr = IntStream.range(1, n + 1).toArray();
        return combinationSum(arr, target);



    }
}

/*

 A loan has the following data points:

Lender (string)
Preapproved (boolean)
APR (float)
You’re given a list of loans, a desired page size, and need to paginate them with certain constraints:

Each page has at most pageSize items.
A preapproved loan must be the first item on each page if one is available. Preapproved loans cannot show up in any other position other than first. Make new pages if necessary.
A lender appears at most once on each page. Make new pages if necessary.
Without violating the above constraints, return loans sorted in increasing APR since lower is better.
Without violating the above constraints, pages should be maximally compact (return the fewest possible pages).

 */



class Loan implements Comparable<Loan>{
    double apr;
    String lender;
    boolean preApproved;

    public Loan(double apr, String lender, boolean preApproved) {
        this.apr = apr;
        this.lender = lender;
        this.preApproved = preApproved;
    }

    public double getApr() {
        return this.apr;
    }

    public String getLender() {
        return this.lender;
    }

    public boolean getPreApproved() {
        return this.preApproved;
    }

    @Override
    public String toString() {
        return "Loan(" + this.apr + ", " + this.lender + ", " + this.preApproved + ")";
    }


    @Override
    public int compareTo(Loan o) {
        return Double.compare(this.apr, o.apr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return lender.equals(loan.lender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lender);
    }
}

class Solution1 {
    private static List<Loan> loans = Arrays.asList(
            new Loan(0.23, "Wells Fargo", false),
            new Loan(0.24, "Wells Fargo", true),
            new Loan(0.21, "Upstart", false),
            new Loan(0.19, "LendingTree", false),
            new Loan(0.20, "Upstart", true),
            new Loan(0.25, "Wells Fargo", true),
            new Loan(0.28, "Bank of America", true),
            new Loan(0.29, "Wells Fargo", false),
            new Loan(0.31, "Wells Fargo", false)
    );

    private static List<List<Loan>> correctPagingFor3LoansPerPage = Arrays.asList(
            Arrays.asList(
                    new Loan(0.20, "Upstart", true),
                    new Loan(0.19, "LendingTree", false),
                    new Loan(0.23, "Wells Fargo", false)
            ),
            Arrays.asList(
                    new Loan(0.24, "Wells Fargo", true),
                    new Loan(0.21, "Upstart", false)
            ),
            Arrays.asList(
                    new Loan(0.25, "Wells Fargo", true)
            ),
            Arrays.asList(
                    new Loan(0.28, "Bank of America", true),
                    new Loan(0.29, "Wells Fargo", false)
            ),
            Arrays.asList(
                    new Loan(0.31, "Wells Fargo", false)
            )
    );

    // Returns a list of pages of loans, subject to the following constraints:
    // * Each page has at most `pageSize` items.
    // * A preapproved loan must be the first item on each page if one
    //   is available. Preapproved loans cannot show up in any other position other than first. Make new pages if necessary.
    // * A lender appears at most once on each page. Make new pages if necessary.
    // * Without violating the above constraints, return loans sorted in increasing APR since lower is better.
    public static List<List<Loan>> getPages(List<Loan> loans, int pageSize) {
        AtomicInteger counter = new AtomicInteger();
        List<List<Loan>> pages = new ArrayList<>();

        for (Loan loan : loans) {
            if (loan.getPreApproved()) {
                pages.add(setPreApprovedAtFirst(loan));
            }
        }
        System.out.println(pages);

        List<List<Loan>> result = new ArrayList<>();
        System.out.println(result);

        int chunkSize = 3;

        for (Loan number : loans) {
            if (counter.getAndIncrement() % chunkSize == 0) {
                result.add(new ArrayList<>());
            }
            result.get(result.size() - 1).add(number);
        }

        Collection<List<Loan>> result11 = loans.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / chunkSize))
                .values();

        System.out.println(result11);
      //  List<Loan> lenderLoans = loans.stream().filter(loan -> loan.getLender()).collect(Collectors.toList());
        return pages;
    }

    public static List<Loan> setPreApprovedAtFirst(Loan loan){

        List<Loan> loans = new ArrayList<>();
        loans.set(0, loan);
        return loans;
    }



    public static void main(String[] args) {
        for (List<Loan> page : getPages(loans, 3)) {
            for (Loan loan : page) {
                System.out.println(loan.toString());
            }
            System.out.println("");
        }
    }
}

