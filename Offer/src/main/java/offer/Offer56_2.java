package offer;

/**
 * 数组中唯一个出现一次的数字，
 * 除此之外其他数字都出现了三次
 */
public class Offer56_2 {
    public static void main(String[] args) {
        int nums[] = {2, 4, 3, 2, 3, 2, 3};
        System.out.println(findAppearOnce(nums));
    }

    private static int findAppearOnce(int[] arr) {
        if (arr == null || arr.length < 4) {
            return 0;
        }
        int[] bitSum = new int[32];
        // 求每一位的和
        for (int i = 0; i < arr.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = arr[i] & bitMask;  //注意arr[i]&bitMask不一定等于1或者0，有可能等于00010000
                if (bit != 0)
                    bitSum[j] += 1;
                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {

            result = result << 1;
            result += (bitSum[i] % 3);

        }
        return result;

    }
}
