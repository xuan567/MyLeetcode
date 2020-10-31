package com.problem;

public class leetcode_234 {

	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	/*���ж�һ�������Ƿ�Ϊ��������
	ʾ�� 1:
	����: 1->2
	���: false
	ʾ�� 2:
	����: 1->2->2->1
	���: true*/
    public boolean isPalindrome(ListNode head) {
    	ListNode p = head;
    	StringBuilder s = new StringBuilder();
    	while(p!=null) {
    		s.append(p.val);
    	}
    	String l = s.toString();
    	return isHuiWen(l);
    }
    public static boolean isHuiWen(String s) {
    	int i=0,j=s.length();
    	for(;i<j;i++,j--) {
    		if(s.charAt(i)!=s.charAt(j))
    			return false;
    	}
    	return true;
    }

}
