package offer;

/**
 * 把数字翻译成字符串
 */
public class Offer46 {
    public static void main(String[] args) {
        //给定一个数字，我们按照如下规则把它翻译成字符串：0->a 1->b ... 25->z。问一个数字可能有多少种翻译？
        int n = 12258;
        System.out.println(getTranslationCount(n));
    }

    //功能函数部分
    public static int getTranslationCount(int n) {
        //思路：例如给定12258为例 我们有两种不同的选择来翻译第一个数字1,。第一种选择是数字1单独翻译成b 或者和第2个数字一起翻译，如果两者合并>=10&&<=25的话
        //剩下的就是对后面的进行递归
        //我们使用f(i)来表示第i位数字开始的不同翻译的数目。f(i)=f(i+1)+g(i,i+1)*f(i+2)。当两者合并满足翻译条件时 g(i,i+1)=1,否则为0

        if (n < 0) return 0;
        String ns = String.valueOf(n);
        return translation(ns);
    }

    public static int translation(String ns) {
        if (Integer.parseInt(ns) < 0) {
            return 0;
        }
        int len = ns.length();
        int[] sum = new int[ns.length()];
        int count = 0;
        //从后往前递归查找
        for (int i = ns.length() - 1; i >= 0; i--) {

            //如果当前处理的不是最后一位
            count = 0;
            if (i < ns.length() - 1) {
                count = sum[i + 1];
            } else {
                //最后一个
                count = 1;
            }

            //两位数可以合并
            if (i < ns.length() - 1) {
                //合并
                int first = ns.charAt(i) - '0';
                int second = ns.charAt(i + 1) - '0';
                int combine = first * 10 + second;

                //判断合并后的数字
                if (combine >= 10 && combine <= 25) {
                    if (i < ns.length() - 2) {
                        //位于倒数第二位左边           /当前位与当前位的前一位当成一位数字来算，所以cont要加i+2的值
                        count += sum[i + 2];
                    } else {
                        count += 1;
                    }
                }
            }
            sum[i] = count;
        }
        return sum[0];
    }


}
