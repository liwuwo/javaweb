package com.algorithm;

import java.util.*;

public class Result {


    public static void main(String[] args) {
        List<Integer> val = Arrays.asList(3, 1, 2);
        int tNodes = 3;
        List<Integer> tFrom = Arrays.asList(1, 1);
        List<Integer> tTo = Arrays.asList(2, 3);
        System.out.println(getMinCost(val, tNodes, tFrom, tTo));
    }

    public static int getMinCost(List<Integer> val, int tNodes, List<Integer> tFrom, List<Integer> tTo) {
        val.replaceAll(integer -> integer % 2);

        List<Set<Integer>> adjList = new ArrayList<>(tNodes);
        for (int i = 0; i < tNodes; i++) {
            adjList.add(new HashSet<>());
        }
        for (int i = 0; i < tFrom.size(); i++) {
            int from = tFrom.get(i) - 1;
            int to = tTo.get(i) - 1;
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < tNodes; i++) {
            if (adjList.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        int remaining = tNodes;
        int cost = 0;
        while (!leaves.isEmpty() && remaining > 2) {
            remaining -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int parent = adjList.get(leaf).iterator().next();
                adjList.get(leaf).clear();
                adjList.get(parent).remove(leaf);

                if (val.get(leaf) == 1) {
                    cost++;
                    val.set(parent, 1 - val.get(parent));
                }

                if (adjList.get(parent).size() == 1) {
                    newLeaves.add(parent);
                }
            }
            leaves = newLeaves;
        }

        if (leaves.size() == 2 && val.get(leaves.get(0)) == 1) {
            cost++;
        }

        return cost;
    }
}
