package 数组和字符串;

import java.util.Arrays;

public class leetcode215数组中的第K个最大元素 {
    /*
    215.
    数组中的第K个最大元素
    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

    示例 1:
    输入: [3,2,1,5,6,4] 和 k = 2
    输出: 5

    示例 2:
    输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
    输出: 4
    * */

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int x = findKthLargest(nums,4);
        System.out.println(x);
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int t=0;
        for(int j=nums.length-1;j>=0;j--){
            t++;
            if(t==k){
                return nums[j];
            }
        }
        return nums[0];
    }



}
