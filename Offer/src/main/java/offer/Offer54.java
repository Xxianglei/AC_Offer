package offer;

import java.util.ArrayList;

/**
 * 二叉搜索树的第K大节点
 */
public class Offer54 {
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(5);
        TreeLinkNode node2 = new TreeLinkNode(3);
        TreeLinkNode node3 = new TreeLinkNode(7);
        TreeLinkNode node4 = new TreeLinkNode(2);
        TreeLinkNode node5 = new TreeLinkNode(4);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(8);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node7;
        node3.right = node6;

        TreeLinkNode kMax = findKMax(root, 3);
        System.out.println(kMax.val);
    }

    static TreeLinkNode findKMax(TreeLinkNode pRoot, int k) {
        //中序遍历的第k-1个节点就是第k大的节点
        if (pRoot == null || k <= 0)
            return null;
        ArrayList<TreeLinkNode> aList = new ArrayList();
        inOrderRecursive(pRoot, aList);
        int len = aList.size();
        if (len < k)
            return null;
        else
            return aList.get(k - 1);
    }

    static void inOrderRecursive(TreeLinkNode root, ArrayList<TreeLinkNode> al) {
        if (root == null) {
            return;
        }
        inOrderRecursive(root.left, al);
        al.add(root);
        //System.out.println(root.val);
        inOrderRecursive(root.right, al);
    }

}
