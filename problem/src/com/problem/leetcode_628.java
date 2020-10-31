package com.problem;

import java.util.Arrays;

public class leetcode_628 {
	/*
	 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
		示例 1:
		输入: [1,2,3]
		输出: 6
		
		示例 2:
		输入: [1,2,3,4]
		输出: 24*/

	public static void main(String[] args) {
		int nums[] = {-4,-3,-2,-1,60};
		int n = maximumProduct(nums);
		System.out.println(n);
	}
	 public static int maximumProduct(int[] nums) {
//		 	Arrays.sort(nums);
//	        int i;
//	        int length = nums.length;
//	        for(i=0;i<nums.length;i++){
//	            if(nums[i] >=0)
//	                break;
//	        }
//	        if(i==0 || i==nums.length-1){
//	            return nums[length-1]*nums[length-2]*nums[length-3];
//	        }
//	        else if( i == 1){
//	            return nums[length-1]*nums[length-2]*nums[length-3];
//	        }else if( i >= 2){
//	            Math.max(nums[length-1]*nums[length-2]*nums[length-3],nums[length-1]*nums[0]*nums[1]);
//	        }
//	        return 0;
		 
		 Arrays.sort(nums);
		 int length = nums.length;
		 return  Math.max(nums[length-1]*nums[length-2]*nums[length-3],nums[length-1]*nums[0]*nums[1]);
// 将数组按递增排序，因为考虑有负数情况，负负得正，所以返回后的三位的乘积 或最后一个和前两个的乘积		 
	 }

}
