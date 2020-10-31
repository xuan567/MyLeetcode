package com.problem;

import java.util.Arrays;
import java.util.HashMap;


public class leetcode_217 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,2};
		System.out.println(containsDuplicate(nums));
 
	}
	
	public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        boolean flag = false;
        for(int i = 0;i<nums.length;i++) {
        	if(!hm.containsKey(nums[i]))
        		hm.put(nums[i], 0);
        	else {
        		hm.put(nums[i],hm.get(nums[i])+1);
        		flag=true;
        	}
        }
        return flag;
    }
	
	public static boolean containsDuplicate2(int[] nums) {
		Arrays.sort(nums);
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]==nums[i+1])
				return true;
		}
		return false;
	}

}
