package offer;

import java.util.Arrays;

public class Offer12 {
    public static void main(String[] args) {
        char nums[][] = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
        int rows = nums.length;
        int cols = nums[0].length;
        char startch[] = {'b', 'f', 'c', 'h'};

        boolean tag = hashPath(nums, rows, cols, startch);
        if (tag) {
            System.out.println("存在路径");
        } else {
            System.out.println("不存在路径");
        }

    }

    static boolean hashPath(char nums[][], int rows, int cols, char startch[]) {

        if (nums == null || rows <= 1 || cols <= 1 || startch == null) {
            return false;
        }
        boolean visited[] = new boolean[rows * cols];
        Arrays.fill(visited, false);
        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hashPathCore(nums, i, j, rows, cols, startch, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hashPathCore(char[][] nums, int row, int col, int rows, int cols, char[] startch, int pathLength, boolean[] visited) {
        if (pathLength>startch.length-1 ) {
            return true;
        }
        boolean hasPath = false;
        if (row < rows && col < cols && col >= 0 && row >= 0 && nums[row][col] == startch[pathLength] && !visited[row * cols + col]) {
            ++pathLength;
            visited[row * cols + col] = true;
            hasPath = hashPathCore(nums, row - 1, col, rows, cols, startch, pathLength, visited)
                    || hashPathCore(nums, row + 1, col, rows, cols, startch, pathLength, visited)
                    || hashPathCore(nums, row, col - 1, rows, cols, startch, pathLength, visited)
                    || hashPathCore(nums, row, col + 1, rows, cols, startch, pathLength, visited);
            if (!hasPath) {
                --pathLength;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }
}
