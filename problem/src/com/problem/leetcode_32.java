package com.problem;

import java.util.Stack;

public class leetcode_32 {
	/*32. 最长有效括号难度困难911给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

	示例 1:
	输入: "(()"
	输出: 2
	解释: 最长有效括号子串为 "()"

	示例 2:
	输入: ")()())"
	输出: 4
	解释: 最长有效括号子串为 "()()"
	 * */

	public static void main(String[] args) {
		String s = ")()())";
		int n1 = longestValidParentheses1(s);
		System.out.println(n1);
		int n2 = longestValidParentheses2(s);
		System.out.println(n2);
	}
	public static int longestValidParentheses1(String s) {
		int l=s.length();
		while(l!=0) {
			for(int i=0;i+l<=s.length();i++) {
				if(isTrue(s,i,i+l-1))
					return l;
			}
			l--;
		}
		return l;
	}
	public static boolean isTrue(String s,int i,int j) {
		Stack<Character> stack = new Stack<>();
		for(;i<=j;i++) {
			if(s.charAt(i)=='(')
				stack.push(')');
			else if(stack.isEmpty()||stack.pop()!=s.charAt(i))
				return false;
		}
		if(stack.isEmpty())
			return true;
		return false;
	}
    public static int longestValidParentheses2(String s) {
    	Stack<Integer> stack = new Stack<>();
    	int max = 0;
    	stack.push(-1);
    	for(int i=0;i<s.length();i++) {
    		if(s.charAt(i)=='(')
    			stack.push(i);
    		else {
    			stack.pop();
    			if(stack.isEmpty()) {
    				stack.push(i);
    			}else {
    				max = Math.max(max, i-stack.peek());
    			}
    		}
    	}
    	return max;
    }
    public static int longestValidParentheses3(String s) {
    	int left,right;
    	left=right=0;
    	int max = 0;
    	for(int i=0;i<s.length();i++) {
    		if(s.charAt(i)=='(')
    			left++;
    		else
    			right++;
    		if(right==left)
    			max= Math.max(max, right*2);
    		if(right>left) {
    			left = right =0;
    		}
    	}
    	for(int i=s.length()-1;i>=0;i--) {
    		if(s.charAt(i)==')')
    			right++;
    		else
    			left++;
    		if(left==right)
    			max = Math.max(max, left*2);
    		if(left>right) {
    			left = right =0;
    		}
    	}
    	return max;
    }

}

/* 思路：暴力遍历，将每一个子串判断是否是有效括号，记录最大的长度，但是超时。
 * 利用栈，遇到每个'('入栈，遇到每个')'弹出配对的栈顶元素，如果栈为空，说明他没有
 * 配对，将下标放进去，如果不为空，就用它的下标减去栈顶元素，就是目前的最大
 * 长度。*/
