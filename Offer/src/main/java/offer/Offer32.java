package offer;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 从上往下打印二叉树的每个节点，同一层的节点按照从左到右的顺序打印。例如输入下图的二叉树，则一次打印出8，6，10，5，7，9，11。
 */
public class Offer32 {
    public static void main(String[] args) throws InterruptedException {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode node1 = new BinaryTreeNode(6);
        BinaryTreeNode node2 = new BinaryTreeNode(10);
        BinaryTreeNode node3 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(9);
        BinaryTreeNode node6 = new BinaryTreeNode(11);
        root.leftTree = node1;
        root.rightTree = node2;
        node1.leftTree = node3;
        node1.rightTree = node4;
        node2.rightTree = node6;
        node2.leftTree = node5;
        printInOrder(root);
    }

    /**
     * 借助队列的特性 保存当前打印节点的子节点
     *
     * @param root
     */
    static void printInOrder(BinaryTreeNode root) throws InterruptedException {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> tempQueue=new LinkedBlockingQueue<BinaryTreeNode>();
        tempQueue.add(root);
        while (tempQueue.size()!=0){
            BinaryTreeNode node = tempQueue.poll();
            System.out.println(node.node_value);
            if(node.leftTree!=null){
                tempQueue.add(node.leftTree);
            }
            if(node.rightTree!=null){
                tempQueue.add(node.rightTree);
            }
        }
    }

}
