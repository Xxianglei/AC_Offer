package offer;

/**
 * 在排序数组中查找数字  统计一个数字在排序数组中出现的次数
 */
public class Offer53 {
    public static void main(String[] args) {
        int nums[] = {2, 2, 2, 2, 2, 2, 3, 5};
        int target = 2;
        System.out.println(GetNumberOfK(nums, target));
    }

    private static int GetFirstK(int[] data, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middIndex = (start + end) / 2;
        int middData = data[middIndex];

        if (middData == k) {
            if ((middIndex > 0 && data[middIndex - 1] != k) || middIndex == 0) {
                return middIndex;
            } else {
                end = middIndex - 1;
            }
        } else if (middData > k) {
            end = middIndex - 1;
        } else {
            start = middIndex + 1;
        }

        return GetFirstK(data, k, start, end);
    }

    private static int GetLastK(int[] data, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middIndex = (start + end) / 2;
        int middData = data[middIndex];

        if (middData == k) {
            if ((middIndex < data.length - 1 && data[middIndex + 1] != k) || middIndex == end) {
                return middIndex;
            } else {
                start = middIndex + 1;
            }
        } else if (middData > k) {
            end = middIndex - 1;
        } else {
            start = middIndex + 1;
        }

        return GetLastK(data, k, start, end);
    }

    public static int GetNumberOfK(int[] data, int k) {
        int number = 0;
        if (data != null && data.length > 0) {
            int first = GetFirstK(data, k, 0, data.length - 1);
            int last = GetLastK(data, k, 0, data.length - 1);

            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }
        return number;
    }
}
