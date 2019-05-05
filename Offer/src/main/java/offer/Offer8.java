package offer;

public class Offer8 {
    public static void main(String[] args) {


    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
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
        while (pNode.next != null) {//这个则是在没有右子树的情况下，求下一个结点。下面if
            if (pNode.next.left == pNode)
                return pNode.next;
            pNode = pNode.next;
        }
        return pNode;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
