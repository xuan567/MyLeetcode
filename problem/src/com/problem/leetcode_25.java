package com.problem;
/*�Ѷ�����679����һ������ÿ k ���ڵ�һ����з�ת�����㷵�ط�ת�������
	k ��һ��������������ֵС�ڻ��������ĳ��ȡ�
	����ڵ��������� k ������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
	
	ʾ����
	�����������1->2->3->4->5
	�� k = 2 ʱ��Ӧ������: 2->1->4->3->5
	�� k = 3 ʱ��Ӧ������: 3->2->1->4->5
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
