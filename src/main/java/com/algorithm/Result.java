package com.algorithm;

import java.util.*;

public class Result {


    public static void main(String[] args) {
        List<Integer> val = Arrays.asList(3,1,2);
        int tNodes = 3;
        List<Integer> tFrom = Arrays.asList(1,1);
        List<Integer> tTo = Arrays.asList(2,3);
        System.out.println(getMinCost(val, tNodes, tFrom, tTo));
    }

    public static int getMinCost(List<Integer> val, int t_nodes, List<Integer> t_from, List<Integer> t_to) {
        // 对每个节点的值进行取模操作，只保留奇偶性
        for (int i = 0; i < val.size(); i++) {
            val.set(i, val.get(i) % 2);
        }

        // 构建邻接表存储树
        List<Set<Integer>> adjList = new ArrayList<>(t_nodes);
        for (int i = 0; i < t_nodes; i++) {
            adjList.add(new HashSet<>());
        }
        for (int i = 0; i < t_from.size(); i++) {
            int from = t_from.get(i) - 1;
            int to = t_to.get(i) - 1;
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        // 找到所有叶子节点
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < t_nodes; i++) {
            if (adjList.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // 依次移除叶子节点，直到剩下两个节点为止
        int remaining = t_nodes;
        int cost = 0;
        while (!leaves.isEmpty() && remaining > 2) {
            remaining -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                // 叶子节点只有一个父节点，因此可以任意选择一个直接从邻接表中弹出
                int parent = adjList.get(leaf).iterator().next();
                adjList.get(leaf).clear();
                adjList.get(parent).remove(leaf);

                if (val.get(leaf) == 1) { // 如果叶子节点的值为奇数
                    cost++;
                    // 父节点的值需要改变，由 0 变为 1 或者由 1 变为 0
                    val.set(parent, 1 - val.get(parent));
                }

                if (adjList.get(parent).size() == 1) { // 如果父节点成为了新的叶子节点
                    newLeaves.add(parent);
                }
            }
            leaves = newLeaves;
        }

        // 检查剩余的两个节点是否都为奇数
        if (leaves.size() == 2 && val.get(leaves.get(0)) == 1) {
            cost++;
        }

        return cost;
    }
}
