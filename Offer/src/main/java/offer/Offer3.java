package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * 找出所有重复的  每个元素范围都在0~n-1
 */
public class Offer3 {
    static int nums[] = {2, 3, 1, 0, 2, 5, 3};

    public static void main(String[] args) {
        // System.out.println(findRe(nums));
        //System.out.println(findReHash(nums));
        findRe2(nums);

    }
    /**
     * 排序+暴力搜索
     *
     * @param nums
     * @return
     */
    public static String findRe(int nums[]) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                stringBuilder.append("重复数字" + nums[i]);
            } else {
                continue;
            }
        }
        return stringBuilder.toString();
    }

    /**
     * hash 解决
     *
     * @param nums
     * @return
     */
    private static String findReHash(int[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            if (map.get(key) > 1) {
                stringBuilder.append("重复数字" + key);
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 优化
     * 2, 3, 1, 0, 2, 5, 3
     * 0  1  2  3  4  5  6
     * @param nums
     * @return
     */
    private static void findRe2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {          // 一次判断
                int temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
                if (nums[i] == nums[nums[i]]) {      //二次判断
                    System.out.println("重复数字" + nums[i] );
                    break;
                }
            }
        }

    }

}
