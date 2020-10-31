package com.problem;

public class leetcode_415 {
	/*给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
	 * num1 和num2 的长度都小于 5100.
	num1 和num2 都只包含数字 0-9.
	num1 和num2 都不包含任何前导零。
	你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。*/

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
