package offer;

import java.util.Stack;

/**
 * 二叉树中和为某一值得路径
 */
public class Offer34 {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(12);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(7);
        root.leftTree = node1;
        root.rightTree = node2;
        node1.leftTree = node3;
        node1.rightTree = node4;
        int target = 22;
        Stack<Integer> path=new Stack<Integer>();
        findPath(root, target,path, 0);
    }

    private static void findPath(BinaryTreeNode root, int target, Stack<Integer> path, int currentSum) {
        if(root==null){
            return;
        }
        currentSum+=root.node_value;
        path.push(root.node_value);
        boolean isLeaf=root.leftTree==null&&root.rightTree==null;
        if(isLeaf&&currentSum==target){
           while (!path.isEmpty()){
               Integer poll = path.pop();
               System.out.println(poll+" ");
           }
            System.exit(0);
        }
        else{
            if(root.leftTree!=null){
                findPath(root.leftTree,target,path,currentSum);
            }
            if(root.rightTree!=null){
                findPath(root.rightTree,target,path,currentSum);
            }
            path.pop();
        }

    }
}
