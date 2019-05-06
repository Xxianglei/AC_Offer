package offer;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如把9表示成二进制是1001，有2位是1 因此如果输入9，该函数输出2;
 */
public class Offer15 {
    public static void main(String[] args) {
        int nums = 9;
      System.out.println(NumBerOf1(nums));
        //  System.out.println(HNumBerOf1(nums));
    }
    // 可能引起死循环的解法1
    public static int numberof1_1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    /**
     * 常规写法  将1 来左移 与原数据按位做与运算
     * 32位 左移32次  因为int占4字节  也就是32位
     *
     * @param n
     * @return
     */
    static int NumBerOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            System.out.println((n & flag));
            if ((n & flag) != 0) {

                count++;
            }
            flag = flag << 1;
        }

        return count;
    }

    /**
     * 减1后与运算 直到等于0
     * @param n
     * @return
     */
    static int HNumBerOf1(int n) {
        int count = 0;
        while (n != 0) {
           ++count;
           n=(n-1)&n;
        }

        return count;
    }

}
