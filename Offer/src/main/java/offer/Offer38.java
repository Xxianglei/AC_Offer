package offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符串的排列
 */
public class Offer38 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return list;
        }
        char[] strArr = str.toCharArray();
        permu(list, strArr, 0);
        Collections.sort(list);
        return list;
    }

    public void permu(ArrayList<String> list, char[] strArr, int start) {
        if (start == strArr.length - 1) {
            String result = String.valueOf(strArr);
            if (list.indexOf(result) < 0) {
                list.add(String.valueOf(strArr));
            }
        }
        for (int i = start; i < strArr.length; i++) {
            char temp = strArr[i];
            strArr[i] = strArr[start];
            strArr[start] = temp;
            permu(list, strArr, start + 1);
            temp = strArr[i];
            strArr[i] = strArr[start];
            strArr[start] = temp;
        }
        return;
    }
}

