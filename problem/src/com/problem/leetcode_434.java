package com.problem;

public class leetcode_434 {
	/*
	 * ͳ���ַ����еĵ��ʸ���������ĵ���ָ���������Ĳ��ǿո���ַ���
	   ��ע�⣬����Լٶ��ַ����ﲻ�����κβ��ɴ�ӡ���ַ���
	   
		ʾ��:
		����: "Hello, my name is John"
		���: 5
		����: ����ĵ�����ָ�����Ĳ��ǿո���ַ������� "Hello," ���� 1 �����ʡ�*/

	public static void main(String[] args) {
		String s = "Hello";
		int a = countSegments(s);
		System.out.println(a);

	}
    public static int countSegments(String s) {
    	int sum = 0;
    	for(int i=0;i<s.length();i++) {
    		if((i==0||s.charAt(i-1)==' ')&&s.charAt(i)!=' ') {
    			sum++;
    		}
    	}

    	return sum;

    } 

}
