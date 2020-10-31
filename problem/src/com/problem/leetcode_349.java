package com.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class leetcode_349 {
	/*349. 两个数组的交集难度简单224给定两个数组，编写一个函数来计算它们的交集。
		示例 1：
		输入：nums1 = [1,2,2,1], nums2 = [2,2]
		输出：[2]
	*/

	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] nums3 = intersection(nums1,nums2);
		for (int i = 0; i < nums3.length; i++) {
			System.out.print(nums3[i]);
		}
	}
	public static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		for (int i : nums1) {
			set1.add(i);
		}
		for (int i : nums2) {
			set2.add(i);
		}
		if(set1.size()<set2.size())
			return set(set1,set2);
		else
			return set(set2,set1);
	}
	public static int[] set(HashSet<Integer> set1,HashSet<Integer> set2) {
		int index = 0;
		int[] output = new int[set1.size()];
		for (Integer s : set1) {
			if(set2.contains(s))
				output[index++]=s;
		}
		return Arrays.copyOf(output, index);
	}
    public static int[] intersection1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums1.length;i++) {
        	for(int j=0;j<nums2.length;j++) {
        		if(nums1[i]==nums2[j]) {
        			if(list.contains(nums1[i]))
        				break;
        			else{
        				list.add(nums1[i]);
        			}
        		}
        	}
        }
        int[] nums3 = new int[list.size()];
        for(int i=0;i<list.size();i++) {
        	nums3[i]=list.get(i);
        }
        return nums3;
    }
  
}
