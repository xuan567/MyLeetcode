package com.problem;

import java.util.HashMap;

public class leetcode_409 {
	/*
	 * 409. 最长回文串难度简单
	 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
		在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
		注意:
		假设字符串的长度不会超过 1010。
		示例 1: 
		输入:
		"abccccdd"
		输出:
		7
		解释:
		我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。*/

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
//定义一个数组将字符串每个字符出现的次数记录下来，然后遍历这个数组
//ans+=该字母索引对应的元素/2*2，每次ans加的数字都是偶数，然后回文字符串
//长度最大，让它变成一个奇数的字符串，中心对称，if(v%2==1&&ans%2==0)
//如果该字母出现的次数是奇数，同时目前的回文字符串是偶数，长度++;		
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
