package offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 复杂链表的复制
 */
public class Offer35 {
    public static void main(String[] args) {
        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        ComplexListNode node3 = new ComplexListNode(3);
        ComplexListNode node4 = new ComplexListNode(4);
        ComplexListNode node5 = new ComplexListNode(5);
        node1.pNext = node2;
        node2.pNext = node3;
        node3.pNext = node4;
        node4.pNext = node5;
        node5.pNext = null;
        node1.pSibling = node3;
        node2.pSibling = node5;
        node4.pSibling = node2;
        CloneNodes(node1);
        // CloneNodes2(node1);
    }

    /**
     * 基于On空间复杂度
     */
    static void CloneNodes(ComplexListNode head) {
        ComplexListNode currNode = head;
        ComplexListNode copyNode = null;
        HashMap<ComplexListNode, ComplexListNode> nodesMap = new HashMap<ComplexListNode, ComplexListNode>();
        while (currNode != null) {
            copyNode = new ComplexListNode(currNode.node_value);
            nodesMap.put(currNode, copyNode);
            // System.out.println(currNode.node_value + "-" + copyNode.node_value);
            copyNode.pNext = currNode.pNext;
            currNode = currNode.pNext;
        }
        Set<Map.Entry<ComplexListNode, ComplexListNode>> entries = nodesMap.entrySet();
        for (Map.Entry<ComplexListNode, ComplexListNode> entry : entries) {
            //   System.out.println(entry.getKey().node_value);
            if (entry.getKey().pSibling != null) {
                //  System.out.println(entry.getKey().pSibling.node_value);
                ComplexListNode newSib = nodesMap.get(entry.getKey().pSibling);
                if (newSib != null) {
                    entry.getValue().pSibling = newSib;
                    System.out.println(entry.getValue().node_value + "->" + newSib.node_value);
                }
            }
        }
    }

    /**
     * 基于On时间复杂度
     */
    static void CloneNodes2(ComplexListNode head) {
        /**
         * 复制节点同时连接到当前节点下一个
         */
        ComplexListNode currNode = head;
        ComplexListNode copyNode = null;
        while (currNode != null) {
            copyNode = new ComplexListNode(currNode.node_value);
            copyNode.pNext = currNode.pNext;
            copyNode = currNode.pNext;
            currNode = copyNode.pNext;
        }
        /**
         * 确定Sibling的指向
         */
        ComplexListNode currNode2 = head;
        while (currNode2 != null) {
            ComplexListNode copyNode2 = currNode2.pNext;
            if (copyNode2.pSibling != null) {
                copyNode2.pSibling = copyNode2.pSibling.pNext;
            }
            copyNode2 = copyNode2.pNext;
        }
        /**
         * 裁断链表
         */
        ComplexListNode currNode3 = head;
        ComplexListNode copyNodeHead = null;
        ComplexListNode copyNode3 = null;
        if (currNode3 != null) {
            copyNodeHead = copyNode3 = currNode3.pNext;  // 第二个  偶数位
            currNode3.pNext = copyNode3.pNext;   //
            copyNode3 = currNode3.pNext;           //
        }
        while (copyNode3 != null) {
            copyNodeHead.pNext = copyNode3.pNext;
            copyNode3 = copyNodeHead.pNext;
            copyNode3.pNext = copyNodeHead.pNext;
            copyNode3 = currNode3.pNext;
        }
    }
}
/**
 * 链表类
 */
class ComplexListNode {
    int node_value;
    ComplexListNode pNext;
    ComplexListNode pSibling;

    ComplexListNode(int node_value) {
        this.node_value = node_value;
        pNext = null;
        pSibling = null;
    }
}