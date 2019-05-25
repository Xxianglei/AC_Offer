package offer;

/**
 * 礼物的最大值
 */
public class Offer47 {
    public static void main(String[] args) {

    }

    /**
     * 辅助数组不用和m*n的二维数组一样大，只需要保存上一层的最大值就可以。
     * 代码中使用长度为列数n的一位数组作为辅助数组，注释部分为二维辅助数组。
     * @param values
     * @return
     */
    public static int maxValueOfGifts(int[][] values) {
        if (values == null || values.length <= 0 || values[0].length <= 0)
            return 0;
        int rows = values.length;
        int cols = values[0].length;
//      int[][] maxValue=new int[rows][cols];
        int[] maxValue = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0)
//                  up=maxValue[i-1][j];
                    up = maxValue[j];
                if (j > 0)
//                  left=maxValue[i][j-1];
                    left = maxValue[j - 1];
//              maxValue[i][j]=Math.max(up, left)+values[i][j];
                maxValue[j] = Math.max(up, left) + values[i][j];
            }
        }
//      return maxValue[rows-1][cols-1];
        return maxValue[cols - 1];
    }
}
