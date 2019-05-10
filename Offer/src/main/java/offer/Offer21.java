package offer;

/**
 * 使计数位于偶数前面
 */
public class Offer21 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 5, 8, 13, 6, 11};
        OrderNums(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    static void OrderNums(int[] nums) {
        // 起始和尾部指针
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            //  第一个指针往后 直到遇到一个偶数
            while ((start < end) && (nums[start] & 0x1) != 0) {
                start++;
            }
            // 第二个指针往前 直到遇到一个奇数
            while ((start < end) && (nums[end] & 0x1) == 0) {
                end--;
            }
            if (start < end) {
                int temp = 0;
                temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }

    }
}
