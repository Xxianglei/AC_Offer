package offer;

/**
 * 二叉搜索树的后序遍历
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * 5    7   6   9   11  10  8   8为根
 */
public class Offer33 {
    public static void main(String[] args) {
        int nums[] = {5, 7, 6, 9, 11, 10, 8};
        int nums2[]={7,4,6,5};
        System.out.println(VerifySquenceOfBST(nums,0, nums.length));
        System.out.println(VerifySquenceOfBST(nums2,0, nums2.length));
    }

    private static boolean VerifySquenceOfBST(int nums[],int start , int length) {
        if (nums == null || length <= 0) {
            return false;
        }
        int root = nums[length-1];
        int index;
        for (index = 0; index < length-1 ; index++) {
            if (nums[index] > root) {
                break;
            }
        }
        // 在小值后面如果还出现了小值 肯定不是搜索树
        int index2=index;
        for (; index2 < length -1; index2++) {
            if (nums[index2] < root) {
              return false;
            }
        }
        // 找到两个分界点  在递归判断  二分查找

        boolean left = true;
        if (index > 0) {
            left = VerifySquenceOfBST(nums,0, index);
        }
        boolean right = true;
        if (index2 < length-1 ) {

            right = VerifySquenceOfBST(nums,index, index2);
        }
        return  right;
    }
}
