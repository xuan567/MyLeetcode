package com.problem;

public class Test11 {

	public static void main(String[] args) {
		String s = "take leetcode test";
		String l = reverseString(s);
		System.out.println(l);
	}
	
	public static String reverseString(String s) {
		String[] arr = new String[s.length()];
		arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<arr.length;i++) {
			if(i==arr.length-1) {
				sb.append(reverse(arr[i]));
			}else {
				sb.append(reverse(arr[i]));
				sb.append(" ");
			}
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
