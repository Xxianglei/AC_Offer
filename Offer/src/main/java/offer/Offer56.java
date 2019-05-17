package offer;

/**
 * 数组中数字出现的次数
 * 数组中只出现一次的两个数字
 * 统计一个数字在数组中出现的次数。例如输入排序数组{2,4,3,6,3,2,5,5}  4 6
 */
public class Offer56 {
    public static void main(String[] args) {
        int nums[] = {2, 4, 3, 6, 3, 2, 5, 5};
        findAppearOnce(nums);
    }

    /**
     * 设法将只出现一次的数据分别放入两个数组  再对两个数组做异或运算
     *
     * @param nums
     */
    static void findAppearOnce(int nums[]) {

        if (nums == null || nums.length < 2) {
            return;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        int findFirstOne = 0;
        // 找到最后一个为1的位置
        while ((result & 1) == 0 && findFirstOne < 32) {
            result = result >> 1;
            findFirstOne++;
        }
        // 分两部分数组分别做循环与运算  最后剩下的就是单独的
        int tag1 = 0, tag2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] >> findFirstOne & 1) == 0) {
                tag1 ^= nums[i];
            } else {
                tag2 ^= nums[i];
            }
        }

        System.out.println(tag1+"---"+tag2);
    }
}
