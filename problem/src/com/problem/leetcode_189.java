package com.problem;

public class leetcode_189 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		rotate3(nums,k);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}

	}
    public static void rotate(int[] nums, int k) {
    	int temp,previous;
    	for(int i = 0;i<k;i++) {
    		previous = nums[nums.length-1];
    		for(int j=0;j<nums.length;j++) {
    			temp=nums[j];
    			nums[j]=previous;
    			previous=temp;
    		}
    	}
    }
    public static void rotate2(int[] nums, int k) {
    	int[] a = new int[nums.length];
    	for(int i=0;i<nums.length;i++) {
    		a[(i+k)%nums.length]=nums[i];
    	}
    	for(int i = 0;i<nums.length;i++)
    		nums[i]=a[i];
    }
    
    public static void rotate3(int[] nums, int k) {
    	 k %= nums.length;
    	reserve(nums,0,nums.length-1);
    	reserve(nums,0,k-1);
    	reserve(nums,k,nums.length-1);
    	
    }
    public static void reserve(int[] nums,int start,int end) {
    	int temp;
    	while(start<end) {
    		temp=nums[start];
    		nums[start]=nums[end];
    		nums[end]=temp;
    		start++;
    		end--;
    	}
    }

}
