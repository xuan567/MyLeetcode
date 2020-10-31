package com.problem;

public class leetcode_234 {

	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	/*请判断一个链表是否为回文链表。
	示例 1:
	输入: 1->2
	输出: false
	示例 2:
	输入: 1->2->2->1
	输出: true*/
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
