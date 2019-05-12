package offer;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */
public class Offer28 {
    public static void main(String[] args) {

    }

    static boolean isSymmetrical() {
        return isSymmetrical();
    }

    static boolean isSymmertrical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1.node_value != root2.node_value) {
            return false;
        }

        return isSymmertrical(root1.leftTree, root2.rightTree) && isSymmertrical(root1.rightTree, root2.leftTree);
    }
}
