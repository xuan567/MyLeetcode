package com.problem;

public class leetcode_191 {

	public static void main(String[] args) {
		

	}
	public int hammingWeight(int n) {
		int bits=0;
		int mask=1;
		for(int i = 0;i<32;i++) {
			if((n&mask)!=0) {
				bits++;
			}
			mask <<=1;
		}
		return bits;
	}

}
