package offer;

/**
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数：
 * 如数组{7,5,6,4}，逆序对总共有5对，{7,5}，{7,6}，{7,4}，{5,4}，{6,4}；
 */
public class Offer51 {
    public static void main(String[] args) {
        int nums[] = {7, 5, 6, 4};
        InversePairs(nums);
    }

    /**
     * 大力出奇迹 时间复杂度O（n^2）
     * @param nums
     */
    static void InversePairs(int nums[]) {
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length  ; j++) {
                if(nums[i]>nums[j]){
                    System.out.println("{"+nums[i]+","+nums[j]+"}");
                }
            }
        }
    }
}
