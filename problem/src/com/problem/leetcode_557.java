package com.problem;

public class leetcode_557 {
	/*����һ���ַ���������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��
	ʾ����
	
	���룺"Let's take LeetCode contest"
	�����"s'teL ekat edoCteeL tsetnoc"
	 */

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));
	}
    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
        	sb.append(reverse(arr[i]));
        	if(i!=arr.length-1)
        		sb.append(" ");
        }
        return sb.toString();
    }
    public static String reverse(String s) {
    	StringBuilder sb = new StringBuilder();
    	for(int i=s.length()-1;i>=0;i--) {
    		sb.append(s.charAt(i));
    	}
    	return sb.toString();
    }

}
