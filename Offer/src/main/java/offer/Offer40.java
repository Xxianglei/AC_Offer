package offer;

import java.util.Arrays;

/**
 * 最小的K个数
 * 输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Offer40 {
    public static void main(String[] args) {
        int nums[] = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 5;
        /**
         * 排序后找
         */
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            System.out.println(nums[i]);
        }

    }


}
