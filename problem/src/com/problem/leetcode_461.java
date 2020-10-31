package com.problem;

public class leetcode_461 {
	/*
	 *461. 汉明距离难度简单312两个整数之间的汉明距离指的是
	 *这两个数字对应二进制位不同的位置的数目。
	给出两个整数 x 和 y，计算它们之间的汉明距离。
	注意：
	0 ≤ x, y < 231.
	
	示例:
	输入: x = 1, y = 4
	输出: 2
	解释:
	1   (0 0 0 1)
	4   (0 1 0 0)
	       ↑   ↑
	 */

	public static void main(String[] args) {
		int x=1,y=2;
		System.out.println(hammingDistance(x,y));
		System.out.println(hammingDistance2(x,y));
		System.out.println(hammingDistance3(x,y));

	}
    public static int hammingDistance(int x, int y) {
    	return Integer.bitCount(x^y);
    }
    public static int hammingDistance2(int x, int y) {
    	int xor = x^y;
    	int count=0;
    	while(xor!=0) {
    		if(xor%2==1)
    			count++;
    		xor>>=1;
    	}
    	return count;
    }
    public static int hammingDistance3(int x, int y) {
    	int xor =x^y;
    	int count =0;
    	while(xor!=0) {
    		count++;
    		xor = xor&(xor-1);
    	}
    	return count;
    }

}
