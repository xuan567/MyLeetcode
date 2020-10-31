package com.problem;

public class leetcode_496 {
	/*
	 * 496. 下一个更大元素 I难度简单263给定两个 没有重复元素 的数组 nums1 和 nums2 ，
	 * 其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
		nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
		如果不存在，对应位置输出 -1 。
		
		示例 1:
		输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
		输出: [-1,3,-1]
		解释:
	    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
	    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
	    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。*/

	public static void main(String[] args) {
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		int[] nums3 = nextGreaterElement(nums1,nums2);
		for (int i : nums3) {
			System.out.print(i + " ");
		}
	}
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	int[] nums = new int[nums1.length];
    	int k=0;
    	for(int i=0;i<nums1.length;i++) {
    		nums[k++] = find(nums1[i],nums2);
    	}
    	return nums;
    }
    public static int find(int n,int[] nums) {
    	int i;
    	for(i=0;i<nums.length;i++) {
    		if(nums[i]==n)
    			break;
    	}
    	for(;i<nums.length;i++) {
    		if(nums[i]>n)
    			return nums[i];
    	}
    	return -1;
    }
//遍历nums1，每次遍历将nums1[i]和nums2传入到定义的find方法里，在nums2中找到该元素在
//的位置，从该位置往后找，若找到第一个比nums[i]大的元素，直接返回，当找完还没找到时，
//返回-1；    
}
