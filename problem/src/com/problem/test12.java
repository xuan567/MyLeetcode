package com.problem;

public class test12 {
	

	public static void main(String[] args) {

	}
	public static ListNode reverseList(ListNode head,int m,int n) {
		if(head==null)
			return null;
		ListNode p = head;
		int i=1;
		while(p!=null) {
			if(i==m-1) {
				ListNode a = p;
				p=p.next;
				ListNode b = p;
				i=i+1;
				while(i<n) {
					p=p.next;
					i++;
				}
				ListNode c = p.next;
				p.next = null;
				ListNode d = reverse(b);
				a.next = d;
				while(d.next!=null) {
					d=d.next;
				}
				d.next = c;
			}else {
				p=p.next;
				i++;
			}
		}
		return head;
	}
	
	public static ListNode reverse(ListNode head) {
		if(head==null || head.next==null) {
			return null;
		}
		ListNode p,l,q=null;
		l=head;
		p=head.next;
		l.next=null;
		while(p!=null) {
			q=p.next;
			p.next = l;
			l=p;
			p=q;
		}
		return l;
	}

}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
