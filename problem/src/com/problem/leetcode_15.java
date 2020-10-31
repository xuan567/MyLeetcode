package com.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_15 {

	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> list =threeSum(nums);
		System.out.println(list);

	}
	public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null||len<3)
        	return ans;
        Arrays.sort(nums);
        for(int i = 0;i<len;i++) {
        	if(nums[i]>0)
        		break;
        	if(i>0&&nums[i]==nums[i-1])
        		continue;
        	int l=i+1;
        	int r = len-1;
        	while(l<r) {
        		int sum=nums[i]+nums[r]+nums[l];
        		if(sum==0) {
        			ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
        			while(l<r && nums[l]==nums[l+1]) l++;
        			while(l<r && nums[r]==nums[r-1]) r--;
        			l++;
        			r--;
        		}
        		else if(sum>0) r--;
        		else if(sum<0) l++;
        	}
        	
        }
        
        return ans;
    }

}
