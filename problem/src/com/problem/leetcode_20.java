package com.problem;

import java.util.Stack;

public class leetcode_20 {
	/*
	 * 难度简单1760给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
	    有效字符串需满足：
	     左括号必须用相同类型的右括号闭合。
	     左括号必须以正确的顺序闭合。*/

	public static void main(String[] args) {
		boolean b = isValid("[()]");
		System.out.println(b);
	}
	
    public static boolean isValid(String s) {
    	if(s.isEmpty()) {
    		return true;
    	}
    	Stack<Character> stack = new Stack<>();
    	for(char c:s.toCharArray()) {
    		if(c=='(')
    			stack.push(')');
    		else if(c=='{')
    			stack.push('}');
    		else if(c=='[')
    			stack.push(']');
    		else if(stack.empty()||c!=stack.pop())
    			return false;
    	}
    	if(stack.empty())
    		return true;
    	return false;

    }

}
