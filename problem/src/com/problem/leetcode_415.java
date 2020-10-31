package com.problem;

public class leetcode_415 {
	/*���������ַ�����ʽ�ķǸ����� num1 ��num2 ���������ǵĺ͡�
	 * num1 ��num2 �ĳ��ȶ�С�� 5100.
	num1 ��num2 ��ֻ�������� 0-9.
	num1 ��num2 ���������κ�ǰ���㡣
	�㲻��ʹ���κ΃Ƚ� BigInteger �⣬ Ҳ����ֱ�ӽ�������ַ���ת��Ϊ������ʽ��*/

	public static void main(String[] args) {
		String s1 = "99";
		String s2 = "1";
		String s3 = addStrings(s1,s2);
		System.out.println(s3);
	}
	
	public static String addStrings(String num1, String num2) {
		int i = num1.length()-1;
		int j = num2.length()-1;
		int add=0;
		StringBuffer sb = new StringBuffer();
		while(i>=0||j>=0||add!=0) {
			int x = i>=0?num1.charAt(i)-'0':0;
			int y = j>=0?num2.charAt(j)-'0':0;
			int sum = x+y+add;
			add=sum/10;
			sb.append(sum%10);
			i--;
			j--;
		}
		sb.reverse();
		return sb.toString();

    }

}
