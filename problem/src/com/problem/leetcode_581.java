package com.problem;

import java.util.Arrays;
import java.util.Stack;

public class leetcode_581 {
	/*581. ������������������Ѷȼ�373����һ���������飬
	 * ����ҪѰ��һ�������������飬�������������������������
	 * ��ô�������鶼���Ϊ��������
	 *���ҵ���������Ӧ����̵ģ���������ĳ��ȡ�
	ʾ�� 1:
	����: [2, 6, 4, 8, 10, 9, 15]
	���: 5
	����: ��ֻ��Ҫ�� [6, 4, 8, 10, 9] ��������������ô���������Ϊ��������
	 * */

	public static void main(String[] args) {
		int[] nums = {1,3,2,2,2}; 
		int n = findUnsortedSubarray(nums);
		System.out.println(n);
	}
	
    public static int findUnsortedSubarray(int[] nums) {
    	int[] nums2 = new int[nums.length];
    	for(int i=0;i<nums.length;i++) {
    		nums2[i]=nums[i];
    	}
    	int i,j;
    	Arrays.sort(nums2);
    	for(i=0;i<nums.length;i++) {
    		if(nums[i]!=nums2[i]) {
    			break;
    		}
    	}
    	for(j=nums.length-1;j>=0;j--) {
    		if(nums[j]!=nums2[j]) {
    			break;
    		}
    	}
    	return j-i+1<0?0:j-i+1;
    }
    public static int findUnsortedSubarray2(int[] nums) {
    	int[] snums = nums.clone();
    	Arrays.sort(snums);
    	int start = snums.length,end =0;
    	for(int i=0;i<snums.length;i++) {
    		if(snums[i]!=nums[i]) {
    			start = Math.min(start, i);
    			end = Math.max(end, i);
    		}
    	}
    	return (end-start>=0?end-start+1:0);
    }
    public static int findUnsortedSubarray3(int[] nums) {
    	int l=nums.length,r=0;
    	for(int i=0;i<nums.length-1;i++) {
    		for(int j=i+1;j<nums.length;j++) {
    			if(nums[j]<nums[i]) {
    				r=Math.max(r, j);
    				l=Math.min(l, i);
    			}
    		}
    	}
    	return r-l<0?0:r-l+1;
    }
    
    public static int findUnsortedSubarray4(int[] nums) {
    	Stack<Integer> stack = new Stack<Integer>();
    	int l=nums.length,r=0;
    	for(int i=0;i<nums.length;i++) {
    		while(!stack.isEmpty()&&nums[stack.peek()]>nums[i]) {
    			l=Math.min(l, stack.pop());
    		}
    		stack.push(i);
    	}
    	stack.clear();
    	for(int i=nums.length-1;i>=0;i--) {
    		while(!stack.isEmpty()&&nums[stack.peek()]<nums[i]) {
    			r=Math.max(r, stack.pop());
    		}
    		stack.push(i);
    	}
    	return r-l>0?r-l+1:0;
    }

}
