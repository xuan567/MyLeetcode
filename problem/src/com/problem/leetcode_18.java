package com.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_18 {
	/*给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
	注意：
	答案中不可以包含重复的四元组。
	示例：
	给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
	满足要求的四元组集合为：
	[
  		[-1,  0, 0, 1],
  		[-2, -1, 1, 2],
  		[-2,  0, 0, 2]
	]*/


	public static void main(String[] args) {
		int[] nums= {0,4,-5,2,-2,4,2,-1,4};
		List<List<Integer>> list = fourSum(nums,12);
		System.out.println(list);
	}
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		int len= nums.length;
		if(len < 4)
			return list;
		Arrays.sort(nums);
		for(int k =0;k<=len-4;k++) {
			if(k>0&&nums[k]==nums[k-1])
				continue;
			for(int i=k+1;i<=len-3;i++) {
				if(i>k+1&&nums[i]==nums[i-1])
					continue;
				int r = len-1;
				int l = i+1;
				while(l<r) {
					int sum=nums[k]+nums[i]+nums[l]+nums[r];
					if(sum==target) {
						list.add(Arrays.asList(nums[k],nums[i],nums[l],nums[r]));
						while(l<r&&nums[l]==nums[l+1])
							l++;
						while(l<r&&nums[r]==nums[r-1])
							r--;
						l++;
						r--;
					}
					else if(sum>target)
						r--;
					else if(sum<target)
						l++;
				}
			}
		}
		return list;
			
    }

}
