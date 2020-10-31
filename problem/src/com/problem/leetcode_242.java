package com.problem;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode_242 {
	/*
	 * �Ѷȼ�226���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
	ʾ�� 1:
	����: s = "anagram", t = "nagaram"
	���: true
	ʾ�� 2:
	����: s = "rat", t = "car"
	���: false
	*/

	public static void main(String[] args) {
		boolean b = isAnagram2("a","b");
		System.out.println(b);

	}
	public static boolean isAnagram1(String s, String t) {
		HashMap<Character,Integer> hm1 = new HashMap<>();
		HashMap<Character,Integer> hm2 = new HashMap<>();
		char[] a1 = s.toCharArray();
		char[] a2 = t.toCharArray();
		for(int i = 0;i<a1.length;i++) {
			if(hm1.containsKey(a1[i]))
				hm1.put(a1[i],hm1.get(a1[i])+1);
			else
				hm1.put(a1[i], 1);
		}
		for(int j = 0;j<a2.length;j++) {
			if(hm2.containsKey(a2[j]))
				hm2.put(a2[j],hm2.get(a2[j])+1);
			else
				hm2.put(a2[j], 1);
		}
		if(hm1.equals(hm2))
			return true;
		else
			return false;
    }
	public static boolean isAnagram2(String s, String t) {
		if (s.length() != t.length()) {
	        return false;
	    }
		char[] a1 = s.toCharArray();
		char[] a2 = t.toCharArray();
		Arrays.sort(a1);
		Arrays.sort(a2);
		return Arrays.equals(a1, a2);
	}
	
	public static boolean isAnagram3(String s, String t) {
		if(s.length()!=t.length())
			return false;
		int[] count = new int[26]; 
		for(int i = 0;i<s.length();i++) {
			count[s.charAt(i)-'a']++;
			count[t.charAt(i)-'a']--;
		}
		
		for (int i : count) {
			if(i!=0)
				return false;
		}
		return true;
	}
}
