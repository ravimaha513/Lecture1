package com.info.lecture1.collections;

import javax.security.auth.Subject;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Permission;
import java.security.Principal;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Vehicle {

    Double salary;

    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();

      //  List<Truck> truckList = vehicleList.stream().map().collect(Collectors.toList());

        // stringFuture ;
        ExecutorService executorService = Executors.newFixedThreadPool(5);


        Callable task = (Callable<String>) () -> {
            StringBuilder sbr = new StringBuilder("news=");

            for(int i =0; i < 26;i++){
                sbr.append((char) (i + 'A'));
            }

            return sbr.toString();
        };

        List<Future<String>> result = new ArrayList<>();

        for(int i =0; i < 99; i++){
            result.add(executorService.submit(task));
        }

        Collections.sort(vehicleList, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.salary.compareTo(o2.salary);
            }
        });

        try{

        }catch (NullPointerException npe){
            throw npe;
        }catch(OutOfMemoryError e){

        }

    }

    Function< Vehicle, Truck> myFunction = vehicle -> null;
}

class Truck extends Vehicle{



    Lock lock = new ReentrantLock();

    void check(){
        lock.lock();
        Subject subject = Subject.getSubject(AccessController.getContext());

        Set<Principal> principalSet = subject.getPrincipals();

        for(Principal p : principalSet){

        }

        lock.unlock();
        return;
    }

    public static void main(String[] args) {
      //  System.out.println( checkCommonChars(new String[]{"aabcca", "abax"}).size());

      //  countPairs(Arrays.asList(1,1,1,2), 1);

        validateLicenses(new ArrayList<>(), new ArrayList<>());


    }

    private static boolean validateLicenses(List<Device> devices, List<License> existingLicenses) {

        // devices = [ 1, 2, 3, 4, 5]
        // existing Licenses = [ [2 : 0 : 2 ], [2 : 1 : 3]] = 4 for accountId, 2
        // [ accountId : useCount :  totalUsesAllowed ]

        // for each deviceId update the license

        devices.add(new Device(123, "Mobile", "2334"));
        devices.add(new Device(111, "Mobile", "2334"));
        devices.add(new Device(100, "Mobile", "2334"));
        devices.add(new Device(99, "Mobile", "2334"));

        existingLicenses.add(new License("Mobile", "2334", "Mobile", 4, 4));

        List<Boolean> results = new ArrayList<>();


        devices.forEach(
                device -> existingLicenses.stream()
                        .filter(license -> license.getTotalUsesAllowed() - license.getUseCount() <= 0)
                        .filter(license -> device.getDeviceType().equals(license.getDeviceType()))
                        .filter(license -> device.getAccountId().equals(license.getAccountId()))
                        .map( license -> {
                            license.useCount = license.getUseCount() + 1;
                            results.add(true);
                            return true;
                        })

        );

        if(results.size() == devices.size()){
            Predicate<? super Boolean> p1 = s -> s.equals(true);
            System.out.println(results.stream().allMatch(p1));
        }

        return false;




    }

    public static int countPairs(List<Integer> input, int k) {
        // Write your code here
      //  HashSet<HashSet> hs = new HashSet<>();

   /*     IntStream.range(0, numbers.size())
                .forEach(i -> IntStream.range(0, numbers.size())
                        .filter(j -> i != j && numbers.get(i) - numbers.get(i) - numbers.get(j) == k)
                        .forEach(j -> {
                            HashSet<Integer> inner = new HashSet<>();
                            inner.add(numbers.get(i));
                            inner.add(numbers.get(j));
                            hs.add(inner);
                        }));

        System.out.println(hs);*/

        HashSet<HashSet> hs = new HashSet<HashSet>();
        IntStream.range(0,  input.size())
                .forEach(i -> IntStream.range(0,  input.size())
                        .filter(j -> i != j && input.get(i) - input.get(j) == k)
                        .forEach(j -> {
                            HashSet inner = new HashSet<>();
                            inner.add(input.get(j));
                            inner.add(input.get(i));
                            hs.add(inner);
                        })
                );
        System.out.println(hs);
        return hs.size();
    }

    public static List<String> checkCommonChars(String[] A){
        List<String> ans = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : A) {
            int[] cnt = new int[26];
            str.chars().forEach(c -> ++cnt[c - 'a']); // count each char's frequency in string str.
            for (int i = 0; i < 26; ++i) { count[i] = Math.min(cnt[i], count[i]); } // update minimum frequency.
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) { ans.add("" + c); }
        }
        return ans;
    }

}

 class Device {
    int id;
    String deviceType;
    String accountId;

     public Device(int id, String deviceType, String accountId) {
         this.id = id;
         this.deviceType = deviceType;
         this.accountId = accountId;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getDeviceType() {
         return deviceType;
     }

     public void setDeviceType(String deviceType) {
         this.deviceType = deviceType;
     }

     public String getAccountId() {
         return accountId;
     }

     public void setAccountId(String accountId) {
         this.accountId = accountId;
     }
 }

 class License {
    int id;
    String type;
    String accountId;
    String deviceType;  //must be the same as on Device.deviceType
    int useCount;  //some will have useCount greater than 0 to begin with
    int totalUsesAllowed;
    boolean isActive;

     public License(String type, String accountId, String deviceType, int useCount, int totalUsesAllowed) {

         this.type = type;
         this.accountId = accountId;
         this.deviceType = deviceType;
         this.useCount = useCount;
         this.totalUsesAllowed = totalUsesAllowed;

     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getType() {
         return type;
     }

     public void setType(String type) {
         this.type = type;
     }

     public String getAccountId() {
         return accountId;
     }

     public void setAccountId(String accountId) {
         this.accountId = accountId;
     }

     public String getDeviceType() {
         return deviceType;
     }

     public void setDeviceType(String deviceType) {
         this.deviceType = deviceType;
     }

     public int getUseCount() {
         return useCount;
     }

     public void setUseCount(int useCount) {
         this.useCount = useCount;
     }

     public int getTotalUsesAllowed() {
         return totalUsesAllowed;
     }

     public void setTotalUsesAllowed(int totalUsesAllowed) {
         this.totalUsesAllowed = totalUsesAllowed;
     }

     public boolean isActive() {
         return isActive;
     }

     public void setActive(boolean active) {
         isActive = active;
     }
 }
