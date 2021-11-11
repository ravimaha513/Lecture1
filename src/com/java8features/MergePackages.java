package com.java8features;

import java.util.*;

public class MergePackages{

    public List<Package> getMergedPackages(List<Package> oldPackages, List<Package> newPackages) {
        //Return the updated packages by merging based on vendor, country, barcode

        Map<Package, String> packageMap = new LinkedHashMap<>();



        for(Package pack : oldPackages){
                packageMap.put(pack, pack.description);
        }

        for(Package pack : newPackages){
            packageMap.put(pack, pack.description);
        }

        List<Package> mergedPackages = new ArrayList<>();

        for(Map.Entry<Package, String> entrySet : packageMap.entrySet()){
            Package pack = entrySet.getKey();
            pack.description = entrySet.getValue();
            mergedPackages.add(pack);
        }

        return mergedPackages;
    }

    public boolean happyPathTest() {
        MergePackages mergePackages = new MergePackages();

        List<Package> oldPackages = new ArrayList<Package>();
        oldPackages.add(new Package(123, "US", "11111111", "First Package"));
        oldPackages.add(new Package(123, "US", "22222222", "Second Package"));
        oldPackages.add(new Package(123, "CA", "33333333", "Second Package"));

        List<Package> newPackages = new ArrayList<Package>();
        newPackages.add(new Package(123, "US", "22222222", "Second Package Updated"));
        newPackages.add(new Package(123, "CA", "33333333", "Second Package"));
        newPackages.add(new Package(123, "US", "33333333", "Third Package"));


        List<Package> mergedPackages = new ArrayList<>();
        mergedPackages.add(new Package(123, "US", "11111111", "First Package"));
        mergedPackages.add(new Package(123, "US", "22222222", "Second Package Updated"));
        mergedPackages.add(new Package(123, "CA", "33333333", "Second Package"));
        mergedPackages.add(new Package(123, "US", "33333333", "Third Package"));

        return mergePackages.getMergedPackages(oldPackages, newPackages).equals(mergedPackages);
    }

    public static void main(String[] args) {
        MergePackages mergePackages = new MergePackages();
        System.out.println(mergePackages.happyPathTest());
    }
}


class Package {
    int vendor;
    String country;
    String barcode;
    String description;

    public Package(int vendor, String country, String barcode, String description) {
        this.vendor = vendor;
        this.country = country;
        this.barcode = barcode;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return vendor == aPackage.vendor && country.equals(aPackage.country) && barcode.equals(aPackage.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendor, country, barcode);
    }

    @Override
    public String toString() {
        return "Package{" +
                "vendor=" + vendor +
                ", country='" + country + '\'' +
                ", barcode='" + barcode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}