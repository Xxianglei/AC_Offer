package offer;

import java.util.Stack;

/**
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值.
 * 1.借助栈结构实现
 * 2.借助递归算法 去查询每一个节点的下一个节点  直到查到位置
 */
public class Offer6 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //输入的链表有多个结点
        Offer6 linkedOffer6 = new Offer6();
        LinkNode<Integer> node1 = new LinkNode<Integer>();
        LinkNode<Integer> node2 = new LinkNode<Integer>();
        LinkNode<Integer> node3 = new LinkNode<Integer>();
        node1.node_value = 1;
        node2.node_value = 2;
        node3.node_value = 3;
        node1.next = node2;
        node2.next = node3;
        /**
         * 1.借助栈实现
         */
        // linkedOffer6.revers(node1);

        /**
         * 递归实现
         */
        linkedOffer6.revers2(node1);

    }

    public static void revers(LinkNode<Integer> linkNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while (linkNode != null) {
            stack.push(linkNode.node_value);
            linkNode = linkNode.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

    }

    public static void revers2(LinkNode<Integer> linkNode) {
        if (linkNode!=null) {
            if (linkNode.next != null) {
                revers2(linkNode.next);
            }
            System.out.println(linkNode.node_value);
        }
    }

    /**
     * 模拟链表数据结构
     *
     * @param <E>
     */
    static class LinkNode<E> {
        LinkNode<E> next;
        E node_value;
    }
}
