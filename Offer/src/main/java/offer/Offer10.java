package offer;

/**
 * 写一个函数，输入n，求斐波那契数列的第n项，斐波那契数列的定义如下： n=0,f(n)=0 ;n=1,f(n)=1 n>1;f(n)=f(n-1)+f(n-2).
 */
public class Offer10 {

    public static void main(String[] args) {
        System.out.println("low:"+LowFibonacci(3));
        System.out.println("high:"+HFibonacci(3));
    }

    public static int LowFibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return LowFibonacci(n - 1) + LowFibonacci(n - 2);
    }

    /**
     * 效率高  减少重复计算
     *
     * @param n
     * @return
     */
    public static int HFibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int one = 0;
        int two = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = one + two;
            two=fib;
            one=two;
        }
        return fib;
    }
}
