package offer;

/**
 * 实现函数double power(double base,int exponent),求base的exponent次方。不能使用库函数，同时不需要考虑大数问题。
 */
public class Offer16 {
    public static void main(String[] args) {
       // System.out.println(power(2, 5));
      // System.out.println(power2(2, 0));
        System.out.println(power3(2, 5));
    }

    /**
     * 无脑版本  但是忽略了指数为负数的情况  和0^0
     *
     * @param base
     * @param exponent
     * @return
     */
    static double power(double base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }

    /**
     * 处理了  底数为0  指数为非正数的情况
     * @param base
     * @param exponent
     * @return
     */
    static double power2(double base, int exponent) {
        int absexponent = exponent;
        if (base - 0.0<0.000000001 && exponent < 0&&0.0-base>-0.00000001) {
            return 0.0;
        }
        if (exponent < 0) {
            absexponent = -exponent;
        }

        double result = 1.0;
        for (int i = 1; i <= absexponent; i++) {
            result *= base;
        }
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    /**
     * 分基欧  高效公式计算
     * @param base
     * @param exponent
     * @return
     */
    static double power3(double base, int exponent) {
       if(exponent==0){
           return 1;
       }
       if (exponent==1){
           return base;
       }
       double result=power3(base,exponent>>1);
       result*=result;
       if((exponent&0x1)==1){
           result*=base;
       }
       return result;
    }

}
