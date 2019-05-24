package offer;

/**
 * 丑数
 * 我们把只包含因子2、3和5的数称作丑数（Ugly Number）。求按从小到大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7。习惯上我们把1当做第一个丑数。
 * 求从小到大第1500个丑数
 */
public class Offer49 {
    public static void main(String[] args) {
        System.out.println(getAllNumber(1500));
    }

    static boolean isUglyNumber(int num) {
        while (num % 2 == 0) {
            num = num >> 1;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return (num == 1) ? true : false;
    }

    static int getAllNumber(int num) {
        if (num <= 0) {
            return 0;
        }
        int number = 0;
        int ugly = 0;
        while (ugly < num) {
            number++;
            if (isUglyNumber(number)) {
                ugly++;

            }
        }

        return number;
    }
}
