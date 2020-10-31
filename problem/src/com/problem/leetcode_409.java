package com.problem;

import java.util.HashMap;

public class leetcode_409 {
	/*
	 * 409. ����Ĵ��Ѷȼ�
	 * ����һ��������д��ĸ��Сд��ĸ���ַ������ҵ�ͨ����Щ��ĸ����ɵ���Ļ��Ĵ���
		�ڹ�������У���ע�����ִ�Сд������ "Aa" ���ܵ���һ�������ַ�����
		ע��:
		�����ַ����ĳ��Ȳ��ᳬ�� 1010��
		ʾ�� 1: 
		����:
		"abccccdd"
		���:
		7
		����:
		���ǿ��Թ������Ļ��Ĵ���"dccaccd", ���ĳ����� 7��*/

	public static void main(String[] args) {
		String s = "abccccdd";
		int n = nlongestPalindrome(s);
		System.out.println(n);
	}
	public static int nlongestPalindrome(String s) {
		int[] count = new int[128];
		for (char c : s.toCharArray()) {
			count[c]++;
		}
		int ans = 0;
		for(int v : count) {
			ans+=v/2*2;
			if(v%2==1 && ans%2==0)
				ans++;
		}
		return ans;
//����һ�����齫�ַ���ÿ���ַ����ֵĴ�����¼������Ȼ������������
//ans+=����ĸ������Ӧ��Ԫ��/2*2��ÿ��ans�ӵ����ֶ���ż����Ȼ������ַ���
//��������������һ���������ַ��������ĶԳƣ�if(v%2==1&&ans%2==0)
//�������ĸ���ֵĴ�����������ͬʱĿǰ�Ļ����ַ�����ż��������++;		
	}
    public static int nlongestPalindrome1(String s) {
    	HashMap<Character,Integer> map = new HashMap<>();
    	for(int i=0;i<s.length();i++) {
    		map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
    	}
    	int sum = 0;
    	int max = 0;
    	for(Integer n : map.values()) {
    		if(n%2==0)
    			sum+=n;
    		else {
    			if(n>max)
    				max = n;
    			else {
    				sum+=n-1;
    			} 
    		}
    	}
    	sum = sum + max ;
    	return sum;
    }

}
