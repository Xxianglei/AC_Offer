package offer;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像;
 */
public class Offer27 {
    public static void main(String[] args) {

    }

    static void findMirror(TreeLinkNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        TreeLinkNode temp = null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.right != null) {
            findMirror(root.right);
        }
        if (root.left != null) {
            findMirror(root.left);
        }
    }

}
