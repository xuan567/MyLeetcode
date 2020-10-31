package com.problem;

import java.util.HashSet;

public class leetcode_202 {

	public static void main(String[] args) {
		//deom1();
		int n = 2;
		boolean b = deom2(n);
		System.out.println(b);
	}
	public static boolean deom1() {
		int n=19;
		HashSet<Integer> hs = new HashSet<>();
		while(n!=1&&(!hs.contains(n))) {
			hs.add(n);
			n=getNext(n);
		}
		return n==1;
	}
	public static boolean deom2(int n) {
		int slow = n;
		int fast = getNext(n);
		while(fast!=1&&fast!=slow) {
			slow = getNext(slow);
			fast = getNext(getNext(fast));
		}
		return fast==1;
		
	}
	public static int getNext(int n) {
		int sum = 0;
		while(n!=0) {
			sum+=(n%10)*(n%10);
			n=n/10;
		}
		return sum;
	}

}
