package offer;

import static java.lang.StrictMath.pow;

/**
 * 剪绳子
 */
public class Offer14 {
    public static void main(String[] args) {
        int length = 10;
        System.out.println(maxProductAfterCuttingTtoD(length));
        System.out.println(maxProductAfterCuttingDtoT(length));
        System.out.println(maxProductAfterCuttingActive(length));
    }


    /**
     * 从上到下动态规划
     *
     * @return
     */
    static int maxProductAfterCuttingTtoD(int length) {
        int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int i = 4;
        while (i <= length) {
            int j = 1;
            while (j <= i / 2) {
                if (a[j] * a[i - j] > a[i])
                    a[i] = a[j] * a[i - j];
                j++;
            }
            i++;
        }
        return a[length];
    }

    /**
     * 从下到上动态规划
     *
     * @param length
     */
    private static int maxProductAfterCuttingActive(int length) {
        if (length < 2) return 0;
        else if (length == 2) return 1;
        else if (length == 3) return 2;
        else if (length >= 4) {
            int product[] = new int[length + 1];
            product[0] = 0; //这个其实写不写都行，后面的代码也用不到这个
            product[1] = 1; //这个也用不到
            product[2] = 2; //这里的 2 指的是剩下了一段长度为 2 的绳子，可以不剪
            product[3] = 3; //这里的 3 指的是剩下了一段长度为 3 的绳子，可以不剪
            /**
             * 方便后面第二个for循环计算最大值
             */
            int max = 0;
            for (int i = 4; i <= length; ++i) {
                max = 0;
                for (int j = 2; j <= i / 2; ++j) //从 2 开始比较
                {
                    if (max < product[j] * product[i - j])
                        max = product[j] * product[i - j]; //比较出最大的那个情况
                }
                product[i] = max; //记录下来
            }
            return product[length]; //这个时候从 0 到 n 的最优情况都记录下来了

        }
        return 0;
    }


    /**
     * 贪心算法
     *
     * @param length
     */
    private static int maxProductAfterCuttingDtoT(int length) {

        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int timesOf3 = length / 3;    //剪长度为3的绳子 段数
        if ((length - timesOf3 * 3) == 1)   //当长度为4的时候不能去用3剪
            timesOf3 = timesOf3 - 1;
        int timesOf2 = (length - timesOf3 * 3) / 2;     // 这时应该把绳子剪成长度为2的两段：2*2>1*3
        return ((int) (pow(3, timesOf3)) * ((int) pow(2, timesOf2)));

    }


}
