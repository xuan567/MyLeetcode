package com.problem;

public class leetcode_172 {

	public static void main(String[] args) {
		int a = 5;
		int x = deom1(a);
		System.out.println(x);

	}
	public static int deom1(int n) {
		int count = 0;
		while(n!=0) {
			count+=n/5;
			n= n/5;
		}
		return count;
	}

}
