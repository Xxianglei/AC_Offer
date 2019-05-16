package offer;

/**
 * 股票的最大利润
 * 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能获得最大的利润为11.
 */
public class Offer63 {
    public static void main(String[] args) {
        int nums[] = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(maxDiff(nums));
    }

    static int maxDiff(int nums[]) {
        if (nums == null) {
            return 0;
        }
        // 最小买入
        int minbugIn = nums[0];
        //当前利润
        int maxDiff = nums[1] - minbugIn;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i-1] < minbugIn) {
                minbugIn = nums[i];
            }
            int currentDiff=nums[i]-minbugIn;
            if(currentDiff>maxDiff){
                maxDiff=currentDiff;
            }
        }
        return maxDiff;
    }

}
