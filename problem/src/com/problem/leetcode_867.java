package com.problem;

public class leetcode_867 {
	/*
	 * 867. 转置矩阵难度简单104给定一个矩阵 A， 返回 A 的转置矩阵。
		矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
		
		示例 1：
		输入：[[1,2,3],[4,5,6],[7,8,9]]
		输出：[[1,4,7],[2,5,8],[3,6,9]]
		
		示例 2：
		输入：[[1,2,3],[4,5,6]]
		输出：[[1,4],[2,5],[3,6]]
*/

	public static void main(String[] args) {
		int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] nums2 = transpose(nums);
		for (int i = 0; i < nums2.length; i++) {
			for (int j = 0; j < nums2[i].length; j++) {
				System.out.print(nums2[i][j]);
			}
			System.out.println();
		}
	}
    public static int[][] transpose(int[][] A) {
    	int[][] array = new int[A.length][A[0].length];
    	for(int i=0;i<A.length;i++) {
    		for(int j=0;j<A[i].length;j++) {
    			array[j][i] = A[i][j];
    		}
    	}
    	return array;
    }
// 定义一个新数组int[][] array = new int[A.length][A[0].length];
// 将原数组遍历， array[j][i] = A[i][j];就将原来的数组转置了。   
}
