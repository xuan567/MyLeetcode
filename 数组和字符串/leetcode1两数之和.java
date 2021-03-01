package 数组和字符串;

import java.util.Arrays;

public class leetcode1两数之和 {

    /*
    给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值的那两个整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
    你可以按任意顺序返回答案。

    示例 1：
    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

    示例 2：
    输入：nums = [3,2,4], target = 6
    输出：[1,2]
     */
    //方法1:暴力,时间复杂度O(n)，空间复杂度O(1)

    public int[] twoSum1(int[] nums, int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

}
