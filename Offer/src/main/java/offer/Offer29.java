package offer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺组依次打印出每一个数字。
 */
public class Offer29 {
    public static void main(String[] args) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int nums[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printNums(result, nums, nums.length, nums[0].length);
    }

    static void printNums(ArrayList<Integer> result, int num[][], int cols, int rows) {
        if (num == null || cols <= 0 || rows <= 0) {
            return;
        }
        int start = 0;
        while (cols > 2 * start && rows > 2 * start) {
            corePrint(result, num, cols, rows, start);
            ++start;
        }
    }

    private static void corePrint(ArrayList<Integer> result, int[][] num, int cols, int rows, int start) {
        int endY = cols - 1 - start;
        int endX = rows - 1 - start;
        //从左到右
        for (int i = start; i <= endX; i++) {
            result.add(num[start][i]);
        }
        // 从上到i下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                result.add(num[i][endX]);
            }
        }
        // 从右到左
        if (start < endX && start < endY) {
            for (int i = endX-1; i >= start; i--) {
                result.add(num[endY][i]);
            }
        }
        // 从下到上
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                result.add(num[i][start]);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
