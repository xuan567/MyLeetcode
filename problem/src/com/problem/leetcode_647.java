package com.problem;

public class leetcode_647 {
	/*647. 回文子串难度中等322给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
	具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
	
	示例 1：
	输入："abc"
	输出：3
	解释：三个回文子串: "a", "b", "c"
	
	示例 2：
	输入："aaa"
	输出：6
	解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"*/


	public static void main(String[] args) {
		String s = "abc";
		int n = countSubstrings(s);
		System.out.println(n);
		int n2 = countSubstrings2(s);
		System.out.println(n2);
	}
	
    public static int countSubstrings(String s) {
    	char[] arr = s.toCharArray();
    	int len = s.length();
    	int count = len;
    	for(int i = 0;i<len-1;i++) {
    		for(int j=i+1;j<len;j++) {
    			if(isHuiWen(arr,i,j)) {
    				count++;
    			}
    		}
    	}
    	return count;
    }
    public static boolean isHuiWen(char[] arr,int i,int j) {
    	for(;i<=j;i++,j--) {
    		if(arr[i]!=arr[j])
    			return false;
    	}
    	return true;
    }
    
    public static int countSubstrings2(String s) {
    	int count =0;
    	int n = s.length();
    	for(int i=0;i<2*n-1;i++) {
    		int l = i/2;
    		int r = i/2+i%2;
    		while(l>=0&&r<n&&s.charAt(l)==s.charAt(r)) {
    			l--;
    			r++;
    			count++;
    		}
    	}
    	return count;
    }

}

/* 自己的思路是将所有子串遍历一遍然后判断是否是回文子串，是的话count++；
 * 然后看了题解，题解使用了中心拓展法，用时少了，因为是回文字符串，所以中心可能是
 * 一个也可能是两个，有2n-1个中心，从i=0开始遍历，l=i/2，r=i%2，l--，r++，再判断
 * 是不是回文串*/
