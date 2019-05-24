package offer;

/**
 *
 */
public class Offer36 {
    public static void main(String[] args) {
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node14 = new BinaryTreeNode(14);
        BinaryTreeNode node12 = new BinaryTreeNode(12);
        BinaryTreeNode node16 = new BinaryTreeNode(16);

    }

    public static BinaryTreeNode36 Convert(BinaryTreeNode36 root) {
        BinaryTreeNode36 lastNodeInList = null;

        ConvertNode(root, lastNodeInList);

        // lastNodeInList指向双向链表的尾结点，
        // 我们需要返回头结点
        BinaryTreeNode36 headInList = lastNodeInList;
        while (headInList != null && headInList.leftChild != null) {
            headInList = headInList.leftChild;
        }

        return headInList;
    }

    private static void ConvertNode(BinaryTreeNode36 node, BinaryTreeNode36 lastNodeInList) {
        if (node == null) {
            return;
        }
        BinaryTreeNode36 currentNode = node;
        // 转换左子树
        if (currentNode.leftChild != null) {
            ConvertNode(currentNode.leftChild, lastNodeInList);
        }
        // 与根节点的衔接
        currentNode.leftChild = lastNodeInList;
        if (lastNodeInList != null) {
            lastNodeInList.rightChild = currentNode;
        }
        lastNodeInList = currentNode;
        // 转换右子树
        if (currentNode.rightChild != null) {
            ConvertNode(currentNode.rightChild, lastNodeInList);
        }
    }
}

class BinaryTreeNode36 {
    public int Data;
    public BinaryTreeNode36 leftChild;
    public BinaryTreeNode36 rightChild;

    public BinaryTreeNode36(int data) {
        this.Data = data;
    }

    public BinaryTreeNode36(int data, BinaryTreeNode36 left, BinaryTreeNode36 right) {
        this.Data = data;
        this.leftChild = left;
        this.rightChild = right;
    }
}