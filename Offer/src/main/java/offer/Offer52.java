package offer;

import java.util.Stack;

/**
 * 两个链表的第一个公共节点
 */
public class Offer52 {
    public static void main(String[] args) {
        LinkNode<Integer> LinkNode = new LinkNode<Integer>();
        LinkNode<Integer> LinkNode2 = new LinkNode<Integer>();
        LinkNode<Integer> node2 = new LinkNode<Integer>();
        LinkNode<Integer> node3 = new LinkNode<Integer>();
        LinkNode<Integer> node4 = new LinkNode<Integer>();
        LinkNode<Integer> node5 = new LinkNode<Integer>();
        LinkNode<Integer> node6 = new LinkNode<Integer>();
        LinkNode.node_value = 1;
        LinkNode.next = node2;
        node2.node_value = 2;
        node2.next = node3;
        node3.node_value = 3;
        node3.next = node4;
        node4.node_value = 6;
        node4.next = node5;
        node5.node_value = 7;
        node5.next = null;

        LinkNode2.node_value = 4;
        LinkNode2.next = node6;
        node6.node_value = 5;
        node6.next = node4;

        findFirstPublicNode(LinkNode, LinkNode2);
    }

    private static void findFirstPublicNode(LinkNode<Integer> linkNode, LinkNode<Integer> linkNode2) {
        if (linkNode == null || linkNode2 == null) {
            return;
        }
        // System.out.println(findFirstPublicNodeBaoLi(linkNode, linkNode2).node_value);
        //System.out.println(findFirstPublicNodeStack(linkNode, linkNode2).node_value);
        System.out.println(findFirstPublicNodeHigh(linkNode, linkNode2).node_value);


    }


    /**
     * 暴搜
     *
     * @param linkNode
     * @param linkNode2
     */
    private static LinkNode findFirstPublicNodeBaoLi(LinkNode<Integer> linkNode, LinkNode<Integer> linkNode2) {
        LinkNode head1 = linkNode;
        LinkNode head2 = linkNode2;
        while (head1.next != null) {
            while (head2.next != null) {
                if (head1.node_value == head2.node_value) {
                    return head1;
                } else {
                    head2 = head2.next;
                }
            }
            head2 = linkNode2;
            head1 = head1.next;
        }
        return null;
    }

    /**
     * 利用辅助栈  先入后出特性 将数据逆序处理
     * 实现时间复杂度O（n+m）空间复杂度O（n+m）
     *
     * @param linkNode
     * @param linkNode2
     * @return
     */
    private static LinkNode findFirstPublicNodeStack(LinkNode<Integer> linkNode, LinkNode<Integer> linkNode2) {
        Stack<LinkNode> stack1 = new Stack<LinkNode>();
        Stack<LinkNode> stack2 = new Stack<LinkNode>();
        while (linkNode.next != null) {
            stack1.push(linkNode);
            linkNode = linkNode.next;
        }
        while (linkNode2.next != null) {
            stack2.push(linkNode2);
            linkNode2 = linkNode2.next;
        }
        LinkNode publicNode = null;
        while (!stack2.empty() && !stack2.empty()) {
            if (stack2.peek() == stack1.peek()) {
                stack1.pop();
                publicNode = stack2.pop();
            } else {
                break;
            }
        }
        return publicNode;
    }

    /**
     * 不开额外空间实现时间复杂度O（n+m）
     *
     * @param linkNode
     * @param linkNode2
     * @return
     */
    private static LinkNode findFirstPublicNodeHigh(LinkNode<Integer> linkNode, LinkNode<Integer> linkNode2) {
        int index1 = 0;
        int index2 = 0;
        int length = 0;
        LinkNode longLinked=null;
        LinkNode l1=linkNode;
        LinkNode l2=linkNode2;
        while (l1.next != null) {
            index1++;
            l1 = l1.next;
        }
        while (l2.next != null) {
            index2++;
            l2 = l2.next;
        }
        if (index1 > index2) {
            length = index1 - index2;
            longLinked=linkNode;
        } else {
            length = index2 - index1;
            longLinked=linkNode2;
        }
        for (int i = 0; i <length; i++) {
            longLinked=longLinked.next;
        }
        while (longLinked.next!=null){
              if(longLinked.node_value==linkNode2.node_value){
                  return longLinked;
              }else{
                  longLinked=longLinked.next;
                  linkNode2=linkNode2.next;
              }
        }

        return null;
    }
}
