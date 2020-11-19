package 数组和字符串;

public class leetcode35搜索插入位置 {
    /*
    * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
        你可以假设数组中无重复元素。
        示例 1:
        输入: [1,3,5,6], 5
        输出: 2

        示例 3:
        输入: [1,3,5,6], 7
        输出: 4*/

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int n = searchInsert(nums,5);
        System.out.println(n);
    }
    public static int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target){
                return i;
            }
        }
        return nums.length;
    }

}
