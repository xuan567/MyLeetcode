package com.problem;

import java.util.Arrays;

public class leetcode_16 {
	/*����һ������ n ������������ nums �� һ��Ŀ��ֵ target���ҳ� nums �е�����������ʹ�����ǵĺ��� target ��ӽ����������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�
		ʾ����
		���룺nums = [-1,2,1,-4], target = 1
		�����2
		���ͣ��� target ��ӽ��ĺ��� 2 (-1 + 2 + 1 = 2) ��*/

	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		int n = threeSumClosest(nums, 2);
		System.out.println(n);
	}
	 public static int threeSumClosest(int[] nums, int target) {
		 Arrays.sort(nums);
		 int len = nums.length;
		 int ans = nums[0]+nums[1]+nums[2];
		 for(int i = 0;i<len;i++) {
			 int l = i+1;
			 int r = len-1;
			 while(l<r) {
				 int sum = nums[i]+nums[l]+nums[r];
				 if(Math.abs(target-sum)<Math.abs(target-ans));
				 	ans = sum;
				 if(sum>target)
					 r--;
				 else if(sum<target)
					 l++;
				 else
					 return ans;
			 }
			 
		 }
		 return ans;
	 }

}
