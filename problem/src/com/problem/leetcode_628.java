package com.problem;

import java.util.Arrays;

public class leetcode_628 {
	/*
	 * ����һ���������飬���������ҳ�����������ɵ����˻������������˻���
		ʾ�� 1:
		����: [1,2,3]
		���: 6
		
		ʾ�� 2:
		����: [1,2,3,4]
		���: 24*/

	public static void main(String[] args) {
		int nums[] = {-4,-3,-2,-1,60};
		int n = maximumProduct(nums);
		System.out.println(n);
	}
	 public static int maximumProduct(int[] nums) {
//		 	Arrays.sort(nums);
//	        int i;
//	        int length = nums.length;
//	        for(i=0;i<nums.length;i++){
//	            if(nums[i] >=0)
//	                break;
//	        }
//	        if(i==0 || i==nums.length-1){
//	            return nums[length-1]*nums[length-2]*nums[length-3];
//	        }
//	        else if( i == 1){
//	            return nums[length-1]*nums[length-2]*nums[length-3];
//	        }else if( i >= 2){
//	            Math.max(nums[length-1]*nums[length-2]*nums[length-3],nums[length-1]*nums[0]*nums[1]);
//	        }
//	        return 0;
		 
		 Arrays.sort(nums);
		 int length = nums.length;
		 return  Math.max(nums[length-1]*nums[length-2]*nums[length-3],nums[length-1]*nums[0]*nums[1]);
// �����鰴����������Ϊ�����и���������������������Է��غ����λ�ĳ˻� �����һ����ǰ�����ĳ˻�		 
	 }

}
