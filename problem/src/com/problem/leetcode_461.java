package com.problem;

public class leetcode_461 {
	/*
	 *461. ���������Ѷȼ�312��������֮��ĺ�������ָ����
	 *���������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��
	������������ x �� y����������֮��ĺ������롣
	ע�⣺
	0 �� x, y < 231.
	
	ʾ��:
	����: x = 1, y = 4
	���: 2
	����:
	1   (0 0 0 1)
	4   (0 1 0 0)
	       ��   ��
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
