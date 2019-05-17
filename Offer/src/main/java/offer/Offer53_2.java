package offer;

/**
 * 0-n-1中缺失的数字
 */
public class Offer53_2 {
    public static void main(String[] args) {
        int nums[] = {0, 1, 2, 3, 4, 5, 6, 8, 9, 10};
        //System.out.println(getMissingNum(nums));
        System.out.println(getMissingNumH(nums));
    }


    /**
     * 一般  O（n）
     *
     * @param nums
     * @return
     */
    private static int getMissingNum(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int sum1 = 0;
        int sum2 = (nums[0] + nums[nums.length - 1]) * (nums.length + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
        }
        return sum2 - sum1;
    }

    /**
     * 改良
     * {0, 1, 2, 3, 4, 5, 7, 8, 9, 10}
     *
     * @param arr
     * @return
     */
    private static int getMissingNumH(int[] arr) {
        if (arr == null || arr.length <= 0)
            return -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (arr[mid] != mid) {
                if (mid == 0 || arr[mid - 1] == mid - 1)
                    return mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
