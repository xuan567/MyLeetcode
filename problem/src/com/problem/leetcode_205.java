package com.problem;

import java.util.HashMap;

public class leetcode_205 {

	public static void main(String[] args) {
		boolean b = isTsomorphic("abc","egi");
		System.out.println(b);
		boolean b2 = isTsomorphic2("abc","egi");
		System.out.println(b2);
		boolean b3 = isTsomorphic3("abc","egi");
		System.out.println(b3);
	}
	public static boolean isTsomorphic(String s,String t) {
		return isIsomorphicHelper(s,t)&&isIsomorphicHelper(t,s);
	}
	public static boolean isIsomorphicHelper(String s , String t) {
		HashMap<Character, Character> map = new HashMap<>();
		for(int i = 0; i< s.length();i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if(map.containsKey(c1)) {
				if(map.get(c1)!=c2)
					return false;
			}else {
				map.put(c1, c2);
			}
		}
		return true;
	}
	
	public static boolean isTsomorphic2(String s,String t) {
		return isIsomorphicHelper2(s).equals(isIsomorphicHelper2(t));
	}
	
	public static String isIsomorphicHelper2(String s) {
		int[] map = new int [128];
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<n;i++) {
			char c = s.charAt(i);
			if(map[c]==0) {
				map[c]=i+1;
			}
			sb.append(map[c]);
		}
		return sb.toString();
	}
	
	public static boolean isTsomorphic3(String s,String t) {
		int n = s.length();
		int[] mapS = new int[128];
		int[] mapT = new int[128];
		for(int i = 0;i<n;i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if(mapS[c1]!=mapT[c2]) {
				return false;
			}else {
				if(mapS[c1]==0) {
					mapS[c1]=i+1;
					mapT[c2]=i+1;
				}
			}
		}
		return true;
	}

}
