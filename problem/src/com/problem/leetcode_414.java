package com.problem;

import java.util.Arrays;

public class leetcode_414 {

/*
 * 414. ����������Ѷȼ�160����һ���ǿ����飬���ش������е������������������ڣ��򷵻���������������Ҫ���㷨ʱ�临�Ӷȱ�����O(n)��
	ʾ�� 1:
	����: [3, 2, 1]
	���: 1
	����: ����������� 1.*/
	public static void main(String[] args) {
		int[] nums = {4,3,3,2,2,1,0};
		int n = thirdMax(nums);
		System.out.println(n);
	}
    public static int thirdMax(int[] nums) {
    	Arrays.sort(nums);
    	int t=1,i;
    	for(i=nums.length-2;i>=0;i--) {
    		if(nums[i]<nums[i+1]) {
    			t++;
    		}
    		if(t==3)
    			break;
    	}
    	if(t==3)
    		return nums[i];
    	else {
    		return nums[nums.length-1];
    	}
    }

}
