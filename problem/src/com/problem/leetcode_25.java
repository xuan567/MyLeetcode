package com.problem;
/*难度困难679给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
	k 是一个正整数，它的值小于或等于链表的长度。
	如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
	
	示例：
	给你这个链表：1->2->3->4->5
	当 k = 2 时，应当返回: 2->1->4->3->5
	当 k = 3 时，应当返回: 3->2->1->4->5
 	*/

public class leetcode_25 {
	
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	  public ListNode reverseKGroup(ListNode head, int k) {
		 ListNode l = new ListNode(0);
		 l.next = head;
		 ListNode pre = l;
		 ListNode end = l;
		 while(end.next!=null) {
			 for(int i=0;i<k&&end!=null;i++) end=end.next;
			 if(end==null) break;
			 ListNode start = pre.next;
			 ListNode next = end.next;
			 end.next=null;
			 pre.next = reverse(start);
			 start.next = next;
			 pre=start;
			 end = pre;
			 
		 }
		 return l.next;
	  }
	  
	  public ListNode reverse(ListNode head) {
		  ListNode  cure = head;
		  ListNode pre = null;
		  while(cure!=null) {
			  ListNode next = cure.next;
			  cure.next = pre;
			  pre = cure;
			  cure = next;
		  }
		  return pre;
	  }
}
