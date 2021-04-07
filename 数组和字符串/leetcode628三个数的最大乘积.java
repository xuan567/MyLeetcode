package 数组和字符串;

import java.util.Arrays;

public class leetcode628三个数的最大乘积eetcode628三个数的最大乘积 {
    /*
    * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

        示例 1：
        输入：nums = [1,2,3]
        输出：6

        示例 2：
        输入：nums = [1,2,3,4]
        输出：24

        示例 3：
        输入：nums = [-1,-2,-3]
        输出：-6

    * */

    public int maximumProduct(int[] nums) {
        if(nums.length == 3){
            return nums[0]*nums[1]*nums[2];
        }

        Arrays.sort(nums);
        int n = nums.length;

        if(nums[n-1]<0){
            return nums[0]*nums[1]*nums[2];
        }
        if(nums[0]>0 || (nums[0]<0 && nums[1]>0)){
            return nums[n-1]*nums[n-2]*nums[n-3];
        }
        if(nums[0]<0 && nums[1]<0 && nums[n-1]>0){
            return Math.max()
        }

        return nums[n]
    }

}
