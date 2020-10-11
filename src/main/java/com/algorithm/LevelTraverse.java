package com.algorithm;


import com.common.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

//层次遍历树
public class LevelTraverse {

    public static void main(String[] args) {

        TreeNode level1node1 = createTreeNode();
        System.out.println(JsonUtil.write2JsonStr(level1node1));
        levelTraverseTree(level1node1);
    }

    private static void levelTraverseTree(TreeNode treeNode){
        System.out.println(treeNode.getData());
        List<TreeNode> childNodeList = treeNode.getChildNodeList();
        if(childNodeList != null && childNodeList.size() > 0){
            List<TreeNode> nodeList = new ArrayList<>(childNodeList);
            while (nodeList.size() > 0){
                List<TreeNode> tempList = new ArrayList<>();
                for(TreeNode tn:nodeList){
                    System.out.println(tn.getData());
                    List<TreeNode> cnl = tn.getChildNodeList();
                    if(cnl != null && cnl.size() > 0){
                        tempList.addAll(tn.getChildNodeList());
                    }
                }
                nodeList.clear();
                if(tempList.size() > 0){
                    nodeList.addAll(tempList);
                }
            }
        }
    }

    private static TreeNode createTreeNode(){
        TreeNode level4node1 = new TreeNode("41",null);
        TreeNode level4node2 = new TreeNode("42",null);
        TreeNode level4node3 = new TreeNode("43",null);
        TreeNode level4node4 = new TreeNode("44",null);
        TreeNode level4node5 = new TreeNode("45",null);
        TreeNode level4node6 = new TreeNode("46",null);

        TreeNode level3node1 = new TreeNode("31");
        TreeNode level3node2 = new TreeNode("32");
        TreeNode level3node3 = new TreeNode("33",null);
        TreeNode level3node4 = new TreeNode("34");
        TreeNode level3node5 = new TreeNode("35",null);
        TreeNode level3node6 = new TreeNode("36");

        level3node1.getChildNodeList().add(level4node1);
        level3node1.getChildNodeList().add(level4node2);
        level3node2.getChildNodeList().add(level4node3);
        level3node4.getChildNodeList().add(level4node4);
        level3node6.getChildNodeList().add(level4node5);
        level3node6.getChildNodeList().add(level4node6);

        TreeNode level2node1 = new TreeNode("21");
        TreeNode level2node2 = new TreeNode("22");
        TreeNode level2node3 = new TreeNode("23");

        level2node1.getChildNodeList().add(level3node1);
        level2node2.getChildNodeList().add(level3node2);
        level2node2.getChildNodeList().add(level3node3);
        level2node2.getChildNodeList().add(level3node4);
        level2node3.getChildNodeList().add(level3node5);
        level2node3.getChildNodeList().add(level3node6);

        TreeNode level1node1 = new TreeNode("11");
        level1node1.getChildNodeList().add(level2node1);
        level1node1.getChildNodeList().add(level2node2);
        level1node1.getChildNodeList().add(level2node3);
        return level1node1;
    }

    static class TreeNode{

        private Object data;

        private List<TreeNode> childNodeList = new ArrayList<>();

        public TreeNode(){

        }

        public TreeNode(Object data) {
            this.data = data;
        }

        public TreeNode(Object data,List<TreeNode> childNodeList) {
            this.data = data;
            this.childNodeList = childNodeList;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public List<TreeNode> getChildNodeList() {
            return childNodeList;
        }

        public void setChildNodeList(List<TreeNode> childNodeList) {
            this.childNodeList = childNodeList;
        }
    }
}
