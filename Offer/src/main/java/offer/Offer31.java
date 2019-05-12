package offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1/2/3/4/5是某栈的压栈序列，序列4/5/3/2/1是该压栈序列对应的一个弹出序列，
 * 但4/3/5/1/2就不可能是该压栈序列的弹出序列;
 */
public class Offer31 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};  // 入栈
        int[] array2 = {4, 5, 3, 2, 1};   // 出栈
        System.out.println(isPopOrder(array1, array2));
    }

    static boolean isPopOrder(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        for (int i = 0; i < array2.length; i++) {
            if (!stack.empty() && stack.peek() == array2[i]) {
                stack.pop();
            } else {
                if (index == array1.length) {
                    return false;
                } else {
                    do {
                        stack.push(array1[index++]);
                    }
                    while (stack.peek() != array2[i] && index != array1.length);
                    if (stack.peek() == array2[i])
                        stack.pop();
                    else
                        return false;
                }
            }
        }
        return true;
    }
}
