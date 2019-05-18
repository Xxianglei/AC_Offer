package offer;

/**
 * 队列的最大值
 */
public class Offer59 {
    public static void main(String[] args) {
        int nums[] = {2, 3, 4, 2, 6, 2, 5, 1};
        findMaxInQueue(nums, 3);
    }

    /**
     * 暴力   时间复杂度O（nk）
     *
     * @param nums
     * @param K
     */
    static void findMaxInQueue(int nums[], int K) {
        if (nums == null) {
            return;
        }
        if (nums.length < 2) {
            System.out.println(nums[0]);
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int max = nums[i];
            for (int j = 1; j < K; j++) {
                if (max < nums[i + 1]) {
                    max = nums[i + 1];
                }
                i++;
            }
            i = i - 2;
            System.out.println(max);

        }
    }
}
