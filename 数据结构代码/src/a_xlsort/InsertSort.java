package a_xlsort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 8, 5, 9, 1, 0};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int arr[]) {
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]<arr[i-1]){
                int temp=arr[i];
                int j;
                // 从前一位开始往前比较
                for(j=i-1;j>=0;j--) {
                    if(temp<arr[j]){
                        //把前一个数字赋给后一个数字
                        arr[j+1]=arr[j];
                    }
                }
                arr[j+1]=temp;
            }
        }
    }

}
