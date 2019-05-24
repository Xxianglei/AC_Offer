package offer;

/**
 * 1-n整数中1出现的次数
 * 最直观的是，对于1~n中的每个整数，分别判断n中的1的个数，具体见《剑指offer》。这种方法的时间复杂度为O(N*logN)，当N比较大的时候，一般会超时。
 */
public class Offer43 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(getAllOne(n));
    }

    static int getAllOne(int n) {
        if (n < 1) {
            return 0;
        }
        int num=0;
        for (int i = 1; i <= n; i++) {
            int temp=i;
            while (temp >0) {
                if ( temp % 10 == 1) {
                    num++;
                }
                temp = temp / 10;
            }
        }

        return num;
    }

}
