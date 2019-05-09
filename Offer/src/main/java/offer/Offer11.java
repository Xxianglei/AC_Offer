package offer;

/**
 * 旋转数组最小的数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1;
 */
public class Offer11 {

    public static void main(String[] args) {
        int nums[] = {1,0,1,1,1};
        System.out.println(findMin(nums));
    }

    static int findMin(int nums[]) {
        int first = 0;
        int mid = first;
        if (nums == null) {
            try {
                throw new NullPointerException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            int end = nums.length - 1;
            while (nums[first] >= nums[end]) {
                if (end - first == 1) {
                    mid = end;
                    break;
                }
                mid = (end + first) / 2;
                if(nums[first]==nums[end]&&nums[first]==nums[mid]){
                    return MinInOrder(nums,first,end);
                }
                if (nums[mid] >= nums[first]) {
                    first = mid;
                } else {
                    end = mid;
                }
            }
            return nums[mid];
        }
        return 0;
    }

    private static int MinInOrder(int[] nums, int first, int end) {
        int result=nums[first];
        for (int i=first+1;i<=end;i++){
            if(result>nums[i]){
                result=nums[i];
            }
        }
        return result;
    }
}
