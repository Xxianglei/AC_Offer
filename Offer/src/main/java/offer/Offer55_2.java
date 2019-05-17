package offer;

/**
 * 平衡二叉树 判断是否是平衡二叉树
 */
public class Offer55_2 {
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node7;
        node3.right = node6;
        System.out.println(isBalanced(root));
    }

    /**
     * 通过后序遍历分别先遍历左右子节点
     *
     * @param root
     * @return
     */
    private static boolean isBalanced(TreeLinkNode root) {
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int diff=left-right;
        if(diff> 1||diff<-1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    static int treeDepth(TreeLinkNode root) {
        if (root != null) {
            int left = treeDepth(root.left);
            int right = treeDepth(root.right);
            return left > right ? left + 1 : right + 1;
        }
        return 0;
    }
}
