package com.problem;

import java.util.Stack;

public class leetcode_32 {
	/*32. ���Ч�����Ѷ�����911����һ��ֻ���� '(' �� ')' ���ַ������ҳ���İ�����Ч���ŵ��Ӵ��ĳ��ȡ�

	ʾ�� 1:
	����: "(()"
	���: 2
	����: ���Ч�����Ӵ�Ϊ "()"

	ʾ�� 2:
	����: ")()())"
	���: 4
	����: ���Ч�����Ӵ�Ϊ "()()"
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

/* ˼·��������������ÿһ���Ӵ��ж��Ƿ�����Ч���ţ���¼���ĳ��ȣ����ǳ�ʱ��
 * ����ջ������ÿ��'('��ջ������ÿ��')'������Ե�ջ��Ԫ�أ����ջΪ�գ�˵����û��
 * ��ԣ����±�Ž�ȥ�������Ϊ�գ����������±��ȥջ��Ԫ�أ�����Ŀǰ�����
 * ���ȡ�*/
