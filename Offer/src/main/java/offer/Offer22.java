package offer;

/**
 * 输入一个链表，输出该链表中倒数第K个结点。为了符合大多数人的习惯，
 * 从1开始计数，即链表的尾结点是倒数第一个结点。
 * 例如一个链表有6个结点，从头结点开始它们的值依次是1、2、3、4、5、6.这个链表的倒数第三个结点是值为4的结点。
 */
public class Offer22 {
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
        int K = 5;
        System.out.println(deleteOnK(LinkNode, K));
    }

    /**
     * 指针1 先走k步  指针2位于开始位置  当1走到尾  2就是k
     *
     * @param linkNode
     * @return
     */
    private static int deleteOnK(LinkNode<Integer> linkNode, int K) {
        if(linkNode==null||K==0){
            return 0;
        }
        LinkNode<Integer> firstK = linkNode;
        LinkNode<Integer> last = null;
        for (int i = 0; i < K - 1; i++) {
            if(firstK.next==null){
                return 0;
            }
            firstK = firstK.next;
        }
        last=linkNode;
        while (firstK.next != null) {
            last = last.next;
            firstK = firstK.next;
        }
        return last.node_value;
    }
}

/**
 * 模拟链表数据结构
 *
 * @param <E>
 */
class LinkNode<E> {
    LinkNode<Integer> next;
    E node_value;
}