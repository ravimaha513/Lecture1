package com.chase.question;


import java.util.*;

enum AccountType {
    CREDIT_CARD,
    CHECKING,
    SAVINGS
}

class Account {

    private double balance;
    private String name;
    private AccountType accountType;
    private long openedDate;

    public Account(double balance, String name, AccountType accountType, long openedDate) {
        this.balance = balance;
        this.name = name;
        this.accountType = accountType;
        this.openedDate = openedDate;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getName() {
        return this.name;
    }

    public AccountType getAccountType() {
        return this.accountType;
    }

    public long getOpenedDate() {
        return this.openedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return openedDate == account.openedDate && Objects.equals(name, account.name) && accountType == account.accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, accountType, openedDate);
    }

    /* Modifications or additional methods can be implemented by the interviewee as a part of their solution */

}
enum AcctOperation{
    Added,
    Removed
}
class ApiResponse{
    public double balance;
    public String name;
    public AcctOperation operationType;

    @Override
    public String toString() {
        return "" +
                "balance=" + balance +
                ", name='" + name + '\'' +
                ", operationType=" + operationType +
                '}';
    }
}
class Solution {
    public static void main(String[] args) {
        // Data
        List<Account> previousAccounts = Arrays.asList(
                new Account(2000.00, "Chase Freedom", AccountType.CREDIT_CARD, 1111680799),
                new Account(100.00, "Citibank", AccountType.CREDIT_CARD, 1000680799)
        );

        List<Account> currentAccounts = Arrays.asList(
                new Account(1000.00, "Chase Freedom", AccountType.CREDIT_CARD, 1111680799),
                new Account(500.00, "American Express", AccountType.CREDIT_CARD, 1222680799)
        );

        System.out.println(printChangesOfAccts(previousAccounts, currentAccounts));

    }

    public static List<ApiResponse> printChangesOfAccts(List<Account> prevAccts, List<Account> currAccts) {
        Map<Account, Double> acctsMap = new HashMap<>();
        Set<Account> removedAccts = new HashSet<>();

        List<ApiResponse> responseList = new ArrayList<>();

        for (Account acct : prevAccts) {
            acctsMap.put(acct, acct.getBalance());
        }

        for (Account acct : currAccts) {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.name = acct.getName();
            if (acctsMap.containsKey(acct)) {
                double currBalance = acctsMap.get(acct);
                apiResponse.balance = acct.getBalance() - currBalance;
            } else {
                  apiResponse.operationType = AcctOperation.Added;

            }
            responseList.add(apiResponse);

            removedAccts.add(acct);
        }

        for (Account acct : prevAccts) {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.name = acct.getName();
            if (!removedAccts.contains(acct)) {
                 apiResponse.operationType = AcctOperation.Removed;
                responseList.add(apiResponse);
            }


        }

        return responseList;

    }
}


/* Name of the class has to be "Main" only if the class is public. */
class HelloWorld
{
    public static void main (String[] args)
    {

        long n0 = 2123;
        Long n1 = 2134L;
        Long n2 = new Long("");


    }

    //
    public static boolean isAnagramOfEachOther(String input, String text){

        char[] inChar = input.toCharArray();
        char[] teChar = text.toCharArray();

        Arrays.sort(inChar);
        Arrays.sort(teChar);

        return String.valueOf(inChar).equals(String.valueOf(teChar));
    }

    public static String[] getAnagrams(String input, List<String> words) {
        //Preparing dictionary
        // O(N) + O(MLogM) - N - size of list
        // a -> t, e -> ate
        // a -> e, t -> aet
        // ate, tea, put, pit, tip, word

        // ate -> aet -> ate,

        // tea -> aet -> ate, tea
        Map<String, Set<String>> dictionary = prepareDictionary(words);

        //Work with "input"  - O(PLogP) -> input length
        char[] inWd = input.toCharArray();
        Arrays.sort(inWd);
        String key = String.valueOf(inWd);
        if(dictionary.containsKey(key)){
            Set<String> set = dictionary.get(key);
            return set.stream().toArray(String[]::new);
        }

        return null;
        // look it up in hashMap - O(1)



    }

    private static Map<String, Set<String>> prepareDictionary(List<String> words){
        Map<String, Set<String>> dictionary = new HashMap<>();

        Optional<String> name = Optional.of("something");
        for(String word : words){
            char[] wd = word.toCharArray();
            Arrays.sort(wd);
            String wtIn = String.valueOf(wd);
            if(dictionary.containsKey(wtIn)){
                Set<String> anagrams = dictionary.get(wtIn);
                anagrams.add(word);
                dictionary.put(wtIn, anagrams);
            }else{
                Set<String> wds = new HashSet<>();
                wds.add(word);
                dictionary.put(wtIn, wds);
            }
        }

        return dictionary;

    }


}