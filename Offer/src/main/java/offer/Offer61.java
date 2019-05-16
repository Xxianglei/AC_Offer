package offer;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。其中A为1，J为11，Q为12，K为13，而大小王为0，且大小王能够当做任意一张牌。
 */
public class Offer61 {
    public static void main(String[] args) {
        int nums[] = {1, 0, 2, 0, 3,7};
        System.out.println(isContinuous(nums));
    }

    static boolean isContinuous(int nums[]) {
        // 1. 排序
        Arrays.sort(nums);
        int length = nums.length;
        int zeornum = 0;
        int gapnum = 0;
        // 找零个数  找间隔数
        int jianju[] = new int[length];
        for (int i = 0; i < length-1; i++) {
            if (nums[i] == 0) {
                zeornum++;
                continue;
            }
            if(nums[i]==nums[i+1]&&nums[i]!=0&&nums[i+1]!=0){
                return false;
            }
            if(nums[1+i]-nums[i]!=1){
                gapnum++;
                jianju[i]=nums[1+i]-nums[i]-1;
            }

        }
        for (int i = 0; i <length ; i++) {
            if(jianju[i]>zeornum){
                return false;
            }
        }
        if(gapnum>zeornum){
            return false;
        }else {
            return true;
        }
    }
}
