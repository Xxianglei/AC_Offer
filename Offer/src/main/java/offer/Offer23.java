package offer;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Offer23 {
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
        node5.next = node3;
        System.out.println(EntryNodeOfLoop(LinkNode));
    }

    static LinkNode MeetingNode(LinkNode head) {
        if (head == null || head.next == null) return null;
        /**
         * 定义两个指针  一个快一个慢  如果相遇则有环
         */
        LinkNode slow = head;
        LinkNode fast = head.next.next;
        while (fast != null && slow != null) {
            if (fast == slow)
                return fast;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return null;
    }

    static int EntryNodeOfLoop(LinkNode<Integer> head) {
        LinkNode<Integer> meetingNode = MeetingNode(head);
        if (meetingNode == null)
            return 0;
        int count = 1;
        LinkNode<Integer> node = meetingNode;
        while (node.next != meetingNode) {
            node = node.next;
            count++;
        }
        node = head;
        /**
         * 先移动node1  移动位数为 环中节点个数
         */
        for (int i = 0; i < count; i++) {
            node = node.next;
        }
        LinkNode<Integer> node1 = head;
        while (node != node1) {
            node = node1.next;
            node1 = node1.next;
        }

        int node_value = node1.node_value;
        return node_value;
    }


}
