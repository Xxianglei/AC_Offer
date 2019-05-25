package offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数字
 */
public class Offer45 {
    public static void main(String[] args) {
        int num[] = {3, 32, 321};
        PrintMinNumber(num);
    }

    /**
     * 若ab > ba 则 a > b
     * 若ab < ba 则 a < b
     * 若ab = ba 则 a = b
     * 解释说明：
     * a = 21
     * b = 2
     * 因为 212 < 221, 即 ab < ba ，所以 a < b
     * 所以我们通过对ab和ba比较大小，来判断a在前或者b在前的。
     *
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int[] numbers) {
        int len = numbers.length;
        if (len == 0)
            return "";
        if (len == 1)
            return String.valueOf(numbers[0]);
        StringBuffer res = new StringBuffer();
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });

        for (int i = 0; i < len; i++)
            res.append(str[i]);
        return res.toString();
    }
}
