package com.info.lecture1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;

class Employee {
    String department;

    Integer salary;
}

public class Example {

    public static void main(String[] args) {

        //  List<Story> storiesList = new ArrayList<>(todoList.stories);


        //  findMinCoins(new int[]{1, 2, 5}, 11);

        List<Employee> employees = new ArrayList<>();
        Map<String, Employee> topEmployees =
                employees.stream()
                        .collect(groupingBy(
                                e -> e.department,
                                collectingAndThen(Collectors.maxBy(Comparator.comparingInt(e -> e.salary)), Optional::get)
                        ));

        List<String> strings = new ArrayList<>();

        strings.add("Aditya");
        strings.add("Bird");
        strings.add("cat");
        strings.add("dog");
        strings.add("check");
/*
        strings.removeIf(x -> x.toUpperCase().contains("A"));

        System.out.println(strings);*/

        //   System.out.println( jumps(8, 3) );

        // System.out.println(countTeams(Arrays.asList(12, 4, 6, 13, 5, 10), 3, 4, 10));

        System.out.println(countTeams(Arrays.asList(4, 8, 5, 6), 1, 5, 7));
    }


    public static int jumps(int flagHeight, int bigJump) {
        // Write your code here

        int result = 0;

        int tempHeight = flagHeight;
        while (tempHeight >= bigJump) {
            tempHeight = tempHeight - bigJump;
            result++;
        }

        return result + Math.abs(flagHeight - result * bigJump);

    }

    public static int countTeams(List<Integer> skills, int minPlayers, int minLevel, int maxLevel) {
        // Write your code here

        List<Integer> integerList = skills.stream().filter(x -> (x >= minLevel) && (x <= maxLevel)).collect(Collectors.toList());

        return findPowerSet(integerList).size() - 1;

    }

    public static Set<List<Integer>> findPowerSet(List<Integer> list) {

        int N = (int) Math.pow(2, list.size());
        Set<List<Integer>> set = new HashSet<>();

        Collections.sort(list);


        for (int i = 0; i < N; i++) {
            List<Integer> subset = new ArrayList<>();


            for (int j = 0; j < list.size(); j++) {

                if ((i & (1 << j)) != 0) {
                    subset.add(list.get(j));
                }
            }

            set.add(subset);
        }
        return set;
    }

    private static void getSubsets(List<Integer> superSet, int k, int idx,
                                   List<Integer> current, List<List<Integer>> solution) {

        if (current.size() == k) {
            solution.add(new ArrayList<>(current));
            return;
        }

        for (int i = idx; i < superSet.size(); i++) {
            Integer x = superSet.get(i);
            current.add(x);
            getSubsets(superSet, k, i + 1, current, solution);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> getSubsets(List<Integer> superSet, int k) {
        List<List<Integer>> res = new ArrayList<>();
        getSubsets(superSet, k, 0, new ArrayList<Integer>(), res);
        return res;
    }

    public static int findMinCoins(int[] currency, int amount) {
        int min = findMinCoins(currency, amount, 0);
        System.out.print("The coins used were: ");
        return min;
    }

    private static int findMinCoins(int[] currency, int amount, int min) {
        int min1 = min;
        for (int i = currency.length - 1; i >= 0; i--) {
            if (amount >= currency[i]) {
                amount = amount - currency[i];
                System.out.print(currency[i] + " ");
                min1 = findMinCoins(currency, amount, min1);
                return ++min1;
            }
        }
        return min1;
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int n = amount + 1;
        for (int coin : coins) {
            int curr = 0;
            if (amount >= coin) {
                int next = coinChange(coins, amount - coin);
                if (next >= 0)
                    curr = 1 + next;
            }
            if (curr > 0)
                n = Math.min(n, curr);
        }
        int finalCount = (n == amount + 1) ? -1 : n;
        return finalCount;
    }
}


class Story implements Comparator<Story> {

    String title;
    Integer priority;

    public Story(String title, Integer priority) {

        this.title = title;
        this.priority = priority;
    }

    public String toString() {

        return this.priority + " - " + this.title;
    }

    @Override
    public int compare(Story o1, Story o2) {

        return o1.priority.compareTo(o2.priority);
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Story story = (Story) o;

        return Objects.equals(title, story.title) && Objects.equals(priority, story.priority);
    }

    //hashCode
    @Override
    public int hashCode() {

        return Objects.hash(title, priority);

    }
}

class TodoList {

    TreeSet<Story> stories;

    public TodoList() {
        this.stories = new TreeSet<>();
    }

    public void addStory(Story story) {

        Comparator<Story> storyComparator = (o1, o2) -> o1.priority.compareTo(o2.priority);

        stories.add(story);

    }


}

/*
 *
 * Create a new instance of TodoList
 * Create a new Story with title "First Story" and priority 50
 * The TodoList should contain a set of `Story` objects
 *
 * Print the Story's output as "priorty - title", e.g. "50 - First Story"
 * At the end, should output "50 - First Story"
 */
class CustomSort {

    public static void main(String[] args) {
        String consonants = "kadei";
        //de
        Character[] charObjectArray =
                consonants.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        sortVowels(charObjectArray);

        Map<Character, Integer> freqmap = new HashMap<>();

        boolean val = true;

        String str1 = "stress";
        String str2 = "restss";

        for (Character ch : str1.toCharArray()) {

            if (freqmap.containsKey(ch)) {
                int value = freqmap.get(ch);
                freqmap.put(ch, value + 1);
            } else {
                freqmap.put(ch, 1);
            }
        }

        for (Character ch : str2.toCharArray()) {

            if (freqmap.containsKey(ch)) {
                int value = freqmap.get(ch);
                freqmap.put(ch, value - 1);
            } else {
                freqmap.put(ch, 1);
            }
        }

        Iterator<Map.Entry<Character, Integer>> iterator = freqmap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (entry.getValue() != 0) {
                val = false;
                break;
            }
        }

        System.out.println(val);


    }

    public static void sortVowels(Character[] tempArray) {

        Arrays.sort(tempArray, (c1, c2) -> {

            if (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c2 == 'u' || c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u') {
                return 0;
            } else {
                return Character.compare(Character.toLowerCase(c1),
                        Character.toLowerCase(c2));
            }
            // ignoring case

        });

        System.out.println(Arrays.deepToString(tempArray));
    }
}

