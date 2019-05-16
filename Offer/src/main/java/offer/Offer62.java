package offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字(约瑟夫环问题)
 * 题目：0, 1, … , n-1 这 n 个数字排成一个圈圈，从数字 0 开始每次从圆圏里删除第 m 个数字。
 * 求出这个圈圈里剩下的最后一个数字。
 */
public class Offer62 {
    public static void main(String[] args) {
        System.out.println(lastRemaining(20, 3));
    }

    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // 要删除元素的位置
        int delIndex = 0;
        while (list.size() > 1) {
            // 只要移动m-1次就可以移动到下一个要删除的元素上
            for (int i = 1; i < m; i++) {
                delIndex = (delIndex + 1) % list.size();
            }
            list.remove(delIndex);
        }
        return list.get(0);
    }
}
