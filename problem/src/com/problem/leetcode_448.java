package com.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class leetcode_448 {
	/*给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，
	 * 数组中的元素一些出现了两次，另一些只出现一次。
	    找到所有在 [1, n] 范围之间没有出现在数组中的数字。
	    您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 
	    你可以假定返回的数组不算在额外空间内。
		示例:
		输入:
		[4,3,2,7,8,2,3,1]
		输出:
		[5,6]
	 */

	public static void main(String[] args) {
		int[] num = {1,1,1,1,1,1};
		List<Integer> list = findDisappearedNumbers2(num);
		System.out.println(list);
	}
    public static List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> list = new ArrayList<>();
    	Arrays.sort(nums);
    	for(int i = 0;i<nums.length;i++) {
    		if(i==0) {
    			if(nums[i]-1>=1) {
    				for(int j=1;j<nums[i];j++) {
    					list.add(j);
    				}
    			}
    		}else if(nums[i]-nums[i-1]>1) {
    			for(int k = 1;k<nums[i]-nums[i-1];k++) {
    				list.add(nums[i-1]+k);
    			}
    		}
    	}
    	if(nums[nums.length-1]<nums.length) {
    		for(int t=1;t<=nums.length-nums[nums.length-1];t++) {
    			list.add(nums[nums.length-1] +t);
    		}
    	}
    	return list;
    }
    
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
    	HashMap<Integer, Boolean> hm = new HashMap<>();
    	for(int i =0;i<nums.length;i++) {
    		hm.put(nums[i],true);
    	}
    	List<Integer> list = new ArrayList<>();
    	for(int i=1;i<=nums.length;i++) {
    		if(!hm.containsKey(i)) {
    			list.add(i);
    		}
    	}
    	return list;
    }
    public static List<Integer> findDisappearedNumbers3(int[] nums){
    	for(int i=0;i<nums.length;i++) {
    		int newIndex = Math.abs(nums[i])-1;
    		if(nums[newIndex]>0) {
    			nums[newIndex]*=-1;
    		}
    	}
    	List<Integer> result = new LinkedList<Integer>();
    	for(int i=1;i<=nums.length;i++) {
    		if(nums[i-1]>0)
    			result.add(i);
    	}
    	return result;
    }

}
