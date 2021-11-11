package com.coderpad.student.eBay;

// Given an account defined as:
//
// Account
//   balance (decimal number)
//   name: (string)
//   accountType (e.g. credit card, checking, savings)
//   openedDate: (time stamp)
//
// for example
//   balance: 1000.00
//   name   : Chase Freedom
//   accountType   : credit card
//   opened Date: 6/19/2004
//
// Compare 2 sets of accounts for a user - one set from the current month, and one set from the prior month, e.g.:

// previous: [ { "balance":2000.0, "name":"Chase Freedom", "type":"credit_card", "openedDate":1111680799 }, { "balance":100.0, "name":"Citibank", "type":"credit_card", "openedDate":1000680799 } ]
// current:  [ { "balance":1000.0, "name":"Chase Freedom", "type":"credit_card", "openedDate":1111680799 }, { "balance":500.0, "name":"American Express", "type":"credit_card", "openedDate":1222680799 } ]

//    * print out "<name>: <balance change>" for accounts that are in both months, e.g. "Chase Freedom: -1000"
//    * print out "<name>: added" for those that are in the current month but not the previous month, e.g. "American Express: added"
//    * print out "<name>: deleted" for those that are in the previous month but not the current month, e.g. "Citibank: deleted"
/*
 * Click `Run` to execute the snippet below!
 */


import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {
        ArrayList<Account> prevAccounts = new ArrayList<>();
        prevAccounts.add(new Account(new BigDecimal(2000.0), "Chase Freedom", AccountType.CREDIT_CARD, 1111680799L));
        prevAccounts.add(new Account(new BigDecimal(100.0), "Citibank", AccountType.CREDIT_CARD, 1000680799L));

        ArrayList<Account> currAccounts = new ArrayList<>();
        currAccounts.add(new Account(new BigDecimal(1000.0), "Chase Freedom", AccountType.CREDIT_CARD, 1111680799L));
        currAccounts.add(new Account(new BigDecimal(2000.0), "American Express", AccountType.CREDIT_CARD, 1222680799L));

        printChangesInAccount(prevAccounts, currAccounts);
    }



    public static void printChangesInAccount(List<Account> previous, List<Account> curr){

        Map<AccountKey, Account> accountMap = new HashMap<>();


        for(Account acct : previous){

            String name = acct.getName();
            AccountType acctType = acct.getAccountType();
            long openedDate = acct.getOpenedDate();
            accountMap.put( new AccountKey(name, acctType,openedDate), acct);
        }

        for(Account check : curr){

            String name = check.getName();
            AccountType acctType = check.getAccountType();
            long openedDate = check.getOpenedDate();
            AccountKey accountKey =  new AccountKey(name, acctType, openedDate);
            if(accountMap.containsKey(accountKey)){

                compareAccount(check, accountMap.get(accountKey));
            }else{

                System.out.println(name + ": added");
            }
            previous.remove(check);
        }

        if(!previous.isEmpty()){

            for(Account removed : previous){

                System.out.println(removed.getName() + " : " + "deleted");
            }
        }

    }

    public static void compareAccount(Account prev, Account curr){

        BigDecimal difference = prev.getBalance().subtract(curr.getBalance());

        System.out.println(prev.getName() + " : " + difference);

    }

}

class AccountKey{
    String name;
    AccountType accountType;
    long openedDate;

    public AccountKey(String name, AccountType accountType, long openedDate) {
        this.name = name;
        this.accountType = accountType;
        this.openedDate = openedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountKey that = (AccountKey) o;
        return openedDate == that.openedDate && Objects.equals(name, that.name) && accountType == that.accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, accountType, openedDate);
    }
}


class Account{

//   balance (decimal number)
//   name: (string)
//   accountType (e.g. credit card, checking, savings)
//   openedDate: (time stamp)

    BigDecimal balance;

    String name;
    AccountType accountType;

    Long openedDate;

    public Account(BigDecimal balance, String name, AccountType accountType, Long openedDate) {
        this.balance = balance;
        this.name = name;
        this.accountType = accountType;
        this.openedDate = openedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(name, account.name) && accountType == account.accountType && Objects.equals(openedDate, account.openedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, accountType, openedDate);
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setOpenedDate(Long openedDate) {
        this.openedDate = openedDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Long getOpenedDate() {
        return openedDate;
    }


//hashcode

    // equals method override

    //getter, setter

    //parametrized constructor

}

enum AccountType{

    CREDIT_CARD,
    CHECKING,
    SAVINGS
}