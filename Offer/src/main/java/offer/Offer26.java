package offer;

/**
 * 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构;
 */
public class Offer26 {
    public static void main(String[] args) {

    }

    static boolean HasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean result = false;

        //第一步;在树A中找到和树B根结点值相同的节点，因此需要对二叉树进行遍历
        if (root1 != null && root2 != null) {
            if (root1.node_value == root2.node_value) {
                result = DoTheJudge(root1, root2);
            }
            if (!result) {
                result = HasSubtree(root1.leftTree, root2);
            }
            if (!result) {
                result = HasSubtree(root1.rightTree, root2);
            }
        }
        return result;
    }

    private static boolean DoTheJudge(BinaryTreeNode root1, BinaryTreeNode root2) {
        //遍历完树A都没有，其中都没有完全匹配树B的子结构
        if (root1 == null && root2 != null) {
            return false;
        }
        //root2的所有节点与root1中进行了匹配
        if (root2 == null) {
            return true;
        }
        if (root1.node_value != root2.node_value) {
            return false;
        } else {
            return DoTheJudge(root1.leftTree, root2.leftTree) && DoTheJudge(root1.rightTree, root2.rightTree);
        }
    }
}
