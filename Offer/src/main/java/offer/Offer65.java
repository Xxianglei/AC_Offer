package offer;

/**
 * 不用加减乘除做加法
 */
public class Offer65 {
    public static void main(String[] args) {
        int sum, carry;
        int num1, num2;
        num1 = 50;
        num2 = 7;
        do {
            sum = num1 ^ num2;                          //相加不进位 异或
            carry = (num1 & num2) << 1;                   // 同1才产生进位 产生进位  记下
            num1 = sum;                               // 两数相加 循环重复  直到不产生 进位
            num2 = carry;
        }
        while (num2 != 0);
        System.out.printf(String.valueOf(num1));
    }
}
