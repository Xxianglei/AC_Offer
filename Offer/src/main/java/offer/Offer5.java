package offer;


/**
 * 替换空格 换 ‘’ -> %20
 * <p>
 * 题目描述： 请实现一个函数，将字符串的每个空格替换为"%20"。
 * 例如输入"We are happy",则输出"We%20are%20happy."。
 */
public class Offer5 {

    public static void main(String[] args) {
        String str1 = "We are happy";

        System.out.println(myReplace(str1));
        System.out.println(myReplace2(str1));
    }

    /**
     * 1. 无脑写  不算算法
     *
     * @param str1
     * @return
     */
    private static String myReplace(String str1) {

        String s = str1.replaceAll(" ", "%20");
        return s;

    }

    public static String myReplace2(String str) {
        if(str==null){
            return  null;
        }
        StringBuffer res = new StringBuffer();
        int len = str.length() - 1;
        for (int i = len; i >= 0; i--) {
            if (str.charAt(i) == ' ')
                res.append("02%");
            else
                res.append(str.charAt(i));
        }
        return res.reverse().toString();
    }

}

