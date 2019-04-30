package offer;

/**
 * 二维数组查找 左到右变大  上到下变大  找右上角  小与列则删一列大于列则删一行
 */
public class Offer4 {
    /*
     * 1  2  8  9
     * 2  4  9  12
     * 4  7  10 13
     * 6  8  11 15
     */
    public static void main(String[] args) {
        int array[][] = new int[4][4];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 8;
        array[0][3] = 9;
        array[1][0] = 2;
        array[1][1] = 4;
        array[1][2] = 9;
        array[1][3] = 12;
        array[2][0] = 4;
        array[2][1] = 7;
        array[2][2] = 10;
        array[2][3] = 13;
        array[3][0] = 6;
        array[3][1] = 8;
        array[3][2] = 11;
        array[3][3] = 15;
        System.out.println(find(array, 7));
        System.out.println(find(array, 5));
    }

    private static boolean find(int[][] arr, int keyNumber) {
        if (arr.length == 0) {
        } else {
            int column = arr[0].length - 1;     // 列  最右的那列
            int row = 0;                        // 行
            while (column >= 0 && row < arr.length) {
                if (arr[row][column] == keyNumber) {
                    return true;
                } else if (arr[row][column] > keyNumber) {
                    column--;
                } else {
                    row++;
                }
            }
        }
        return false;
    }


}
