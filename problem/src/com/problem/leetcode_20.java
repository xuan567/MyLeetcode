package com.problem;

import java.util.Stack;

public class leetcode_20 {
	/*
	 * �Ѷȼ�1760����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
	    ��Ч�ַ��������㣺
	     �����ű�������ͬ���͵������űպϡ�
	     �����ű�������ȷ��˳��պϡ�*/

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
