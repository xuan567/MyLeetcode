package com.problem;

public class leetcode_204 {

	public static void main(String[] args) {
		int n = countPrimes(10);
		System.out.println(n);

	}
	public static int countPrimes(int n) {
		int[] nums = new int[n];
		for(int i = 0;i<n;i++) {
			nums[i]=1;
		}
		for(int i = 2; i<n ;i++) {
			if(nums[i]==1) {
				for(int j = 2;i*j<n;j++) {
					nums[i*j]=0;
				}
			}
		}
		int res = 0;
		for(int i = 2;i<n;i++) {
			if(nums[i]==1)
				res++;
		}
		return res;
	}

}
