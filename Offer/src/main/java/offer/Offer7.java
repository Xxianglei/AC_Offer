package offer;

/**
 * 输入某二叉树的前序遍历和中序遍历结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不包含重复的数字。
 * 例如输入前序遍历序列:{1,2,4,7,3,5,6,8}和中序遍历{4,7,2,1,5,3,8,6},
 * 则重建出图中所示二叉树并且输出它的头结点。
 */
public class Offer7 {
    BinaryTreeNode binaryTreeNode = null;
    public static void main(String[] args) {
        int preOrder[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int inOrder[] = {4, 7, 2, 1, 5, 3, 8, 6};
        Offer7 constructBinaryTree = new Offer7();
        BinaryTreeNode node = constructBinaryTree.construct(preOrder, inOrder, preOrder.length);
        // 前序打印
        printPreBinaryTree(node);
    }

    /**
     * 初始化判断
     *
     * @param preOrder
     * @param inOrder
     * @param prelength
     * @return
     */
    public BinaryTreeNode construct(int preOrder[], int inOrder[],
                                    int prelength) {

        if (prelength == 0 || preOrder == null || inOrder == null) {
            return null;
        } else {
            binaryTreeNode = coreConstruct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
        }
        return binaryTreeNode;
    }

    /**
     * 区分左右子树，找出根节点核心
     *
     * @param preOrder
     * @param startPreIndex
     * @param endPreIndex
     * @param inOrder
     * @param startInIndex
     * @param endInIndex
     * @return
     */
    public BinaryTreeNode coreConstruct(int[] preOrder, int startPreIndex, int endPreIndex, int[] inOrder, int startInIndex, int endInIndex) {
        int rootPreValue = preOrder[startPreIndex];
        /**
         *首先构建一颗只有根节点的树
         */
        BinaryTreeNode rootNode = new BinaryTreeNode(rootPreValue);
        /**
         * 只有一个元素的情况 先序遍历和中序遍历都只有一个元素
         */
        if (startPreIndex == endPreIndex && startInIndex == endInIndex
                && preOrder[startInIndex] == inOrder[endInIndex]) {
            System.out.println("只有一个元素");
            return rootNode;
        } else {
            /**
             * 在中序遍历中找到根节点  区分左右子树 分别递归创建   核心（⭐）
             */
            int rootInIndex = startInIndex;
            while (rootInIndex <= endInIndex && inOrder[rootInIndex] != rootPreValue) {
                rootInIndex++;
            }

            // 左子树长度
            int letfTreelength = rootInIndex - startInIndex;
            // 左子树右端值
            int leftPreEndIndex = startPreIndex + letfTreelength;
            // 构建左子树
            if (letfTreelength > 0) {
                rootNode.leftTree = coreConstruct(preOrder, startPreIndex + 1,
                        leftPreEndIndex, inOrder, startInIndex, rootInIndex - 1);
            }
            // 如果左子树长度小于 先序遍历的元素个数  说明存在右子树
            if (letfTreelength < endPreIndex - startPreIndex) {
                rootNode.rightTree = coreConstruct(preOrder, leftPreEndIndex + 1,
                        endPreIndex, inOrder, rootInIndex + 1, endInIndex);
            }
            return rootNode;
        }
    }

    // 按照前序遍历打印二叉树的节点
    public static void printPreBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.println(root.node_value + " ");
        }
        if (root.leftTree != null) {
            printPreBinaryTree(root.leftTree);
        }
        if (root.rightTree != null) {
            printPreBinaryTree(root.rightTree);
        }
    }
}

/**
 * 二叉树数据结构
 */
class BinaryTreeNode {
    int node_value;
    BinaryTreeNode leftTree;
    BinaryTreeNode rightTree;

    /**
     * 创建对象的时候初始化出一个无左右子节点的节点
     *
     * @param node_value
     */
    BinaryTreeNode(int node_value) {
        this.leftTree = null;
        this.rightTree = null;
        this.node_value = node_value;
    }
}