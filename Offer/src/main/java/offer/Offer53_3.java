package offer;

/**
 * 数组中数值和下标相等的元素
 */
public class Offer53_3 {
    public static void main(String[] args) {
        int nums[] = {-3, -1, 1, 3, 5};
        //System.out.println(getMissingNum(nums));
        System.out.println(getMissingNumH(nums));
    }

    private static int getMissingNumH(int[] arr) {
        if (arr == null || arr.length <= 0)
            return -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] == mid) {
                return mid;
            }
            if (arr[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
