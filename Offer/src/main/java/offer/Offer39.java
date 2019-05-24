package offer;

/**
 * 数组中出现次数超过一半的数字
 * 数组中一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为 9 的数组{1,2,3,2,2,2,5,4,2}。由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2.
 */
public class Offer39 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(findMoreHalf(nums));
    }

    /**
     * O(n)
     * @param nums
     * @return
     */
    static int findMoreHalf(int nums[]) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int tag = 1;
        int result=nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            int curent = nums[i];
            if (tag == 0) {
                result= nums[i];
                tag = 1;
            }
            if (curent == nums[i + 1]) {
                tag++;
            } else {
                tag--;
            }

        }
        return result;
    }

}
