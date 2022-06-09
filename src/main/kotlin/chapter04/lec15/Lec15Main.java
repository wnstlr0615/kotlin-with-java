package chapter04.lec15;

import java.util.*;

public class Lec15Main {
    public static void main(String[] args) {
        //= 1. 배열 =//
        int[] arr = {100, 200};
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s %s \n", i, arr[i]);
        }

        //== 2. 코틀린에서의 Collection ==//
        // List
        final List<Integer> numbers = Arrays.asList(100, 200);

        System.out.println(numbers.get(0));
        for (int number : numbers) {
            System.out.println(number);
        }

        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%s %s", i, numbers.get(i));
        }

        //set
        Set<Integer> set = new LinkedHashSet<>();
        set.add(100);
        set.add(200);

        //map
        //jdk 8
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "MONDAY");
        map.put(2, "TUESDAY");

        //jdk 9
        Map.of(1, "MONDAY", 2, "TUESDAY");

        for (Integer key : map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key));
        }
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
