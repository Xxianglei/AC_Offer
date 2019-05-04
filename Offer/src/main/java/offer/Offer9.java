package offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数appendTail和deleteHead,
 * 分别完成在队列尾部插入结点和在队列头部删除结点的功能
 */
public class Offer9 {
    static Stack<String> stack1 = new Stack<String>();
    static Stack<String> stack2 = new Stack<String>();

    public static void main(String[] args) {
        Offer9.appendTail("xl");
        for (int i = 1; i <= 10; i++) {
            appendTail(i + "");
        }
        System.out.println(Offer9.deleteHead());
    }

    public static void appendTail(String string) {
        stack1.push(string);
    }

    public static String deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
