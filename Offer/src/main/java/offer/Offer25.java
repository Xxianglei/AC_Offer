package offer;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 */
public class Offer25 {
    public static void main(String[] args) {
        LinkNode<Integer> LinkNode1 = new LinkNode<Integer>();
        LinkNode<Integer> node2 = new LinkNode<Integer>();
        LinkNode<Integer> node3 = new LinkNode<Integer>();
        LinkNode<Integer> node4 = new LinkNode<Integer>();
        LinkNode<Integer> node5 = new LinkNode<Integer>();
        LinkNode1.next = node2;
        LinkNode1.node_value = 1;
        node2.next = node3;
        node2.node_value = 3;
        node3.next = node4;
        node3.node_value = 5;
        node4.next = node5;
        node4.node_value = 7;
        node4.next = null;
        LinkNode<Integer> LinkNode2 = new LinkNode<Integer>();
        LinkNode<Integer> node22 = new LinkNode<Integer>();
        LinkNode<Integer> node33 = new LinkNode<Integer>();
        LinkNode<Integer> node44 = new LinkNode<Integer>();
        LinkNode<Integer> node55 = new LinkNode<Integer>();
        LinkNode2.next = node22;
        LinkNode2.node_value = 2;
        node22.next = node33;
        node22.node_value = 4;
        node33.next = node44;
        node33.node_value = 6;
        node44.next = node55;
        node44.node_value = 8;
        node44.next = null;
        LinkNode<Integer> merge = Merge(LinkNode1, LinkNode2);

        while (merge.next != null) {
            System.out.println(merge.node_value);
            merge=merge.next;
        }
    }

    static LinkNode<Integer> Merge(LinkNode<Integer> head1, LinkNode<Integer> head2) {
        LinkNode<Integer> mergeLinkListHead = null;
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.node_value < head2.node_value) {
            mergeLinkListHead = head1;
            mergeLinkListHead.next = Merge(head1.next, head2);
        } else {
            mergeLinkListHead = head2;
            mergeLinkListHead.next = Merge(head1, head2.next);
        }

        return mergeLinkListHead;
    }

}
