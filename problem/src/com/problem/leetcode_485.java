package com.problem;

public class leetcode_485 {
	/*
	 * 485. 最大连续1的个数难度简单120给定一个二进制数组， 计算其中最大连续1的个数。
		
		示例 1:
		输入: [1,1,0,1,1,1]
		输出: 3
		解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.*/

	public static void main(String[] args) {
		int[] nums = {1,1,0,1,1,1};
		int n = findMaxConsecutiveOnes(nums);
		System.out.println(n);

	}
    public static int findMaxConsecutiveOnes(int[] nums) {
        int left = 0,right = 0,ans = 0;
        while(left<nums.length){
            if(nums[left] == 1){
            	int i = left;
            	for(;i<nums.length && nums[i] ==1;i++) {
            	}
            	ans = Math.max(ans, i-left);
            	left = i+1;
            }else {
            	left++;
            }
        }
        return ans;
    }
//从头找，如果该元素是1，从这里进入循环，i=left，如果nums[i]==1，则i++;
//如果不是1或者已经遍历完，跳出循环，ans = Math.max(ans, i-left);
//得到最大的连续的1    
}
