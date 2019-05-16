package offer;

/**
 * 和为s的数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s，如果有多对数字的和等于s，输出任意一对即可。
 */
public class Offer57 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 4, 7, 11, 15};
        findNumberWithSum(nums, 15);
    }

    static void findNumberWithSum(int nums[], int s) {
        if (nums == null || s <= 0 || nums.length < 1) {
            return;
        }
        int small = 0;
        int big = nums.length - 1;
        while (small < big) {
            int sum = nums[small] + nums[big];
            if(sum<s){
                small++;
            }
            if(sum>s){
                big--;
            }
            sum=nums[small]+nums[big];
            if(sum==s){
                System.out.println(nums[small]+"-"+nums[big]);
                break;
            }
        }
    }
}
