package offer;

/**
 * 第一个只出现一次的字符
 */
public class Offer50 {
    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(FirstNotRepeatingChar(s));
    }

    /**
     * 1. 暴力法  不写了  O（n^2）
     * 2. hash  O(1) O(n)
     *
     * @param str
     * @return
     */
    public static char FirstNotRepeatingChar(String str) {
        if (str == " ") {
            return ' ';
        }
        char[] array = str.toCharArray();
        int size = 256;
        // 借助数组来模拟哈希表，只用1K的空间消耗
        int[] hastTable = new int[size];
        // 初始化数组
        for (int i = 0; i < size; i++) {
            hastTable[i] = 0;
        }

        for (int i = 0; i < array.length; i++) {
            hastTable[array[i]]++;
        }

        for (int i = 0; i < array.length; i++) {
            if (hastTable[array[i]] == 1) {
                return array[i];

            }
        }
        return ' ';
    }
}
