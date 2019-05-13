package offer;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 分行从上到下打印二叉树
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印 ，每一层打印一行。
 */
public class Offer32_2 {
    public static void main(String[] args) {
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
        printByLayer(root);
    }

    /**
     * 使用队列  + 标记量  一个记录还未打印  一个记录下一层有多少个节点
     *
     * @param root
     */
    private static void printByLayer(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> tempQueue = new LinkedBlockingQueue<BinaryTreeNode>();
        int toBePrint = 1;
        int nextNodes = 0;
        tempQueue.add(root);  // 8
        while (!tempQueue.isEmpty()) {
            BinaryTreeNode poll = tempQueue.poll();
            toBePrint--;
            System.out.print(poll.node_value+" ");
            if (poll.leftTree != null) {
                tempQueue.add(poll.leftTree);
                nextNodes++;
            }
            if (poll.rightTree != null) {
                tempQueue.add(poll.rightTree);
                nextNodes++;
            }
            if (toBePrint == 0) {
                System.out.println();
                toBePrint = nextNodes;
                nextNodes = 0;
            }

        }
    }
}
