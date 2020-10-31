package com.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_18 {
	/*����һ������ n ������������ nums ��һ��Ŀ��ֵ target���ж� nums ���Ƿ�����ĸ�Ԫ�� a��b��c �� d ��ʹ�� a + b + c + d ��ֵ�� target ��ȣ��ҳ��������������Ҳ��ظ�����Ԫ�顣
	ע�⣺
	���в����԰����ظ�����Ԫ�顣
	ʾ����
	�������� nums = [1, 0, -1, 0, -2, 2]���� target = 0��
	����Ҫ�����Ԫ�鼯��Ϊ��
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
