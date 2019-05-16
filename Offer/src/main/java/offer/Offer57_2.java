package offer;

/**
 * 和为s的连续正数序列
 * 输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1-5,，4-6和7-8.
 */
public class Offer57_2 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8};
        findContinuous(nums, 15);
    }

    static void findContinuous(int nums[], int s) {
        if (nums == null || s <= 0 || nums.length < 1) {
            return;
        }
        int small = 1;
        int big = 2;
        int currsum = 3;
        int mid = (1 + s) / 2;
        while (small < mid) {
            if (currsum == s) {
                for (int i = small; i <= big; i++) {
                    System.out.print(i);
                }
                System.out.println();
            }
            while (currsum > s && small < mid) {
                currsum -= small;
                small++;
                if (currsum == s) {
                    for (int i = small; i <= big; i++) {
                        System.out.print(i);
                    }
                    System.out.println();
                }
            }
            big++;
            currsum += big;
        }
    }
}
