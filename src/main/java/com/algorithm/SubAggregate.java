package com.algorithm;

import java.util.HashMap;

//求子集
public class SubAggregate {

    public static void main(String[] args) {

        String aggregateTotal = "ABCDE";
        String[] array = aggregateTotal.split("");

        HashMap<String, Integer> aggMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            aggMap.put(array[i], i);
            System.out.println(array[i]);
        }

        outputSubAgg(array, aggMap);
        //@表示空集
        System.out.println("@");

    }

    private static void outputSubAgg(String[] array, HashMap<String, Integer> aggMap) {

        HashMap<String, Integer> newMap = new HashMap<>();
        aggMap.forEach((key, value) -> {
            for (int i = value; i < array.length - 1; i++) {
                String newKey = key + array[i + 1];
                System.out.println(newKey);
                newMap.put(newKey, i + 1);
            }
        });
        if (newMap.size() != 0) {
            outputSubAgg(array, newMap);
        }
    }
}
