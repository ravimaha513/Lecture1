package com.nary.tree.dfs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DFS {

    public static void main(String[] args) {
        String[][] str = new String[][]{
                {"3", "0", "11"},
                {"6", null, "12"}
        };

        List<HotelTrip> hotelTrips = new ArrayList<>();
        Set<NaryTree> hotels = new HashSet<>();

        for(String[] strings : str){
            String child = strings[0];
            String parent = strings[1];
            Integer qty = Integer.parseInt(strings[2]);

            hotelTrips.add(new HotelTrip(child, parent, qty));
        }


    }



    public static void findParentOrChild(String[] str){
        for(int i = 0; i < str.length; i++){
            String child = str[i];
            System.out.println(child);
        }
    }

    public static void dfs(LinkedList<Integer> list[],
                           int node, int arrival)
    {
        System.out.println(node);

        for (int i = 0; i < list[node].size(); i++) {

            if (list[node].get(i) != arrival)
                dfs(list, list[node].get(i), node);
        }
    }
}

class HotelTrip{
    String parent;
    String child;
    Integer sum;

    public HotelTrip(String parent, String child, Integer sum) {
        this.parent = parent;
        this.child = child;
        this.sum = sum;
    }
}
class NaryTree{
    int data;
    List<NaryTree> children;

}

