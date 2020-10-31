package com.problem;

import java.util.Arrays;

public class leetcode_16 {
	/*给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
		示例：
		输入：nums = [-1,2,1,-4], target = 1
		输出：2
		解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。*/

	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		int n = threeSumClosest(nums, 2);
		System.out.println(n);
	}
	 public static int threeSumClosest(int[] nums, int target) {
		 Arrays.sort(nums);
		 int len = nums.length;
		 int ans = nums[0]+nums[1]+nums[2];
		 for(int i = 0;i<len;i++) {
			 int l = i+1;
			 int r = len-1;
			 while(l<r) {
				 int sum = nums[i]+nums[l]+nums[r];
				 if(Math.abs(target-sum)<Math.abs(target-ans));
				 	ans = sum;
				 if(sum>target)
					 r--;
				 else if(sum<target)
					 l++;
				 else
					 return ans;
			 }
			 
		 }
		 return ans;
	 }

}
