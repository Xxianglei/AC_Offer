package offer;


/**
 * 左旋转字符串   abcdefg 2 ----->cdefgab
 */
public class Offer58_2 {
    public static void main(String[] args) {
        String string = "abcdefg";
        int index = 2;  // 后置前两个字符
        StringBuilder temp = new StringBuilder(string);
        StringBuffer stringBuffer=new StringBuffer();
        String reverse = String.valueOf(temp.reverse());
        String headString = reverse.substring(0, string.length() - index);
        stringBuffer.append(new StringBuilder(headString).reverse());
        String endString = reverse.substring(string.length() - index, string.length());
        stringBuffer.append(new StringBuilder(endString).reverse());
        System.out.printf(stringBuffer+"");
    }
}
