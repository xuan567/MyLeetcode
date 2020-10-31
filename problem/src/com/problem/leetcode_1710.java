package com.problem;

import java.util.HashMap;

public class leetcode_1710 {
	/*
	 * ������ 17.10. ��ҪԪ���Ѷȼ�28������ռ�ȳ���һ���Ԫ�س�֮Ϊ��ҪԪ�ء�����һ���������飬�ҵ�������ҪԪ�ء���û�У�����-1��

	ʾ�� 1��
	
	���룺[1,2,5,9,5,9,5,5,5]
	�����5
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
