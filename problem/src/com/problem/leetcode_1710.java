package com.problem;

import java.util.HashMap;

public class leetcode_1710 {
	/*
	 * 面试题 17.10. 主要元素难度简单28数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。

	示例 1：
	
	输入：[1,2,5,9,5,9,5,5,5]
	输出：5
*/
	
	public static void main(String[] args) {
		int[] nums = {1,2,5,9,5,9,5,5,5};
		int n = majorityElement(nums);
		System.out.println(n);
	}
	public static int majorityElement(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for (int key : map.keySet()) {
			if(map.get(key) > (nums.length /2)) {
				return key;
			}
		}
        return -1;
	}

}
