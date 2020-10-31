package com.problem;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode_218 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,1,2,3};
		int k = 2;
		System.out.println(containsNearbyDuplicate(nums,3));
 
	}
	
	public static boolean containsNearbyDuplicate(int[] nums,int k) {
        for(int i = 0;i<nums.length;i++) {
        	for(int j = Math.max(i-k, 0);j<i;++j) {
        		if(nums[i]==nums[j])
        			return true;
        	}
        }
        return false;
    }

}
