package offer;

/**
 * 打印1-n的最大n为数
 */
public class Offer17 {
    public static void main(String[] args) {
        int n = 3;
        //PrintMax(n);
        PrintMax2(n);
    }


    /**
     * 先求出最大的n位数再打印
     * 大数情况下存在溢出的问题
     *
     * @param n
     */
    private static void PrintMax(int n) {
        int result = 1;
        int i = 0;
        while (i++ < n) {
            result *= 10;
        }
        for (i = 1; i < result; i++) {
            System.out.println(i);
        }
    }

    /**
     * 使用递归思想 为每一位进行排序  直到个位条件结束
     *
     * @param
     */
    private static void PrintMax2(int n) {
        if (n <= 0) {
            return;
        }
        char number[] = new char[n + 1];
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i+'0');
            Next(number, n, 0);
        }

    }

    private static void Next(char[] number, int lenght, int index) {
        int nowIndex=index + 1;
        if (index == lenght - 1) {
            PrintNumber(number);
        } else {
            for (int i = 0; i < 10; i++) {
                number[nowIndex] = (char) (i+'0');
                Next(number, lenght,nowIndex );
            }
        }
    }

    private static void PrintNumber(char[] number) {
        boolean start = true;
        for (int i = 0; i < number.length; i++) {
            if (start) {
                if (number[i] != '0') {
                    start = false;
                }
            } else {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

}
