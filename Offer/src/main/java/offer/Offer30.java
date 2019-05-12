package offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push以及pop的时间复杂度为O(1)
 */
public class Offer30 {
    static Stack<Integer> useStack = new Stack<Integer>();
    static Stack<Integer> withStack = new Stack<Integer>();

    public static void main(String[] args) {
        Offer30.push(3);
        Offer30.push(4);
        Offer30.push(2);
        Offer30.push(1);
        Offer30.push(0);
        System.out.println(min());
        System.out.println(min());
        System.out.println(min());
        System.out.println(min());
    }

    static int min() {
        return myPop();
    }

    static void push(int n) {
        useStack.push(n);
        if (withStack.empty()) {
            withStack.push(n);
            return;
        }
        if (n <= withStack.peek()) {
            withStack.push(n);
        } else {
            withStack.push(withStack.peek());
        }

    }

    static int myPop() {
        if (!withStack.empty() && !useStack.empty()) {
            return withStack.pop();
        }
        return 0;
    }
}
