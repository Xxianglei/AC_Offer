package offer;

/**
 * @author xianglei
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Offer24 {
    public static void main(String[] args) {
        LinkNode<Integer> LinkNode = new LinkNode<Integer>();
        LinkNode<Integer> node2 = new LinkNode<Integer>();
        LinkNode<Integer> node3 = new LinkNode<Integer>();
        LinkNode<Integer> node4 = new LinkNode<Integer>();
        LinkNode<Integer> node5 = new LinkNode<Integer>();
        LinkNode.next = node2;
        LinkNode.node_value = 1;
        node2.next = node3;
        node2.node_value = 2;
        node3.next = node4;
        node3.node_value = 3;
        node4.next = node5;
        node4.node_value = 4;
        node5.node_value = 5;
        node5.next = null;
        System.out.println(ReversLinkedList(LinkNode).node_value);
    }

    static LinkNode<Integer> ReversLinkedList(LinkNode<Integer> head) {
        /**
         * node  当前节点  pre 前一个 next  后一个
         */
        if (head == null)
            return null;
        LinkNode pre = null;
        LinkNode next = null;
        LinkNode currentNode = head;
        while (currentNode != null) {
            next = currentNode.next;  // 实现保存一个next、防止断裂无法遍历  （下一个节点保存到next）
            // 如果下一个节点是空  说白了就是反转后的头节点  直接返回即可
            if (next == null) {
                pre = next;
            }
            currentNode.next = pre;  // 下一个节点赋值为他的前一个节点 当前节点的指针指向前一个节点
            pre = currentNode;      // 把当前节点赋值给前一个节点----pre指针后移
            currentNode = next;     //下一个节点赋值为当前节点----currentNode指针后移
        }
        return pre;
    }

}
