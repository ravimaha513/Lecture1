package com.coderpad.student.twodimensions;

import java.time.ZonedDateTime;
import java.util.*;

public class TwoDimensionPath {

    

    public static void main(String[] args) {

        System.out.println(optimalPath(new Integer[][]{
                {0,0,0,0,5},
                {0,1,1,1,0},
                {2,0,0,0,0}}));

    // 2,0 -> 1, 0 -> 1, 1 -> 1,2 -> 1,3 -> 1,4 -> 0,4
    }

    public static Integer optimalPath(Integer[][] grid)
    {
        // Todo: Implement optimalPath
        int rowLen = grid.length;
        int colLen = grid[0].length;

        int start = grid[rowLen - 1][ 0];
        int end = grid[0][ colLen - 1];

        int sum = 0;

        int rowStart = rowLen - 1;
        int colStart = 0;

        sum = sum + start + end;
        while( rowStart >=0 && colStart < colLen ){
            if((rowStart - 1) >= 0 ){

                if(colStart + 1 <= colLen){
                    int element = Math.max(grid[rowStart - 1][colStart ], grid[rowStart][colStart + 1]);
                    if(grid[rowStart - 1][ colStart] >=  grid[rowStart ][colStart + 1]){
                        rowStart--;
                    }else{
                        colStart++;
                    }
                    sum += element;
                }


            }else{
                colStart++;
            }


        }
       /* for(int row  = rowLen - 1; row >= 0; row--){

            if(row <= rowLen){

                for(int col = 0; col < grid[row].length; col++){

                    if(col <= colLen){
                        if(grid[row][col] != end){

                            int element = Math.max(grid[row - 1][col ], grid[row][col + 1]);
                            sum += element;
                        }else{
                            break;
                        }
                    }
                }
            }
        }*/

      //  return sum;

        return sum;
    }
}

//    /a/./b/../../c/  -> /c

class Solutio{

    public static void main(String[] args){

        System.out.println(canonicalPath("/home/"));

        System.out.println(canonicalPath("/../"));

        System.out.println(canonicalPath("/home//foo/"));

        System.out.println(canonicalPath("/a/./b/../../c/"));
    }

    public static String canonicalPath(String path){
        Stack<String> stack = new Stack<>();

        String[] arr = path.split("/");

        for(String root : arr){

            if(root.equals(".") || root.isEmpty()){
                continue;
            }

            else if(root.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }

            }

            else{

                stack.add(root);
            }
        }

        StringBuilder sbr = new StringBuilder();
        for(String dir : stack){

            sbr.append("/");
            sbr.append(dir);
        }

        return sbr.toString();
    }


}

class AccountTransaction{
    String txAcctFrom;
    String txAcctTo;
    ZonedDateTime txDate;
    String txCurrency;
    Double txAmt;
    ZonedDateTime txTimestamp;

    static Set<AccountTransaction> accountTransactionSet = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(txCurrency, that.txCurrency) && Objects.equals(txAcctFrom, that.txAcctFrom) && Objects.equals(txAcctTo, that.txAcctTo) && Objects.equals(txAmt, that.txAmt) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(txAcctFrom, txAcctTo, txAmt, txCurrency);
    }

    public AccountTransaction(String txAcctFrom, String txAcctTo,ZonedDateTime txDate, Double txAmt, ZonedDateTime txTimestamp) {
        this.txAcctFrom = txAcctFrom;
        this.txAcctTo = txAcctTo;
        this.txDate = txDate;
        this.txAmt = txAmt;
        this.txTimestamp = txTimestamp;
    }

    public static boolean transfer(String txAcctFrom, String txAcctTo, ZonedDateTime date, Double amt, String crrncy, ZonedDateTime tmstmp){
        AccountTransaction accountTransaction = new AccountTransaction(txAcctFrom, txAcctTo, date, amt, tmstmp);
        if(accountTransactionSet.contains(accountTransaction)){
            accountTransaction.setTxTimestamp(tmstmp);
            accountTransactionSet.add(accountTransaction);
        }
        return false;
    }

    //@Scheduler
    public static void removeElementsIn30secs(){

    }

    public ZonedDateTime getTxTimestamp() {
        return txTimestamp;
    }

    public void setTxTimestamp(ZonedDateTime txTimestamp) {
        this.txTimestamp = txTimestamp;
    }

    public static void main(String[] args) {

       boolean txSuccess = transfer("acct1", "acct2", ZonedDateTime.now(), 1000.00, "USD", ZonedDateTime.now());
    }
}
