package offer;

/**
 * n+1数组里面  范围都在1~n     如 8 {2, 3, 5, 4, 3, 2, 6,7} 找出任意一个重复数字
 */
public class Offer3_2 {
    static int nums[] = {2, 3, 5, 4, 3, 2, 5, 7};

    public static void main(String[] args) {
        findRe1(nums);
    }

    /**
     * 开辟新数组  存入对应值对应为  判断是否存在  存在则重复
     *
     * @param nums
     */
    private static void findRe1(int[] nums) {
        int newnums[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (newnums[nums[i]] != nums[i]) {
                newnums[nums[i]] = nums[i];
            } else {
                System.out.println("重复数字" + nums[i]);
            }
        }
    }

}
