package offer;


public class Offer8 {
    public static void main(String[] args) {
        //            1
        //          // \\
        //         2     3
        //       // \\
        //      4     5
        //    inorder->42513
        TreeLinkNode root = new TreeLinkNode(1);

        root.left = new TreeLinkNode(2);
        root.left.father =root;
        root.right = new TreeLinkNode(3);
        root.right.father =root;
        root.left.left = new TreeLinkNode(4);
        root.left.left.father =root.left;
        root.left.right = new TreeLinkNode(5);
        root.left.right.father =root.left;
        System.out.println(GetNext(root.left.right ).val);
    }

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        /*这里需要注意的是pNode.next是pNode结点的父结点
        1、如果有右子树，那么下一个结点就是右子树最左边的节点。
        2、如果没有右子树，分两种情况，如果该结点的为父结点的左孩子，则该结点的父节点pNode.next则为
        该结点的下一个结点。
        第二种情况则是如果该结点的为父节点的右孩子，则向上找父节点，直到父节点为该父节点的左孩子，则该父节点的父节点
        为下一个结点。
        */
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {//1、如果有右子树，那么下一个结点就是右子树最左边的节点。
            pNode = pNode.right;
            while (pNode.left != null) pNode = pNode.left;
            return pNode;
        }
        while (pNode.father !=null) {//这个则是在没有右子树的情况下，求下一个结点。下面if
            if (pNode.father.left == pNode) {
                return pNode.father;
            }
            pNode = pNode.father;
        }
        return pNode;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode father = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
