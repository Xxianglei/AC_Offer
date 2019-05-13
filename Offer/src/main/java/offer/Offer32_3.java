package offer;

import java.util.Stack;

/**
 * 之形打印二叉树
 */
public class Offer32_3 {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(6);
        BinaryTreeNode node6 = new BinaryTreeNode(7);
        BinaryTreeNode node7 = new BinaryTreeNode(8);
        BinaryTreeNode node8 = new BinaryTreeNode(9);
        BinaryTreeNode node9 = new BinaryTreeNode(10);
        BinaryTreeNode node10 = new BinaryTreeNode(11);
        BinaryTreeNode node11 = new BinaryTreeNode(12);
        BinaryTreeNode node12 = new BinaryTreeNode(13);
        BinaryTreeNode node13 = new BinaryTreeNode(14);
        BinaryTreeNode node14 = new BinaryTreeNode(15);
        root.leftTree = node1;
        root.rightTree = node2;
        node1.leftTree = node3;
        node3.leftTree = node7;
        node3.rightTree = node8;
        node1.rightTree = node4;
        node4.leftTree = node9;
        node4.rightTree = node10;
        node2.rightTree = node6;
        node6.leftTree = node13;
        node6.rightTree = node14;
        node2.leftTree = node5;
        node5.leftTree = node11;
        node5.rightTree = node12;
        printByZ(root);
    }

    private static void printByZ(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        int currentlayer = 1;
        Stack<BinaryTreeNode> stackj = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> stacko = new Stack<BinaryTreeNode>();
        stackj.push(root);
        while (!stackj.empty() || !stacko.empty()) {
            BinaryTreeNode currNode = null;
            if (currentlayer % 2 == 0 && !stacko.empty()) {
                currNode = stacko.pop();
            }
            if (currentlayer % 2 != 0 && !stackj.empty()) {
                currNode = stackj.pop();
            }
            System.out.print(currNode.node_value + " ");
            currentlayer++;
            if (currentlayer % 2 == 0) {
                if (currNode.leftTree != null) {
                    stacko.push(currNode.leftTree);
                }
                if (currNode.rightTree != null) {
                    stacko.push(currNode.rightTree);
                }
            } else {
                if (currNode.rightTree != null) {
                    stackj.push(currNode.rightTree);
                }
                if (currNode.leftTree != null) {
                    stackj.push(currNode.leftTree);
                }
            }
            /**
             * 分奇偶 讨论什么时候打印换行  放在一起判断的话会出现某一个空就打印换行 引起空指针异常
             */
            if (currentlayer % 2 != 0) {
                if (stacko.empty()) {
                    System.out.println();
                } else {
                    currentlayer = currentlayer - 1;
                }
            } else {
                if (stackj.empty()) {
                    System.out.println();
                } else {
                    currentlayer = currentlayer - 1;
                }
            }

        }
    }
}
