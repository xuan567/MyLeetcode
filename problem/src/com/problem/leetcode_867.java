package com.problem;

public class leetcode_867 {
	/*
	 * 867. ת�þ����Ѷȼ�104����һ������ A�� ���� A ��ת�þ���
		�����ת����ָ����������Խ��߷�ת���������������������������
		
		ʾ�� 1��
		���룺[[1,2,3],[4,5,6],[7,8,9]]
		�����[[1,4,7],[2,5,8],[3,6,9]]
		
		ʾ�� 2��
		���룺[[1,2,3],[4,5,6]]
		�����[[1,4],[2,5],[3,6]]
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
// ����һ��������int[][] array = new int[A.length][A[0].length];
// ��ԭ��������� array[j][i] = A[i][j];�ͽ�ԭ��������ת���ˡ�   
}
