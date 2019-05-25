package offer;

/**
 * 最长不含重复字符的子字符串
 * 用双指针i,j分别指向第一第二个元素，当j发现了重复元素，则从i的下一位开始搜索。
 * <p>
 * 代码中用了个trick，用vector生成256个-1，用来存储每个字符上一次出现的下标。
 */
public class Offer48 {
    public static void main(String[] args) {
        String s = "arabcacfropi";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * map 统计了每个字符最后一次出现的位置
     * maxLength 记录当前最长不重复子串长度
     * currentLength 记录以当前字符 chars[i] 或char[i-1] 结尾的最长不重复子串长度
     * chars[pre] 表示以 i 结尾的最长不重复子串的第一个字符
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int maxlength = 0;
        int currentlength = 1;
        char[] chars = s.toCharArray();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            temp = temp.append(chars[i]);

            for (int j = i + 1; j < length ; j++) {
                if (temp.indexOf(chars[j] + "") != -1) {
                    if (currentlength >= maxlength) {
                        maxlength = currentlength;
                    }
                    temp.delete(0, length);
                    currentlength=1;
                    break;
                } else {
                    temp.append(chars[j]);
                    currentlength++;
                }

            }
        }
        return maxlength;
    }

}
