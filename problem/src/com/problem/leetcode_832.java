package com.problem;

public class leetcode_832 {

	/*
	 * 832. ��תͼ���Ѷȼ�184����һ�������ƾ��� A����������ˮƽ��תͼ��
	  * Ȼ��תͼ�񲢷��ؽ����ˮƽ��תͼƬ���ǽ�ͼƬ��ÿһ�ж����з�ת��������
	  * ���磬ˮƽ��ת [1, 1, 0] �Ľ���� [0, 1, 1]��
		��תͼƬ����˼��ͼƬ�е� 0 ȫ���� 1 �滻�� 1 ȫ���� 0 �滻��
		���磬��ת [0, 1, 1] �Ľ���� [1, 0, 0]��
		����: [[1,1,0],[1,0,1],[0,0,0]]
		���: [[1,0,0],[0,1,0],[1,1,1]]
		����: ���ȷ�תÿһ��: [[0,1,1],[1,0,1],[0,0,0]]��
     	Ȼ��תͼƬ: [[1,0,0],[0,1,0],[1,1,1]]
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
