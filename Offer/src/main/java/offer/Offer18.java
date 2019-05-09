package offer;

/**
 * 删除链表节点  删除的节点信息复制到前一个节点 然后删除该节点
 */
public class Offer18 {
    public static void main(String[] args) {
        LinkNode<Integer> firstNode = new LinkNode<Integer>();
        LinkNode<Integer> node2 = new LinkNode<Integer>();
        LinkNode<Integer> node3 = new LinkNode<Integer>();
        LinkNode<Integer> node4 = new LinkNode<Integer>();
        LinkNode<Integer> node5 = new LinkNode<Integer>();
        firstNode.next = node2;
        firstNode.node_value = 1;
        node2.next = node3;
        node2.node_value = 2;
        node3.next = node4;
        node3.node_value = 3;
        node4.next = node5;
        node4.node_value = 4;
        node5.node_value = 5;
        node5.next = null;
        DeleteNode(firstNode, node5);
    }

    /**
     * 头节点  尾节点  任意位置  三种情况
     *
     * @param firstNode  链表
     * @param ToBedelete 需要被删除的
     */
    private static void DeleteNode(LinkNode<Integer> firstNode, LinkNode<Integer> ToBedelete) {
        if (firstNode == null || ToBedelete == null) {
            return;
        }
        /**
         * 头尾
         */
        if (ToBedelete == firstNode) {
            System.out.println("删除头"+firstNode.node_value);
            firstNode = null;
            return;
        }
        /**
         * 不是尾节点
         */
        System.out.println("删除非头尾"+ToBedelete.node_value);
        if (ToBedelete.next != null) {
            LinkNode<Integer> nextNode = ToBedelete.next;
            ToBedelete.node_value = nextNode.node_value;
            ToBedelete.next = nextNode.next;
            ToBedelete.next = null;

        } else {
            LinkNode pointNode = firstNode;
            while (pointNode.next != ToBedelete) {
                pointNode = pointNode.next;
            }
            System.out.println("删除尾"+pointNode.next.node_value);
            pointNode.next = null;
        }
    }
}


