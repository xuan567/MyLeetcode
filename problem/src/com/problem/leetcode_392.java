package com.problem;

public class leetcode_392 {
	/*
	 * �����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�
	�������Ϊ s �� t �н�����Ӣ��Сд��ĸ���ַ��� t ���ܻ�ܳ������� ~= 500,000������ s �Ǹ����ַ��������� <=100����
	�ַ�����һ����������ԭʼ�ַ���ɾ��һЩ��Ҳ���Բ�ɾ�����ַ������ı�ʣ���ַ����λ���γɵ����ַ����������磬"ace"��"abcde"��һ�������У���"aec"���ǣ���
	ʾ�� 1:
	s = "abc", t = "ahbgdc"
	���� true.
	
	ʾ�� 2:
	s = "axc", t = "ahbgdc"
	���� false
*/

	public static void main(String[] args) {
		String s ="abc";
		String t = "ahbgdc";
		boolean b = isSubsequence(s,t);
		System.out.println(b);
	}
	public static boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        while(i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        System.out.println(i);
        if(i==s.length())
            return true;
        else 
            return false;
    }

}
