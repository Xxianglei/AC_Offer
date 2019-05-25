package offer;

/**
 * 数字序列中某一位的数字
 */
public class Offer44 {
    public static void main(String[] args) {
        String num = "01234567891011121314151617181920";
        System.out.println(findNumber(num, 19));
    }

    /**
     * 无脑比对
     * 0-9 位数求和-->10   10-20 位数求和--->20         如求第11位   11是二位数 只有理论上应该是10+1 但是目前10+2
     * 时间复杂O（n）
     *
     * @param num
     * @return
     */
    static char findNumber(String num, int n) {
        int temp = n;
        int index2 = 1;
        int sum = 1;
        for (int i = 0; i < temp; i++) {
            while (i > 0) {
                i = i / 10;
                index2++;         //计算当前n的位数
            }
            if (sum > temp) {
                sum = sum - 1;
                break;
            }
            sum += index2;
            index2 = 0;
        }
        return num.charAt(sum);
    }
}
