package offer;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student."，则输出"student. a am I"。
 */
public class Offer58 {
    public static void main(String[] args) {
        /**
         * 无脑写法利用自带的反转方法  两次反转
         */
        String s = "I am a student.";
        StringBuilder temp = new StringBuilder(s);
        String reverse = String.valueOf(temp.reverse());
        String[] s1 = reverse.split(" ");
        StringBuffer buffer=new StringBuffer();
        for (int i = 0; i < s1.length; i++) {
            if(i==s1.length-1){
                buffer.append(new StringBuilder(s1[i]).reverse());
            }else{
                buffer.append(new StringBuilder(s1[i]).reverse()+" ");
            }

        }
        System.out.printf(buffer + "");
    }

}
