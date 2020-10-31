package com.problem;

public class leetcode_832 {

	/*
	 * 832. 翻转图像难度简单184给定一个二进制矩阵 A，我们想先水平翻转图像，
	  * 然后反转图像并返回结果。水平翻转图片就是将图片的每一行都进行翻转，即逆序。
	  * 例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
		反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。
		例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
		输入: [[1,1,0],[1,0,1],[0,0,0]]
		输出: [[1,0,0],[0,1,0],[1,1,1]]
		解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     	然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
*/
	public static void main(String[] args) {

	}
    public static int[][] flipAndInvertImage(int[][] A) {
    	for(int i=0;i<A.length;i++) {
    		reverse(A[i]);
    	}
    	return A;
    }
    
    public static void reverse(int[] a) {
    	for(int i=0,j=a.length-1;i<j;i++,j--) {
    		int temp = a[j];
    		a[j] = a[i];
    		a[i] = temp;
    	}
    	for(int i=0;i<a.length;i++) {
    		if(a[i]==0) {
    			a[i]=1;
    		}else if(a[i]==1) {
    			a[i]=0;
    		}
    	}
    }

}
