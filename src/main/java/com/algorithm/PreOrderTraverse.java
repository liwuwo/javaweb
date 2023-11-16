package com.algorithm;


import java.util.LinkedList;

//先序遍历二叉树
public class PreOrderTraverse {

    public static void main(String[] args) {
        BiTreeNode biTreeNode = createBiTreeNode();
        //preOrderTraverseTree1(biTreeNode);
        //preOrderTraverseTree2(biTreeNode);
        midOrderTraverse(biTreeNode);
    }

    private static void midOrderTraverse(BiTreeNode biTreeNode){
        LinkedList<BiTreeNode> stack = new LinkedList<>();
        stack.add(biTreeNode);
        while(stack.size()>0){
            BiTreeNode node = stack.getLast();
            if(node.leftChild != null){
                stack.add(node.leftChild);
            }else{
                stack.removeLast();
                System.out.println(node.data);
                if(node.rightChild != null){
                    stack.add(node.rightChild);
                }
            }
        }

    }


    //递归遍历
    private static void preOrderTraverseTree1(BiTreeNode biTreeNode){

        System.out.println(biTreeNode.getData());
        BiTreeNode leftChild = biTreeNode.getLeftChild();
        BiTreeNode rightChild = biTreeNode.getRightChild();
        if(leftChild != null){
            preOrderTraverseTree1(biTreeNode.getLeftChild());
        }
        if(rightChild != null){
            preOrderTraverseTree1(biTreeNode.getRightChild());
        }
    }

    //非递归遍历
    private static void preOrderTraverseTree2(BiTreeNode biTreeNode){

        LinkedList<BiTreeNode> stack = new LinkedList<>();
        stack.add(biTreeNode);
        while(stack.size() > 0){
            BiTreeNode node = stack.removeLast();
            System.out.println(node.getData());
            BiTreeNode leftChild = node.getLeftChild();
            BiTreeNode rightChild = node.getRightChild();
            if(rightChild != null){
                stack.add(rightChild);
            }

            if(leftChild != null){
                stack.add(leftChild);
            }
        }
    }

    private static  BiTreeNode createBiTreeNode(){

        BiTreeNode level4Node56 = new BiTreeNode(6,null,null);
        BiTreeNode level4Node57 = new BiTreeNode(7,null,null);

        BiTreeNode level3Node24 = new BiTreeNode(4,null,null);
        BiTreeNode level3Node25 = new BiTreeNode(5,level4Node56,level4Node57);

        BiTreeNode level2Node12 = new BiTreeNode(2,level3Node24,level3Node25);
        BiTreeNode level2Node13 = new BiTreeNode(3,null,null);

        return new BiTreeNode(1,level2Node12,level2Node13);

    }

    static class BiTreeNode{

        private Object data;

        private BiTreeNode leftChild;

        private BiTreeNode rightChild;

        public BiTreeNode() {
        }

        public BiTreeNode(Object data) {
            this.data = data;
        }

        public BiTreeNode(Object data, BiTreeNode leftChild, BiTreeNode rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public BiTreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(BiTreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public BiTreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(BiTreeNode rightChild) {
            this.rightChild = rightChild;
        }
    }
}
